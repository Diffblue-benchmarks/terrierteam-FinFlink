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

class AverageTrueRangeDiffblueTest {
  /**
   * Method under test: {@link AverageTrueRange#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    AverageTrueRange averageTrueRange = new AverageTrueRange();

    // Act and Assert
    assertEquals(0.0d, averageTrueRange.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link AverageTrueRange#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    AverageTrueRange averageTrueRange = new AverageTrueRange();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(null);

    // Act and Assert
    assertEquals(0.0d, averageTrueRange.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link AverageTrueRange#AverageTrueRange()}
   */
  @Test
  void testNewAverageTrueRange() {
    // Arrange and Act
    AverageTrueRange actualAverageTrueRange = new AverageTrueRange();

    // Assert
    assertNull(actualAverageTrueRange.getIndicatorRequirements());
    assertEquals(0L, actualAverageTrueRange.getTimePeriod());
  }

  /**
   * Method under test: {@link AverageTrueRange#AverageTrueRange(Time)}
   */
  @Test
  void testNewAverageTrueRange2() {
    // Arrange and Act
    AverageTrueRange actualAverageTrueRange = new AverageTrueRange(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("AverageTrueRange", actualAverageTrueRange.getName());
    assertEquals(0L, actualAverageTrueRange.getTimePeriod());
    assertTrue(actualAverageTrueRange.getProperties().isEmpty());
  }
}
