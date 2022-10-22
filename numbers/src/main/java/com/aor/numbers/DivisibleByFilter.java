package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter {
    private Integer n;
    public DivisibleByFilter(Integer n){
        this.n=n;
    }
    @Override
    public boolean accept(Integer number) {
        if(number%this.n==0) return true;
        System.out.println(number%this.n);
        return false;
    }
}
