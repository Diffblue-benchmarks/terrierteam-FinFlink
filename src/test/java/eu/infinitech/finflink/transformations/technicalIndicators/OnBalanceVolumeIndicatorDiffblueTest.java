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

class OnBalanceVolumeIndicatorDiffblueTest {
  /**
   * Test {@link OnBalanceVolumeIndicator#OnBalanceVolumeIndicator(Time)}.
   *
   * <ul>
   *   <li>Then return Name is {@code OnBalanceVolumeIndicator}.
   * </ul>
   *
   * <p>Method under test: {@link OnBalanceVolumeIndicator#OnBalanceVolumeIndicator(Time)}
   */
  @Test
  @DisplayName(
      "Test new OnBalanceVolumeIndicator(Time); then return Name is 'OnBalanceVolumeIndicator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OnBalanceVolumeIndicator.<init>(Time)"})
  void testNewOnBalanceVolumeIndicator_thenReturnNameIsOnBalanceVolumeIndicator() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);

    // Act
    OnBalanceVolumeIndicator actualOnBalanceVolumeIndicator =
        new OnBalanceVolumeIndicator(timePeriod);

    // Assert
    assertEquals("OnBalanceVolumeIndicator", actualOnBalanceVolumeIndicator.getName());
    assertEquals(0L, actualOnBalanceVolumeIndicator.getTimePeriod());
    assertTrue(actualOnBalanceVolumeIndicator.getProperties().isEmpty());
  }

  /**
   * Test {@link OnBalanceVolumeIndicator#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()} ClosePrice is ten.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link OnBalanceVolumeIndicator#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod() ClosePrice is ten; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OnBalanceVolumeIndicator.calculate(List)"})
  void testCalculate_givenTradePeriodClosePriceIsTen_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    OnBalanceVolumeIndicator onBalanceVolumeIndicator = new OnBalanceVolumeIndicator(timePeriod);

    TradePeriod tradePeriod = new TradePeriod();
    tradePeriod.setClosePrice(10.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(tradePeriod);
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, onBalanceVolumeIndicator.calculate(periodsToConsider));
  }

  /**
   * Test {@link OnBalanceVolumeIndicator#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()} ClosePrice is ten.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link OnBalanceVolumeIndicator#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod() ClosePrice is ten; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OnBalanceVolumeIndicator.calculate(List)"})
  void testCalculate_givenTradePeriodClosePriceIsTen_thenReturnZero2() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    OnBalanceVolumeIndicator onBalanceVolumeIndicator = new OnBalanceVolumeIndicator(timePeriod);

    TradePeriod tradePeriod = new TradePeriod();
    tradePeriod.setClosePrice(10.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(tradePeriod);

    // Act and Assert
    assertEquals(0.0d, onBalanceVolumeIndicator.calculate(periodsToConsider));
  }

  /**
   * Test {@link OnBalanceVolumeIndicator#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link OnBalanceVolumeIndicator#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OnBalanceVolumeIndicator.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    OnBalanceVolumeIndicator onBalanceVolumeIndicator = new OnBalanceVolumeIndicator(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, onBalanceVolumeIndicator.calculate(periodsToConsider));
  }

  /**
   * Test {@link OnBalanceVolumeIndicator#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link OnBalanceVolumeIndicator#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OnBalanceVolumeIndicator.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero2() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    OnBalanceVolumeIndicator onBalanceVolumeIndicator = new OnBalanceVolumeIndicator(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, onBalanceVolumeIndicator.calculate(periodsToConsider));
  }

  /**
   * Test {@link OnBalanceVolumeIndicator#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link OnBalanceVolumeIndicator#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double OnBalanceVolumeIndicator.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    OnBalanceVolumeIndicator onBalanceVolumeIndicator = new OnBalanceVolumeIndicator(timePeriod);

    // Act and Assert
    assertEquals(0.0d, onBalanceVolumeIndicator.calculate(new ArrayList<>()));
  }
}
