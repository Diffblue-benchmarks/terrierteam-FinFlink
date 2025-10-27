package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class VortexPlusDiffblueTest {
  /**
   * Method under test: {@link VortexPlus#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    VortexPlus vortexPlus = new VortexPlus(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, vortexPlus.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link VortexPlus#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    VortexPlus vortexPlus = new VortexPlus(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, vortexPlus.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link VortexPlus#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    VortexPlus vortexPlus = new VortexPlus(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, vortexPlus.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link VortexPlus#VortexPlus(Time)}
   */
  @Test
  void testNewVortexPlus() {
    // Arrange and Act
    VortexPlus actualVortexPlus = new VortexPlus(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("VortexPlus", actualVortexPlus.getName());
    assertEquals(0L, actualVortexPlus.getTimePeriod());
    assertTrue(actualVortexPlus.getProperties().isEmpty());
  }
}
