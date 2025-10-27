package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class VolatilityDiffblueTest {
  /**
   * Method under test: {@link Volatility#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    Volatility volatility = new Volatility(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, volatility.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link Volatility#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    Volatility volatility = new Volatility(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, volatility.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link Volatility#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    Volatility volatility = new Volatility(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, volatility.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link Volatility#calculate(List)}
   */
  @Test
  void testCalculate4() {
    // Arrange
    Volatility volatility = new Volatility(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, volatility.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link Volatility#Volatility(Time)}
   */
  @Test
  void testNewVolatility() {
    // Arrange and Act
    Volatility actualVolatility = new Volatility(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("Volatility", actualVolatility.getName());
    assertEquals(0L, actualVolatility.getTimePeriod());
    assertTrue(actualVolatility.getProperties().isEmpty());
  }
}
