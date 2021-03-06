package com.apple.model;

/**
 * @author apple created at: 15/12/20 下午7:01
 */
public class Movie {

  public static final int CHILDRENS = 2;

  public static final int REGULAR = 0;

  public static final int NEW_RELEASE = 1;

  private String _title;

  private Price _price;

  public Movie(String title, int priceCode) {
    _title = title;
    setPriceCode(priceCode);
  }

  public int getPriceCode() {
    return _price.getPriceCode();
  }

  public void setPriceCode(int arg) {
    switch (arg) {
      case REGULAR : _price = new RegularPrice();
        break;
      case NEW_RELEASE : _price = new NewReleasePrice();
        break;
      case CHILDRENS : _price = new ChildrensPrice();
        break;
      default : throw new IllegalArgumentException("Incorrect Price Code");
    }
  }

  public String getTitle() {
    return _title;
  }

  public double getCharge(int daysRented) {
    return _price.getCharge(daysRented);
  }

  public int getFrequentRenterPoints(int daysRented) {
    return _price.getFrequentRenterPoints(daysRented);
  }

  abstract class Price {
    abstract int getPriceCode();

    abstract public double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
      return 1;
    }
  }

  class RegularPrice extends Price {

    @Override
    int getPriceCode() {
      return REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
      double result = 2;
      if (daysRented > 2)
        result += (daysRented - 2) * 1.5;

      return result;
    }
  }

  class NewReleasePrice extends Price {

    @Override
    int getPriceCode() {
      return NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
      return (double) (daysRented * 3);
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
      return daysRented > 1 ? 2 : 1;
    }
  }

  class ChildrensPrice extends Price {

    @Override
    int getPriceCode() {
      return CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
      double result = 1.5;

      if (daysRented > 3)
        result += (daysRented - 3) * 1.5;

      return result;
    }
  }

}
