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

class HighPriceDirectionalMomentumDiffblueTest {
  /**
   * Test {@link HighPriceDirectionalMomentum#HighPriceDirectionalMomentum()}.
   * <p>
   * Method under test: {@link HighPriceDirectionalMomentum#HighPriceDirectionalMomentum()}
   */
  @Test
  @DisplayName("Test new HighPriceDirectionalMomentum()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HighPriceDirectionalMomentum.<init>()"})
  void testNewHighPriceDirectionalMomentum() {
    // Arrange and Act
    HighPriceDirectionalMomentum actualHighPriceDirectionalMomentum = new HighPriceDirectionalMomentum();

    // Assert
    assertNull(actualHighPriceDirectionalMomentum.getIndicatorRequirements());
    assertEquals(0L, actualHighPriceDirectionalMomentum.getTimePeriod());
  }

  /**
   * Test {@link HighPriceDirectionalMomentum#HighPriceDirectionalMomentum(Time)}.
   * <ul>
   *   <li>Then return Name is {@code HighPriceDirectionalMomentum}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HighPriceDirectionalMomentum#HighPriceDirectionalMomentum(Time)}
   */
  @Test
  @DisplayName("Test new HighPriceDirectionalMomentum(Time); then return Name is 'HighPriceDirectionalMomentum'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HighPriceDirectionalMomentum.<init>(Time)"})
  void testNewHighPriceDirectionalMomentum_thenReturnNameIsHighPriceDirectionalMomentum() {
    // Arrange and Act
    HighPriceDirectionalMomentum actualHighPriceDirectionalMomentum = new HighPriceDirectionalMomentum(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("HighPriceDirectionalMomentum", actualHighPriceDirectionalMomentum.getName());
    assertEquals(0L, actualHighPriceDirectionalMomentum.getTimePeriod());
    assertTrue(actualHighPriceDirectionalMomentum.getProperties().isEmpty());
  }

  /**
   * Test {@link HighPriceDirectionalMomentum#calculate(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HighPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given 'null'; when ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double HighPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_givenNull_whenArrayListAddNull() {
    // Arrange
    HighPriceDirectionalMomentum highPriceDirectionalMomentum = new HighPriceDirectionalMomentum();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(null);

    // Act and Assert
    assertEquals(0.0d, highPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link HighPriceDirectionalMomentum#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HighPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double HighPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_whenArrayList() {
    // Arrange
    HighPriceDirectionalMomentum highPriceDirectionalMomentum = new HighPriceDirectionalMomentum();

    // Act and Assert
    assertEquals(0.0d, highPriceDirectionalMomentum.calculate(new ArrayList<>()));
  }
}
