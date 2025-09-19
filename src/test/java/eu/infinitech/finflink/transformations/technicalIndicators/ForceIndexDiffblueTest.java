package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class ForceIndexDiffblueTest {
  /**
   * Test {@link ForceIndex#ForceIndex(Time)}.
   *
   * <ul>
   *   <li>Then return Name is {@code ForceIndex}.
   * </ul>
   *
   * <p>Method under test: {@link ForceIndex#ForceIndex(Time)}
   */
  @Test
  @DisplayName("Test new ForceIndex(Time); then return Name is 'ForceIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ForceIndex.<init>(Time)"})
  void testNewForceIndex_thenReturnNameIsForceIndex() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);

    // Act
    ForceIndex actualForceIndex = new ForceIndex(timePeriod);

    // Assert
    assertEquals("ForceIndex", actualForceIndex.getName());
    assertEquals(0L, actualForceIndex.getTimePeriod());
    assertTrue(actualForceIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link ForceIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ForceIndex#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double ForceIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    ForceIndex forceIndex = new ForceIndex(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, forceIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link ForceIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ForceIndex#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double ForceIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero2() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    ForceIndex forceIndex = new ForceIndex(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, forceIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link ForceIndex#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ForceIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double ForceIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    ForceIndex forceIndex = new ForceIndex(timePeriod);

    // Act and Assert
    assertEquals(0.0d, forceIndex.calculate(new ArrayList<>()));
  }
}
