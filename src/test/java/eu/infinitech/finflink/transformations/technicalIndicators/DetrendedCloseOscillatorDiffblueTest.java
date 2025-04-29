package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class DetrendedCloseOscillatorDiffblueTest {
  /**
   * Test {@link DetrendedCloseOscillator#DetrendedCloseOscillator(Time)}.
   * <ul>
   *   <li>Then return Name is {@code DetrendedCloseOscillator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DetrendedCloseOscillator#DetrendedCloseOscillator(Time)}
   */
  @Test
  @DisplayName("Test new DetrendedCloseOscillator(Time); then return Name is 'DetrendedCloseOscillator'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DetrendedCloseOscillator.<init>(Time)"})
  void testNewDetrendedCloseOscillator_thenReturnNameIsDetrendedCloseOscillator() {
    // Arrange and Act
    DetrendedCloseOscillator actualDetrendedCloseOscillator = new DetrendedCloseOscillator(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("DetrendedCloseOscillator", actualDetrendedCloseOscillator.getName());
    assertEquals(0L, actualDetrendedCloseOscillator.getTimePeriod());
    assertTrue(actualDetrendedCloseOscillator.getProperties().isEmpty());
  }

  /**
   * Test {@link DetrendedCloseOscillator#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DetrendedCloseOscillator#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double DetrendedCloseOscillator.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    DetrendedCloseOscillator detrendedCloseOscillator = new DetrendedCloseOscillator(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, detrendedCloseOscillator.calculate(periodsToConsider));
  }

  /**
   * Test {@link DetrendedCloseOscillator#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DetrendedCloseOscillator#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double DetrendedCloseOscillator.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero2() {
    // Arrange
    DetrendedCloseOscillator detrendedCloseOscillator = new DetrendedCloseOscillator(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, detrendedCloseOscillator.calculate(periodsToConsider));
  }

  /**
   * Test {@link DetrendedCloseOscillator#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DetrendedCloseOscillator#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double DetrendedCloseOscillator.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero3() {
    // Arrange
    DetrendedCloseOscillator detrendedCloseOscillator = new DetrendedCloseOscillator(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, detrendedCloseOscillator.calculate(periodsToConsider));
  }

  /**
   * Test {@link DetrendedCloseOscillator#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DetrendedCloseOscillator#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double DetrendedCloseOscillator.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    DetrendedCloseOscillator detrendedCloseOscillator = new DetrendedCloseOscillator(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, detrendedCloseOscillator.calculate(new ArrayList<>()));
  }
}
