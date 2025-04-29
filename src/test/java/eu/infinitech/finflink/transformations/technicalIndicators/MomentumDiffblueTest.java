package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

class MomentumDiffblueTest {
  /**
   * Test {@link Momentum#Momentum(int)}.
   * <p>
   * Method under test: {@link Momentum#Momentum(int)}
   */
  @Test
  @DisplayName("Test new Momentum(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Momentum.<init>(int)"})
  void testNewMomentum() {
    // Arrange and Act
    Momentum actualMomentum = new Momentum(10);

    // Assert
    assertNull(actualMomentum.getIndicatorRequirements());
    assertEquals(0L, actualMomentum.getTimePeriod());
  }

  /**
   * Test {@link Momentum#Momentum(Time, int)}.
   * <ul>
   *   <li>Then return Name is {@code Momentum}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Momentum#Momentum(Time, int)}
   */
  @Test
  @DisplayName("Test new Momentum(Time, int); then return Name is 'Momentum'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Momentum.<init>(Time, int)"})
  void testNewMomentum_thenReturnNameIsMomentum() {
    // Arrange and Act
    Momentum actualMomentum = new Momentum(Time.of(3L, TimeUnit.NANOSECONDS), 10);

    // Assert
    assertEquals("Momentum", actualMomentum.getName());
    assertEquals(0L, actualMomentum.getTimePeriod());
    assertEquals(10, actualMomentum.numPeriods);
    assertTrue(actualMomentum.getProperties().isEmpty());
  }

  /**
   * Test {@link Momentum#calculate(List)}.
   * <ul>
   *   <li>Given {@link Momentum#Momentum(int)} with numPeriods is ten.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Momentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given Momentum(int) with numPeriods is ten; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Momentum.calculate(List)"})
  void testCalculate_givenMomentumWithNumPeriodsIsTen_thenReturnZero() {
    // Arrange
    Momentum momentum = new Momentum(10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, momentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link Momentum#calculate(List)}.
   * <ul>
   *   <li>Given {@link Momentum#Momentum(int)} with numPeriods is ten.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Momentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given Momentum(int) with numPeriods is ten; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Momentum.calculate(List)"})
  void testCalculate_givenMomentumWithNumPeriodsIsTen_thenReturnZero2() {
    // Arrange
    Momentum momentum = new Momentum(10);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, momentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link Momentum#calculate(List)}.
   * <ul>
   *   <li>Given {@link Momentum#Momentum(int)} with numPeriods is ten.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Momentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given Momentum(int) with numPeriods is ten; when ArrayList(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Momentum.calculate(List)"})
  void testCalculate_givenMomentumWithNumPeriodsIsTen_whenArrayList_thenReturnZero() {
    // Arrange
    Momentum momentum = new Momentum(10);

    // Act and Assert
    assertEquals(0.0d, momentum.calculate(new ArrayList<>()));
  }

  /**
   * Test {@link Momentum#calculate(List)}.
   * <ul>
   *   <li>Given {@link Momentum#Momentum(int)} with numPeriods is zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Momentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given Momentum(int) with numPeriods is zero; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Momentum.calculate(List)"})
  void testCalculate_givenMomentumWithNumPeriodsIsZero_thenReturnZero() {
    // Arrange
    Momentum momentum = new Momentum(0);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, momentum.calculate(periodsToConsider));
  }
}
