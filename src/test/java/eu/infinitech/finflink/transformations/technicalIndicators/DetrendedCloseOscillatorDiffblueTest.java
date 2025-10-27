package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class DetrendedCloseOscillatorDiffblueTest {
  /**
   * Method under test: {@link DetrendedCloseOscillator#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    DetrendedCloseOscillator detrendedCloseOscillator = new DetrendedCloseOscillator(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, detrendedCloseOscillator.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link DetrendedCloseOscillator#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    DetrendedCloseOscillator detrendedCloseOscillator = new DetrendedCloseOscillator(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, detrendedCloseOscillator.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link DetrendedCloseOscillator#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    DetrendedCloseOscillator detrendedCloseOscillator = new DetrendedCloseOscillator(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, detrendedCloseOscillator.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link DetrendedCloseOscillator#calculate(List)}
   */
  @Test
  void testCalculate4() {
    // Arrange
    DetrendedCloseOscillator detrendedCloseOscillator = new DetrendedCloseOscillator(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, detrendedCloseOscillator.calculate(periodsToConsider));
  }

  /**
   * Method under test:
   * {@link DetrendedCloseOscillator#DetrendedCloseOscillator(Time)}
   */
  @Test
  void testNewDetrendedCloseOscillator() {
    // Arrange and Act
    DetrendedCloseOscillator actualDetrendedCloseOscillator = new DetrendedCloseOscillator(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("DetrendedCloseOscillator", actualDetrendedCloseOscillator.getName());
    assertEquals(0L, actualDetrendedCloseOscillator.getTimePeriod());
    assertTrue(actualDetrendedCloseOscillator.getProperties().isEmpty());
  }
}
