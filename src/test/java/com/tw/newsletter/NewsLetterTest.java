package com.tw.newsletter;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class NewsLetterTest {
    @Test
    void shouldAbleToNotifyStudentWhenHeIsSubscribed() {
        NewsLetter newsLetter = new NewsLetter();
        Student mockedStudent = mock(Student.class);

        newsLetter.subscribe(mockedStudent);
        newsLetter.sendNotifications();

        verify(mockedStudent, times(1)).notification();
    }

    @Test
    void shouldAbleToNotifySoftwareDeveloperWHenHeIsSubscribed() {
        NewsLetter newsLetter = new NewsLetter();
        SoftwareDeveloper mockedSoftwareDeveloper = mock(SoftwareDeveloper.class);

        newsLetter.subscribe(mockedSoftwareDeveloper);
        newsLetter.sendNotifications();

        verify(mockedSoftwareDeveloper, times(1)).notification();
    }
}
