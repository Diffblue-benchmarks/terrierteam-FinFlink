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

class HighPriceDirectionalMomentumDiffblueTest {
  /**
   * Method under test: {@link HighPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    HighPriceDirectionalMomentum highPriceDirectionalMomentum = new HighPriceDirectionalMomentum();

    // Act and Assert
    assertEquals(0.0d, highPriceDirectionalMomentum.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link HighPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    HighPriceDirectionalMomentum highPriceDirectionalMomentum = new HighPriceDirectionalMomentum();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(null);

    // Act and Assert
    assertEquals(0.0d, highPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Method under test:
   * {@link HighPriceDirectionalMomentum#HighPriceDirectionalMomentum()}
   */
  @Test
  void testNewHighPriceDirectionalMomentum() {
    // Arrange and Act
    HighPriceDirectionalMomentum actualHighPriceDirectionalMomentum = new HighPriceDirectionalMomentum();

    // Assert
    assertNull(actualHighPriceDirectionalMomentum.getIndicatorRequirements());
    assertEquals(0L, actualHighPriceDirectionalMomentum.getTimePeriod());
  }

  /**
   * Method under test:
   * {@link HighPriceDirectionalMomentum#HighPriceDirectionalMomentum(Time)}
   */
  @Test
  void testNewHighPriceDirectionalMomentum2() {
    // Arrange and Act
    HighPriceDirectionalMomentum actualHighPriceDirectionalMomentum = new HighPriceDirectionalMomentum(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("HighPriceDirectionalMomentum", actualHighPriceDirectionalMomentum.getName());
    assertEquals(0L, actualHighPriceDirectionalMomentum.getTimePeriod());
    assertTrue(actualHighPriceDirectionalMomentum.getProperties().isEmpty());
  }
}
