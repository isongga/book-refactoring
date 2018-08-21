package com.rj.demo.book.refactoring.ch1._1;

import com.rj.demo.book.refactoring.ch1.Movie;
import com.rj.demo.book.refactoring.ch1.Rental;
import lombok.Data;

import java.util.Enumeration;
import java.util.Vector;

@Data
public class Customer {

    private String name;
    private Vector rentals = new Vector();

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;//积分
        Enumeration rentalsEnum = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentalsEnum.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentalsEnum.nextElement();

            thisAmount = amountFor(each);

            frequentRenterPoints ++;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints ++;

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;

        }
        //add footer lines;
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if(each.getDaysRented() > 2) {
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if(each.getDaysRented() > 3) {
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }
}