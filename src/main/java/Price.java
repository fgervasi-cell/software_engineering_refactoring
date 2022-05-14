public abstract class Price {
    abstract int getPriceCode();

    public double getCharge(int daysRented) {
        double result = 0;
        switch (this.getPriceCode()) {
            case Movie.REGULAR -> {
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> result += daysRented * 3;
            case Movie.CHILDREN -> {
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
            }
        }
        return result;
    }
}
