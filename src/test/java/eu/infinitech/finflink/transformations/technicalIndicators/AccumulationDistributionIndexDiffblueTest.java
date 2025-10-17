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

class AccumulationDistributionIndexDiffblueTest {
  /**
   * Test {@link AccumulationDistributionIndex#AccumulationDistributionIndex(Time)}.
   *
   * <p>Method under test: {@link AccumulationDistributionIndex#AccumulationDistributionIndex(Time)}
   */
  @Test
  @DisplayName("Test new AccumulationDistributionIndex(Time)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumulationDistributionIndex.<init>(Time)"})
  void testNewAccumulationDistributionIndex() {
    // Arrange and Act
    AccumulationDistributionIndex actualAccumulationDistributionIndex =
        new AccumulationDistributionIndex(TimeFactory.createTime());

    // Assert
    assertEquals("AccumulationDistributionIndex", actualAccumulationDistributionIndex.getName());
    assertNull(actualAccumulationDistributionIndex.getIndicatorRequirements());
    assertEquals(0, actualAccumulationDistributionIndex.longSpan);
    assertEquals(0, actualAccumulationDistributionIndex.shortSpan);
    assertEquals(0L, actualAccumulationDistributionIndex.getTimePeriod());
    assertTrue(actualAccumulationDistributionIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link AccumulationDistributionIndex#AccumulationDistributionIndex(Time, int, int)}.
   *
   * <p>Method under test: {@link AccumulationDistributionIndex#AccumulationDistributionIndex(Time,
   * int, int)}
   */
  @Test
  @DisplayName("Test new AccumulationDistributionIndex(Time, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumulationDistributionIndex.<init>(Time, int, int)"})
  void testNewAccumulationDistributionIndex2() {
    // Arrange and Act
    AccumulationDistributionIndex actualAccumulationDistributionIndex =
        new AccumulationDistributionIndex(TimeFactory.createTime(), 1, 1);

    // Assert
    assertEquals("AccumulationDistributionIndex", actualAccumulationDistributionIndex.getName());
    assertEquals(1, actualAccumulationDistributionIndex.longSpan);
    assertEquals(1, actualAccumulationDistributionIndex.shortSpan);
    assertEquals(1000L, actualAccumulationDistributionIndex.getTimePeriod());
    assertTrue(actualAccumulationDistributionIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link AccumulationDistributionIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link AccumulationDistributionIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double AccumulationDistributionIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnNaN() {
    // Arrange
    AccumulationDistributionIndex accumulationDistributionIndex =
        new AccumulationDistributionIndex(TimeFactory.createTime());

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, accumulationDistributionIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link AccumulationDistributionIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AccumulationDistributionIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double AccumulationDistributionIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnZero() {
    // Arrange
    AccumulationDistributionIndex accumulationDistributionIndex =
        new AccumulationDistributionIndex(TimeFactory.createTime());

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, accumulationDistributionIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link AccumulationDistributionIndex#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AccumulationDistributionIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double AccumulationDistributionIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    AccumulationDistributionIndex accumulationDistributionIndex =
        new AccumulationDistributionIndex(TimeFactory.createTime());

    // Act and Assert
    assertEquals(0.0d, accumulationDistributionIndex.calculate(new ArrayList<>()));
  }
}
