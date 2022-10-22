package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListFilterTest {
    @Test
    public void PositiveFilterTest(){
        List<Integer> l= Arrays.asList(-5,-2,5,0,-7);
        List<Boolean> expected=Arrays.asList(false,false,true,false,false);
        PositiveFilter filter= new PositiveFilter();
        for(int i=0;i<l.size();i++){
            Boolean expect=expected.get(i);
            Assertions.assertEquals(expect,filter.accept(l.get(i)));
        }
    }
    @Test
    public void DivisibleByFilterTest(){
        DivisibleByFilter filter= new DivisibleByFilter(5);
        List<Integer> l= Arrays.asList(-5,-2,5,0,-7);
        List<Boolean> expected=Arrays.asList(true,false,true,true,false);
        for(int i=0;i<l.size();i++){
            Boolean expect=expected.get(i);
            Assertions.assertEquals(expect,filter.accept(l.get(i)));
        }
    }
}
