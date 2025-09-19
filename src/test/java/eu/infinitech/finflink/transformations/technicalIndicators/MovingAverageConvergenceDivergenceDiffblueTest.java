package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

class MovingAverageConvergenceDivergenceDiffblueTest {
  /**
   * Test {@link MovingAverageConvergenceDivergence#MovingAverageConvergenceDivergence(Time)}.
   *
   * <p>Method under test: {@link
   * MovingAverageConvergenceDivergence#MovingAverageConvergenceDivergence(Time)}
   */
  @Test
  @DisplayName("Test new MovingAverageConvergenceDivergence(Time)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MovingAverageConvergenceDivergence.<init>(Time)"})
  void testNewMovingAverageConvergenceDivergence() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);

    // Act
    MovingAverageConvergenceDivergence actualMovingAverageConvergenceDivergence =
        new MovingAverageConvergenceDivergence(timePeriod);

    // Assert
    assertEquals(
        "MovingAverageConvergenceDivergence", actualMovingAverageConvergenceDivergence.getName());
    assertNull(actualMovingAverageConvergenceDivergence.getIndicatorRequirements());
    assertEquals(0, actualMovingAverageConvergenceDivergence.longSpan);
    assertEquals(0, actualMovingAverageConvergenceDivergence.shortSpan);
    assertEquals(0L, actualMovingAverageConvergenceDivergence.getTimePeriod());
    assertTrue(actualMovingAverageConvergenceDivergence.getProperties().isEmpty());
  }

  /**
   * Test {@link MovingAverageConvergenceDivergence#MovingAverageConvergenceDivergence(Time, int,
   * int)}.
   *
   * <p>Method under test: {@link
   * MovingAverageConvergenceDivergence#MovingAverageConvergenceDivergence(Time, int, int)}
   */
  @Test
  @DisplayName("Test new MovingAverageConvergenceDivergence(Time, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MovingAverageConvergenceDivergence.<init>(Time, int, int)"})
  void testNewMovingAverageConvergenceDivergence2() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);

    // Act
    MovingAverageConvergenceDivergence actualMovingAverageConvergenceDivergence =
        new MovingAverageConvergenceDivergence(timePeriod, 1, 1);

    // Assert
    assertEquals(
        "MovingAverageConvergenceDivergence", actualMovingAverageConvergenceDivergence.getName());
    assertEquals(0L, actualMovingAverageConvergenceDivergence.getTimePeriod());
    assertEquals(1, actualMovingAverageConvergenceDivergence.longSpan);
    assertEquals(1, actualMovingAverageConvergenceDivergence.shortSpan);
    assertTrue(actualMovingAverageConvergenceDivergence.getProperties().isEmpty());
  }

  /**
   * Test {@link MovingAverageConvergenceDivergence#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MovingAverageConvergenceDivergence#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MovingAverageConvergenceDivergence.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    MovingAverageConvergenceDivergence movingAverageConvergenceDivergence =
        new MovingAverageConvergenceDivergence(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, movingAverageConvergenceDivergence.calculate(periodsToConsider));
  }

  /**
   * Test {@link MovingAverageConvergenceDivergence#calculate(List)}.
   *
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MovingAverageConvergenceDivergence#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MovingAverageConvergenceDivergence.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero2() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    MovingAverageConvergenceDivergence movingAverageConvergenceDivergence =
        new MovingAverageConvergenceDivergence(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, movingAverageConvergenceDivergence.calculate(periodsToConsider));
  }

  /**
   * Test {@link MovingAverageConvergenceDivergence#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MovingAverageConvergenceDivergence#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MovingAverageConvergenceDivergence.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    MovingAverageConvergenceDivergence movingAverageConvergenceDivergence =
        new MovingAverageConvergenceDivergence(timePeriod);

    // Act and Assert
    assertEquals(0.0d, movingAverageConvergenceDivergence.calculate(new ArrayList<>()));
  }
}
