import java.util.*;
import java.util.stream.Stream;

public class VehicleDealer {
    private ArrayList<Car> cars;
    private ArrayList<SUV> suvs;
    private ArrayList <Truck> trucks;

    private double turnover;

    public VehicleDealer() {
        cars = new ArrayList<>();
        suvs = new ArrayList<>();
        trucks = new ArrayList<>();
        turnover = 0;
    }

   public void addVehicle(Vehicle vehicle)
   {
       if(Stream.of(cars, suvs, trucks).flatMap(Collection::stream)
               .filter(vehicle1 -> vehicle1.getId() == vehicle.getId()).count() == 1)
       {
           throw new IllegalArgumentException("Invalid id provided");
       }

       if(vehicle instanceof Car)
       {
           cars.add((Car) vehicle);
       }else if(vehicle instanceof SUV)
       {
           suvs.add((SUV) vehicle);
       }else
       {
           trucks.add((Truck) vehicle);
       }
   }

    public HashMap<String, HashMap<Integer, Vehicle>> getAllVehiclesByIdByMaker(){
        HashMap<String, HashMap<Integer, Vehicle>> myMap = new HashMap<>();

        Stream.of(cars, trucks, suvs)
                .flatMap(Collection::stream)
                .forEach(vehicle -> {
                    if(myMap.containsKey(vehicle.getMaker()))
                    {
                        myMap.get(vehicle.getMaker()).put(vehicle.getId(), vehicle);
                    }else
                    {
                        HashMap<Integer, Vehicle> miniMap = new HashMap<>();
                        miniMap.put(vehicle.getId(), vehicle);
                        myMap.put(vehicle.getMaker(), miniMap);
                    }
                });

        return myMap;
    }

    public List<SUV> getAllSUVWith4By4()
    {
        return suvs.stream().filter(SUV::isHas4by4).toList();
    }

    public List<Car>getAllCarsWithEquipmentLevel(EquipmentLevel equipmentLevel)
    {
        return cars.stream().filter(car -> car.getEquipmentLevel() == equipmentLevel).toList();
    }

    public Vehicle getCheapestVehicle(Collection vehicles)
    {
        return (Vehicle) vehicles.stream().min(new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return (int) (v1.getPrice() - v2.getPrice());
            }
        }).get();
    }

    public long getTotalNumberOfModels(String maker){
         return Stream.of(cars, trucks, suvs).flatMap(Collection::stream).
                filter(vehicle -> vehicle.getMaker().equals(maker)).count();
    }

    public void sellVehicle(int vehicleId)
    {
        if(Stream.of(cars, suvs, trucks).flatMap(Collection::stream)
                .noneMatch(vehicle -> vehicle.getId() == vehicleId))
        {
            throw new IllegalArgumentException("Invalid id provided");
        }

        if(cars.stream().anyMatch(car -> car.getId() == vehicleId))
        {
            Car car1 = cars.stream().filter(car -> car.getId() == vehicleId).findFirst().get();
            turnover = turnover + car1.getPrice();
            cars.remove(car1);
        }else if(suvs.stream().anyMatch(suv -> suv.getId() == vehicleId))
        {
            SUV suv1 = suvs.stream().filter(suv -> suv.getId() == vehicleId).findFirst().get();
            turnover = turnover + suv1.getPrice();
            suvs.remove(suv1);
        }else
        {
            Truck truck1 = trucks.stream().filter(truck -> truck.getId() == vehicleId).findFirst().get();
            turnover = turnover + truck1.getPrice();
            trucks.remove(truck1);
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<SUV> getSuvs() {
        return suvs;
    }

    public ArrayList<Truck> getTrucks() {
        return trucks;
    }

    public double getTurnover() {
        return turnover;
    }
}
