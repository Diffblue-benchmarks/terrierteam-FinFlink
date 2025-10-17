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

class LowPriceDirectionalIndexDiffblueTest {
  /**
   * Test {@link LowPriceDirectionalIndex#LowPriceDirectionalIndex()}.
   *
   * <p>Method under test: {@link LowPriceDirectionalIndex#LowPriceDirectionalIndex()}
   */
  @Test
  @DisplayName("Test new LowPriceDirectionalIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LowPriceDirectionalIndex.<init>()"})
  void testNewLowPriceDirectionalIndex() {
    // Arrange and Act
    LowPriceDirectionalIndex actualLowPriceDirectionalIndex = new LowPriceDirectionalIndex();

    // Assert
    assertNull(actualLowPriceDirectionalIndex.getIndicatorRequirements());
    assertEquals(0L, actualLowPriceDirectionalIndex.getTimePeriod());
  }

  /**
   * Test {@link LowPriceDirectionalIndex#LowPriceDirectionalIndex(Time)}.
   *
   * <ul>
   *   <li>Then return Name is {@code LowPriceDirectionalIndex}.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalIndex#LowPriceDirectionalIndex(Time)}
   */
  @Test
  @DisplayName(
      "Test new LowPriceDirectionalIndex(Time); then return Name is 'LowPriceDirectionalIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LowPriceDirectionalIndex.<init>(Time)"})
  void testNewLowPriceDirectionalIndex_thenReturnNameIsLowPriceDirectionalIndex() {
    // Arrange and Act
    LowPriceDirectionalIndex actualLowPriceDirectionalIndex =
        new LowPriceDirectionalIndex(TimeFactory.createTime());

    // Assert
    assertEquals("LowPriceDirectionalIndex", actualLowPriceDirectionalIndex.getName());
    assertEquals(1000L, actualLowPriceDirectionalIndex.getTimePeriod());
    assertTrue(actualLowPriceDirectionalIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link LowPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod HighPrice is one.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod HighPrice is one; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriodHighPriceIsOne_thenReturnNaN() {
    // Arrange
    LowPriceDirectionalIndex lowPriceDirectionalIndex = new LowPriceDirectionalIndex();

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(createTradePeriodResult);
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, lowPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link LowPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod HighPrice is one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod HighPrice is one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriodHighPriceIsOne_thenReturnZero() {
    // Arrange
    LowPriceDirectionalIndex lowPriceDirectionalIndex = new LowPriceDirectionalIndex();

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, createTradePeriodResult);

    // Act and Assert
    assertEquals(0.0d, lowPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link LowPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnNaN() {
    // Arrange
    LowPriceDirectionalIndex lowPriceDirectionalIndex = new LowPriceDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, lowPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link LowPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one and createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given one; when ArrayList() add one and createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalIndex.calculate(List)"})
  void testCalculate_givenOne_whenArrayListAddOneAndCreateTradePeriod_thenReturnNaN() {
    // Arrange
    LowPriceDirectionalIndex lowPriceDirectionalIndex = new LowPriceDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, lowPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link LowPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one and createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given one; when ArrayList() add one and createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalIndex.calculate(List)"})
  void testCalculate_givenOne_whenArrayListAddOneAndCreateTradePeriod_thenReturnNaN2() {
    // Arrange
    LowPriceDirectionalIndex lowPriceDirectionalIndex = new LowPriceDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, lowPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link LowPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnNaN() {
    // Arrange
    LowPriceDirectionalIndex lowPriceDirectionalIndex = new LowPriceDirectionalIndex();

    // Act and Assert
    assertEquals(Double.NaN, lowPriceDirectionalIndex.calculate(new ArrayList<>()));
  }
}
