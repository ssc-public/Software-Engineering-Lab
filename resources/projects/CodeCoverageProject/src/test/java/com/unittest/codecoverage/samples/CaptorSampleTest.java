package com.unittest.codecoverage.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CaptorSampleTest {
	
	@Mock
	List<String> mockedList;

	@Captor 
	ArgumentCaptor<String> argCaptor;

	@Test
	public void whenUseCaptorAnnotation_thenTheSame() {
	    mockedList.add("one");
	    verify(mockedList).add(argCaptor.capture());

	    assertEquals("one", argCaptor.getValue());
	}

}
