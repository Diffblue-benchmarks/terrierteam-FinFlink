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

class ForceIndexDiffblueTest {
  /**
   * Test {@link ForceIndex#ForceIndex(Time)}.
   *
   * <ul>
   *   <li>When createTime.
   *   <li>Then return Name is {@code ForceIndex}.
   * </ul>
   *
   * <p>Method under test: {@link ForceIndex#ForceIndex(Time)}
   */
  @Test
  @DisplayName("Test new ForceIndex(Time); when createTime; then return Name is 'ForceIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ForceIndex.<init>(Time)"})
  void testNewForceIndex_whenCreateTime_thenReturnNameIsForceIndex() {
    // Arrange and Act
    ForceIndex actualForceIndex = new ForceIndex(TimeFactory.createTime());

    // Assert
    assertEquals("ForceIndex", actualForceIndex.getName());
    assertEquals(1000L, actualForceIndex.getTimePeriod());
    assertTrue(actualForceIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link ForceIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ForceIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double ForceIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnZero() {
    // Arrange
    ForceIndex forceIndex = new ForceIndex(TimeFactory.createTime());

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, forceIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link ForceIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ForceIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double ForceIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnZero2() {
    // Arrange
    ForceIndex forceIndex = new ForceIndex(TimeFactory.createTime());

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, forceIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link ForceIndex#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ForceIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double ForceIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    ForceIndex forceIndex = new ForceIndex(TimeFactory.createTime());

    // Act and Assert
    assertEquals(0.0d, forceIndex.calculate(new ArrayList<>()));
  }
}
