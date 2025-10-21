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

class AverageTrueRangeDiffblueTest {
  /**
   * Test {@link AverageTrueRange#AverageTrueRange()}.
   * <p>
   * Method under test: {@link AverageTrueRange#AverageTrueRange()}
   */
  @Test
  @DisplayName("Test new AverageTrueRange()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AverageTrueRange.<init>()"})
  void testNewAverageTrueRange() {
    // Arrange and Act
    AverageTrueRange actualAverageTrueRange = new AverageTrueRange();

    // Assert
    assertNull(actualAverageTrueRange.getIndicatorRequirements());
    assertEquals(0L, actualAverageTrueRange.getTimePeriod());
  }

  /**
   * Test {@link AverageTrueRange#AverageTrueRange(Time)}.
   * <ul>
   *   <li>Then return Name is {@code AverageTrueRange}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AverageTrueRange#AverageTrueRange(Time)}
   */
  @Test
  @DisplayName("Test new AverageTrueRange(Time); then return Name is 'AverageTrueRange'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AverageTrueRange.<init>(Time)"})
  void testNewAverageTrueRange_thenReturnNameIsAverageTrueRange() {
    // Arrange and Act
    AverageTrueRange actualAverageTrueRange = new AverageTrueRange(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("AverageTrueRange", actualAverageTrueRange.getName());
    assertEquals(0L, actualAverageTrueRange.getTimePeriod());
    assertTrue(actualAverageTrueRange.getProperties().isEmpty());
  }

  /**
   * Test {@link AverageTrueRange#calculate(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AverageTrueRange#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given 'null'; when ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double AverageTrueRange.calculate(List)"})
  void testCalculate_givenNull_whenArrayListAddNull() {
    // Arrange
    AverageTrueRange averageTrueRange = new AverageTrueRange();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(null);

    // Act and Assert
    assertEquals(0.0d, averageTrueRange.calculate(periodsToConsider));
  }

  /**
   * Test {@link AverageTrueRange#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AverageTrueRange#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double AverageTrueRange.calculate(List)"})
  void testCalculate_whenArrayList() {
    // Arrange
    AverageTrueRange averageTrueRange = new AverageTrueRange();

    // Act and Assert
    assertEquals(0.0d, averageTrueRange.calculate(new ArrayList<>()));
  }
}
