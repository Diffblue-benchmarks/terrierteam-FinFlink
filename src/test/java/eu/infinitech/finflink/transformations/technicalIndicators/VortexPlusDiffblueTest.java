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

class VortexPlusDiffblueTest {
  /**
   * Test {@link VortexPlus#VortexPlus(Time)}.
   *
   * <ul>
   *   <li>When createTime.
   *   <li>Then return Name is {@code VortexPlus}.
   * </ul>
   *
   * <p>Method under test: {@link VortexPlus#VortexPlus(Time)}
   */
  @Test
  @DisplayName("Test new VortexPlus(Time); when createTime; then return Name is 'VortexPlus'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VortexPlus.<init>(Time)"})
  void testNewVortexPlus_whenCreateTime_thenReturnNameIsVortexPlus() {
    // Arrange and Act
    VortexPlus actualVortexPlus = new VortexPlus(TimeFactory.createTime());

    // Assert
    assertEquals("VortexPlus", actualVortexPlus.getName());
    assertEquals(1000L, actualVortexPlus.getTimePeriod());
    assertTrue(actualVortexPlus.getProperties().isEmpty());
  }

  /**
   * Test {@link VortexPlus#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link VortexPlus#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double VortexPlus.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnNaN() {
    // Arrange
    VortexPlus vortexPlus = new VortexPlus(TimeFactory.createTime());

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, vortexPlus.calculate(periodsToConsider));
  }

  /**
   * Test {@link VortexPlus#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link VortexPlus#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double VortexPlus.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnZero() {
    // Arrange
    VortexPlus vortexPlus = new VortexPlus(TimeFactory.createTime());

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, vortexPlus.calculate(periodsToConsider));
  }

  /**
   * Test {@link VortexPlus#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link VortexPlus#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double VortexPlus.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    VortexPlus vortexPlus = new VortexPlus(TimeFactory.createTime());

    // Act and Assert
    assertEquals(0.0d, vortexPlus.calculate(new ArrayList<>()));
  }
}
