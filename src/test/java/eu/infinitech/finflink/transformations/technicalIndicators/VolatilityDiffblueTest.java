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

class VolatilityDiffblueTest {
  /**
   * Test {@link Volatility#Volatility(Time)}.
   *
   * <ul>
   *   <li>Then return Name is {@code Volatility}.
   * </ul>
   *
   * <p>Method under test: {@link Volatility#Volatility(Time)}
   */
  @Test
  @DisplayName("Test new Volatility(Time); then return Name is 'Volatility'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Volatility.<init>(Time)"})
  void testNewVolatility_thenReturnNameIsVolatility() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);

    // Act
    Volatility actualVolatility = new Volatility(timePeriod);

    // Assert
    assertEquals("Volatility", actualVolatility.getName());
    assertEquals(0L, actualVolatility.getTimePeriod());
    assertTrue(actualVolatility.getProperties().isEmpty());
  }

  /**
   * Test {@link Volatility#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()} ClosePrice is ten.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link Volatility#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod() ClosePrice is ten; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Volatility.calculate(List)"})
  void testCalculate_givenTradePeriodClosePriceIsTen_thenReturnNaN() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    Volatility volatility = new Volatility(timePeriod);

    TradePeriod tradePeriod = new TradePeriod();
    tradePeriod.setClosePrice(10.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(tradePeriod);
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, volatility.calculate(periodsToConsider));
  }

  /**
   * Test {@link Volatility#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()} ClosePrice is ten.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Volatility#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod() ClosePrice is ten; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Volatility.calculate(List)"})
  void testCalculate_givenTradePeriodClosePriceIsTen_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    Volatility volatility = new Volatility(timePeriod);

    TradePeriod tradePeriod = new TradePeriod();
    tradePeriod.setClosePrice(10.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(tradePeriod);
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, volatility.calculate(periodsToConsider));
  }

  /**
   * Test {@link Volatility#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Volatility#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Volatility.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    Volatility volatility = new Volatility(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, volatility.calculate(periodsToConsider));
  }

  /**
   * Test {@link Volatility#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Volatility#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Volatility.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero2() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    Volatility volatility = new Volatility(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, volatility.calculate(periodsToConsider));
  }

  /**
   * Test {@link Volatility#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Volatility#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Volatility.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero3() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    Volatility volatility = new Volatility(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, volatility.calculate(periodsToConsider));
  }

  /**
   * Test {@link Volatility#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Volatility#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Volatility.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    Volatility volatility = new Volatility(timePeriod);

    // Act and Assert
    assertEquals(0.0d, volatility.calculate(new ArrayList<>()));
  }
}
