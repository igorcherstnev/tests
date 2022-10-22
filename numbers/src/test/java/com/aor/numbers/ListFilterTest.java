package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListFilterTest {
    @Test
    public void PositiveFilterTest(){
        Integer i= 5;
        PositiveFilter filter= new PositiveFilter();
        boolean result=filter.accept(i);
        Boolean expected=true;
        Assertions.assertEquals(expected,result);


    }
    @Test
    public void DivisibleByFilterTest(){
        Integer n_tested= 10;
        DivisibleByFilter filter= new DivisibleByFilter(5);
        boolean result=filter.accept(n_tested);
        Boolean expected=true;
        Assertions.assertEquals(expected,result);


    }
}
