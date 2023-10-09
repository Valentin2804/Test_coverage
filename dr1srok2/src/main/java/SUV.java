public class SUV extends Vehicle{
    private boolean has4by4;
    private double clearance;

    public SUV(String maker, String model, int year, String color, double price, boolean has4by4, double clearance) {
        super(maker, model, year, color, price);
        if(clearance <= 0)
        {
            throw new IllegalArgumentException("Invalid clearance provided");
        }
        this.has4by4 = has4by4;
        this.clearance = clearance;
    }

    public boolean isHas4by4() {
        return has4by4;
    }
}
