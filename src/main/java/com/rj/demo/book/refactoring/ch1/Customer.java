package com.rj.demo.book.refactoring.ch1;

import lombok.*;

import java.util.Enumeration;
import java.util.Vector;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {

    @NonNull
    private String name;
    private Vector rentals = new Vector();

    public void addRental(Rental rental) {
        rentals.add(rental);
    }


    public String htmlStatement() {
        Enumeration rentalsEnum = rentals.elements();
        String result = "<h1>Rental record for <b>" + getName() + "</b></h1>\n";
        while (rentalsEnum.hasMoreElements()) {
            Rental rental = (Rental) rentalsEnum.nextElement();
            result += "<p>" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "</p>\n";
        }
        result += "<p>Amount owed is <b>" + String.valueOf(getTotalCharge()) + "</b></p>\n";
        result += "<p>You earned <b>" + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points</b></p>";
        return result;

    }

    public String statement() {
        Enumeration rentalsEnum = rentals.elements();
        String result = "Rental record for " + getName() + "\n";
        while (rentalsEnum.hasMoreElements()) {

            Rental each = (Rental) rentalsEnum.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

        }
        //add footer lines;
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentalsEnum = rentals.elements();
        while (rentalsEnum.hasMoreElements()) {
            Rental each = (Rental) rentalsEnum.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentalsEnum = rentals.elements();
        while (rentalsEnum.hasMoreElements()) {
            Rental each = (Rental) rentalsEnum.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }


}
