package eu.infinitech.finflink.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.InputStreamType;
import eu.infinitech.finflink.structures.PricePoint;
import eu.infinitech.finflink.structures.TradePeriod;
import eu.infinitech.finflink.structures.TradingData;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TradePeriodsGeneratorDiffblueTest {
  /**
   * Test {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long, List)}.
   *
   * <p>Method under test: {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long,
   * List)}
   */
  @Test
  @DisplayName("Test generateTradePeriods(InputStreamType, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TradePeriodsGenerator.generateTradePeriods(InputStreamType, long, List)"
  })
  void testGenerateTradePeriods() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    ArrayList<TradingData> tradingData = new ArrayList<>();
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint);

    // Act
    List<TradePeriod> actualGenerateTradePeriodsResult =
        TradePeriodsGenerator.generateTradePeriods(inputStreamType, 10L, tradingData);

    // Assert
    assertEquals(1, actualGenerateTradePeriodsResult.size());
    TradePeriod getResult = actualGenerateTradePeriodsResult.get(0);
    List<TradingData> tradingData2 = getResult.getTradingData();
    assertEquals(1, tradingData2.size());
    assertEquals(10.0d, getResult.getHighPrice());
    assertEquals(10.0d, getResult.getLowPrice());
    assertSame(pricePoint, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long, List)}.
   *
   * <ul>
   *   <li>Then return first HighPrice is {@link Double#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long,
   * List)}
   */
  @Test
  @DisplayName(
      "Test generateTradePeriods(InputStreamType, long, List); then return first HighPrice is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TradePeriodsGenerator.generateTradePeriods(InputStreamType, long, List)"
  })
  void testGenerateTradePeriods_thenReturnFirstHighPriceIsMin_value() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    ArrayList<TradingData> tradingData = new ArrayList<>();
    PricePoint pricePoint =
        new PricePoint(1L, 10.0d, Double.MIN_VALUE, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint);

    // Act
    List<TradePeriod> actualGenerateTradePeriodsResult =
        TradePeriodsGenerator.generateTradePeriods(inputStreamType, 10L, tradingData);

    // Assert
    assertEquals(1, actualGenerateTradePeriodsResult.size());
    TradePeriod getResult = actualGenerateTradePeriodsResult.get(0);
    List<TradingData> tradingData2 = getResult.getTradingData();
    assertEquals(1, tradingData2.size());
    assertEquals(10.0d, getResult.getLowPrice());
    assertEquals(Double.MIN_VALUE, getResult.getHighPrice());
    assertSame(pricePoint, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long, List)}.
   *
   * <ul>
   *   <li>Then return first LowPrice is {@link Double#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long,
   * List)}
   */
  @Test
  @DisplayName(
      "Test generateTradePeriods(InputStreamType, long, List); then return first LowPrice is MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TradePeriodsGenerator.generateTradePeriods(InputStreamType, long, List)"
  })
  void testGenerateTradePeriods_thenReturnFirstLowPriceIsMax_value() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    ArrayList<TradingData> tradingData = new ArrayList<>();
    PricePoint pricePoint =
        new PricePoint(1L, 10.0d, 10.0d, Double.MAX_VALUE, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint);

    // Act
    List<TradePeriod> actualGenerateTradePeriodsResult =
        TradePeriodsGenerator.generateTradePeriods(inputStreamType, 10L, tradingData);

    // Assert
    assertEquals(1, actualGenerateTradePeriodsResult.size());
    TradePeriod getResult = actualGenerateTradePeriodsResult.get(0);
    List<TradingData> tradingData2 = getResult.getTradingData();
    assertEquals(1, tradingData2.size());
    assertEquals(10.0d, getResult.getHighPrice());
    assertEquals(Double.MAX_VALUE, getResult.getLowPrice());
    assertSame(pricePoint, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long,
   * List)}
   */
  @Test
  @DisplayName(
      "Test generateTradePeriods(InputStreamType, long, List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TradePeriodsGenerator.generateTradePeriods(InputStreamType, long, List)"
  })
  void testGenerateTradePeriods_whenArrayList_thenReturnEmpty() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    // Act
    List<TradePeriod> actualGenerateTradePeriodsResult =
        TradePeriodsGenerator.generateTradePeriods(inputStreamType, 10L, new ArrayList<>());

    // Assert
    assertTrue(actualGenerateTradePeriodsResult.isEmpty());
  }
}
