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

class PeriodEndDiffblueTest {
  /**
   * Test {@link PeriodEnd#PeriodEnd(Time)}.
   *
   * <ul>
   *   <li>Then return Name is {@code PeriodEnd}.
   * </ul>
   *
   * <p>Method under test: {@link PeriodEnd#PeriodEnd(Time)}
   */
  @Test
  @DisplayName("Test new PeriodEnd(Time); then return Name is 'PeriodEnd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PeriodEnd.<init>(Time)"})
  void testNewPeriodEnd_thenReturnNameIsPeriodEnd() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);

    // Act
    PeriodEnd actualPeriodEnd = new PeriodEnd(timePeriod);

    // Assert
    assertEquals("PeriodEnd", actualPeriodEnd.getName());
    assertEquals(0L, actualPeriodEnd.getTimePeriod());
    assertTrue(actualPeriodEnd.getProperties().isEmpty());
  }

  /**
   * Test {@link PeriodEnd#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PeriodEnd#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PeriodEnd.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    PeriodEnd periodEnd = new PeriodEnd(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, periodEnd.calculate(periodsToConsider));
  }

  /**
   * Test {@link PeriodEnd#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PeriodEnd#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PeriodEnd.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero2() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    PeriodEnd periodEnd = new PeriodEnd(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, periodEnd.calculate(periodsToConsider));
  }
}
