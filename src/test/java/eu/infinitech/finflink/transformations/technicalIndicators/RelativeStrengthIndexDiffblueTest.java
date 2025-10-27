package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class RelativeStrengthIndexDiffblueTest {
  /**
   * Method under test: {@link RelativeStrengthIndex#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    RelativeStrengthIndex relativeStrengthIndex = new RelativeStrengthIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, relativeStrengthIndex.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link RelativeStrengthIndex#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    RelativeStrengthIndex relativeStrengthIndex = new RelativeStrengthIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, relativeStrengthIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link RelativeStrengthIndex#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    RelativeStrengthIndex relativeStrengthIndex = new RelativeStrengthIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(100.0d, relativeStrengthIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link RelativeStrengthIndex#calculate(List)}
   */
  @Test
  void testCalculate4() {
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
   * Method under test: {@link RelativeStrengthIndex#RelativeStrengthIndex(Time)}
   */
  @Test
  void testNewRelativeStrengthIndex() {
    // Arrange and Act
    RelativeStrengthIndex actualRelativeStrengthIndex = new RelativeStrengthIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("RelativeStrengthIndex", actualRelativeStrengthIndex.getName());
    assertEquals(0L, actualRelativeStrengthIndex.getTimePeriod());
    assertTrue(actualRelativeStrengthIndex.getProperties().isEmpty());
  }
}
