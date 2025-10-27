package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class PeriodEndDiffblueTest {
  /**
   * Method under test: {@link PeriodEnd#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    PeriodEnd periodEnd = new PeriodEnd(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, periodEnd.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link PeriodEnd#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    PeriodEnd periodEnd = new PeriodEnd(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, periodEnd.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link PeriodEnd#PeriodEnd(Time)}
   */
  @Test
  void testNewPeriodEnd() {
    // Arrange and Act
    PeriodEnd actualPeriodEnd = new PeriodEnd(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("PeriodEnd", actualPeriodEnd.getName());
    assertEquals(0L, actualPeriodEnd.getTimePeriod());
    assertTrue(actualPeriodEnd.getProperties().isEmpty());
  }
}
