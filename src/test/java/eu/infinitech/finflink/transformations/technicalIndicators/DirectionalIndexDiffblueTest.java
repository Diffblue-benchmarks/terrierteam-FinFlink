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

class DirectionalIndexDiffblueTest {
  /**
   * Test {@link DirectionalIndex#DirectionalIndex()}.
   * <p>
   * Method under test: {@link DirectionalIndex#DirectionalIndex()}
   */
  @Test
  @DisplayName("Test new DirectionalIndex()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DirectionalIndex.<init>()"})
  void testNewDirectionalIndex() {
    // Arrange and Act
    DirectionalIndex actualDirectionalIndex = new DirectionalIndex();

    // Assert
    assertNull(actualDirectionalIndex.getIndicatorRequirements());
    assertEquals(0L, actualDirectionalIndex.getTimePeriod());
  }

  /**
   * Test {@link DirectionalIndex#DirectionalIndex(Time)}.
   * <ul>
   *   <li>Then return Name is {@code DirectionalIndex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectionalIndex#DirectionalIndex(Time)}
   */
  @Test
  @DisplayName("Test new DirectionalIndex(Time); then return Name is 'DirectionalIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DirectionalIndex.<init>(Time)"})
  void testNewDirectionalIndex_thenReturnNameIsDirectionalIndex() {
    // Arrange and Act
    DirectionalIndex actualDirectionalIndex = new DirectionalIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("DirectionalIndex", actualDirectionalIndex.getName());
    assertEquals(0L, actualDirectionalIndex.getTimePeriod());
    assertTrue(actualDirectionalIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given 'null'; when ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_givenNull_whenArrayListAddNull() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(null);

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link DirectionalIndex#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double DirectionalIndex.calculate(List)"})
  void testCalculate_whenArrayList() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(new ArrayList<>()));
  }
}
