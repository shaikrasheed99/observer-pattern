package com.tw.youtube;

import com.tw.SoftwareDeveloper;
import com.tw.Student;
import com.tw.exceptions.SubscriberAlreadyExist;
import com.tw.exceptions.SubscriberDoesNotExist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ChannelTest {
    @Test
    void shouldAbleToNotifySubscribersWhenNewVideoIsUploaded() throws SubscriberAlreadyExist {
        Channel channel = new Channel();
        Student mockedStudent = mock(Student.class);
        SoftwareDeveloper mockedSoftwareDeveloper = mock(SoftwareDeveloper.class);
        Video mockedVideo = mock(Video.class);

        channel.subscribe(mockedStudent);
        channel.subscribe(mockedSoftwareDeveloper);
        channel.upload(mockedVideo);

        verify(mockedStudent, times(1)).notification();
        verify(mockedSoftwareDeveloper, times(1)).notification();
    }

    @Test
    void shouldNotLetSubscriberToSubscribeAgainWhenHeAlreadySubscribed() throws SubscriberAlreadyExist {
        Channel channel = new Channel();
        Student mockedStudent = mock(Student.class);

        channel.subscribe(mockedStudent);

        assertThrows(SubscriberAlreadyExist.class, () -> channel.subscribe(mockedStudent));
    }

    @Test
    void shouldNotUnsubscribeUserWhenHeIsNotSubscribed() {
        Channel channel = new Channel();
        Student mockedStudent = mock(Student.class);

        assertThrows(SubscriberDoesNotExist.class, () -> channel.unsubscribe(mockedStudent));
    }
}
