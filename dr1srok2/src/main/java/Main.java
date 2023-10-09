import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        VehicleDealer myVec = new VehicleDealer();

        Car car = new Car("az", "toi", 2012, "maika", 18, 2, 2
                , EquipmentLevel.SPORT);
        Truck truck = new Truck("az", "sss", 2000, "sin", 400.8
                , 400, 30);
        SUV suv = new SUV("koi", "AMG", 2018, "haha", 200, true, 200.5);
        SUV suv1 = new SUV("ko", "AMG", 2015, "ha", 500.2, false, 150.5);
        Car car1 = new Car("aha", "kopa", 1900, "cheren", 300.78, 3
                , 5, EquipmentLevel.PREMIUM);
        myVec.addVehicle(car);
        myVec.addVehicle(truck);
        myVec.addVehicle(suv);
        myVec.addVehicle(car1);

        for (String marks : myVec.getAllVehiclesByIdByMaker().keySet()) {
            System.out.println("Mark: " + marks);
            HashMap<Integer, Vehicle> Map = myVec.getAllVehiclesByIdByMaker().get(marks);
            for (Integer id : Map.keySet()) {
                Vehicle vehicle = Map.get(id);
                System.out.println("ID: " + id + ", Inner value: " + vehicle);
            }
        }

        System.out.println();

        for(Vehicle vehicle : myVec.getAllSUVWith4By4())
        {
            System.out.println(vehicle);
        }

        System.out.println();

        for(Vehicle vehicle : myVec.getAllCarsWithEquipmentLevel(EquipmentLevel.PREMIUM))
        {
            System.out.println(vehicle);
        }

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);

        System.out.println();

        System.out.println(myVec.getCheapestVehicle(vehicles));

        System.out.println();

        System.out.println(myVec.getTotalNumberOfModels("az"));

        myVec.sellVehicle(2);

        System.out.println();

        for (String marks : myVec.getAllVehiclesByIdByMaker().keySet()) {
            System.out.println("Mark: " + marks);
            HashMap<Integer, Vehicle> Map = myVec.getAllVehiclesByIdByMaker().get(marks);
            for (Integer id : Map.keySet()) {
                Vehicle vehicle = Map.get(id);
                System.out.println("ID: " + id + ", Inner value: " + vehicle);
            }
        }
    }
}