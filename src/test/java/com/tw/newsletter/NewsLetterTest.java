package com.tw.newsletter;

import com.tw.newsletter.exceptions.SubscriberAlreadyExists;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class NewsLetterTest {
    @Test
    void shouldAbleToNotifyStudentWhenHeIsSubscribed() throws SubscriberAlreadyExists {
        NewsLetter newsLetter = new NewsLetter();
        Student mockedStudent = mock(Student.class);

        newsLetter.subscribe(mockedStudent);
        newsLetter.sendNotifications();

        verify(mockedStudent, times(1)).notification();
    }

    @Test
    void shouldAbleToNotifySoftwareDeveloperWHenHeIsSubscribed() throws SubscriberAlreadyExists {
        NewsLetter newsLetter = new NewsLetter();
        SoftwareDeveloper mockedSoftwareDeveloper = mock(SoftwareDeveloper.class);

        newsLetter.subscribe(mockedSoftwareDeveloper);
        newsLetter.sendNotifications();

        verify(mockedSoftwareDeveloper, times(1)).notification();
    }

    @Test
    void shouldAbleToNotifyPoliticalLeaderWhenHeIsSubscribed() throws SubscriberAlreadyExists {
        NewsLetter newsLetter = new NewsLetter();
        PoliticalLeader mockedPoliticalLeader = mock(PoliticalLeader.class);

        newsLetter.subscribe(mockedPoliticalLeader);
        newsLetter.sendNotifications();

        verify(mockedPoliticalLeader, times(1)).notification();
    }

    @Test
    void shouldAbleToNotifyAllKindOfSubscribers() throws SubscriberAlreadyExists {
        NewsLetter newsLetter = new NewsLetter();
        Student mockedStudent = mock(Student.class);
        SoftwareDeveloper mockedSoftwareDeveloper = mock(SoftwareDeveloper.class);
        PoliticalLeader mockedPoliticalLeader = mock(PoliticalLeader.class);

        newsLetter.subscribe(mockedStudent);
        newsLetter.subscribe(mockedSoftwareDeveloper);
        newsLetter.subscribe(mockedPoliticalLeader);
        newsLetter.sendNotifications();

        verify(mockedStudent, times(1)).notification();
        verify(mockedSoftwareDeveloper, times(1)).notification();
        verify(mockedPoliticalLeader, times(1)).notification();
    }

    @Test
    void shouldNotNotifyStudentWhenHeIsUnsubscribed() throws SubscriberAlreadyExists {
        NewsLetter newsLetter = new NewsLetter();
        Student mockedStudent = mock(Student.class);
        SoftwareDeveloper mockedSoftwareDeveloper = mock(SoftwareDeveloper.class);

        newsLetter.subscribe(mockedStudent);
        newsLetter.subscribe(mockedSoftwareDeveloper);
        newsLetter.sendNotifications();
        newsLetter.unsubscribe(mockedStudent);
        newsLetter.sendNotifications();

        verify(mockedStudent, times(1)).notification();
        verify(mockedSoftwareDeveloper, times(2)).notification();
    }

    @Test
    void shouldAbleToSubscribeOnlyOnceWhenSubscriberTryToSubscribeMultipleTimes() throws SubscriberAlreadyExists {
        NewsLetter newsLetter = new NewsLetter();
        Student mockedStudent = mock(Student.class);

        newsLetter.subscribe(mockedStudent);

        assertThrows(SubscriberAlreadyExists.class, () -> newsLetter.subscribe(mockedStudent));
    }
}
