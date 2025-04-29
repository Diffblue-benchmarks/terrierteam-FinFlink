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

class LowPriceDirectionalMomentumDiffblueTest {
  /**
   * Test {@link LowPriceDirectionalMomentum#LowPriceDirectionalMomentum()}.
   * <p>
   * Method under test: {@link LowPriceDirectionalMomentum#LowPriceDirectionalMomentum()}
   */
  @Test
  @DisplayName("Test new LowPriceDirectionalMomentum()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LowPriceDirectionalMomentum.<init>()"})
  void testNewLowPriceDirectionalMomentum() {
    // Arrange and Act
    LowPriceDirectionalMomentum actualLowPriceDirectionalMomentum = new LowPriceDirectionalMomentum();

    // Assert
    assertNull(actualLowPriceDirectionalMomentum.getIndicatorRequirements());
    assertEquals(0L, actualLowPriceDirectionalMomentum.getTimePeriod());
  }

  /**
   * Test {@link LowPriceDirectionalMomentum#LowPriceDirectionalMomentum(Time)}.
   * <ul>
   *   <li>Then return Name is {@code LowPriceDirectionalMomentum}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LowPriceDirectionalMomentum#LowPriceDirectionalMomentum(Time)}
   */
  @Test
  @DisplayName("Test new LowPriceDirectionalMomentum(Time); then return Name is 'LowPriceDirectionalMomentum'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LowPriceDirectionalMomentum.<init>(Time)"})
  void testNewLowPriceDirectionalMomentum_thenReturnNameIsLowPriceDirectionalMomentum() {
    // Arrange and Act
    LowPriceDirectionalMomentum actualLowPriceDirectionalMomentum = new LowPriceDirectionalMomentum(
        Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("LowPriceDirectionalMomentum", actualLowPriceDirectionalMomentum.getName());
    assertEquals(0L, actualLowPriceDirectionalMomentum.getTimePeriod());
    assertTrue(actualLowPriceDirectionalMomentum.getProperties().isEmpty());
  }

  /**
   * Test {@link LowPriceDirectionalMomentum#calculate(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LowPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given 'null'; when ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double LowPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_givenNull_whenArrayListAddNull() {
    // Arrange
    LowPriceDirectionalMomentum lowPriceDirectionalMomentum = new LowPriceDirectionalMomentum();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(null);

    // Act and Assert
    assertEquals(0.0d, lowPriceDirectionalMomentum.calculate(periodsToConsider));
  }

  /**
   * Test {@link LowPriceDirectionalMomentum#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LowPriceDirectionalMomentum#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double LowPriceDirectionalMomentum.calculate(List)"})
  void testCalculate_whenArrayList() {
    // Arrange
    LowPriceDirectionalMomentum lowPriceDirectionalMomentum = new LowPriceDirectionalMomentum();

    // Act and Assert
    assertEquals(0.0d, lowPriceDirectionalMomentum.calculate(new ArrayList<>()));
  }
}
