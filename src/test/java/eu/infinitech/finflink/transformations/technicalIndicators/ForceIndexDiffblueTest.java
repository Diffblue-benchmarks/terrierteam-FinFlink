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

class ForceIndexDiffblueTest {
  /**
   * Test {@link ForceIndex#ForceIndex(Time)}.
   * <ul>
   *   <li>Then return Name is {@code ForceIndex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForceIndex#ForceIndex(Time)}
   */
  @Test
  @DisplayName("Test new ForceIndex(Time); then return Name is 'ForceIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ForceIndex.<init>(Time)"})
  void testNewForceIndex_thenReturnNameIsForceIndex() {
    // Arrange and Act
    ForceIndex actualForceIndex = new ForceIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("ForceIndex", actualForceIndex.getName());
    assertEquals(0L, actualForceIndex.getTimePeriod());
    assertTrue(actualForceIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link ForceIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForceIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double ForceIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    ForceIndex forceIndex = new ForceIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, forceIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link ForceIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForceIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double ForceIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero2() {
    // Arrange
    ForceIndex forceIndex = new ForceIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, forceIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link ForceIndex#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForceIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double ForceIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    ForceIndex forceIndex = new ForceIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, forceIndex.calculate(new ArrayList<>()));
  }
}
