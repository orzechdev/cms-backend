package com.cms.service;

import com.cms.entity.Article;
import com.cms.entity.Version;
import com.cms.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class VersionService {
    @Autowired
    private VersionRepository versionRepository;

    public Version addInitialVersionWithArticle(Article article, String fileUrl) {
        Version version = new Version(Calendar.getInstance().getTime(), fileUrl, 1, article);

        return versionRepository.save(version);
    }

    public List<Version> getAllVersions() {
        List<Version> versions = new ArrayList<>();
        versionRepository.findAll().forEach(versions::add);
        return versions;
    }

    public List<Version> getLatestVersions() {
        List<Version> allVersions = new ArrayList<>(versionRepository.findAllByOrderByVersionIDDescArticle_ArticleIDDesc());
        List<Version> latestVersions = new ArrayList<>();
        Integer lastArticleID = -1;
        for (Version version : allVersions) {
            Integer currArticleID = version.getArticle().getArticleID();
            if (!lastArticleID.equals(currArticleID)) {
                latestVersions.add(version);
                lastArticleID = currArticleID;
            }
        }
        return latestVersions;
    }
}
