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

class AverageTrueRangeDiffblueTest {
  /**
   * Test {@link AverageTrueRange#AverageTrueRange()}.
   *
   * <p>Method under test: {@link AverageTrueRange#AverageTrueRange()}
   */
  @Test
  @DisplayName("Test new AverageTrueRange()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AverageTrueRange.<init>()"})
  void testNewAverageTrueRange() {
    // Arrange and Act
    AverageTrueRange actualAverageTrueRange = new AverageTrueRange();

    // Assert
    assertNull(actualAverageTrueRange.getIndicatorRequirements());
    assertEquals(0L, actualAverageTrueRange.getTimePeriod());
  }

  /**
   * Test {@link AverageTrueRange#AverageTrueRange(Time)}.
   *
   * <ul>
   *   <li>When createTime.
   *   <li>Then return Name is {@code AverageTrueRange}.
   * </ul>
   *
   * <p>Method under test: {@link AverageTrueRange#AverageTrueRange(Time)}
   */
  @Test
  @DisplayName(
      "Test new AverageTrueRange(Time); when createTime; then return Name is 'AverageTrueRange'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AverageTrueRange.<init>(Time)"})
  void testNewAverageTrueRange_whenCreateTime_thenReturnNameIsAverageTrueRange() {
    // Arrange and Act
    AverageTrueRange actualAverageTrueRange = new AverageTrueRange(TimeFactory.createTime());

    // Assert
    assertEquals("AverageTrueRange", actualAverageTrueRange.getName());
    assertEquals(1000L, actualAverageTrueRange.getTimePeriod());
    assertTrue(actualAverageTrueRange.getProperties().isEmpty());
  }

  /**
   * Test {@link AverageTrueRange#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AverageTrueRange#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double AverageTrueRange.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnZero() {
    // Arrange
    AverageTrueRange averageTrueRange = new AverageTrueRange();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, averageTrueRange.calculate(periodsToConsider));
  }

  /**
   * Test {@link AverageTrueRange#calculate(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one and createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AverageTrueRange#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given one; when ArrayList() add one and createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double AverageTrueRange.calculate(List)"})
  void testCalculate_givenOne_whenArrayListAddOneAndCreateTradePeriod_thenReturnZero() {
    // Arrange
    AverageTrueRange averageTrueRange = new AverageTrueRange();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, averageTrueRange.calculate(periodsToConsider));
  }

  /**
   * Test {@link AverageTrueRange#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AverageTrueRange#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double AverageTrueRange.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    AverageTrueRange averageTrueRange = new AverageTrueRange();

    // Act and Assert
    assertEquals(0.0d, averageTrueRange.calculate(new ArrayList<>()));
  }
}
