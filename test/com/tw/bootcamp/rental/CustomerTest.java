package com.tw.bootcamp.rental;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void shouldPrintTextStatement() {
        Customer customer = new Customer("Krishna Sure");
        int[] daysRented = {4, 3, 2, 5, 1};

        ArrayList<Movie> movieArrayList = new ArrayList<>();
        movieArrayList.add(new Movie("102 Dalmatiens", Movie.CHILDRENS));
        movieArrayList.add(new Movie("She's Out Of My League", Movie.REGULAR));
        movieArrayList.add(new Movie("Scooby-Doo and the Alien Invaders", Movie.CHILDRENS));
        movieArrayList.add(new Movie("Despicable Me 2", Movie.NEW_RELEASE));
        movieArrayList.add(new Movie("Salt", Movie.REGULAR));

        for (int i = 0; i < movieArrayList.size(); i++) {
            customer.addRental(new Rental(movieArrayList.get(i), daysRented[i]));
        }

        String expectedResult = "Rental Record for Krishna Sure\n" +
                "\t102 Dalmatiens\t3.0\n" +
                "\tShe's Out Of My League\t3.5\n" +
                "\tScooby-Doo and the Alien Invaders\t1.5\n" +
                "\tDespicable Me 2\t15.0\n" +
                "\tSalt\t2.0\n" +
                "Amount owed is 25.0\n" +
                "You earned 6 frequent renter points";

        assertEquals(expectedResult, customer.statement());
    }

    @Test
    public void shouldPrintHTMLStatement() {
        Customer customer = new Customer("Krishna Sure");
        int[] daysRented = {4, 3, 2, 5, 1};

        ArrayList<Movie> movieArrayList = new ArrayList<>();
        movieArrayList.add(new Movie("102 Dalmatiens", Movie.CHILDRENS));
        movieArrayList.add(new Movie("She's Out Of My League", Movie.REGULAR));
        movieArrayList.add(new Movie("Scooby-Doo and the Alien Invaders", Movie.CHILDRENS));
        movieArrayList.add(new Movie("Despicable Me 2", Movie.NEW_RELEASE));
        movieArrayList.add(new Movie("Salt", Movie.REGULAR));

        for (int i = 0; i < movieArrayList.size(); i++) {
            customer.addRental(new Rental(movieArrayList.get(i), daysRented[i]));
        }

        String expectedResult = "<H1>Rentals for <EM>Krishna Sure</EM></H1><P>\n" +
                "102 Dalmatiens: 3.0<BR>\n" +
                "She's Out Of My League: 3.5<BR>\n" +
                "Scooby-Doo and the Alien Invaders: 1.5<BR>\n" +
                "Despicable Me 2: 15.0<BR>\n" +
                "Salt: 2.0<BR>\n" +
                "<P>You owed <EM>25.0</EM><P>\n" +
                "On this rental you earned <EM>6</EM> frequent renter points<P>";

        assertEquals(expectedResult, customer.htmlStatement());
    }
}
