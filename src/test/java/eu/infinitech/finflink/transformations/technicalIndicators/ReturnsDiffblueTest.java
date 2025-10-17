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

class ReturnsDiffblueTest {
  /**
   * Test {@link Returns#Returns(Time, int)}.
   *
   * <ul>
   *   <li>When createTime.
   *   <li>Then return Name is {@code Returns}.
   * </ul>
   *
   * <p>Method under test: {@link Returns#Returns(Time, int)}
   */
  @Test
  @DisplayName("Test new Returns(Time, int); when createTime; then return Name is 'Returns'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Returns.<init>(Time, int)"})
  void testNewReturns_whenCreateTime_thenReturnNameIsReturns() {
    // Arrange and Act
    Returns actualReturns = new Returns(TimeFactory.createTime(), 10);

    // Assert
    assertEquals("Returns", actualReturns.getName());
    assertEquals(10, actualReturns.numPeriods);
    assertEquals(1000L, actualReturns.getTimePeriod());
    assertTrue(actualReturns.getProperties().isEmpty());
  }

  /**
   * Test {@link Returns#calculate(List)}.
   *
   * <ul>
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link Returns#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Returns.calculate(List)"})
  void testCalculate_thenReturnNaN() {
    // Arrange
    Returns returns = new Returns(TimeFactory.createTime(), 0);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, returns.calculate(periodsToConsider));
  }

  /**
   * Test {@link Returns#calculate(List)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Returns#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Returns.calculate(List)"})
  void testCalculate_thenReturnZero() {
    // Arrange
    Returns returns = new Returns(TimeFactory.createTime(), 10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, returns.calculate(periodsToConsider));
  }

  /**
   * Test {@link Returns#calculate(List)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Returns#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Returns.calculate(List)"})
  void testCalculate_thenReturnZero2() {
    // Arrange
    Returns returns = new Returns(TimeFactory.createTime(), 10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, returns.calculate(periodsToConsider));
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
    Returns returns = new Returns(TimeFactory.createTime(), 10);

    // Act and Assert
    assertEquals(0.0d, returns.calculate(new ArrayList<>()));
  }
}
