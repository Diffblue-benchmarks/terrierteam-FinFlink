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

class AverageDirectionalIndexDiffblueTest {
  /**
   * Test {@link AverageDirectionalIndex#AverageDirectionalIndex()}.
   * <p>
   * Method under test: {@link AverageDirectionalIndex#AverageDirectionalIndex()}
   */
  @Test
  @DisplayName("Test new AverageDirectionalIndex()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AverageDirectionalIndex.<init>()"})
  void testNewAverageDirectionalIndex() {
    // Arrange and Act
    AverageDirectionalIndex actualAverageDirectionalIndex = new AverageDirectionalIndex();

    // Assert
    assertNull(actualAverageDirectionalIndex.getIndicatorRequirements());
    assertEquals(0L, actualAverageDirectionalIndex.getTimePeriod());
  }

  /**
   * Test {@link AverageDirectionalIndex#AverageDirectionalIndex(Time)}.
   * <ul>
   *   <li>Then return Name is {@code AverageDirectionalIndex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AverageDirectionalIndex#AverageDirectionalIndex(Time)}
   */
  @Test
  @DisplayName("Test new AverageDirectionalIndex(Time); then return Name is 'AverageDirectionalIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AverageDirectionalIndex.<init>(Time)"})
  void testNewAverageDirectionalIndex_thenReturnNameIsAverageDirectionalIndex() {
    // Arrange and Act
    AverageDirectionalIndex actualAverageDirectionalIndex = new AverageDirectionalIndex(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("AverageDirectionalIndex", actualAverageDirectionalIndex.getName());
    assertEquals(0L, actualAverageDirectionalIndex.getTimePeriod());
    assertTrue(actualAverageDirectionalIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link AverageDirectionalIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AverageDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given 'null'; when ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double AverageDirectionalIndex.calculate(List)"})
  void testCalculate_givenNull_whenArrayListAddNull() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(null);

    // Act and Assert
    assertEquals(Double.NaN, averageDirectionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link AverageDirectionalIndex#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AverageDirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double AverageDirectionalIndex.calculate(List)"})
  void testCalculate_whenArrayList() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();

    // Act and Assert
    assertEquals(Double.NaN, averageDirectionalIndex.calculate(new ArrayList<>()));
  }
}
