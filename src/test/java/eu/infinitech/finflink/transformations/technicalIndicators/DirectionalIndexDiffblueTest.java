package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class DirectionalIndexDiffblueTest {
  /**
   * Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link DirectionalIndex#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    DirectionalIndex directionalIndex = new DirectionalIndex();

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(null);

    // Act and Assert
    assertEquals(Double.NaN, directionalIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link DirectionalIndex#DirectionalIndex()}
   */
  @Test
  void testNewDirectionalIndex() {
    // Arrange and Act
    DirectionalIndex actualDirectionalIndex = new DirectionalIndex();

    // Assert
    assertNull(actualDirectionalIndex.getIndicatorRequirements());
    assertEquals(0L, actualDirectionalIndex.getTimePeriod());
  }

  /**
   * Method under test: {@link DirectionalIndex#DirectionalIndex(Time)}
   */
  @Test
  void testNewDirectionalIndex2() {
    // Arrange and Act
    DirectionalIndex actualDirectionalIndex = new DirectionalIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("DirectionalIndex", actualDirectionalIndex.getName());
    assertEquals(0L, actualDirectionalIndex.getTimePeriod());
    assertTrue(actualDirectionalIndex.getProperties().isEmpty());
  }
}
