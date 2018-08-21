package com.rj.demo.book.refactoring.ch1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    public static final int CHILDREN = 1;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 2;

    private String title;
    private int priceCode;

}
