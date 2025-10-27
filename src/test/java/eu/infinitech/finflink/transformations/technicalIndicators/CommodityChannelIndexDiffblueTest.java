package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class CommodityChannelIndexDiffblueTest {
  /**
   * Method under test: {@link CommodityChannelIndex#calculate(List)}
   */
  @Test
  void testCalculate() {
    // Arrange
    CommodityChannelIndex commodityChannelIndex = new CommodityChannelIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, commodityChannelIndex.calculate(new ArrayList<>()));
  }

  /**
   * Method under test: {@link CommodityChannelIndex#calculate(List)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    CommodityChannelIndex commodityChannelIndex = new CommodityChannelIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, commodityChannelIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link CommodityChannelIndex#calculate(List)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    CommodityChannelIndex commodityChannelIndex = new CommodityChannelIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, commodityChannelIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link CommodityChannelIndex#calculate(List)}
   */
  @Test
  void testCalculate4() {
    // Arrange
    CommodityChannelIndex commodityChannelIndex = new CommodityChannelIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, commodityChannelIndex.calculate(periodsToConsider));
  }

  /**
   * Method under test: {@link CommodityChannelIndex#CommodityChannelIndex(Time)}
   */
  @Test
  void testNewCommodityChannelIndex() {
    // Arrange and Act
    CommodityChannelIndex actualCommodityChannelIndex = new CommodityChannelIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("CommodityChannelIndex", actualCommodityChannelIndex.getName());
    assertEquals(0L, actualCommodityChannelIndex.getTimePeriod());
    assertTrue(actualCommodityChannelIndex.getProperties().isEmpty());
  }
}
