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

class LowPriceDirectionalMomentumDiffblueTest {
  /**
   * Test {@link LowPriceDirectionalMomentum#LowPriceDirectionalMomentum()}.
   *
   * <p>Method under test: {@link LowPriceDirectionalMomentum#LowPriceDirectionalMomentum()}
   */
  @Test
  @DisplayName("Test new LowPriceDirectionalMomentum()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LowPriceDirectionalMomentum.<init>()"})
  void testNewLowPriceDirectionalMomentum() {
    // Arrange and Act
    LowPriceDirectionalMomentum actualLowPriceDirectionalMomentum =
        new LowPriceDirectionalMomentum();

    // Assert
    assertNull(actualLowPriceDirectionalMomentum.getIndicatorRequirements());
    assertEquals(0L, actualLowPriceDirectionalMomentum.getTimePeriod());
  }

  /**
   * Test {@link LowPriceDirectionalMomentum#LowPriceDirectionalMomentum(Time)}.
   *
   * <ul>
   *   <li>Then return Name is {@code LowPriceDirectionalMomentum}.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalMomentum#LowPriceDirectionalMomentum(Time)}
   */
  @Test
  @DisplayName(
      "Test new LowPriceDirectionalMomentum(Time); then return Name is 'LowPriceDirectionalMomentum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LowPriceDirectionalMomentum.<init>(Time)"})
  void testNewLowPriceDirectionalMomentum_thenReturnNameIsLowPriceDirectionalMomentum() {
    // Arrange and Act
    LowPriceDirectionalMomentum actualLowPriceDirectionalMomentum =
        new LowPriceDirectionalMomentum(TimeFactory.createTime());

    // Assert
    assertEquals("LowPriceDirectionalMomentum", actualLowPriceDirectionalMomentum.getName());
    assertEquals(1000L, actualLowPriceDirectionalMomentum.getTimePeriod());
    assertTrue(actualLowPriceDirectionalMomentum.getProperties().isEmpty());
  }

  /**
   * Test {@link LowPriceDirectionalMomentum#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod HighPrice is one.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod HighPrice is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_givenCreateTradePeriodHighPriceIsOne() {
    // Arrange
    LowPriceDirectionalMomentum lowPriceDirectionalMomentum = new LowPriceDirectionalMomentum();

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(createTradePeriodResult);
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, lowPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link LowPriceDirectionalMomentum#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod HighPrice is one.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod HighPrice is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_givenCreateTradePeriodHighPriceIsOne2() {
    // Arrange
    LowPriceDirectionalMomentum lowPriceDirectionalMomentum = new LowPriceDirectionalMomentum();

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setHighPrice(1.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, createTradePeriodResult);

    // Act and Assert
    assertEquals(0.0d, lowPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link LowPriceDirectionalMomentum#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnZero() {
    // Arrange
    LowPriceDirectionalMomentum lowPriceDirectionalMomentum = new LowPriceDirectionalMomentum();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, lowPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link LowPriceDirectionalMomentum#calculate(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one and createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given one; when ArrayList() add one and createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_givenOne_whenArrayListAddOneAndCreateTradePeriod_thenReturnZero() {
    // Arrange
    LowPriceDirectionalMomentum lowPriceDirectionalMomentum = new LowPriceDirectionalMomentum();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, lowPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link LowPriceDirectionalMomentum#calculate(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one and createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given one; when ArrayList() add one and createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_givenOne_whenArrayListAddOneAndCreateTradePeriod_thenReturnZero2() {
    // Arrange
    LowPriceDirectionalMomentum lowPriceDirectionalMomentum = new LowPriceDirectionalMomentum();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(1, TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, lowPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link LowPriceDirectionalMomentum#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LowPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double LowPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    LowPriceDirectionalMomentum lowPriceDirectionalMomentum = new LowPriceDirectionalMomentum();

    // Act and Assert
    assertEquals(0.0d, lowPriceDirectionalMomentum.calculate(new ArrayList<>()));
  }
}
