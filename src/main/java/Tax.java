public enum Tax {
    TAX_RATE(12.5);

    private double rate;

    Tax(double value) {
        this.rate = value;
    }

    public double getTaxRate() {
        return this.rate;
    }
}
