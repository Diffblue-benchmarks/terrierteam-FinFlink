package eu.infinitech.finflink.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.InputStreamType;
import eu.infinitech.finflink.structures.Trade;
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
   * <ul>
   *   <li>Given {@link Trade#Trade()}.</li>
   *   <li>Then return first ClosePrice is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long, List)}
   */
  @Test
  @DisplayName("Test generateTradePeriods(InputStreamType, long, List); given Trade(); then return first ClosePrice is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TradePeriodsGenerator.generateTradePeriods(InputStreamType, long, List)"})
  void testGenerateTradePeriods_givenTrade_thenReturnFirstClosePriceIsZero() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    Trade trade = new Trade();
    tradingData.add(trade);

    // Act
    List<TradePeriod> actualGenerateTradePeriodsResult = TradePeriodsGenerator.generateTradePeriods(inputStreamType,
        10L, tradingData);

    // Assert
    assertEquals(1, actualGenerateTradePeriodsResult.size());
    TradePeriod getResult = actualGenerateTradePeriodsResult.get(0);
    assertEquals(0.0d, getResult.getClosePrice());
    assertEquals(0.0d, getResult.getLowPrice());
    assertEquals(0.0d, getResult.getOpenPrice());
    assertEquals(0L, getResult.getStartTime());
    assertEquals(0L, getResult.getStopTime());
    assertEquals(0L, getResult.getVolume());
    List<TradingData> tradingData2 = getResult.getTradingData();
    assertEquals(1, tradingData2.size());
    assertEquals(Double.MIN_VALUE, getResult.getHighPrice());
    assertSame(trade, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long, List)}.
   * <ul>
   *   <li>Then return first ClosePrice is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long, List)}
   */
  @Test
  @DisplayName("Test generateTradePeriods(InputStreamType, long, List); then return first ClosePrice is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TradePeriodsGenerator.generateTradePeriods(InputStreamType, long, List)"})
  void testGenerateTradePeriods_thenReturnFirstClosePriceIsTen() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    Trade trade = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    tradingData.add(trade);

    // Act
    List<TradePeriod> actualGenerateTradePeriodsResult = TradePeriodsGenerator.generateTradePeriods(inputStreamType,
        10L, tradingData);

    // Assert
    assertEquals(1, actualGenerateTradePeriodsResult.size());
    TradePeriod getResult = actualGenerateTradePeriodsResult.get(0);
    List<TradingData> tradingData2 = getResult.getTradingData();
    assertEquals(1, tradingData2.size());
    assertEquals(10.0d, getResult.getClosePrice());
    assertEquals(10.0d, getResult.getHighPrice());
    assertEquals(10.0d, getResult.getLowPrice());
    assertEquals(10.0d, getResult.getOpenPrice());
    assertEquals(1L, getResult.getStartTime());
    assertEquals(1L, getResult.getStopTime());
    assertEquals(1L, getResult.getVolume());
    assertSame(trade, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long, List)}
   */
  @Test
  @DisplayName("Test generateTradePeriods(InputStreamType, long, List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List TradePeriodsGenerator.generateTradePeriods(InputStreamType, long, List)"})
  void testGenerateTradePeriods_whenArrayList_thenReturnEmpty() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    // Act
    List<TradePeriod> actualGenerateTradePeriodsResult = TradePeriodsGenerator.generateTradePeriods(inputStreamType,
        10L, new ArrayList<>());

    // Assert
    assertTrue(actualGenerateTradePeriodsResult.isEmpty());
  }
}
