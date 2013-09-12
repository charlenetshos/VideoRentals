package com.tw.bootcamp.rental;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalTest {
    @Test
    public void shouldKnowMovieName() throws Exception {
        Rental rental = new Rental(new Movie("title", Movie.Type.CHILDREN), 1);
        assertEquals("title", rental.movieName());
    }

    @Test
    public void shouldCalculateAmountForARegularOneDayRental() throws Exception {
        Rental rental = new Rental(new Movie("", Movie.Type.REGULAR), 1);
        assertEquals(2, rental.calculateAmount(), 0.001);
    }

    @Test
     public void shouldCalculateAmountForARegularLessThanThreeDaysRental() throws Exception {
        Rental rental = new Rental(new Movie("", Movie.Type.REGULAR), 2);
        assertEquals(2, rental.calculateAmount(), 0.001);
    }

    @Test
    public void shouldCalculateAmountForARegularMoreThanTwoDaysRental() throws Exception {
        Rental rental = new Rental(new Movie("", Movie.Type.REGULAR), 3);
        assertEquals(3.5, rental.calculateAmount(), 0.001);
    }

    @Test
    public void shouldCalculateAmountForARegularFourDaysRental() throws Exception {
        Rental rental = new Rental(new Movie("", Movie.Type.REGULAR), 4);
        assertEquals(5, rental.calculateAmount(), 0.001);
    }

    @Test
    public void shouldCalculateAmountForNewReleaseOneDayRental() throws Exception {
        Rental rental = new Rental(new Movie("", Movie.Type.NEW_RELEASE), 1);
        assertEquals(3, rental.calculateAmount(), 0.001);
    }

    @Test
    public void shouldCalculateAmountForNewReleaseSevenDaysRental() throws Exception {
        Rental rental = new Rental(new Movie("", Movie.Type.NEW_RELEASE), 7);
        assertEquals(21, rental.calculateAmount(), 0.001);
    }

    @Test
    public void shouldCalculateAmountForChildrenOneDayRental() throws Exception {
        Rental rental = new Rental(new Movie("", Movie.Type.CHILDREN), 1);
        assertEquals(1.5, rental.calculateAmount(), 0.001);
    }

    @Test
    public void shouldCalculateAmountForChildrenFiveDaysRental() throws Exception {
        Rental rental = new Rental(new Movie("", Movie.Type.CHILDREN), 5);
        assertEquals(4.5, rental.calculateAmount(), 0.001);
    }
}
