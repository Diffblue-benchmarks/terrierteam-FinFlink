package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class LogReturnsDiffblueTest {
  /**
   * Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    LogReturns logReturns = new LogReturns(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    // Act and Assert
    assertEquals(0.0d, logReturns.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    LogReturns logReturns = new LogReturns(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, logReturns.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    LogReturns logReturns = new LogReturns(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, logReturns.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  void testCalculate4() {
    // Arrange
    LogReturns logReturns = new LogReturns(Time.of(3L, TimeUnit.NANOSECONDS), 0);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, logReturns.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link LogReturns#LogReturns(Time, int)}
   */
  @Test
  void testNewLogReturns() {
    // Arrange and Act
    LogReturns actualLogReturns = new LogReturns(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    // Assert
    assertEquals("LogReturns", actualLogReturns.getName());
    assertEquals(0L, actualLogReturns.getTimePeriod());
    assertEquals(10, actualLogReturns.numPeriods);
    assertTrue(actualLogReturns.getProperties().isEmpty());
  }
}
