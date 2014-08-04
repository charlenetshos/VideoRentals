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

        Statement textStatement = Statement.TEXT;
        String header = textStatement.applyHeader(name);
        String taggedRentals = textStatement.applyTag(rentals);
        String footer = textStatement.applyFooter(totalAmount, frequentRenterPoints);

        return header + taggedRentals + footer;
    }

    public String htmlStatement() {
        double totalAmount = totalAmount();
        int frequentRenterPoints = frequenterPoints();

        Statement htmlStatement = Statement.HTML;
        String header = htmlStatement.applyHeader(name);
        String taggedRentals = htmlStatement.applyTag(rentals);
        String footer = htmlStatement.applyFooter(totalAmount, frequentRenterPoints);

        return header + taggedRentals + footer;
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

}