package com.rj.demo.book.refactoring.ch1;

import lombok.Data;

@Data
public class Rental {

    private Movie movie;
    private int daysRented;

}
