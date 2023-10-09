public class Car extends Vehicle{
    private int seatNumber;
    private int doorNumber;

    private EquipmentLevel equipmentLevel;

    public Car(String maker, String model, int year, String color, double price, int seatNumber, int doorNumber
            , EquipmentLevel equipmentLevel) {
        super(maker, model, year, color, price);
        if(seatNumber < 2 || seatNumber > 5 || doorNumber < 2 || doorNumber > 5)
        {
            throw new IllegalArgumentException("Invalid data provided");
        }
        this.seatNumber = seatNumber;
        this.doorNumber = doorNumber;
        this.equipmentLevel = equipmentLevel;
    }

    public EquipmentLevel getEquipmentLevel() {
        return equipmentLevel;
    }
}
