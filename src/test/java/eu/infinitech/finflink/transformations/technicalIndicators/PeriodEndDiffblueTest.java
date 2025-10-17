package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class PeriodEndDiffblueTest {
  /**
   * Test {@link PeriodEnd#PeriodEnd(Time)}.
   *
   * <ul>
   *   <li>When createTime.
   *   <li>Then return Name is {@code PeriodEnd}.
   * </ul>
   *
   * <p>Method under test: {@link PeriodEnd#PeriodEnd(Time)}
   */
  @Test
  @DisplayName("Test new PeriodEnd(Time); when createTime; then return Name is 'PeriodEnd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PeriodEnd.<init>(Time)"})
  void testNewPeriodEnd_whenCreateTime_thenReturnNameIsPeriodEnd() {
    // Arrange and Act
    PeriodEnd actualPeriodEnd = new PeriodEnd(TimeFactory.createTime());

    // Assert
    assertEquals("PeriodEnd", actualPeriodEnd.getName());
    assertEquals(1000L, actualPeriodEnd.getTimePeriod());
    assertTrue(actualPeriodEnd.getProperties().isEmpty());
  }

  /**
   * Test {@link PeriodEnd#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PeriodEnd#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PeriodEnd.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnZero() {
    // Arrange
    PeriodEnd periodEnd = new PeriodEnd(TimeFactory.createTime());

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, periodEnd.calculate(periodsToConsider));
  }

  /**
   * Test {@link PeriodEnd#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PeriodEnd#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PeriodEnd.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnZero2() {
    // Arrange
    PeriodEnd periodEnd = new PeriodEnd(TimeFactory.createTime());

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, periodEnd.calculate(periodsToConsider));
  }
}
