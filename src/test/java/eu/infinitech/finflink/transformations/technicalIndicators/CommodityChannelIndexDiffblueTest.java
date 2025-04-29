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

class CommodityChannelIndexDiffblueTest {
  /**
   * Test {@link CommodityChannelIndex#CommodityChannelIndex(Time)}.
   * <ul>
   *   <li>Then return Name is {@code CommodityChannelIndex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommodityChannelIndex#CommodityChannelIndex(Time)}
   */
  @Test
  @DisplayName("Test new CommodityChannelIndex(Time); then return Name is 'CommodityChannelIndex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CommodityChannelIndex.<init>(Time)"})
  void testNewCommodityChannelIndex_thenReturnNameIsCommodityChannelIndex() {
    // Arrange and Act
    CommodityChannelIndex actualCommodityChannelIndex = new CommodityChannelIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Assert
    assertEquals("CommodityChannelIndex", actualCommodityChannelIndex.getName());
    assertEquals(0L, actualCommodityChannelIndex.getTimePeriod());
    assertTrue(actualCommodityChannelIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link CommodityChannelIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommodityChannelIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double CommodityChannelIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnNaN() {
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
   * Test {@link CommodityChannelIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommodityChannelIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double CommodityChannelIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero() {
    // Arrange
    CommodityChannelIndex commodityChannelIndex = new CommodityChannelIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, commodityChannelIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link CommodityChannelIndex#calculate(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommodityChannelIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double CommodityChannelIndex.calculate(List)"})
  void testCalculate_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnZero2() {
    // Arrange
    CommodityChannelIndex commodityChannelIndex = new CommodityChannelIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(new TradePeriod());
    periodsToConsider.add(new TradePeriod());

    // Act and Assert
    assertEquals(0.0d, commodityChannelIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link CommodityChannelIndex#calculate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommodityChannelIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double CommodityChannelIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    CommodityChannelIndex commodityChannelIndex = new CommodityChannelIndex(Time.of(3L, TimeUnit.NANOSECONDS));

    // Act and Assert
    assertEquals(0.0d, commodityChannelIndex.calculate(new ArrayList<>()));
  }
}
