package com.tw.bootcamp.rental;

import java.util.ArrayList;
import java.util.List;

//Customer class
class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        String header = "Rental Record for " + name + "\n";
        String tag = "\t%s\t%s\n";
        String result = header;

        double totalAmount = totalAmount();

        int frequentRenterPoints = frequenterPoints();

        for (Rental rental : rentals) {
            result += String.format(tag, rental.movieName(), String.valueOf(rental.calculateAmount()));
        }

        String footer1 = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        String footer2 = "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        result += footer1;
        result += footer2;
        return result;
    }

    private int frequenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequenterPoints();
        }
        return frequentRenterPoints;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.calculateAmount();
        }
        return totalAmount;
    }

    public String htmlStatement() {
        String header = "<H1>Rentals for <EM>" + name + "</EM></H1><P>\n";
        String tag = "%s: %s<BR>\n";
        String result = header;

        double totalAmount = totalAmount();

        int frequentRenterPoints = frequenterPoints();

        for (Rental rental : rentals) {
            result += String.format(tag, rental.movieName(), String.valueOf(rental.calculateAmount()));
        }

        String footer1 = "<P>You owed <EM>" + String.valueOf(totalAmount) + "</EM><P>\n";
        String footer2 = "On this rental you earned <EM>" + String.valueOf(frequentRenterPoints) + "</EM> frequent renter points<P>";
        result += footer1;
        result += footer2;
        return result;
    }

}