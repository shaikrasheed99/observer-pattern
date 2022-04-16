package com.tw.youtube;

import com.tw.SoftwareDeveloper;
import com.tw.Student;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ChannelTest {
    @Test
    void shouldAbleToNotifySubscribersWhenNewVideoIsUploaded() {
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
}
