package com.cms.controller;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.cms.entity.Version;
import com.cms.payload.UploadFileResponse;
import com.cms.principal.AppUserPrincipal;
import com.cms.service.FileStorageService;
import com.cms.service.VersionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.cms.entity.Article;
import com.cms.service.ArticleService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

@CrossOrigin
@RestController
public class ArticleController {

	@Autowired
    private ArticleService articleService;

	@Autowired
    private VersionService versionService;

    @RequestMapping("/articles")
    public List<ArticleContainer> articles() {
        return articleService.getAllArticleContainers();
    }

    @RequestMapping("/articlesVersions")
    public List<Version> versions() {
        return versionService.getAllVersions();
    }
    @RequestMapping("/articlesLatestVersions")
    public List<Version> latestVersions() {
        return versionService.getLatestVersions();
    }
    
    @RequestMapping("/articles/{articleId}")
    public ArticleContainer getArticle(@PathVariable Integer articleId) {
    	return articleService.getArticleContainer(articleId);
    }
    
    @RequestMapping(value="/articles", method=RequestMethod.POST)
    public void addArticle(@RequestBody Article article) {
    	articleService.addArticle(article);
    }
    
    @RequestMapping(value="/articles/{articleId}", method=RequestMethod.PUT)
    public void updateArticle(@RequestBody Article article) {
    	articleService.updateArticle(article);
    }
    
    @RequestMapping(value="/articles/{articleId}", method=RequestMethod.DELETE)
    public void deleteArticle(@PathVariable Integer articleId) {
    	articleService.deleteArticle(articleId);
    }




    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadFile")
    public Version uploadFile(@AuthenticationPrincipal AppUserPrincipal user, @RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) {
        if (user != null) {

            String fileNameStored = fileStorageService.storeFile(file);

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileNameStored)
                    .toUriString();

            Article article = articleService.addArticleFile(fileName, user.getUser());
            Version version = versionService.addInitialVersionWithArticle(article, fileDownloadUri);

            return version;
        } else {
            return null;
        }
    }

    @PostMapping("/uploadMultipleFiles")
    public List<Version> uploadMultipleFiles(@AuthenticationPrincipal AppUserPrincipal user, @RequestParam("files") MultipartFile[] files, @RequestParam("fileNames") String[] fileNames) {
        List<Version> versions = new ArrayList<>();
        int fileNamesItr = 0;
        for (MultipartFile file : files) {
            versions.add(uploadFile(user, file, fileNames[fileNamesItr]));
            fileNamesItr++;
        }
        return versions;
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}