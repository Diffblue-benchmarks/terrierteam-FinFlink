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

class AverageDirectionalIndexDiffblueTest {
  /**
   * Test {@link AverageDirectionalIndex#AverageDirectionalIndex()}.
   *
   * <p>Method under test: {@link AverageDirectionalIndex#AverageDirectionalIndex()}
   */
  @Test
  @DisplayName("Test new AverageDirectionalIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AverageDirectionalIndex.<init>()"})
  void testNewAverageDirectionalIndex() {
    // Arrange and Act
    AverageDirectionalIndex actualAverageDirectionalIndex = new AverageDirectionalIndex();

    // Assert
    assertNull(actualAverageDirectionalIndex.getIndicatorRequirements());
    assertEquals(0L, actualAverageDirectionalIndex.getTimePeriod());
  }

  /**
   * Test {@link AverageDirectionalIndex#AverageDirectionalIndex(Time)}.
   *
   * <ul>
   *   <li>Then return Name is {@code AverageDirectionalIndex}.
   * </ul>
   *
   * <p>Method under test: {@link AverageDirectionalIndex#AverageDirectionalIndex(Time)}
   */
  @Test
  @DisplayName(
      "Test new AverageDirectionalIndex(Time); then return Name is 'AverageDirectionalIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AverageDirectionalIndex.<init>(Time)"})
  void testNewAverageDirectionalIndex_thenReturnNameIsAverageDirectionalIndex() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);

    // Act
    AverageDirectionalIndex actualAverageDirectionalIndex = new AverageDirectionalIndex(timePeriod);

    // Assert
    assertEquals("AverageDirectionalIndex", actualAverageDirectionalIndex.getName());
    assertEquals(0L, actualAverageDirectionalIndex.getTimePeriod());
    assertTrue(actualAverageDirectionalIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link AverageDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link AverageDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double AverageDirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnNaN() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, averageDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link AverageDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link AverageDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double AverageDirectionalIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnNaN2() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, averageDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link AverageDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link AverageDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double AverageDirectionalIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnNaN() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();

    // Act and Assert
    assertEquals(Double.NaN, averageDirectionalIndex.calculate(new ArrayList<>()));
  }
}
