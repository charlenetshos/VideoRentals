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
        double totalAmount = totalAmount();
        int frequentRenterPoints = frequenterPoints();

        String header = "Rental Record for " + name + "\n";
        String tag = "\t%s\t%s\n";
        String footer = String.format("Amount owed is %s\nYou earned %s frequent renter points",
                String.valueOf(totalAmount), String.valueOf(frequentRenterPoints));

        return formatReceipt(header, tag, footer);
    }

    public String htmlStatement() {
        double totalAmount = totalAmount();
        int frequentRenterPoints = frequenterPoints();

        String header = "<H1>Rentals for <EM>" + name + "</EM></H1><P>\n";
        String tag = "%s: %s<BR>\n";
        String footer = String.format("<P>You owed <EM>%s</EM><P>\nOn this rental you earned <EM>%s</EM> frequent renter points<P>",
                String.valueOf(totalAmount), String.valueOf(frequentRenterPoints));

        return formatReceipt(header, tag, footer);
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

    private String formatReceipt(String header, String tag, String footer) {
        String result = header;

        for (Rental rental : rentals) {
            result += String.format(tag, rental.movieName(), String.valueOf(rental.calculateAmount()));
        }
        result += footer;
        return result;
    }

}