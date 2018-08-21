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

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;//积分
        Enumeration rentalsEnum = rentals.elements();
        String result = "Rental record for " + getName() + "\n";
        while (rentalsEnum.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentalsEnum.nextElement();
            thisAmount = each.getThisAmount();

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

}
