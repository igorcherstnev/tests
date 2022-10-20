package com.aor.numbers;

import com.sun.tools.javac.jvm.Gen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    private List<Integer> list;

    @Test
    public void deduplicate() {
        helper(Arrays.asList(1,2,4,2,5));
        ListSorter sorter = new ListSorter();
        List<Integer> expected = Arrays.asList(1,2,4,5);

        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }
    @Test
    public void deduplicate_bug_8726(){
        helper(Arrays.asList(1,2,4,2));
        class StubListSorter implements GenericListSorter{
            @Override public List<Integer> sort(List<Integer> list){
                return Arrays.asList(1,2,2,4);
            }
        }
        StubListSorter sorter = new StubListSorter();
        List<Integer> expected = Arrays.asList(1,2,4);

        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }

    public void helper(List<Integer> alist){
        this.list=alist;
    }
}
