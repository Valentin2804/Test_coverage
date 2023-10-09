import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class VehicleDealerTest {

    @AfterEach
    void remove()
    {
        Vehicle.setIdcounter(0);
    }

    @Test
    void addVehicle() {
        VehicleDealer myVec = new VehicleDealer();
        Car car = new Car("az", "toi", 2012, "maika", 18, 2, 2
                , EquipmentLevel.SPORT);

        myVec.addVehicle(car);

        assertEquals(1, myVec.getCars().size());
    }

    @Test
    void getAllVehiclesByIdByMaker() {
        VehicleDealer myVec = new VehicleDealer();
        Car car = new Car("az", "toi", 2012, "maika", 18, 2, 2
                , EquipmentLevel.SPORT);
        Truck truck = new Truck("az", "sss", 2000, "sin", 400
                , 400, 30);
        SUV suv = new SUV("koi", "AMG", 2018, "haha", 200, true, 200.5);
        myVec.addVehicle(car);
        myVec.addVehicle(truck);
        myVec.addVehicle(suv);

        HashMap<String, HashMap<Integer, Vehicle>> myMap = new HashMap<>();
        HashMap<Integer, Vehicle> map1 = new HashMap<>();
        map1.put(0, car);
        map1.put(1, truck);
        HashMap<Integer, Vehicle> map2 = new HashMap<>();
        map2.put(2, suv);

        myMap.put("az", map1);
        myMap.put("koi", map2);

        assertEquals(myMap, myVec.getAllVehiclesByIdByMaker());
    }



    @Test
    void getAllSUVWith4By4() {
        VehicleDealer myVec = new VehicleDealer();
        SUV suv = new SUV("koi", "AMG", 2018, "haha", 200, true, 200.5);
        SUV suv1 = new SUV("koi", "AMG", 2018, "haha", 200, false, 200.5);
        myVec.addVehicle(suv);
        myVec.addVehicle(suv1);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(suv);

        assertEquals(vehicles, myVec.getAllSUVWith4By4());
    }

    @Test
    void getAllCarsWithEquipmentLevel() {
        VehicleDealer myVec = new VehicleDealer();
        Car car = new Car("az", "toi", 2012, "maika", 18, 2, 2
                , EquipmentLevel.SPORT);
        Car car1 = new Car("az", "toi", 2012, "maika", 18, 2, 2
                , EquipmentLevel.BASIC);
        myVec.addVehicle(car);
        myVec.addVehicle(car1);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);

        assertEquals(cars, myVec.getAllCarsWithEquipmentLevel(EquipmentLevel.BASIC));
    }

    @Test
    void getCheapestVehicle() {
        VehicleDealer myVec = new VehicleDealer();
        Car car = new Car("az", "toi", 2012, "maika", 18, 2, 2
                , EquipmentLevel.SPORT);
        Truck truck = new Truck("az", "sss", 2000, "sin", 400.8
                , 400, 30);
        SUV suv = new SUV("koi", "AMG", 2018, "haha", 200, true, 200.5);
        myVec.addVehicle(car);
        myVec.addVehicle(truck);
        myVec.addVehicle(suv);

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);

        assertEquals(car, myVec.getCheapestVehicle(vehicles));
    }

    @Test
    void getTotalNumberOfModels() {
        VehicleDealer myVec = new VehicleDealer();
        Car car = new Car("az", "toi", 2012, "maika", 18, 2, 2
                , EquipmentLevel.SPORT);
        Truck truck = new Truck("az", "sss", 2000, "sin", 400.8
                , 400, 30);
        SUV suv = new SUV("koi", "AMG", 2018, "haha", 200, true, 200.5);
        myVec.addVehicle(car);
        myVec.addVehicle(truck);
        myVec.addVehicle(suv);

        assertEquals(2, myVec.getTotalNumberOfModels("az"));
    }

    @Test
    void sellVehicleTurnover() {
        VehicleDealer myVec = new VehicleDealer();
        Car car = new Car("az", "toi", 2012, "maika", 18, 2, 2
                , EquipmentLevel.SPORT);
        Truck truck = new Truck("az", "sss", 2000, "sin", 400.8
                , 400, 30);
        SUV suv = new SUV("koi", "AMG", 2018, "haha", 200, true, 200.5);
        myVec.addVehicle(car);
        myVec.addVehicle(truck);
        myVec.addVehicle(suv);

        myVec.sellVehicle(0);

        assertEquals(18, myVec.getTurnover());
    }

    @Test
    void sellVehicleRemoveCar() {
        VehicleDealer myVec = new VehicleDealer();
        Car car = new Car("az", "toi", 2012, "maika", 18, 2, 2
                , EquipmentLevel.SPORT);
        Truck truck = new Truck("az", "sss", 2000, "sin", 400.8
                , 400, 30);
        SUV suv = new SUV("koi", "AMG", 2018, "haha", 200, true, 200.5);
        myVec.addVehicle(car);
        myVec.addVehicle(truck);
        myVec.addVehicle(suv);

        myVec.sellVehicle(0);

        assertEquals(0, myVec.getCars().size());
    }

    @Test
    void sellVehicleFail() {
        VehicleDealer myVec = new VehicleDealer();
        Car car = new Car("az", "toi", 2012, "maika", 18, 2, 2
                , EquipmentLevel.SPORT);
        Truck truck = new Truck("az", "sss", 2000, "sin", 400.8
                , 400, 30);
        SUV suv = new SUV("koi", "AMG", 2018, "haha", 200, true, 200.5);
        myVec.addVehicle(car);
        myVec.addVehicle(truck);
        myVec.addVehicle(suv);

        assertThrows(IllegalArgumentException.class, ()->myVec.sellVehicle(4));
    }

    @Test
    void sellVehicleRemoveSUV() {
        VehicleDealer myVec = new VehicleDealer();
        Car car = new Car("az", "toi", 2012, "maika", 18, 2, 2
                , EquipmentLevel.SPORT);
        Truck truck = new Truck("az", "sss", 2000, "sin", 400.8
                , 400, 30);
        SUV suv = new SUV("koi", "AMG", 2018, "haha", 200, true, 200.5);
        myVec.addVehicle(car);
        myVec.addVehicle(truck);
        myVec.addVehicle(suv);

        myVec.sellVehicle(2);

        assertEquals(0, myVec.getSuvs().size());
    }

    @Test
    void sellVehicleRemoveTruck() {
        VehicleDealer myVec = new VehicleDealer();
        Car car = new Car("az", "toi", 2012, "maika", 18, 2, 2
                , EquipmentLevel.SPORT);
        Truck truck = new Truck("az", "sss", 2000, "sin", 400.8
                , 400, 30);
        SUV suv = new SUV("koi", "AMG", 2018, "haha", 200, true, 200.5);
        myVec.addVehicle(car);
        myVec.addVehicle(truck);
        myVec.addVehicle(suv);

        myVec.sellVehicle(1);

        assertEquals(0, myVec.getTrucks().size());
    }
}