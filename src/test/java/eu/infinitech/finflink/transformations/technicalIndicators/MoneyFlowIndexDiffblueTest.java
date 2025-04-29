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

class MoneyFlowIndexDiffblueTest {
  /**
   * Test {@link MoneyFlowIndex#MoneyFlowIndex(Time)}.
   * <ul>
   *   <li>Then return Name is {@code MoneyFlowIndex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoneyFlowIndex#MoneyFlowIndex(Time)}
   */
  @Test
  @DisplayName("Test new MoneyFlowIndex(Time); then return Name is 'MoneyFlowIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MoneyFlowIndex.<init>(Time)"})
  void testNewMoneyFlowIndex_thenReturnNameIsMoneyFlowIndex() {
    // Arrange and Act
    MoneyFlowIndex actualMoneyFlowIndex = new MoneyFlowIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("MoneyFlowIndex", actualMoneyFlowIndex.getName());
    assertEquals(0L, actualMoneyFlowIndex.getTimePeriod());
    assertTrue(actualMoneyFlowIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link MoneyFlowIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()} ClosePrice is three.</li>
   *   <li>Then return {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod() ClosePrice is three; then return NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double MoneyFlowIndex.calculate(List)"})
  void testCalculate_givenTradePeriodClosePriceIsThree_thenReturnNaN() {
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
   * Test {@link MoneyFlowIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()} ClosePrice is three.</li>
   *   <li>Then return {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod() ClosePrice is three; then return NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double MoneyFlowIndex.calculate(List)"})
  void testCalculate_givenTradePeriodClosePriceIsThree_thenReturnNaN2() {
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
   * Test {@link MoneyFlowIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double MoneyFlowIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnNaN() {
    // Arrange
    MoneyFlowIndex moneyFlowIndex = new MoneyFlowIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, moneyFlowIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link MoneyFlowIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double MoneyFlowIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    MoneyFlowIndex moneyFlowIndex = new MoneyFlowIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, moneyFlowIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link MoneyFlowIndex#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoneyFlowIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double MoneyFlowIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    MoneyFlowIndex moneyFlowIndex = new MoneyFlowIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, moneyFlowIndex.calculate(new ArrayList<>()));
  }
}
