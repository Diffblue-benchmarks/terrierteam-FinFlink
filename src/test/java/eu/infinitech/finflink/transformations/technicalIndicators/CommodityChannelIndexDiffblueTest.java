package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.TradePeriod;
import eu.infinitech.finflink.structures.TradePeriodFactory;
import java.util.ArrayList;
import java.util.List;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CommodityChannelIndexDiffblueTest {
  /**
   * Test {@link CommodityChannelIndex#CommodityChannelIndex(Time)}.
   *
   * <ul>
   *   <li>Then return Name is {@code CommodityChannelIndex}.
   * </ul>
   *
   * <p>Method under test: {@link CommodityChannelIndex#CommodityChannelIndex(Time)}
   */
  @Test
  @DisplayName("Test new CommodityChannelIndex(Time); then return Name is 'CommodityChannelIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommodityChannelIndex.<init>(Time)"})
  void testNewCommodityChannelIndex_thenReturnNameIsCommodityChannelIndex() {
    // Arrange and Act
    CommodityChannelIndex actualCommodityChannelIndex =
        new CommodityChannelIndex(TimeFactory.createTime());

    // Assert
    assertEquals("CommodityChannelIndex", actualCommodityChannelIndex.getName());
    assertEquals(1000L, actualCommodityChannelIndex.getTimePeriod());
    assertTrue(actualCommodityChannelIndex.getProperties().isEmpty());
  }

  /**
   * Test {@link CommodityChannelIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link CommodityChannelIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CommodityChannelIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnNaN() {
    // Arrange
    CommodityChannelIndex commodityChannelIndex =
        new CommodityChannelIndex(TimeFactory.createTime());

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(Double.NaN, commodityChannelIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link CommodityChannelIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommodityChannelIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CommodityChannelIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnZero() {
    // Arrange
    CommodityChannelIndex commodityChannelIndex =
        new CommodityChannelIndex(TimeFactory.createTime());

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, commodityChannelIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link CommodityChannelIndex#calculate(List)}.
   *
   * <ul>
   *   <li>Given createTradePeriod.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommodityChannelIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); given createTradePeriod; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CommodityChannelIndex.calculate(List)"})
  void testCalculate_givenCreateTradePeriod_thenReturnZero2() {
    // Arrange
    CommodityChannelIndex commodityChannelIndex =
        new CommodityChannelIndex(TimeFactory.createTime());

    ArrayList<TradePeriod> periodsToConsider = new ArrayList<>();
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());
    periodsToConsider.add(TradePeriodFactory.createTradePeriod());

    // Act and Assert
    assertEquals(0.0d, commodityChannelIndex.calculate(periodsToConsider));
  }

  /**
   * Test {@link CommodityChannelIndex#calculate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CommodityChannelIndex#calculate(List)}
   */
  @Test
  @DisplayName("Test calculate(List); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CommodityChannelIndex.calculate(List)"})
  void testCalculate_whenArrayList_thenReturnZero() {
    // Arrange
    CommodityChannelIndex commodityChannelIndex =
        new CommodityChannelIndex(TimeFactory.createTime());

    // Act and Assert
    assertEquals(0.0d, commodityChannelIndex.calculate(new ArrayList<>()));
  }
}
