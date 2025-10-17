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

class MoneyFlowIndexDiffblueTest {
  /**
   * Test {@link MoneyFlowIndex#MoneyFlowIndex(Time)}.
   *
   * <ul>
   *   <li>When createTime.
   *   <li>Then return Name is {@code MoneyFlowIndex}.
   * </ul>
   *
   * <p>Method under test: {@link MoneyFlowIndex#MoneyFlowIndex(Time)}
   */
  @Test
  @DisplayName(
      "Test new MoneyFlowIndex(Time); when createTime; then return Name is 'MoneyFlowIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MoneyFlowIndex.<init>(Time)"})
  void testNewMoneyFlowIndex_whenCreateTime_thenReturnNameIsMoneyFlowIndex() {
    // Arrange and Act
    MoneyFlowIndex actualMoneyFlowIndex = new MoneyFlowIndex(TimeFactory.createTime());

    // Assert
    assertEquals("MoneyFlowIndex", actualMoneyFlowIndex.getName());
    assertEquals(1000L, actualMoneyFlowIndex.getTimePeriod());
    assertTrue(actualMoneyFlowIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link MoneyFlowIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod ClosePrice is three.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod ClosePrice is three; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MoneyFlowIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriodClosePriceIsThree_thenReturnNaN() {
    // Arrange
    MoneyFlowIndex moneyFlowIndex = new MoneyFlowIndex(TimeFactory.createTime());

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setClosePrice(3.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(createTradePeriodResult);
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, moneyFlowIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link MoneyFlowIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod ClosePrice is three.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod ClosePrice is three; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MoneyFlowIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriodClosePriceIsThree_thenReturnNaN2() {
    // Arrange
    MoneyFlowIndex moneyFlowIndex = new MoneyFlowIndex(TimeFactory.createTime());

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setClosePrice(3.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(createTradePeriodResult);

    // Act and Assert
    assertEquals(Double.NaN, moneyFlowIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link MoneyFlowIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MoneyFlowIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnNaN() {
    // Arrange
    MoneyFlowIndex moneyFlowIndex = new MoneyFlowIndex(TimeFactory.createTime());

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, moneyFlowIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link MoneyFlowIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MoneyFlowIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnZero() {
    // Arrange
    MoneyFlowIndex moneyFlowIndex = new MoneyFlowIndex(TimeFactory.createTime());

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, moneyFlowIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link MoneyFlowIndex#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MoneyFlowIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    MoneyFlowIndex moneyFlowIndex = new MoneyFlowIndex(TimeFactory.createTime());

    // Act and Assert
    assertEquals(0.0d, moneyFlowIndex.calculate(new ArrayList<>()));
  }
}
