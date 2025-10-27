package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class OnBalanceVolumeIndicatorDiffblueTest {
  /**
   * Method under test: {@link OnBalanceVolumeIndicator#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    OnBalanceVolumeIndicator onBalanceVolumeIndicator = new OnBalanceVolumeIndicator(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, onBalanceVolumeIndicator.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link OnBalanceVolumeIndicator#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    OnBalanceVolumeIndicator onBalanceVolumeIndicator = new OnBalanceVolumeIndicator(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, onBalanceVolumeIndicator.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link OnBalanceVolumeIndicator#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    OnBalanceVolumeIndicator onBalanceVolumeIndicator = new OnBalanceVolumeIndicator(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, onBalanceVolumeIndicator.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link OnBalanceVolumeIndicator#calculate(List)}
   */
  @Test
  void testCalculate4() {
    // Arrange
    OnBalanceVolumeIndicator onBalanceVolumeIndicator = new OnBalanceVolumeIndicator(Time.of(3L, TimeUnit.NANOSECONDS));

    TradePeriod tradePeriod = new TradePeriod();
    tradePeriod.setClosePrice(10.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(tradePeriod);
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, onBalanceVolumeIndicator.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link OnBalanceVolumeIndicator#calculate(List)}
   */
  @Test
  void testCalculate5() {
    // Arrange
    OnBalanceVolumeIndicator onBalanceVolumeIndicator = new OnBalanceVolumeIndicator(Time.of(3L, TimeUnit.NANOSECONDS));

    TradePeriod tradePeriod = new TradePeriod();
    tradePeriod.setClosePrice(10.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(tradePeriod);

    // Act and Assert
    assertEquals(0.0d, onBalanceVolumeIndicator.calculate(periodsToConsider));
  }

  /**
   * Method under test:
   * {@link OnBalanceVolumeIndicator#OnBalanceVolumeIndicator(Time)}
   */
  @Test
  void testNewOnBalanceVolumeIndicator() {
    // Arrange and Act
    OnBalanceVolumeIndicator actualOnBalanceVolumeIndicator = new OnBalanceVolumeIndicator(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("OnBalanceVolumeIndicator", actualOnBalanceVolumeIndicator.getName());
    assertEquals(0L, actualOnBalanceVolumeIndicator.getTimePeriod());
    assertTrue(actualOnBalanceVolumeIndicator.getProperties().isEmpty());
  }
}
