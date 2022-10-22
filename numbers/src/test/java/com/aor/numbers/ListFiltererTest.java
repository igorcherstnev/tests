package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    private List<Integer> list;
    public void helper(List<Integer> alist){
        list=alist;
    }
    @Test
    public void list_filterer_Test(){
        helper(Arrays.asList(1,2,3,4,5));
        GenericListFilter filter= Mockito.mock(GenericListFilter.class);
        Mockito.when(filter.accept(Mockito.anyInt())).thenReturn(true);
        List<Integer> expected = Arrays.asList(1,2,3,4,5);
        ListFilterer myFilterer= new ListFilterer(filter);
        List<Integer> filtered= myFilterer.filter(list);
        Assertions.assertEquals(expected, filtered);
    }
}
