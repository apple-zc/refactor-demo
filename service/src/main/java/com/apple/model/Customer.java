package com.apple.model;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author apple created at: 15/12/20 下午7:14
 */
public class Customer {
  private String _name;

  private Vector _rentals = new Vector();

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public String getName() {
    return _name;
  }

  public String statement() {
    int frequentRenterPoints = 0; // 常客积分
    Enumeration rentals = _rentals.elements();
    String result = "Rental Record for " + getName() + "\n";
    while (rentals.hasMoreElements()) { // 租借多个片子时
      Rental each = (Rental) rentals.nextElement();
      frequentRenterPoints += each.getFrequentRenterPoints();

      // show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
    }

    // add footer lines
    result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
    return result;
  }

  private double getTotalCharge() {
    double result = 0; // 消费总额
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()) { // 租借多个片子时
      Rental each = (Rental) rentals.nextElement();
      result += each.getCharge();
    }

    return result;
  }

}
