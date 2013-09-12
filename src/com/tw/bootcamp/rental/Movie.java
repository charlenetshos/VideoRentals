package com.tw.bootcamp.rental;

public class Movie {
    private String title;
    private Type movieType;

    public Movie(String title, Type priceCode) {
        this.title = title;
        this.movieType = priceCode;
    }

    public Type getMovieType() {
        return movieType;
    }

    public String getTitle() {
        return title;
    }

    public enum Type {
        REGULAR(2, 1.5),
        NEW_RELEASE(0,0),
        CHILDREN(0,0);

        Type(int baseDays, double amount) {
            //To change body of created methods use File | Settings | File Templates.
        }
    }
}