package com.apple.model;

/**
 * @author apple created at: 15/12/20 下午7:09
 */
public class Rental {
    private Movie _movie;

    private int _daysRented; // 租期

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }


    public double getCharge() {
        return _movie.getCharge(_daysRented);
    }

}
