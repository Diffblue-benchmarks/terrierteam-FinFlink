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

class MomentumDiffblueTest {
  /**
   * Method under test: {@link Momentum#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    Momentum momentum = new Momentum(10);

    // Act and Assert
    assertEquals(0.0d, momentum.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link Momentum#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    Momentum momentum = new Momentum(10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, momentum.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link Momentum#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    Momentum momentum = new Momentum(10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, momentum.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link Momentum#calculate(List)}
   */
  @Test
  void testCalculate4() {
    // Arrange
    Momentum momentum = new Momentum(0);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, momentum.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link Momentum#Momentum(int)}
   */
  @Test
  void testNewMomentum() {
    // Arrange and Act
    Momentum actualMomentum = new Momentum(10);

    // Assert
    assertNull(actualMomentum.getIndicatorRequirements());
    assertEquals(0L, actualMomentum.getTimePeriod());
  }

  /**
   * Method under test: {@link Momentum#Momentum(Time, int)}
   */
  @Test
  void testNewMomentum2() {
    // Arrange and Act
    Momentum actualMomentum = new Momentum(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    // Assert
    assertEquals("Momentum", actualMomentum.getName());
    assertEquals(0L, actualMomentum.getTimePeriod());
    assertEquals(10, actualMomentum.numPeriods);
    assertTrue(actualMomentum.getProperties().isEmpty());
  }
}
