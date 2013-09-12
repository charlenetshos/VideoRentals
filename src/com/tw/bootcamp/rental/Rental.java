package com.tw.bootcamp.rental;

class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int frequenterPoints() {
        int frequentRenterPoints = 1;
        if ((movie.getMovieType() == Movie.Type.NEW_RELEASE) && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public String movieName() {
        return movie.getTitle();
    }

    public double calculateAmount() {
        double additionalDailyFee = 1.5;
        if (movie.getMovieType() == Movie.Type.CHILDREN) {
            int minimumDays = 3;
            if (daysRented > minimumDays) {
                return 1.5 + (daysRented - minimumDays) * additionalDailyFee * 1;
            }
            return 1.5;
        }
        if (movie.getMovieType() == Movie.Type.NEW_RELEASE) {
            int minimumDays = 0;
            if (daysRented > minimumDays) {
                return 0 + (daysRented - minimumDays) * additionalDailyFee * 2;
            }
            return 0;
        }
        int minimumDays = 2;
        if (daysRented > minimumDays)
            return 2 + (daysRented - minimumDays) * additionalDailyFee * 1;
        return 2;
    }
}