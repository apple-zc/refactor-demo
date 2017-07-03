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
        double totalAmount = 0; // 消费总额
        int frequentRenterPoints = 0; // 常客积分
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) { // 租借多个片子时
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += getFrequentRenterPoints(each);
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private int getFrequentRenterPoints(Rental rental){
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
            return 2;
        else
            return 1;
    }


}
