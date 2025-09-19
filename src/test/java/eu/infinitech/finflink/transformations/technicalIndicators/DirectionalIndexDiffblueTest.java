package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
   *   <li>Then return Name is {@code DirectionalIndex}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#DirectionalIndex(Time)}
   */
  @Test
  @DisplayName("Test new DirectionalIndex(Time); then return Name is 'DirectionalIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DirectionalIndex.<init>(Time)"})
  void testNewDirectionalIndex_thenReturnNameIsDirectionalIndex() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);

    // Act
    DirectionalIndex actualDirectionalIndex = new DirectionalIndex(timePeriod);

    // Assert
    assertEquals("DirectionalIndex", actualDirectionalIndex.getName());
    assertEquals(0L, actualDirectionalIndex.getTimePeriod());
    assertTrue(actualDirectionalIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()} HighPrice is one.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod() HighPrice is one; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_givenTradePeriodHighPriceIsOne_thenReturnNaN() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    TradePeriod tradePeriod = new TradePeriod();
    tradePeriod.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(tradePeriod);
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()} HighPrice is one.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod() HighPrice is one; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_givenTradePeriodHighPriceIsOne_thenReturnNaN2() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    TradePeriod tradePeriod = new TradePeriod();
    tradePeriod.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(tradePeriod);
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()} HighPrice is one.
   *   <li>Then return one hundred.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod() HighPrice is one; then return one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_givenTradePeriodHighPriceIsOne_thenReturnOneHundred() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    TradePeriod tradePeriod = new TradePeriod();
    tradePeriod.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(tradePeriod);

    // Act and Assert
    assertEquals(100.0d, directionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnNaN() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnNaN2() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnNaN3() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

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
