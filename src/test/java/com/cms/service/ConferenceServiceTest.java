package com.cms.service;

import com.cms.entity.Conference;
import com.cms.entity.User;
import com.cms.repository.ConferenceRepository;
import com.cms.repository.PresentationRepository;
import com.cms.repository.SessionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Import(com.cms.service.ConferenceServiceTestContextConfiguration.class)
public class ConferenceServiceTest {

    @Autowired
    private ConferenceService conferenceService;
    @MockBean
    private ConferenceRepository conferenceRepository;
    @MockBean
    private PresentationRepository presentationRepository;
    @MockBean
    private SessionRepository sessionRepository;
    @MockBean
    private VersionService versionService;

        private List<Conference> testConferences = new ArrayList<>();

        @Before
        public void setUp() {
            User testAuthor = new User(
                    "test-username",
                    "TestPassword",
                    "Jan",
                    "Kowalski",
                    "test@test.test",
                    123456789
            );
            testConferences.add(new Conference(0, "testConf1",
                    "Description1", new Date(0), new Date(1), testAuthor,
                    "Img", "emergencyInfo",
                    "accomodationInfo"));
            testConferences.add(new Conference(1, "testConf2",
                    "Description", new Date(1), new Date(2), testAuthor,
                    "Img", "emergencyInfo",
                    "accomodationInfo"));
            testConferences.add(new Conference(2, "testConf2",
                    "Description", new Date(3), new Date(4), testAuthor,
                    "Img", "emergencyInfo",
                    "accomodationInfo"));


            Mockito.when(conferenceRepository.findAll()).thenReturn(testConferences);
            Mockito.when(conferenceRepository.findById(0)).thenReturn(Optional.of(testConferences.get(0)));
            Mockito.when(conferenceRepository.findById(1)).thenReturn(Optional.of(testConferences.get(1)));
            Mockito.when(conferenceRepository.findById(2)).thenReturn(Optional.of(testConferences.get(2)));
        }

        @Test
        public void getAllConferencesTest() {
            List<Conference> conferences = conferenceService.getAllConferences();

            assertEquals(testConferences, conferences);
        }

        @Test
        public void getConferenceTest() {
            Conference conference0 = conferenceService.getConference(0);
            Conference conference1 = conferenceService.getConference(1);
            Conference conference2 = conferenceService.getConference(2);

            assertEquals(testConferences.get(0), conference0);
            assertEquals(testConferences.get(1), conference1);
            assertEquals(testConferences.get(2), conference2);
        }

        @Test
        public void addConferenceTest() {
            conferenceService.addConference(testConferences.get(0));

            Mockito.verify(conferenceRepository).save(testConferences.get(0));
        }

        @Test
        public void updateConferenceTest() {
            conferenceService.updateConference(testConferences.get(0));

            Mockito.verify(conferenceRepository).save(testConferences.get(0));
        }

        @Test
        public void deleteConferenceTest() {
            conferenceService.deleteConference(0);

            Mockito.verify(conferenceRepository).deleteById(0);
        }
    }

    @TestConfiguration
    class ConferenceServiceTestContextConfiguration {
        @Bean
        public ConferenceService conferenceService() {
            return new ConferenceService();
        }
    }
