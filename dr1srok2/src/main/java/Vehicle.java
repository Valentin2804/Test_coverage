public abstract class Vehicle {
    private static int idcounter = -1;
    private final int id;
    private String maker;
    private String model;
    private int year;
    private String color;
    private double price;

    public Vehicle(String maker, String model, int year, String color, double price) {
        if(year > 2023 || year < 1885 || maker.isEmpty() || model.isEmpty() || color.isEmpty() || price <= 0)
        {
            throw new IllegalArgumentException("Invalid data provided");
        }
        id = idcounter;
        idcounter++;
        this.maker = maker;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getMaker() {
        return maker;
    }

    public double getPrice() {
        return price;
    }

    public static void setIdcounter(int idcounter) {
        Vehicle.idcounter = idcounter;
    }
}
