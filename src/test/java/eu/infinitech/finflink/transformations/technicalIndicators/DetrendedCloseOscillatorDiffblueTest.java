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

class DetrendedCloseOscillatorDiffblueTest {
  /**
   * Test {@link DetrendedCloseOscillator#DetrendedCloseOscillator(Time)}.
   *
   * <ul>
   *   <li>Then return Name is {@code DetrendedCloseOscillator}.
   * </ul>
   *
   * <p>Method under test: {@link DetrendedCloseOscillator#DetrendedCloseOscillator(Time)}
   */
  @Test
  @DisplayName(
      "Test new DetrendedCloseOscillator(Time); then return Name is 'DetrendedCloseOscillator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DetrendedCloseOscillator.<init>(Time)"})
  void testNewDetrendedCloseOscillator_thenReturnNameIsDetrendedCloseOscillator() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);

    // Act
    DetrendedCloseOscillator actualDetrendedCloseOscillator =
        new DetrendedCloseOscillator(timePeriod);

    // Assert
    assertEquals("DetrendedCloseOscillator", actualDetrendedCloseOscillator.getName());
    assertEquals(0L, actualDetrendedCloseOscillator.getTimePeriod());
    assertTrue(actualDetrendedCloseOscillator.getProperties().isEmpty());
  }

  /**
   * Test {@link DetrendedCloseOscillator#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DetrendedCloseOscillator#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DetrendedCloseOscillator.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    DetrendedCloseOscillator detrendedCloseOscillator = new DetrendedCloseOscillator(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, detrendedCloseOscillator.calculate(periodsToConsider));
  }

  /**
   * Test {@link DetrendedCloseOscillator#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DetrendedCloseOscillator#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DetrendedCloseOscillator.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero2() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    DetrendedCloseOscillator detrendedCloseOscillator = new DetrendedCloseOscillator(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, detrendedCloseOscillator.calculate(periodsToConsider));
  }

  /**
   * Test {@link DetrendedCloseOscillator#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DetrendedCloseOscillator#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DetrendedCloseOscillator.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero3() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    DetrendedCloseOscillator detrendedCloseOscillator = new DetrendedCloseOscillator(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, detrendedCloseOscillator.calculate(periodsToConsider));
  }

  /**
   * Test {@link DetrendedCloseOscillator#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DetrendedCloseOscillator#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DetrendedCloseOscillator.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    DetrendedCloseOscillator detrendedCloseOscillator = new DetrendedCloseOscillator(timePeriod);

    // Act and Assert
    assertEquals(0.0d, detrendedCloseOscillator.calculate(new ArrayList<>()));
  }
}
