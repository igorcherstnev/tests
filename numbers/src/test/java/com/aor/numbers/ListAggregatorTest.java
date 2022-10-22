package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;
    @Test
    public void sum() {
        helper(Arrays.asList(1,2,4,2,5));
        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        helper(Arrays.asList(1,2,4,2,5));
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }
    @Test
    public void max_bug_7263(){
        helper(Arrays.asList(-1,-4,-5));
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);
        Assertions.assertEquals(-1, max);
    }

    @Test
    public void min() {
        helper(Arrays.asList(1,2,4,2,5));
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct(){
        helper(Arrays.asList(1,2,4,2,5));
        ListAggregator aggregator =new ListAggregator();
        ListSorter sorter =new ListSorter();
        ListDeduplicator deduplicator =new ListDeduplicator(sorter);
        int distinct =aggregator.distinct(list,deduplicator);
        Assertions.assertEquals(4,distinct);
    }
    @Test
    public void bug_8726(){
        helper(Arrays.asList(1,2,4,2));

        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list,deduplicator);

        Assertions.assertEquals(3, distinct);
    }

    public void helper(List<Integer> alist){
        this.list=alist;
    }
}
