package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReturnsDiffblueTest {
  /**
   * Test {@link Returns#Returns(Time, int)}.
   *
   * <ul>
   *   <li>Then return Name is {@code Returns}.
   * </ul>
   *
   * <p>Method under test: {@link Returns#Returns(Time, int)}
   */
  @Test
  @DisplayName("Test new Returns(Time, int); then return Name is 'Returns'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Returns.<init>(Time, int)"})
  void testNewReturns_thenReturnNameIsReturns() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);

    // Act
    Returns actualReturns = new Returns(timePeriod, 10);

    // Assert
    assertEquals("Returns", actualReturns.getName());
    assertEquals(0L, actualReturns.getTimePeriod());
    assertEquals(10, actualReturns.numPeriods);
    assertTrue(actualReturns.getProperties().isEmpty());
  }

  /**
   * Test {@link Returns#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link Returns#Returns(Time, int)} with timePeriod is {@link Time} and numPeriods
   *       is ten.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Returns#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given Returns(Time, int) with timePeriod is Time and numPeriods is ten; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Returns.calculate(List)"})
  void testCalculate_givenReturnsWithTimePeriodIsTimeAndNumPeriodsIsTen_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    Returns returns = new Returns(timePeriod, 10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, returns.calculate(periodsToConsider));
  }

  /**
   * Test {@link Returns#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link Returns#Returns(Time, int)} with timePeriod is {@link Time} and numPeriods
   *       is ten.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Returns#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given Returns(Time, int) with timePeriod is Time and numPeriods is ten; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Returns.calculate(List)"})
  void testCalculate_givenReturnsWithTimePeriodIsTimeAndNumPeriodsIsTen_thenReturnZero2() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    Returns returns = new Returns(timePeriod, 10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, returns.calculate(periodsToConsider));
  }

  /**
   * Test {@link Returns#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link Returns#Returns(Time, int)} with timePeriod is {@link Time} and numPeriods
   *       is zero.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link Returns#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given Returns(Time, int) with timePeriod is Time and numPeriods is zero; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Returns.calculate(List)"})
  void testCalculate_givenReturnsWithTimePeriodIsTimeAndNumPeriodsIsZero_thenReturnNaN() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    Returns returns = new Returns(timePeriod, 0);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, returns.calculate(periodsToConsider));
  }

  /**
   * Test {@link Returns#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Returns#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Returns.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    Returns returns = new Returns(timePeriod, 10);

    // Act and Assert
    assertEquals(0.0d, returns.calculate(new ArrayList<>()));
  }
}
