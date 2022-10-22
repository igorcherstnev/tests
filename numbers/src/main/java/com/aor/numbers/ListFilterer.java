package com.aor.numbers;

import java.util.List;

public class ListFilterer {
    GenericListFilter filter;
    public ListFilterer(GenericListFilter filter) {
        this.filter=filter;
    }
    public List<Integer> filter(List<Integer> list){
        for(int i=0;i<list.size();i++){
            Integer n=list.get(i);
            if(!filter.accept(n)) list.remove(i);
        }
        return list;
    }
}


