package eu.infinitech.finflink.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.InputStreamType;
import eu.infinitech.finflink.structures.Trade;
import eu.infinitech.finflink.structures.TradePeriod;
import eu.infinitech.finflink.structures.TradingData;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class TradePeriodsGeneratorDiffblueTest {
  /**
   * Method under test:
   * {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long, List)}
   */
  @Test
  void testGenerateTradePeriods() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    // Act
    List<TradePeriod> actualGenerateTradePeriodsResult = TradePeriodsGenerator.generateTradePeriods(inputStreamType,
        10L, new ArrayList<>());

    // Assert
    assertTrue(actualGenerateTradePeriodsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long, List)}
   */
  @Test
  void testGenerateTradePeriods2() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new Trade("Asset Symbol", 1L, 10.0d, 1L));

    // Act
    List<TradePeriod> actualGenerateTradePeriodsResult = TradePeriodsGenerator.generateTradePeriods(inputStreamType,
        10L, tradingData);

    // Assert
    assertEquals(1, actualGenerateTradePeriodsResult.size());
    TradePeriod getResult = actualGenerateTradePeriodsResult.get(0);
    assertEquals(10.0d, getResult.getClosePrice());
    assertEquals(10.0d, getResult.getHighPrice());
    assertEquals(10.0d, getResult.getLowPrice());
    assertEquals(10.0d, getResult.getOpenPrice());
    assertEquals(1L, getResult.getStartTime());
    assertEquals(1L, getResult.getStopTime());
    assertEquals(1L, getResult.getVolume());
    assertEquals(tradingData, getResult.getTradingData());
  }

  /**
   * Method under test:
   * {@link TradePeriodsGenerator#generateTradePeriods(InputStreamType, long, List)}
   */
  @Test
  void testGenerateTradePeriods3() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new Trade());

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
    assertEquals(tradingData, getResult.getTradingData());
    assertEquals(Double.MIN_VALUE, getResult.getHighPrice());
  }
}
