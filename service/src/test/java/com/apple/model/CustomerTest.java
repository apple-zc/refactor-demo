package com.apple.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author apple created at: 15/12/20 下午8:30
 */
public class CustomerTest {
  private static String originalStatement =
      "Rental Record for James" + "\n"
      + "\t" + "普通片" + "\t" + "5.0" + "\n"
      + "\t" + "新片" + "\t" + "15.0" + "\n"
      + "\t" + "儿童片" + "\t" + "6.0" + "\n"
      + "Amount owed is 26.0" + "\n"
      + "You earned 4 frequent renter points";

  @Test
  public void testStatement() throws Exception {
    Customer customer = new Customer("James");

    Movie regularMovie = new Movie("普通片", 0);
    Movie newMovie = new Movie("新片", 1);
    Movie childMovie = new Movie("儿童片", 2);

    Rental regularRental = new Rental(regularMovie, 4);
    Rental newRental = new Rental(newMovie, 5);
    Rental childRental = new Rental(childMovie, 6);

    customer.addRental(regularRental);
    customer.addRental(newRental);
    customer.addRental(childRental);

    assertEquals(originalStatement, customer.statement());
  }
}