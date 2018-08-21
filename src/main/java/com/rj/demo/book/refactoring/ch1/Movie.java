package com.rj.demo.book.refactoring.ch1;

import lombok.Data;
@Data
public class Movie {

    public static final int CHILDRENS = 1;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 2;

    private String title;
    private int priceCode;

}
