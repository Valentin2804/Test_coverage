import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SUVTest {

    @Test
    void SUVCFailInvalidClearance()
    {
        assertThrows(IllegalArgumentException.class, ()->new SUV("az", "ti", 200, "kol"
                , 4.9, true, 0));
    }

}