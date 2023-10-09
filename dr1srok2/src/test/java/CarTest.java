import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void CarCFailNoMaker()
    {
        assertThrows(IllegalArgumentException.class, ()->new Car("", "az", 2000, "dig"
                , 90.9, 2, 3, EquipmentLevel.SPORT));
    }

    @Test
    void CarCFailInvalidSeats()
    {
        assertThrows(IllegalArgumentException.class, ()->new Car("aaa", "az", 2000, "dig"
                , 90.9, 1, 3, EquipmentLevel.SPORT));
    }

}