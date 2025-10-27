package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class TradePeriodDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TradePeriod#TradePeriod()}
   *   <li>{@link TradePeriod#setClosePrice(double)}
   *   <li>{@link TradePeriod#setHighPrice(double)}
   *   <li>{@link TradePeriod#setLowPrice(double)}
   *   <li>{@link TradePeriod#setOpenPrice(double)}
   *   <li>{@link TradePeriod#setStartTime(long)}
   *   <li>{@link TradePeriod#setStopTime(long)}
   *   <li>{@link TradePeriod#setTradingData(List)}
   *   <li>{@link TradePeriod#setVolume(long)}
   *   <li>{@link TradePeriod#getClosePrice()}
   *   <li>{@link TradePeriod#getHighPrice()}
   *   <li>{@link TradePeriod#getLowPrice()}
   *   <li>{@link TradePeriod#getOpenPrice()}
   *   <li>{@link TradePeriod#getStartTime()}
   *   <li>{@link TradePeriod#getStopTime()}
   *   <li>{@link TradePeriod#getTradingData()}
   *   <li>{@link TradePeriod#getVolume()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TradePeriod actualTradePeriod = new TradePeriod();
    actualTradePeriod.setClosePrice(10.0d);
    actualTradePeriod.setHighPrice(10.0d);
    actualTradePeriod.setLowPrice(10.0d);
    actualTradePeriod.setOpenPrice(10.0d);
    actualTradePeriod.setStartTime(1L);
    actualTradePeriod.setStopTime(1L);
    ArrayList<TradingData> tradingData = new ArrayList<>();
    actualTradePeriod.setTradingData(tradingData);
    actualTradePeriod.setVolume(1L);
    double actualClosePrice = actualTradePeriod.getClosePrice();
    double actualHighPrice = actualTradePeriod.getHighPrice();
    double actualLowPrice = actualTradePeriod.getLowPrice();
    double actualOpenPrice = actualTradePeriod.getOpenPrice();
    long actualStartTime = actualTradePeriod.getStartTime();
    long actualStopTime = actualTradePeriod.getStopTime();
    List<TradingData> actualTradingData = actualTradePeriod.getTradingData();

    // Assert that nothing has changed
    assertEquals(10.0d, actualClosePrice);
    assertEquals(10.0d, actualHighPrice);
    assertEquals(10.0d, actualLowPrice);
    assertEquals(10.0d, actualOpenPrice);
    assertEquals(1L, actualStartTime);
    assertEquals(1L, actualStopTime);
    assertEquals(1L, actualTradePeriod.getVolume());
    assertTrue(actualTradingData.isEmpty());
    assertSame(tradingData, actualTradingData);
  }

  /**
   * Method under test: {@link TradePeriod#usingPricePoints(List)}
   */
  @Test
  void testUsingPricePoints() {
    // Arrange
    TradePeriod tradePeriod = new TradePeriod();

    ArrayList<PricePoint> pricePoints = new ArrayList<>();
    pricePoints.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));

    // Act
    tradePeriod.usingPricePoints(pricePoints);

    // Assert
    assertEquals(10.0d, tradePeriod.getClosePrice());
    assertEquals(10.0d, tradePeriod.getHighPrice());
    assertEquals(10.0d, tradePeriod.getLowPrice());
    assertEquals(10.0d, tradePeriod.getOpenPrice());
    assertEquals(1L, tradePeriod.getStartTime());
    assertEquals(1L, tradePeriod.getStopTime());
    assertEquals(1L, tradePeriod.getVolume());
  }

  /**
   * Method under test: {@link TradePeriod#usingPricePoints(List)}
   */
  @Test
  void testUsingPricePoints2() {
    // Arrange
    TradePeriod tradePeriod = new TradePeriod();

    ArrayList<PricePoint> pricePoints = new ArrayList<>();
    pricePoints.add(new PricePoint(1L, 10.0d, Double.MIN_VALUE, 10.0d, 10.0d, 1L, (short) 1));

    // Act
    tradePeriod.usingPricePoints(pricePoints);

    // Assert
    assertEquals(10.0d, tradePeriod.getClosePrice());
    assertEquals(10.0d, tradePeriod.getLowPrice());
    assertEquals(10.0d, tradePeriod.getOpenPrice());
    assertEquals(1L, tradePeriod.getStartTime());
    assertEquals(1L, tradePeriod.getStopTime());
    assertEquals(1L, tradePeriod.getVolume());
    assertEquals(Double.MIN_VALUE, tradePeriod.getHighPrice());
  }

  /**
   * Method under test: {@link TradePeriod#usingPricePoints(List)}
   */
  @Test
  void testUsingPricePoints3() {
    // Arrange
    TradePeriod tradePeriod = new TradePeriod();

    ArrayList<PricePoint> pricePoints = new ArrayList<>();
    pricePoints.add(new PricePoint(1L, 10.0d, 10.0d, Double.MAX_VALUE, 10.0d, 1L, (short) 1));

    // Act
    tradePeriod.usingPricePoints(pricePoints);

    // Assert
    assertEquals(10.0d, tradePeriod.getClosePrice());
    assertEquals(10.0d, tradePeriod.getHighPrice());
    assertEquals(10.0d, tradePeriod.getOpenPrice());
    assertEquals(1L, tradePeriod.getStartTime());
    assertEquals(1L, tradePeriod.getStopTime());
    assertEquals(1L, tradePeriod.getVolume());
    assertEquals(Double.MAX_VALUE, tradePeriod.getLowPrice());
  }

  /**
   * Method under test: {@link TradePeriod#usingTrades(List)}
   */
  @Test
  void testUsingTrades() {
    // Arrange
    TradePeriod tradePeriod = new TradePeriod();

    ArrayList<Trade> trades = new ArrayList<>();
    trades.add(new Trade("Asset Symbol", 1L, 10.0d, 1L));

    // Act
    tradePeriod.usingTrades(trades);

    // Assert
    assertEquals(10.0d, tradePeriod.getClosePrice());
    assertEquals(10.0d, tradePeriod.getHighPrice());
    assertEquals(10.0d, tradePeriod.getLowPrice());
    assertEquals(10.0d, tradePeriod.getOpenPrice());
    assertEquals(1L, tradePeriod.getStartTime());
    assertEquals(1L, tradePeriod.getStopTime());
    assertEquals(1L, tradePeriod.getVolume());
  }

  /**
   * Method under test: {@link TradePeriod#usingTrades(List)}
   */
  @Test
  void testUsingTrades2() {
    // Arrange
    TradePeriod tradePeriod = new TradePeriod();

    ArrayList<Trade> trades = new ArrayList<>();
    trades.add(new Trade("Asset Symbol", 1L, Double.MIN_VALUE, 1L));

    // Act
    tradePeriod.usingTrades(trades);

    // Assert
    assertEquals(1L, tradePeriod.getStartTime());
    assertEquals(1L, tradePeriod.getStopTime());
    assertEquals(1L, tradePeriod.getVolume());
    assertEquals(Double.MIN_VALUE, tradePeriod.getClosePrice());
    assertEquals(Double.MIN_VALUE, tradePeriod.getHighPrice());
    assertEquals(Double.MIN_VALUE, tradePeriod.getLowPrice());
    assertEquals(Double.MIN_VALUE, tradePeriod.getOpenPrice());
  }

  /**
   * Method under test: {@link TradePeriod#usingTrades(List)}
   */
  @Test
  void testUsingTrades3() {
    // Arrange
    TradePeriod tradePeriod = new TradePeriod();

    ArrayList<Trade> trades = new ArrayList<>();
    trades.add(new Trade("Asset Symbol", 1L, Double.MAX_VALUE, 1L));

    // Act
    tradePeriod.usingTrades(trades);

    // Assert
    assertEquals(1L, tradePeriod.getStartTime());
    assertEquals(1L, tradePeriod.getStopTime());
    assertEquals(1L, tradePeriod.getVolume());
    assertEquals(Double.MAX_VALUE, tradePeriod.getClosePrice());
    assertEquals(Double.MAX_VALUE, tradePeriod.getHighPrice());
    assertEquals(Double.MAX_VALUE, tradePeriod.getLowPrice());
    assertEquals(Double.MAX_VALUE, tradePeriod.getOpenPrice());
  }

  /**
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  void testNewTradePeriod() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new Trade("Asset Symbol", 1L, 10.0d, 1L));

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData);

    // Assert
    InputStreamType inputStreamType2 = actualTradePeriod.inputStreamType;
    assertNull(inputStreamType2.getAsset());
    assertEquals(10.0d, actualTradePeriod.getClosePrice());
    assertEquals(10.0d, actualTradePeriod.getHighPrice());
    assertEquals(10.0d, actualTradePeriod.getLowPrice());
    assertEquals(10.0d, actualTradePeriod.getOpenPrice());
    assertEquals(1L, actualTradePeriod.getStartTime());
    assertEquals(1L, actualTradePeriod.getStopTime());
    assertEquals(1L, actualTradePeriod.getVolume());
    assertEquals(InputStreamType.Type.Trade, inputStreamType2.getType());
    assertSame(tradingData, actualTradePeriod.getTradingData());
  }

  /**
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  void testNewTradePeriod2() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new Trade());

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData);

    // Assert
    InputStreamType inputStreamType2 = actualTradePeriod.inputStreamType;
    assertNull(inputStreamType2.getAsset());
    assertEquals(0.0d, actualTradePeriod.getClosePrice());
    assertEquals(0.0d, actualTradePeriod.getLowPrice());
    assertEquals(0.0d, actualTradePeriod.getOpenPrice());
    assertEquals(0L, actualTradePeriod.getStartTime());
    assertEquals(0L, actualTradePeriod.getStopTime());
    assertEquals(0L, actualTradePeriod.getVolume());
    assertEquals(InputStreamType.Type.Trade, inputStreamType2.getType());
    assertEquals(Double.MIN_VALUE, actualTradePeriod.getHighPrice());
    assertSame(tradingData, actualTradePeriod.getTradingData());
  }

  /**
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  void testNewTradePeriod3() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData);

    // Assert
    InputStreamType inputStreamType2 = actualTradePeriod.inputStreamType;
    assertEquals("Asset", inputStreamType2.getAsset());
    assertEquals(10.0d, actualTradePeriod.getClosePrice());
    assertEquals(10.0d, actualTradePeriod.getHighPrice());
    assertEquals(10.0d, actualTradePeriod.getLowPrice());
    assertEquals(10.0d, actualTradePeriod.getOpenPrice());
    assertEquals(1L, actualTradePeriod.getStartTime());
    assertEquals(1L, actualTradePeriod.getStopTime());
    assertEquals(1L, actualTradePeriod.getVolume());
    assertEquals(InputStreamType.Type.PricePoint, inputStreamType2.getType());
    assertSame(tradingData, actualTradePeriod.getTradingData());
  }

  /**
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  void testNewTradePeriod4() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData);

    // Assert
    InputStreamType inputStreamType2 = actualTradePeriod.inputStreamType;
    assertEquals("Asset", inputStreamType2.getAsset());
    assertEquals(10.0d, actualTradePeriod.getClosePrice());
    assertEquals(10.0d, actualTradePeriod.getHighPrice());
    assertEquals(10.0d, actualTradePeriod.getLowPrice());
    assertEquals(10.0d, actualTradePeriod.getOpenPrice());
    assertEquals(1L, actualTradePeriod.getStartTime());
    assertEquals(1L, actualTradePeriod.getStopTime());
    assertEquals(2L, actualTradePeriod.getVolume());
    assertEquals(InputStreamType.Type.PricePoint, inputStreamType2.getType());
    assertSame(tradingData, actualTradePeriod.getTradingData());
  }

  /**
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  void testNewTradePeriod5() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new Trade("Asset Symbol", 1L, Double.MAX_VALUE, 1L));

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData);

    // Assert
    InputStreamType inputStreamType2 = actualTradePeriod.inputStreamType;
    assertNull(inputStreamType2.getAsset());
    assertEquals(1L, actualTradePeriod.getStartTime());
    assertEquals(1L, actualTradePeriod.getStopTime());
    assertEquals(1L, actualTradePeriod.getVolume());
    assertEquals(InputStreamType.Type.Trade, inputStreamType2.getType());
    assertEquals(Double.MAX_VALUE, actualTradePeriod.getClosePrice());
    assertEquals(Double.MAX_VALUE, actualTradePeriod.getHighPrice());
    assertEquals(Double.MAX_VALUE, actualTradePeriod.getLowPrice());
    assertEquals(Double.MAX_VALUE, actualTradePeriod.getOpenPrice());
    assertSame(tradingData, actualTradePeriod.getTradingData());
  }

  /**
   * Method under test:
   * {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}
   */
  @Test
  void testNewTradePeriod6() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);

    tradingData.add(pricePoint);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData, 2, 1);

    // Assert
    InputStreamType inputStreamType2 = actualTradePeriod.inputStreamType;
    assertEquals("Asset", inputStreamType2.getAsset());
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(1, tradingData2.size());
    assertEquals(10.0d, actualTradePeriod.getClosePrice());
    assertEquals(10.0d, actualTradePeriod.getHighPrice());
    assertEquals(10.0d, actualTradePeriod.getLowPrice());
    assertEquals(10.0d, actualTradePeriod.getOpenPrice());
    assertEquals(1L, actualTradePeriod.getStartTime());
    assertEquals(1L, actualTradePeriod.getStopTime());
    assertEquals(1L, actualTradePeriod.getVolume());
    assertEquals(InputStreamType.Type.PricePoint, inputStreamType2.getType());
    assertSame(pricePoint, tradingData2.get(0));
  }

  /**
   * Method under test:
   * {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}
   */
  @Test
  void testNewTradePeriod7() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));
    Trade trade = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    tradingData.add(trade);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData, 2, 1);

    // Assert
    InputStreamType inputStreamType2 = actualTradePeriod.inputStreamType;
    assertNull(inputStreamType2.getAsset());
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(1, tradingData2.size());
    assertEquals(10.0d, actualTradePeriod.getClosePrice());
    assertEquals(10.0d, actualTradePeriod.getHighPrice());
    assertEquals(10.0d, actualTradePeriod.getLowPrice());
    assertEquals(10.0d, actualTradePeriod.getOpenPrice());
    assertEquals(1L, actualTradePeriod.getStartTime());
    assertEquals(1L, actualTradePeriod.getStopTime());
    assertEquals(1L, actualTradePeriod.getVolume());
    assertEquals(InputStreamType.Type.Trade, inputStreamType2.getType());
    assertSame(trade, tradingData2.get(0));
  }

  /**
   * Method under test:
   * {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}
   */
  @Test
  void testNewTradePeriod8() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));
    Trade trade = new Trade();
    tradingData.add(trade);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData, 2, 1);

    // Assert
    InputStreamType inputStreamType2 = actualTradePeriod.inputStreamType;
    assertNull(inputStreamType2.getAsset());
    assertEquals(0.0d, actualTradePeriod.getClosePrice());
    assertEquals(0.0d, actualTradePeriod.getLowPrice());
    assertEquals(0.0d, actualTradePeriod.getOpenPrice());
    assertEquals(0L, actualTradePeriod.getStartTime());
    assertEquals(0L, actualTradePeriod.getStopTime());
    assertEquals(0L, actualTradePeriod.getVolume());
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(1, tradingData2.size());
    assertEquals(InputStreamType.Type.Trade, inputStreamType2.getType());
    assertEquals(Double.MIN_VALUE, actualTradePeriod.getHighPrice());
    assertSame(trade, tradingData2.get(0));
  }

  /**
   * Method under test:
   * {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}
   */
  @Test
  void testNewTradePeriod9() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);

    tradingData.add(pricePoint);
    PricePoint pricePoint2 = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);

    tradingData.add(pricePoint2);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData, 2, 1);

    // Assert
    InputStreamType inputStreamType2 = actualTradePeriod.inputStreamType;
    assertEquals("Asset", inputStreamType2.getAsset());
    assertEquals(10.0d, actualTradePeriod.getClosePrice());
    assertEquals(10.0d, actualTradePeriod.getHighPrice());
    assertEquals(10.0d, actualTradePeriod.getLowPrice());
    assertEquals(10.0d, actualTradePeriod.getOpenPrice());
    assertEquals(1L, actualTradePeriod.getStartTime());
    assertEquals(1L, actualTradePeriod.getStopTime());
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(2, tradingData2.size());
    assertEquals(2L, actualTradePeriod.getVolume());
    assertEquals(InputStreamType.Type.PricePoint, inputStreamType2.getType());
    assertSame(pricePoint, tradingData2.get(0));
    assertSame(pricePoint2, tradingData2.get(1));
  }
}
