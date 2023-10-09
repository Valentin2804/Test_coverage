public class Truck extends Vehicle{
    private int maxLoadedWeight;
    private double maxLoadedVolume;

    public Truck(String maker, String model, int year, String color, double price, int maxLoadedWeight, double maxLoadedVolume) {
        super(maker, model, year, color, price);
        if(maxLoadedWeight <= 0 || maxLoadedVolume <= 0)
        {
            throw new IllegalArgumentException("Invalid max loaded weight or volume provided");
        }
        this.maxLoadedWeight = maxLoadedWeight;
        this.maxLoadedVolume = maxLoadedVolume;
    }
}
