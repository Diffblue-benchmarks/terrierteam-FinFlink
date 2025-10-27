package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class VortexMinusDiffblueTest {
  /**
   * Method under test: {@link VortexMinus#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    VortexMinus vortexMinus = new VortexMinus(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, vortexMinus.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link VortexMinus#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    VortexMinus vortexMinus = new VortexMinus(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, vortexMinus.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link VortexMinus#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    VortexMinus vortexMinus = new VortexMinus(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, vortexMinus.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link VortexMinus#VortexMinus(Time)}
   */
  @Test
  void testNewVortexMinus() {
    // Arrange and Act
    VortexMinus actualVortexMinus = new VortexMinus(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("VortexMinus", actualVortexMinus.getName());
    assertEquals(0L, actualVortexMinus.getTimePeriod());
    assertTrue(actualVortexMinus.getProperties().isEmpty());
  }
}
