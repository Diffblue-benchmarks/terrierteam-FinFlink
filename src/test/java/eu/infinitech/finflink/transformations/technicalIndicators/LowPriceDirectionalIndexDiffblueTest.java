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
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);

    // Act
    LowPriceDirectionalIndex actualLowPriceDirectionalIndex =
        new LowPriceDirectionalIndex(timePeriod);

    // Assert
    assertEquals("LowPriceDirectionalIndex", actualLowPriceDirectionalIndex.getName());
    assertEquals(0L, actualLowPriceDirectionalIndex.getTimePeriod());
    assertTrue(actualLowPriceDirectionalIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link LowPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod() {
    // Arrange
    LowPriceDirectionalIndex lowPriceDirectionalIndex = new LowPriceDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, lowPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link LowPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalIndex.calculate(List)"})
  void testCalculate_whenArrayList() {
    // Arrange
    LowPriceDirectionalIndex lowPriceDirectionalIndex = new LowPriceDirectionalIndex();

    // Act and Assert
    assertEquals(Double.NaN, lowPriceDirectionalIndex.calculate(new ArrayList<>()));
  }
}
