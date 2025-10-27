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

class MovingAverageConvergenceDivergenceDiffblueTest {
  /**
   * Method under test: {@link MovingAverageConvergenceDivergence#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    MovingAverageConvergenceDivergence movingAverageConvergenceDivergence = new MovingAverageConvergenceDivergence(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, movingAverageConvergenceDivergence.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link MovingAverageConvergenceDivergence#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    MovingAverageConvergenceDivergence movingAverageConvergenceDivergence = new MovingAverageConvergenceDivergence(
        Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, movingAverageConvergenceDivergence.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link MovingAverageConvergenceDivergence#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    MovingAverageConvergenceDivergence movingAverageConvergenceDivergence = new MovingAverageConvergenceDivergence(
        Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, movingAverageConvergenceDivergence.calculate(periodsToConsider));
  }

  /**
   * Method under test:
   * {@link MovingAverageConvergenceDivergence#MovingAverageConvergenceDivergence(Time)}
   */
  @Test
  void testNewMovingAverageConvergenceDivergence() {
    // Arrange and Act
    MovingAverageConvergenceDivergence actualMovingAverageConvergenceDivergence = new MovingAverageConvergenceDivergence(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("MovingAverageConvergenceDivergence", actualMovingAverageConvergenceDivergence.getName());
    assertNull(actualMovingAverageConvergenceDivergence.getIndicatorRequirements());
    assertEquals(0, actualMovingAverageConvergenceDivergence.longSpan);
    assertEquals(0, actualMovingAverageConvergenceDivergence.shortSpan);
    assertEquals(0L, actualMovingAverageConvergenceDivergence.getTimePeriod());
    assertTrue(actualMovingAverageConvergenceDivergence.getProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link MovingAverageConvergenceDivergence#MovingAverageConvergenceDivergence(Time, int, int)}
   */
  @Test
  void testNewMovingAverageConvergenceDivergence2() {
    // Arrange and Act
    MovingAverageConvergenceDivergence actualMovingAverageConvergenceDivergence = new MovingAverageConvergenceDivergence(
        Time.of(3L, TimeUnit.NANOSECONDS), 1, 1);

    // Assert
    assertEquals("MovingAverageConvergenceDivergence", actualMovingAverageConvergenceDivergence.getName());
    assertEquals(0L, actualMovingAverageConvergenceDivergence.getTimePeriod());
    assertEquals(1, actualMovingAverageConvergenceDivergence.longSpan);
    assertEquals(1, actualMovingAverageConvergenceDivergence.shortSpan);
    assertTrue(actualMovingAverageConvergenceDivergence.getProperties().isEmpty());
  }
}
