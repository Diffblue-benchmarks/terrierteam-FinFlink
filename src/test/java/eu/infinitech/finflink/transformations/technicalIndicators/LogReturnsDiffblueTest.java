package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LogReturnsDiffblueTest {
  /**
   * Test {@link LogReturns#LogReturns(Time, int)}.
   * <ul>
   *   <li>Then return Name is {@code LogReturns}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogReturns#LogReturns(Time, int)}
   */
  @Test
  @DisplayName("Test new LogReturns(Time, int); then return Name is 'LogReturns'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LogReturns.<init>(Time, int)"})
  void testNewLogReturns_thenReturnNameIsLogReturns() {
    // Arrange and Act
    LogReturns actualLogReturns = new LogReturns(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    // Assert
    assertEquals("LogReturns", actualLogReturns.getName());
    assertEquals(0L, actualLogReturns.getTimePeriod());
    assertEquals(10, actualLogReturns.numPeriods);
    assertTrue(actualLogReturns.getProperties().isEmpty());
  }

  /**
   * Test {@link LogReturns#calculate(List)}.
   * <ul>
   *   <li>Given {@link LogReturns#LogReturns(Time, int)} with timePeriod is {@link Time} and numPeriods is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given LogReturns(Time, int) with timePeriod is Time and numPeriods is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double LogReturns.calculate(List)"})
  void testCalculate_givenLogReturnsWithTimePeriodIsTimeAndNumPeriodsIsTen() {
    // Arrange
    LogReturns logReturns = new LogReturns(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, logReturns.calculate(periodsToConsider));
  }

  /**
   * Test {@link LogReturns#calculate(List)}.
   * <ul>
   *   <li>Given {@link LogReturns#LogReturns(Time, int)} with timePeriod is {@link Time} and numPeriods is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given LogReturns(Time, int) with timePeriod is Time and numPeriods is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double LogReturns.calculate(List)"})
  void testCalculate_givenLogReturnsWithTimePeriodIsTimeAndNumPeriodsIsTen2() {
    // Arrange
    LogReturns logReturns = new LogReturns(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, logReturns.calculate(periodsToConsider));
  }

  /**
   * Test {@link LogReturns#calculate(List)}.
   * <ul>
   *   <li>Given {@link LogReturns#LogReturns(Time, int)} with timePeriod is {@link Time} and numPeriods is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given LogReturns(Time, int) with timePeriod is Time and numPeriods is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double LogReturns.calculate(List)"})
  void testCalculate_givenLogReturnsWithTimePeriodIsTimeAndNumPeriodsIsZero() {
    // Arrange
    LogReturns logReturns = new LogReturns(Time.of(3L, TimeUnit.NANOSECONDS), 0);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, logReturns.calculate(periodsToConsider));
  }

  /**
   * Test {@link LogReturns#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogReturns#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double LogReturns.calculate(List)"})
  void testCalculate_whenArrayList() {
    // Arrange
    LogReturns logReturns = new LogReturns(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    // Act and Assert
    assertEquals(0.0d, logReturns.calculate(new ArrayList<>()));
  }
}
