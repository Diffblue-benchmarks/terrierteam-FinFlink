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
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HighPriceDirectionalIndexDiffblueTest {
  /**
   * Test {@link HighPriceDirectionalIndex#HighPriceDirectionalIndex()}.
   *
   * <p>Method under test: {@link HighPriceDirectionalIndex#HighPriceDirectionalIndex()}
   */
  @Test
  @DisplayName("Test new HighPriceDirectionalIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HighPriceDirectionalIndex.<init>()"})
  void testNewHighPriceDirectionalIndex() {
    // Arrange and Act
    HighPriceDirectionalIndex actualHighPriceDirectionalIndex = new HighPriceDirectionalIndex();

    // Assert
    assertNull(actualHighPriceDirectionalIndex.getIndicatorRequirements());
    assertEquals(0L, actualHighPriceDirectionalIndex.getTimePeriod());
  }

  /**
   * Test {@link HighPriceDirectionalIndex#HighPriceDirectionalIndex(Time)}.
   *
   * <ul>
   *   <li>Then return Name is {@code HighPriceDirectionalIndex}.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalIndex#HighPriceDirectionalIndex(Time)}
   */
  @Test
  @DisplayName(
      "Test new HighPriceDirectionalIndex(Time); then return Name is 'HighPriceDirectionalIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HighPriceDirectionalIndex.<init>(Time)"})
  void testNewHighPriceDirectionalIndex_thenReturnNameIsHighPriceDirectionalIndex() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);

    // Act
    HighPriceDirectionalIndex actualHighPriceDirectionalIndex =
        new HighPriceDirectionalIndex(timePeriod);

    // Assert
    assertEquals("HighPriceDirectionalIndex", actualHighPriceDirectionalIndex.getName());
    assertEquals(0L, actualHighPriceDirectionalIndex.getTimePeriod());
    assertTrue(actualHighPriceDirectionalIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link HighPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod HighPrice is one.
   *   <li>Then return minus two hundred.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given createTradePeriod HighPrice is one; then return minus two hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriodHighPriceIsOne_thenReturnMinusTwoHundred() {
    // Arrange
    HighPriceDirectionalIndex highPriceDirectionalIndex = new HighPriceDirectionalIndex();

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(createTradePeriodResult);
    periodsToConsider.add(1, TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(-200.0d, highPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link HighPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod HighPrice is one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod HighPrice is one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriodHighPriceIsOne_thenReturnZero() {
    // Arrange
    HighPriceDirectionalIndex highPriceDirectionalIndex = new HighPriceDirectionalIndex();

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, createTradePeriodResult);

    // Act and Assert
    assertEquals(0.0d, highPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link HighPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnNaN() {
    // Arrange
    HighPriceDirectionalIndex highPriceDirectionalIndex = new HighPriceDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, highPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link HighPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one and createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given one; when ArrayList() add one and createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalIndex.calculate(List)"})
  void testCalculate_givenOne_whenArrayListAddOneAndCreateTradePeriod_thenReturnNaN() {
    // Arrange
    HighPriceDirectionalIndex highPriceDirectionalIndex = new HighPriceDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, highPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link HighPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one and createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given one; when ArrayList() add one and createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalIndex.calculate(List)"})
  void testCalculate_givenOne_whenArrayListAddOneAndCreateTradePeriod_thenReturnNaN2() {
    // Arrange
    HighPriceDirectionalIndex highPriceDirectionalIndex = new HighPriceDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, highPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link HighPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnNaN() {
    // Arrange
    HighPriceDirectionalIndex highPriceDirectionalIndex = new HighPriceDirectionalIndex();

    // Act and Assert
    assertEquals(Double.NaN, highPriceDirectionalIndex.calculate(new ArrayList<>()));
  }
}
