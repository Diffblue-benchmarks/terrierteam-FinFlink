package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.TradePeriod;
import eu.infinitech.finflink.structures.TradePeriodFactory;
import java.util.ArrayList;
import java.util.List;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LogReturnsDiffblueTest {
  /**
   * Test {@link LogReturns#LogReturns(Time, int)}.
   *
   * <ul>
   *   <li>When createTime.
   *   <li>Then return Name is {@code LogReturns}.
   * </ul>
   *
   * <p>Method under test: {@link LogReturns#LogReturns(Time, int)}
   */
  @Test
  @DisplayName("Test new LogReturns(Time, int); when createTime; then return Name is 'LogReturns'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogReturns.<init>(Time, int)"})
  void testNewLogReturns_whenCreateTime_thenReturnNameIsLogReturns() {
    // Arrange and Act
    LogReturns actualLogReturns = new LogReturns(TimeFactory.createTime(), 10);

    // Assert
    assertEquals("LogReturns", actualLogReturns.getName());
    assertEquals(10, actualLogReturns.numPeriods);
    assertEquals(1000L, actualLogReturns.getTimePeriod());
    assertTrue(actualLogReturns.getProperties().isEmpty());
  }

  /**
   * Test {@link LogReturns#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod ClosePrice is ten.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod ClosePrice is ten; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LogReturns.calculate(List)"})
  void testCalculate_givenCreateTradePeriodClosePriceIsTen_thenReturnNaN() {
    // Arrange
    LogReturns logReturns = new LogReturns(TimeFactory.createTime(), 1);

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setClosePrice(10.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(createTradePeriodResult);
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, logReturns.calculate(periodsToConsider));
  }

  /**
   * Test {@link LogReturns#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod ClosePrice is ten.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod ClosePrice is ten; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LogReturns.calculate(List)"})
  void testCalculate_givenCreateTradePeriodClosePriceIsTen_thenReturnZero() {
    // Arrange
    LogReturns logReturns = new LogReturns(TimeFactory.createTime(), 1);

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setClosePrice(10.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(createTradePeriodResult);

    // Act and Assert
    assertEquals(0.0d, logReturns.calculate(periodsToConsider));
  }

  /**
   * Test {@link LogReturns#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link LogReturns#LogReturns(Time, int)} with timePeriod is createTime and
   *       numPeriods is ten.
   * </ul>
   *
   * <p>Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given LogReturns(Time, int) with timePeriod is createTime and numPeriods is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LogReturns.calculate(List)"})
  void testCalculate_givenLogReturnsWithTimePeriodIsCreateTimeAndNumPeriodsIsTen() {
    // Arrange
    LogReturns logReturns = new LogReturns(TimeFactory.createTime(), 10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, logReturns.calculate(periodsToConsider));
  }

  /**
   * Test {@link LogReturns#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link LogReturns#LogReturns(Time, int)} with timePeriod is createTime and
   *       numPeriods is ten.
   * </ul>
   *
   * <p>Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given LogReturns(Time, int) with timePeriod is createTime and numPeriods is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LogReturns.calculate(List)"})
  void testCalculate_givenLogReturnsWithTimePeriodIsCreateTimeAndNumPeriodsIsTen2() {
    // Arrange
    LogReturns logReturns = new LogReturns(TimeFactory.createTime(), 10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, logReturns.calculate(periodsToConsider));
  }

  /**
   * Test {@link LogReturns#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link LogReturns#LogReturns(Time, int)} with timePeriod is createTime and
   *       numPeriods is zero.
   * </ul>
   *
   * <p>Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given LogReturns(Time, int) with timePeriod is createTime and numPeriods is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LogReturns.calculate(List)"})
  void testCalculate_givenLogReturnsWithTimePeriodIsCreateTimeAndNumPeriodsIsZero() {
    // Arrange
    LogReturns logReturns = new LogReturns(TimeFactory.createTime(), 0);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, logReturns.calculate(periodsToConsider));
  }

  /**
   * Test {@link LogReturns#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LogReturns.calculate(List)"})
  void testCalculate_whenArrayList() {
    // Arrange
    LogReturns logReturns = new LogReturns(TimeFactory.createTime(), 10);

    // Act and Assert
    assertEquals(0.0d, logReturns.calculate(new ArrayList<>()));
  }
}
