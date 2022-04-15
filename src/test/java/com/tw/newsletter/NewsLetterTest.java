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
}
