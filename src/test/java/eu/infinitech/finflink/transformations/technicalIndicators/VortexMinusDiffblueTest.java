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

class VortexMinusDiffblueTest {
  /**
   * Test {@link VortexMinus#VortexMinus(Time)}.
   * <ul>
   *   <li>Then return Name is {@code VortexMinus}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VortexMinus#VortexMinus(Time)}
   */
  @Test
  @DisplayName("Test new VortexMinus(Time); then return Name is 'VortexMinus'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VortexMinus.<init>(Time)"})
  void testNewVortexMinus_thenReturnNameIsVortexMinus() {
    // Arrange and Act
    VortexMinus actualVortexMinus = new VortexMinus(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("VortexMinus", actualVortexMinus.getName());
    assertEquals(0L, actualVortexMinus.getTimePeriod());
    assertTrue(actualVortexMinus.getProperties().isEmpty());
  }

  /**
   * Test {@link VortexMinus#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VortexMinus#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double VortexMinus.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnNaN() {
    // Arrange
    VortexMinus vortexMinus = new VortexMinus(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, vortexMinus.calculate(periodsToConsider));
  }

  /**
   * Test {@link VortexMinus#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link VortexMinus#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double VortexMinus.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    VortexMinus vortexMinus = new VortexMinus(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, vortexMinus.calculate(periodsToConsider));
  }

  /**
   * Test {@link VortexMinus#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link VortexMinus#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double VortexMinus.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    VortexMinus vortexMinus = new VortexMinus(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, vortexMinus.calculate(new ArrayList<>()));
  }
}
