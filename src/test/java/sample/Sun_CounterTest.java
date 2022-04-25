package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Sun_CounterTest {
    Sun_Counter sun_counter;

    @BeforeEach
    public void setUp() {
        sun_counter = new Sun_Counter();
    }

    @Test
    public void testSetCount() {
        Assertions.assertEquals(0, sun_counter.getCount());
        sun_counter.setCount(1);
        Assertions.assertEquals(1, sun_counter.getCount());
        sun_counter.setCount(2);
        Assertions.assertEquals(3, sun_counter.getCount());
    }


}
