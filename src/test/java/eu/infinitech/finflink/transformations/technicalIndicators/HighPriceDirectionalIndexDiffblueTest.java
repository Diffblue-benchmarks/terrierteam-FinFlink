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

class HighPriceDirectionalIndexDiffblueTest {
  /**
   * Method under test: {@link HighPriceDirectionalIndex#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    HighPriceDirectionalIndex highPriceDirectionalIndex = new HighPriceDirectionalIndex();

    // Act and Assert
    assertEquals(Double.NaN, highPriceDirectionalIndex.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link HighPriceDirectionalIndex#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    HighPriceDirectionalIndex highPriceDirectionalIndex = new HighPriceDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(null);

    // Act and Assert
    assertEquals(Double.NaN, highPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test:
   * {@link HighPriceDirectionalIndex#HighPriceDirectionalIndex()}
   */
  @Test
  void testNewHighPriceDirectionalIndex() {
    // Arrange and Act
    HighPriceDirectionalIndex actualHighPriceDirectionalIndex = new HighPriceDirectionalIndex();

    // Assert
    assertNull(actualHighPriceDirectionalIndex.getIndicatorRequirements());
    assertEquals(0L, actualHighPriceDirectionalIndex.getTimePeriod());
  }

  /**
   * Method under test:
   * {@link HighPriceDirectionalIndex#HighPriceDirectionalIndex(Time)}
   */
  @Test
  void testNewHighPriceDirectionalIndex2() {
    // Arrange and Act
    HighPriceDirectionalIndex actualHighPriceDirectionalIndex = new HighPriceDirectionalIndex(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("HighPriceDirectionalIndex", actualHighPriceDirectionalIndex.getName());
    assertEquals(0L, actualHighPriceDirectionalIndex.getTimePeriod());
    assertTrue(actualHighPriceDirectionalIndex.getProperties().isEmpty());
  }
}
