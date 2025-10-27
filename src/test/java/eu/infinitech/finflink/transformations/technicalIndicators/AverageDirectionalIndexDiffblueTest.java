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

class AverageDirectionalIndexDiffblueTest {
  /**
   * Method under test: {@link AverageDirectionalIndex#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();

    // Act and Assert
    assertEquals(Double.NaN, averageDirectionalIndex.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link AverageDirectionalIndex#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(null);

    // Act and Assert
    assertEquals(Double.NaN, averageDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link AverageDirectionalIndex#AverageDirectionalIndex()}
   */
  @Test
  void testNewAverageDirectionalIndex() {
    // Arrange and Act
    AverageDirectionalIndex actualAverageDirectionalIndex = new AverageDirectionalIndex();

    // Assert
    assertNull(actualAverageDirectionalIndex.getIndicatorRequirements());
    assertEquals(0L, actualAverageDirectionalIndex.getTimePeriod());
  }

  /**
   * Method under test:
   * {@link AverageDirectionalIndex#AverageDirectionalIndex(Time)}
   */
  @Test
  void testNewAverageDirectionalIndex2() {
    // Arrange and Act
    AverageDirectionalIndex actualAverageDirectionalIndex = new AverageDirectionalIndex(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("AverageDirectionalIndex", actualAverageDirectionalIndex.getName());
    assertEquals(0L, actualAverageDirectionalIndex.getTimePeriod());
    assertTrue(actualAverageDirectionalIndex.getProperties().isEmpty());
  }
}
