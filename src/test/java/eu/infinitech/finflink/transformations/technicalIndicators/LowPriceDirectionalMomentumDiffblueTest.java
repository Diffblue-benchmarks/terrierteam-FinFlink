package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class LowPriceDirectionalMomentumDiffblueTest {
  /**
   * Method under test: {@link LowPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    LowPriceDirectionalMomentum lowPriceDirectionalMomentum = new LowPriceDirectionalMomentum();

    // Act and Assert
    assertEquals(0.0d, lowPriceDirectionalMomentum.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link LowPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    LowPriceDirectionalMomentum lowPriceDirectionalMomentum = new LowPriceDirectionalMomentum();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(null);

    // Act and Assert
    assertEquals(0.0d, lowPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Method under test:
   * {@link LowPriceDirectionalMomentum#LowPriceDirectionalMomentum()}
   */
  @Test
  void testNewLowPriceDirectionalMomentum() {
    // Arrange and Act
    LowPriceDirectionalMomentum actualLowPriceDirectionalMomentum = new LowPriceDirectionalMomentum();

    // Assert
    assertNull(actualLowPriceDirectionalMomentum.getIndicatorRequirements());
    assertEquals(0L, actualLowPriceDirectionalMomentum.getTimePeriod());
  }

  /**
   * Method under test:
   * {@link LowPriceDirectionalMomentum#LowPriceDirectionalMomentum(Time)}
   */
  @Test
  void testNewLowPriceDirectionalMomentum2() {
    // Arrange and Act
    LowPriceDirectionalMomentum actualLowPriceDirectionalMomentum = new LowPriceDirectionalMomentum(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("LowPriceDirectionalMomentum", actualLowPriceDirectionalMomentum.getName());
    assertEquals(0L, actualLowPriceDirectionalMomentum.getTimePeriod());
    assertTrue(actualLowPriceDirectionalMomentum.getProperties().isEmpty());
  }
}
