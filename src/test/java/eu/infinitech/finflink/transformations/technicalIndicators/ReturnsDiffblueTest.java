package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class ReturnsDiffblueTest {
  /**
   * Method under test: {@link Returns#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    Returns returns = new Returns(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    // Act and Assert
    assertEquals(0.0d, returns.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link Returns#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    Returns returns = new Returns(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, returns.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link Returns#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    Returns returns = new Returns(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, returns.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link Returns#calculate(List)}
   */
  @Test
  void testCalculate4() {
    // Arrange
    Returns returns = new Returns(Time.of(3L, TimeUnit.NANOSECONDS), 0);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, returns.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link Returns#Returns(Time, int)}
   */
  @Test
  void testNewReturns() {
    // Arrange and Act
    Returns actualReturns = new Returns(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    // Assert
    assertEquals("Returns", actualReturns.getName());
    assertEquals(0L, actualReturns.getTimePeriod());
    assertEquals(10, actualReturns.numPeriods);
    assertTrue(actualReturns.getProperties().isEmpty());
  }
}
