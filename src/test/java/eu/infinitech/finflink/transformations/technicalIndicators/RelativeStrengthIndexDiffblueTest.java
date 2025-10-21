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

class RelativeStrengthIndexDiffblueTest {
  /**
   * Test {@link RelativeStrengthIndex#RelativeStrengthIndex(Time)}.
   * <ul>
   *   <li>Then return Name is {@code RelativeStrengthIndex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelativeStrengthIndex#RelativeStrengthIndex(Time)}
   */
  @Test
  @DisplayName("Test new RelativeStrengthIndex(Time); then return Name is 'RelativeStrengthIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RelativeStrengthIndex.<init>(Time)"})
  void testNewRelativeStrengthIndex_thenReturnNameIsRelativeStrengthIndex() {
    // Arrange and Act
    RelativeStrengthIndex actualRelativeStrengthIndex = new RelativeStrengthIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("RelativeStrengthIndex", actualRelativeStrengthIndex.getName());
    assertEquals(0L, actualRelativeStrengthIndex.getTimePeriod());
    assertTrue(actualRelativeStrengthIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link RelativeStrengthIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()} ClosePrice is two.</li>
   *   <li>Then return {@code 111.76470588235294}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelativeStrengthIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod() ClosePrice is two; then return '111.76470588235294'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double RelativeStrengthIndex.calculate(List)"})
  void testCalculate_givenTradePeriodClosePriceIsTwo_thenReturn11176470588235294() {
    // Arrange
    RelativeStrengthIndex relativeStrengthIndex = new RelativeStrengthIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    TradePeriod tradePeriod = new TradePeriod();
    tradePeriod.setClosePrice(2.0d);

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(tradePeriod);

    // Act and Assert
    assertEquals(111.76470588235294d, relativeStrengthIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link RelativeStrengthIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelativeStrengthIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return one hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double RelativeStrengthIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnOneHundred() {
    // Arrange
    RelativeStrengthIndex relativeStrengthIndex = new RelativeStrengthIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(100.0d, relativeStrengthIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link RelativeStrengthIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelativeStrengthIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double RelativeStrengthIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    RelativeStrengthIndex relativeStrengthIndex = new RelativeStrengthIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, relativeStrengthIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link RelativeStrengthIndex#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelativeStrengthIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double RelativeStrengthIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    RelativeStrengthIndex relativeStrengthIndex = new RelativeStrengthIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, relativeStrengthIndex.calculate(new ArrayList<>()));
  }
}
