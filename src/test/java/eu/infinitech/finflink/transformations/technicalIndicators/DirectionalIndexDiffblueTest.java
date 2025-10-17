package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

class DirectionalIndexDiffblueTest {
  /**
   * Test {@link DirectionalIndex#DirectionalIndex()}.
   *
   * <p>Method under test: {@link DirectionalIndex#DirectionalIndex()}
   */
  @Test
  @DisplayName("Test new DirectionalIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DirectionalIndex.<init>()"})
  void testNewDirectionalIndex() {
    // Arrange and Act
    DirectionalIndex actualDirectionalIndex = new DirectionalIndex();

    // Assert
    assertNull(actualDirectionalIndex.getIndicatorRequirements());
    assertEquals(0L, actualDirectionalIndex.getTimePeriod());
  }

  /**
   * Test {@link DirectionalIndex#DirectionalIndex(Time)}.
   *
   * <ul>
   *   <li>When createTime.
   *   <li>Then return Name is {@code DirectionalIndex}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#DirectionalIndex(Time)}
   */
  @Test
  @DisplayName(
      "Test new DirectionalIndex(Time); when createTime; then return Name is 'DirectionalIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DirectionalIndex.<init>(Time)"})
  void testNewDirectionalIndex_whenCreateTime_thenReturnNameIsDirectionalIndex() {
    // Arrange and Act
    DirectionalIndex actualDirectionalIndex = new DirectionalIndex(TimeFactory.createTime());

    // Assert
    assertEquals("DirectionalIndex", actualDirectionalIndex.getName());
    assertEquals(1000L, actualDirectionalIndex.getTimePeriod());
    assertTrue(actualDirectionalIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod HighPrice is one.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod HighPrice is one; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriodHighPriceIsOne_thenReturnNaN() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(createTradePeriodResult);
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod HighPrice is one.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod HighPrice is one; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriodHighPriceIsOne_thenReturnNaN2() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(createTradePeriodResult);
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod HighPrice is one.
   *   <li>Then return one hundred.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given createTradePeriod HighPrice is one; then return one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriodHighPriceIsOne_thenReturnOneHundred() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(createTradePeriodResult);

    // Act and Assert
    assertEquals(100.0d, directionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnNaN() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnNaN2() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnNaN3() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnNaN() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(new ArrayList<>()));
  }
}
