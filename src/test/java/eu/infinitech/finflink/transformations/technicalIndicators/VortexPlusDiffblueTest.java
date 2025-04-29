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

class VortexPlusDiffblueTest {
  /**
   * Test {@link VortexPlus#VortexPlus(Time)}.
   * <ul>
   *   <li>Then return Name is {@code VortexPlus}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VortexPlus#VortexPlus(Time)}
   */
  @Test
  @DisplayName("Test new VortexPlus(Time); then return Name is 'VortexPlus'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VortexPlus.<init>(Time)"})
  void testNewVortexPlus_thenReturnNameIsVortexPlus() {
    // Arrange and Act
    VortexPlus actualVortexPlus = new VortexPlus(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("VortexPlus", actualVortexPlus.getName());
    assertEquals(0L, actualVortexPlus.getTimePeriod());
    assertTrue(actualVortexPlus.getProperties().isEmpty());
  }

  /**
   * Test {@link VortexPlus#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VortexPlus#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double VortexPlus.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnNaN() {
    // Arrange
    VortexPlus vortexPlus = new VortexPlus(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, vortexPlus.calculate(periodsToConsider));
  }

  /**
   * Test {@link VortexPlus#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link VortexPlus#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double VortexPlus.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    VortexPlus vortexPlus = new VortexPlus(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, vortexPlus.calculate(periodsToConsider));
  }

  /**
   * Test {@link VortexPlus#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link VortexPlus#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double VortexPlus.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    VortexPlus vortexPlus = new VortexPlus(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, vortexPlus.calculate(new ArrayList<>()));
  }
}
