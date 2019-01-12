package com.cms.service;

import com.cms.entity.Conference;
import com.cms.entity.Session;
import com.cms.entity.User;
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

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Import(com.cms.service.SessionServiceTestContextConfiguration.class)
public class SessionServiceTest {


    @Autowired
    private SessionService sessionService;
    @MockBean
    private SessionRepository sessionRepository;

    private List<Session> testSessions = new ArrayList<>();

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
        Conference testConference = new Conference(0, "testConf1",
                "Description1", new Date(0), new Date(1), testAuthor,
                "Img", "emergencyInfo",
                "accomodationInfo");
        testSessions.add(new Session(0, testConference, "testChairName", new Time(0), new Time(1), "sessionName"));
        testSessions.add(new Session(1, testConference, "testChairName", new Time(0), new Time(1), "sessionName"));
        testSessions.add(new Session(2, testConference, "testChairName", new Time(0), new Time(1), "sessionName"));


        Mockito.when(sessionRepository.findAll()).thenReturn(testSessions);
        Mockito.when(sessionRepository.findById(0)).thenReturn(Optional.of(testSessions.get(0)));
        Mockito.when(sessionRepository.findById(1)).thenReturn(Optional.of(testSessions.get(1)));
        Mockito.when(sessionRepository.findById(2)).thenReturn(Optional.of(testSessions.get(2)));
    }

    @Test
    public void getAllSessionsTest() {
        List<Session> sessions = sessionService.getAllSessions();

        assertEquals(testSessions, sessions);
    }

    @Test
    public void getSessionTest() {
        Session session0 = sessionService.getSession(0);
        Session session1 = sessionService.getSession(1);
        Session session2 = sessionService.getSession(2);

        assertEquals(testSessions.get(0), session0);
        assertEquals(testSessions.get(1), session1);
        assertEquals(testSessions.get(2), session2);
    }

    @Test
    public void addSessionTest() {
        sessionService.addSession(testSessions.get(0));

        Mockito.verify(sessionRepository).save(testSessions.get(0));
    }

    @Test
    public void updateSessionTest() {
        sessionService.updateSession(testSessions.get(0));

        Mockito.verify(sessionRepository).save(testSessions.get(0));
    }

    @Test
    public void deleteSessionTest() {
        sessionService.deleteSession(0);

        Mockito.verify(sessionRepository).deleteById(0);
    }
}

@TestConfiguration
class SessionServiceTestContextConfiguration {
    @Bean
    public SessionService sessionService() {
        return new SessionService();
    }
}


