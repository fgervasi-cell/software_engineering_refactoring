public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private final String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR -> this.price = new RegularPrice();
            case CHILDREN -> this.price = new ChildrensPrice();
            case NEW_RELEASE -> this.price = new NewReleasePrice();
            default -> throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return this.price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return this.price.getFrequentRenterPoints(daysRented);
    }
}
