package com.tw.bootcamp.rental;

import java.util.List;

public enum Statement {
    TEXT("Rental Record for %s\n", "\t%s\t%s\n", "Amount owed is %s\nYou earned %s frequent renter points"),
    HTML("<H1>Rentals for <EM>%s</EM></H1><P>\n", "%s: %s<BR>\n", "<P>You owed <EM>%s</EM><P>\nOn this rental you earned <EM>%s</EM> frequent renter points<P>");

    private final String header;
    private final String tag;
    private final String footer;

    private Statement(String header, String tag, String footer) {
        this.header = header;
        this.tag = tag;
        this.footer = footer;
    }

    public String applyHeader(String customerName) {
        return String.format(header, customerName);
    }

    public String applyTag(List<Rental> rentals) {
        String taggedLines = "";
        for (Rental rental : rentals) {
            taggedLines += String.format(tag, rental.movieName(), String.valueOf(rental.calculateAmount()));
        }
        return taggedLines;
    }

    public String applyFooter(double totalAmount, int frequentRenterPoints) {
        return String.format(footer, totalAmount, frequentRenterPoints);
    }

}
