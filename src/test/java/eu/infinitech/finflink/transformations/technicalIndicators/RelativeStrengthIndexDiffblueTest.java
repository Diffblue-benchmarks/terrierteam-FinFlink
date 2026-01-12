package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.TradePeriod;
import eu.infinitech.finflink.structures.TradePeriodFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RelativeStrengthIndexDiffblueTest {
  /**
   * Test {@link RelativeStrengthIndex#RelativeStrengthIndex(Time)}.
   *
   * <ul>
   *   <li>Then return Name is {@code RelativeStrengthIndex}.
   * </ul>
   *
   * <p>Method under test: {@link RelativeStrengthIndex#RelativeStrengthIndex(Time)}
   */
  @Test
  @DisplayName("Test new RelativeStrengthIndex(Time); then return Name is 'RelativeStrengthIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RelativeStrengthIndex.<init>(Time)"})
  void testNewRelativeStrengthIndex_thenReturnNameIsRelativeStrengthIndex() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);

    // Act
    RelativeStrengthIndex actualRelativeStrengthIndex = new RelativeStrengthIndex(timePeriod);

    // Assert
    assertEquals("RelativeStrengthIndex", actualRelativeStrengthIndex.getName());
    assertEquals(0L, actualRelativeStrengthIndex.getTimePeriod());
    assertTrue(actualRelativeStrengthIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link RelativeStrengthIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod ClosePrice is two.
   *   <li>Then return {@code 111.76470588235294}.
   * </ul>
   *
   * <p>Method under test: {@link RelativeStrengthIndex#calculate(List)}
   */
  @Test
  @DisplayName(
      "Test calculate(List); given createTradePeriod ClosePrice is two; then return '111.76470588235294'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double RelativeStrengthIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriodClosePriceIsTwo_thenReturn11176470588235294() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    RelativeStrengthIndex relativeStrengthIndex = new RelativeStrengthIndex(timePeriod);

    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();
    createTradePeriodResult.setClosePrice(2.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(createTradePeriodResult);

    // Act and Assert
    assertEquals(111.76470588235294d, relativeStrengthIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link RelativeStrengthIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return one hundred.
   * </ul>
   *
   * <p>Method under test: {@link RelativeStrengthIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double RelativeStrengthIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnOneHundred() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    RelativeStrengthIndex relativeStrengthIndex = new RelativeStrengthIndex(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(100.0d, relativeStrengthIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link RelativeStrengthIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RelativeStrengthIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double RelativeStrengthIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    RelativeStrengthIndex relativeStrengthIndex = new RelativeStrengthIndex(timePeriod);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, relativeStrengthIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link RelativeStrengthIndex#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RelativeStrengthIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double RelativeStrengthIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    RelativeStrengthIndex relativeStrengthIndex = new RelativeStrengthIndex(timePeriod);

    // Act and Assert
    assertEquals(0.0d, relativeStrengthIndex.calculate(new ArrayList<>()));
  }
}
