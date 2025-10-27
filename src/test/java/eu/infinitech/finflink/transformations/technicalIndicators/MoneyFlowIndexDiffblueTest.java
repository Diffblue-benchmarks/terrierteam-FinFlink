package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class MoneyFlowIndexDiffblueTest {
  /**
   * Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    MoneyFlowIndex moneyFlowIndex = new MoneyFlowIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, moneyFlowIndex.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    MoneyFlowIndex moneyFlowIndex = new MoneyFlowIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, moneyFlowIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    MoneyFlowIndex moneyFlowIndex = new MoneyFlowIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, moneyFlowIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  void testCalculate4() {
    // Arrange
    MoneyFlowIndex moneyFlowIndex = new MoneyFlowIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    TradePeriod tradePeriod = new TradePeriod();
    tradePeriod.setClosePrice(3.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(tradePeriod);
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, moneyFlowIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  void testCalculate5() {
    // Arrange
    MoneyFlowIndex moneyFlowIndex = new MoneyFlowIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    TradePeriod tradePeriod = new TradePeriod();
    tradePeriod.setClosePrice(3.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(tradePeriod);

    // Act and Assert
    assertEquals(Double.NaN, moneyFlowIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link MoneyFlowIndex#MoneyFlowIndex(Time)}
   */
  @Test
  void testNewMoneyFlowIndex() {
    // Arrange and Act
    MoneyFlowIndex actualMoneyFlowIndex = new MoneyFlowIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("MoneyFlowIndex", actualMoneyFlowIndex.getName());
    assertEquals(0L, actualMoneyFlowIndex.getTimePeriod());
    assertTrue(actualMoneyFlowIndex.getProperties().isEmpty());
  }
}
