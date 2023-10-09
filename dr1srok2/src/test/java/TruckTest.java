import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {

    @Test
    void TruckCFailInvalidWeightOrVolume()
    {
        assertThrows(IllegalArgumentException.class, ()->new Truck("az", "aaa", 2000, "kon"
                , 200.9, 1, -1.2));
    }

}