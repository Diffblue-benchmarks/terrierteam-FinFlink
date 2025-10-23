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
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod() {
    // Arrange
    HighPriceDirectionalIndex highPriceDirectionalIndex = new HighPriceDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, highPriceDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link HighPriceDirectionalIndex#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalIndex.calculate(List)"})
  void testCalculate_whenArrayList() {
    // Arrange
    HighPriceDirectionalIndex highPriceDirectionalIndex = new HighPriceDirectionalIndex();

    // Act and Assert
    assertEquals(Double.NaN, highPriceDirectionalIndex.calculate(new ArrayList<>()));
  }
}
