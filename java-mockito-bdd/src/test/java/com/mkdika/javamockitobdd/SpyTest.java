package com.mkdika.javamockitobdd;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void mockito_spy_demo_test(){
        List list = new LinkedList();
        List spy = spy(list);

        // stub some method
        when(spy.size()).thenReturn(100);

        // using the spy calls "real" method
        spy.add("one");
        spy.add("two");

        // prints "one"
        System.out.println(spy.get(0));

        // size() method was stubbed - 100 is printed
        System.out.println(spy.size());

        //You have to use doReturn() for stubbing real object behaviour
        doReturn("hundred").when(spy).get(100);
        System.out.println(spy.get(100));


        // optionally, can verify
        verify(spy).add("one");
        verify(spy).add("two");
        verify(spy).get(100);
    }

}
