package br.com.estudos.unit_testing.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void testSizeBasic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes", mock.get(0));
        assertNull(mock.get(1));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes", mock.get(0));
        assertEquals("in28Minutes", mock.get(1));
    }

    @Test
    public void verificationBasics() {
        //System Under Test (SUT)
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        //Verify
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        //SUT
        mock.add("Some String");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("Some String", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        //SUT
        mock.add("Some String1");
        mock.add("Some String2");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        List<String> allValues = captor.getAllValues();
        assertEquals("Some String1", allValues.get(0));
        assertEquals("Some String2", allValues.get(1));
    }

    @Test
    public void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); //null
        System.out.println(arrayListMock.size()); //0
        arrayListMock.add("Test");
        arrayListMock.add("Test");
        System.out.println(arrayListMock.size()); //0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); //0
    }

    @Test
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0)); //Test0
        System.out.println(arrayListSpy.size()); //1
        arrayListSpy.add("Test");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size()); //3
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); //5
        arrayListSpy.add("Test3");
        System.out.println(arrayListSpy.size()); //5
        verify(arrayListSpy).add("Test3");
    }
}
