package com.unittest.codecoverage.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockSampleTest {
	
	@Test
	public void shouldReturnFalse_whenAddSomeString() {
		
		MyCustomList listMock = mock(MyCustomList.class);
		when(listMock.add(anyString())).thenReturn(false);
		
		assertFalse(listMock.add("something"));
		
	}
	
	@Test
	public void shouldDoNothing_whenClear() {
		
		MyCustomList listMock = mock(MyCustomList.class);
		doNothing().when(listMock).clear();
		
		listMock.clear();
		
	}
	
	@Test
	public void shouldAnswerSomeString_whenGetItemByIndex() {
		
		MyCustomList listMock = mock(MyCustomList.class);
		doAnswer(invocation -> {
			return "Item";
		}).when(listMock).get(anyInt());
		
		assertEquals("Item", listMock.get(0));
		
	}

}
