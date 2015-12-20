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
    return getMovie().getCharge(getDaysRented());
  }

  public int getFrequentRenterPoints() {
    // add bonus for a two day new release rental
    if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
      return 2;

    return 1;
  }

}
