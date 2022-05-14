import java.lang.*;
import java.util.*;

class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration<Rental> enum_rentals = rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();
            //show figures for this rental
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append("\t").append(each.getDaysRented()).append("\t").append(each.getCharge()).append("\n");
        }
        //add footer lines
        result.append("Amount owed is ").append(this.getTotalCharge()).append("\n");
        result.append("You earned ").append(this.getTotalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }

    public String htmlStatement() {
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("<h1>Rentals for <em>" + getName() + "</em></h1><p>\n");
        while(rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            // show figures for each rental
            result.append(each.getMovie().getTitle()).append(": ").append(each.getCharge()).append("<br>\n");
        }
        // add footer lines
        result.append("</p>You owe <em>").append(this.getTotalCharge()).append("</em><p>\n");
        result.append("On this rental you earned <em>").append(this.getTotalFrequentRenterPoints()).append("</em> frequent renter points</p>");
        return result.toString();
    }

    private double getTotalCharge() {
        double totalAmount = 0;
        Enumeration<Rental> rentalEnum = rentals.elements();
        while (rentalEnum.hasMoreElements()) {
            Rental rental = rentalEnum.nextElement();
            totalAmount += rental.getCharge();
        }
        return totalAmount;
    }

    private int getTotalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        Enumeration<Rental> rentalEnum = rentals.elements();
        while (rentalEnum.hasMoreElements()) {
            Rental rental = rentalEnum.nextElement();
            totalFrequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }

}
