package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class ForceIndexDiffblueTest {
  /**
   * Method under test: {@link ForceIndex#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    ForceIndex forceIndex = new ForceIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, forceIndex.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ForceIndex#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    ForceIndex forceIndex = new ForceIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, forceIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link ForceIndex#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    ForceIndex forceIndex = new ForceIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, forceIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link ForceIndex#ForceIndex(Time)}
   */
  @Test
  void testNewForceIndex() {
    // Arrange and Act
    ForceIndex actualForceIndex = new ForceIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("ForceIndex", actualForceIndex.getName());
    assertEquals(0L, actualForceIndex.getTimePeriod());
    assertTrue(actualForceIndex.getProperties().isEmpty());
  }
}
