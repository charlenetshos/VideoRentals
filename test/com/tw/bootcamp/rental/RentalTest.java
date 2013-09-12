package com.tw.bootcamp.rental;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalTest {
    @Test
    public void shouldKnowMovieName() throws Exception {
        Rental rental = new Rental(new Movie("title", Movie.CHILDREN), 1);
        assertEquals("title", rental.movieName());
    }

    @Test
    public void shouldCalculateAmountForARegularOneDayRental() throws Exception {
        Rental rental = new Rental(new Movie("", Movie.REGULAR), 1);
        assertEquals(2, rental.calculateAmount(), 0.001);
    }

    @Test
     public void shouldCalculateAmountForARegularLessThanThreeDaysRental() throws Exception {
        Rental rental = new Rental(new Movie("", Movie.REGULAR), 2);
        assertEquals(2, rental.calculateAmount(), 0.001);
    }

    @Test
    public void shouldCalculateAmountForARegularMoreThanTwoDaysRental() throws Exception {
        Rental rental = new Rental(new Movie("", Movie.REGULAR), 3);
        assertEquals(3.5, rental.calculateAmount(), 0.001);
    }

    @Test
    public void shouldCalculateAmountForARegularFourDaysRental() throws Exception {
        Rental rental = new Rental(new Movie("", Movie.REGULAR), 4);
        assertEquals(5, rental.calculateAmount(), 0.001);
    }
}
