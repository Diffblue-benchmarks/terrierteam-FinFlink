package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

class AccumulationDistributionIndexDiffblueTest {
  /**
   * Test {@link AccumulationDistributionIndex#AccumulationDistributionIndex(Time)}.
   * <p>
   * Method under test: {@link AccumulationDistributionIndex#AccumulationDistributionIndex(Time)}
   */
  @Test
  @DisplayName("Test new AccumulationDistributionIndex(Time)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumulationDistributionIndex.<init>(Time)"})
  void testNewAccumulationDistributionIndex() {
    // Arrange and Act
    AccumulationDistributionIndex actualAccumulationDistributionIndex = new AccumulationDistributionIndex(
        Time.of(3L, TimeUnit.NANOSECONDS));

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
   * <p>
   * Method under test: {@link AccumulationDistributionIndex#AccumulationDistributionIndex(Time, int, int)}
   */
  @Test
  @DisplayName("Test new AccumulationDistributionIndex(Time, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumulationDistributionIndex.<init>(Time, int, int)"})
  void testNewAccumulationDistributionIndex2() {
    // Arrange and Act
    AccumulationDistributionIndex actualAccumulationDistributionIndex = new AccumulationDistributionIndex(
        Time.of(3L, TimeUnit.NANOSECONDS), 1, 1);

    // Assert
    assertEquals("AccumulationDistributionIndex", actualAccumulationDistributionIndex.getName());
    assertEquals(0L, actualAccumulationDistributionIndex.getTimePeriod());
    assertEquals(1, actualAccumulationDistributionIndex.longSpan);
    assertEquals(1, actualAccumulationDistributionIndex.shortSpan);
    assertTrue(actualAccumulationDistributionIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link AccumulationDistributionIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumulationDistributionIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double AccumulationDistributionIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnNaN() {
    // Arrange
    AccumulationDistributionIndex accumulationDistributionIndex = new AccumulationDistributionIndex(
        Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, accumulationDistributionIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link AccumulationDistributionIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumulationDistributionIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double AccumulationDistributionIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    AccumulationDistributionIndex accumulationDistributionIndex = new AccumulationDistributionIndex(
        Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, accumulationDistributionIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link AccumulationDistributionIndex#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumulationDistributionIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double AccumulationDistributionIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    AccumulationDistributionIndex accumulationDistributionIndex = new AccumulationDistributionIndex(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, accumulationDistributionIndex.calculate(new ArrayList<>()));
  }
}
