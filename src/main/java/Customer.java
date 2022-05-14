import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String newname) {
        name = newname;
    }

    ;

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    ;

    public String getName() {
        return name;
    }

    ;

    public String statement() {
        Enumeration enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(this.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(this.getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double totalAmount = 0;
        Enumeration rentalEnum = rentals.elements();
        while(rentalEnum.hasMoreElements()) {
            Rental rental = (Rental) rentalEnum.nextElement();
            totalAmount += rental.getCharge();
        }
        return totalAmount;
    }

    private int getTotalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        Enumeration rentalEnum = rentals.elements();
        while(rentalEnum.hasMoreElements()) {
            Rental rental = (Rental) rentalEnum.nextElement();
            totalFrequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }

}
