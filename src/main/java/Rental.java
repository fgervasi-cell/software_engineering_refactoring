class Rental {
    private final Movie movie;
    private final int daysRented;
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        return this.movie.getCharge(this.daysRented);
    }

    public int getFrequentRenterPoints() {
        if (this.getMovie().getPriceCode() == Movie.NEW_RELEASE && this.getDaysRented() > 1) {
            return 2;
        }
        return 1;
    }
}
