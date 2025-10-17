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

class HighPriceDirectionalMomentumDiffblueTest {
  /**
   * Test {@link HighPriceDirectionalMomentum#HighPriceDirectionalMomentum()}.
   *
   * <p>Method under test: {@link HighPriceDirectionalMomentum#HighPriceDirectionalMomentum()}
   */
  @Test
  @DisplayName("Test new HighPriceDirectionalMomentum()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HighPriceDirectionalMomentum.<init>()"})
  void testNewHighPriceDirectionalMomentum() {
    // Arrange and Act
    HighPriceDirectionalMomentum actualHighPriceDirectionalMomentum =
        new HighPriceDirectionalMomentum();

    // Assert
    assertNull(actualHighPriceDirectionalMomentum.getIndicatorRequirements());
    assertEquals(0L, actualHighPriceDirectionalMomentum.getTimePeriod());
  }

  /**
   * Test {@link HighPriceDirectionalMomentum#HighPriceDirectionalMomentum(Time)}.
   *
   * <ul>
   *   <li>Then return Name is {@code HighPriceDirectionalMomentum}.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalMomentum#HighPriceDirectionalMomentum(Time)}
   */
  @Test
  @DisplayName(
      "Test new HighPriceDirectionalMomentum(Time); then return Name is 'HighPriceDirectionalMomentum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HighPriceDirectionalMomentum.<init>(Time)"})
  void testNewHighPriceDirectionalMomentum_thenReturnNameIsHighPriceDirectionalMomentum() {
    // Arrange and Act
    HighPriceDirectionalMomentum actualHighPriceDirectionalMomentum =
        new HighPriceDirectionalMomentum(TimeFactory.createTime());

    // Assert
    assertEquals("HighPriceDirectionalMomentum", actualHighPriceDirectionalMomentum.getName());
    assertEquals(1000L, actualHighPriceDirectionalMomentum.getTimePeriod());
    assertTrue(actualHighPriceDirectionalMomentum.getProperties().isEmpty());
  }

  /**
   * Test {@link HighPriceDirectionalMomentum#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod HighPrice is one.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given createTradePeriod HighPrice is one; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_givenCreateTradePeriodHighPriceIsOne_thenReturnMinusOne() {
    // Arrange
    HighPriceDirectionalMomentum highPriceDirectionalMomentum = new HighPriceDirectionalMomentum();

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(createTradePeriodResult);
    periodsToConsider.add(1, TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(-1.0d, highPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link HighPriceDirectionalMomentum#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod HighPrice is one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod HighPrice is one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_givenCreateTradePeriodHighPriceIsOne_thenReturnZero() {
    // Arrange
    HighPriceDirectionalMomentum highPriceDirectionalMomentum = new HighPriceDirectionalMomentum();

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, createTradePeriodResult);

    // Act and Assert
    assertEquals(0.0d, highPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link HighPriceDirectionalMomentum#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnZero() {
    // Arrange
    HighPriceDirectionalMomentum highPriceDirectionalMomentum = new HighPriceDirectionalMomentum();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, highPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link HighPriceDirectionalMomentum#calculate(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one and createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given one; when ArrayList() add one and createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_givenOne_whenArrayListAddOneAndCreateTradePeriod_thenReturnZero() {
    // Arrange
    HighPriceDirectionalMomentum highPriceDirectionalMomentum = new HighPriceDirectionalMomentum();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, highPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link HighPriceDirectionalMomentum#calculate(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one and createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given one; when ArrayList() add one and createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_givenOne_whenArrayListAddOneAndCreateTradePeriod_thenReturnZero2() {
    // Arrange
    HighPriceDirectionalMomentum highPriceDirectionalMomentum = new HighPriceDirectionalMomentum();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, highPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link HighPriceDirectionalMomentum#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HighPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double HighPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    HighPriceDirectionalMomentum highPriceDirectionalMomentum = new HighPriceDirectionalMomentum();

    // Act and Assert
    assertEquals(0.0d, highPriceDirectionalMomentum.calculate(new ArrayList<>()));
  }
}
