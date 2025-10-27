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

class AccumulationDistributionIndexDiffblueTest {
  /**
   * Method under test: {@link AccumulationDistributionIndex#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    AccumulationDistributionIndex accumulationDistributionIndex = new AccumulationDistributionIndex(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, accumulationDistributionIndex.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link AccumulationDistributionIndex#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    AccumulationDistributionIndex accumulationDistributionIndex = new AccumulationDistributionIndex(
        Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, accumulationDistributionIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link AccumulationDistributionIndex#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    AccumulationDistributionIndex accumulationDistributionIndex = new AccumulationDistributionIndex(
        Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, accumulationDistributionIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test:
   * {@link AccumulationDistributionIndex#AccumulationDistributionIndex(Time)}
   */
  @Test
  void testNewAccumulationDistributionIndex() {
    // Arrange and Act
    AccumulationDistributionIndex actualAccumulationDistributionIndex = new AccumulationDistributionIndex(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("AccumulationDistributionIndex", actualAccumulationDistributionIndex.getName());
    assertNull(actualAccumulationDistributionIndex.getIndicatorRequirements());
    assertEquals(0, actualAccumulationDistributionIndex.longSpan);
    assertEquals(0, actualAccumulationDistributionIndex.shortSpan);
    assertEquals(0L, actualAccumulationDistributionIndex.getTimePeriod());
    assertTrue(actualAccumulationDistributionIndex.getProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link AccumulationDistributionIndex#AccumulationDistributionIndex(Time, int, int)}
   */
  @Test
  void testNewAccumulationDistributionIndex2() {
    // Arrange and Act
    AccumulationDistributionIndex actualAccumulationDistributionIndex = new AccumulationDistributionIndex(
        Time.of(3L, TimeUnit.NANOSECONDS), 1, 1);

    // Assert
    assertEquals("AccumulationDistributionIndex", actualAccumulationDistributionIndex.getName());
    assertEquals(0L, actualAccumulationDistributionIndex.getTimePeriod());
    assertEquals(1, actualAccumulationDistributionIndex.longSpan);
    assertEquals(1, actualAccumulationDistributionIndex.shortSpan);
    assertTrue(actualAccumulationDistributionIndex.getProperties().isEmpty());
  }
}
