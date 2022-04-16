package com.tw.newsletter;

import com.tw.PoliticalLeader;
import com.tw.SoftwareDeveloper;
import com.tw.Student;
import com.tw.exceptions.SubscriberAlreadyExist;
import com.tw.exceptions.SubscriberDoesNotExist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class NewsLetterTest {
    @Test
    void shouldAbleToNotifyStudentWhenHeIsSubscribed() throws SubscriberAlreadyExist {
        NewsLetter newsLetter = new NewsLetter();
        Student mockedStudent = mock(Student.class);

        newsLetter.subscribe(mockedStudent);
        newsLetter.sendNotifications();

        verify(mockedStudent, times(1)).notification();
    }

    @Test
    void shouldAbleToNotifySoftwareDeveloperWHenHeIsSubscribed() throws SubscriberAlreadyExist {
        NewsLetter newsLetter = new NewsLetter();
        SoftwareDeveloper mockedSoftwareDeveloper = mock(SoftwareDeveloper.class);

        newsLetter.subscribe(mockedSoftwareDeveloper);
        newsLetter.sendNotifications();

        verify(mockedSoftwareDeveloper, times(1)).notification();
    }

    @Test
    void shouldAbleToNotifyPoliticalLeaderWhenHeIsSubscribed() throws SubscriberAlreadyExist {
        NewsLetter newsLetter = new NewsLetter();
        PoliticalLeader mockedPoliticalLeader = mock(PoliticalLeader.class);

        newsLetter.subscribe(mockedPoliticalLeader);
        newsLetter.sendNotifications();

        verify(mockedPoliticalLeader, times(1)).notification();
    }

    @Test
    void shouldAbleToNotifyAllKindOfSubscribers() throws SubscriberAlreadyExist {
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
    void shouldNotNotifyStudentWhenHeIsUnsubscribed() throws SubscriberAlreadyExist, SubscriberDoesNotExist {
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
    void shouldAbleToSubscribeOnlyOnceWhenSubscriberTryToSubscribeMultipleTimes() throws SubscriberAlreadyExist {
        NewsLetter newsLetter = new NewsLetter();
        Student mockedStudent = mock(Student.class);

        newsLetter.subscribe(mockedStudent);

        assertThrows(SubscriberAlreadyExist.class, () -> newsLetter.subscribe(mockedStudent));
    }

    @Test
    void shouldNotUnsubscribeSubscriberWhenHeIsNotSubscribed() {
        NewsLetter newsLetter = new NewsLetter();
        Student mockedStudent = mock(Student.class);

        assertThrows(SubscriberDoesNotExist.class, () -> newsLetter.unsubscribe(mockedStudent));
    }
}
