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

class LowPriceDirectionalIndexDiffblueTest {
  /**
   * Method under test: {@link LowPriceDirectionalIndex#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    LowPriceDirectionalIndex lowPriceDirectionalIndex = new LowPriceDirectionalIndex();

    // Act and Assert
    assertEquals(Double.NaN, lowPriceDirectionalIndex.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link LowPriceDirectionalIndex#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    LowPriceDirectionalIndex lowPriceDirectionalIndex = new LowPriceDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(null);

    // Act and Assert
    assertEquals(Double.NaN, lowPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test:
   * {@link LowPriceDirectionalIndex#LowPriceDirectionalIndex()}
   */
  @Test
  void testNewLowPriceDirectionalIndex() {
    // Arrange and Act
    LowPriceDirectionalIndex actualLowPriceDirectionalIndex = new LowPriceDirectionalIndex();

    // Assert
    assertNull(actualLowPriceDirectionalIndex.getIndicatorRequirements());
    assertEquals(0L, actualLowPriceDirectionalIndex.getTimePeriod());
  }

  /**
   * Method under test:
   * {@link LowPriceDirectionalIndex#LowPriceDirectionalIndex(Time)}
   */
  @Test
  void testNewLowPriceDirectionalIndex2() {
    // Arrange and Act
    LowPriceDirectionalIndex actualLowPriceDirectionalIndex = new LowPriceDirectionalIndex(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("LowPriceDirectionalIndex", actualLowPriceDirectionalIndex.getName());
    assertEquals(0L, actualLowPriceDirectionalIndex.getTimePeriod());
    assertTrue(actualLowPriceDirectionalIndex.getProperties().isEmpty());
  }
}
