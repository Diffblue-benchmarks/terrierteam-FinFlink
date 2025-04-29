package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.InputStreamType.Type;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TradePeriodDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.<init>()", "double TradePeriod.getClosePrice()",
      "double TradePeriod.getHighPrice()", "double TradePeriod.getLowPrice()", "double TradePeriod.getOpenPrice()",
      "long TradePeriod.getStartTime()", "long TradePeriod.getStopTime()", "List TradePeriod.getTradingData()",
      "long TradePeriod.getVolume()", "void TradePeriod.setClosePrice(double)", "void TradePeriod.setHighPrice(double)",
      "void TradePeriod.setLowPrice(double)", "void TradePeriod.setOpenPrice(double)",
      "void TradePeriod.setStartTime(long)", "void TradePeriod.setStopTime(long)",
      "void TradePeriod.setTradingData(List)", "void TradePeriod.setVolume(long)"})
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

    // Assert
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
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List)}.
   * <p>
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  @DisplayName("Test new TradePeriod(InputStreamType, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List)"})
  void testNewTradePeriod() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    Trade trade = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    tradingData.add(trade);

    // Act and Assert
    List<TradingData> tradingData2 = (new TradePeriod(inputStreamType, tradingData)).getTradingData();
    assertEquals(1, tradingData2.size());
    assertSame(trade, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}.
   * <p>
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}
   */
  @Test
  @DisplayName("Test new TradePeriod(InputStreamType, List, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List, int, int)"})
  void testNewTradePeriod2() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));
    Trade trade = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    tradingData.add(trade);

    // Act and Assert
    List<TradingData> tradingData2 = (new TradePeriod(inputStreamType, tradingData, 2, 1)).getTradingData();
    assertEquals(1, tradingData2.size());
    assertSame(trade, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List)}.
   * <ul>
   *   <li>Given {@link Trade#Trade()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Trade#Trade()}.</li>
   *   <li>Then return ClosePrice is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  @DisplayName("Test new TradePeriod(InputStreamType, List); given Trade(); when ArrayList() add Trade(); then return ClosePrice is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List)"})
  void testNewTradePeriod_givenTrade_whenArrayListAddTrade_thenReturnClosePriceIsZero() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    Trade trade = new Trade();
    tradingData.add(trade);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData);

    // Assert
    assertEquals(0.0d, actualTradePeriod.getClosePrice());
    assertEquals(0.0d, actualTradePeriod.getLowPrice());
    assertEquals(0.0d, actualTradePeriod.getOpenPrice());
    assertEquals(0L, actualTradePeriod.getStartTime());
    assertEquals(0L, actualTradePeriod.getStopTime());
    assertEquals(0L, actualTradePeriod.getVolume());
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(1, tradingData2.size());
    assertEquals(Double.MIN_VALUE, actualTradePeriod.getHighPrice());
    assertSame(trade, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}.
   * <ul>
   *   <li>Given {@link Trade#Trade()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Trade#Trade()}.</li>
   *   <li>Then return ClosePrice is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}
   */
  @Test
  @DisplayName("Test new TradePeriod(InputStreamType, List, int, int); given Trade(); when ArrayList() add Trade(); then return ClosePrice is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List, int, int)"})
  void testNewTradePeriod_givenTrade_whenArrayListAddTrade_thenReturnClosePriceIsZero2() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));
    Trade trade = new Trade();
    tradingData.add(trade);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData, 2, 1);

    // Assert
    assertEquals(0.0d, actualTradePeriod.getClosePrice());
    assertEquals(0.0d, actualTradePeriod.getLowPrice());
    assertEquals(0.0d, actualTradePeriod.getOpenPrice());
    assertEquals(0L, actualTradePeriod.getStartTime());
    assertEquals(0L, actualTradePeriod.getStopTime());
    assertEquals(0L, actualTradePeriod.getVolume());
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(1, tradingData2.size());
    assertEquals(Double.MIN_VALUE, actualTradePeriod.getHighPrice());
    assertSame(trade, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List)}.
   * <ul>
   *   <li>Then return {@link TradePeriod#inputStreamType} Asset is {@code Asset}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  @DisplayName("Test new TradePeriod(InputStreamType, List); then return inputStreamType Asset is 'Asset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List)"})
  void testNewTradePeriod_thenReturnInputStreamTypeAssetIsAsset() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    ArrayList<TradingData> tradingData = new ArrayList<>();
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);

    tradingData.add(pricePoint);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData);

    // Assert
    InputStreamType inputStreamType2 = actualTradePeriod.inputStreamType;
    assertEquals("Asset", inputStreamType2.getAsset());
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(1, tradingData2.size());
    assertEquals(Type.PricePoint, inputStreamType2.getType());
    assertSame(pricePoint, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List)}.
   * <ul>
   *   <li>Then return TradingData size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  @DisplayName("Test new TradePeriod(InputStreamType, List); then return TradingData size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List)"})
  void testNewTradePeriod_thenReturnTradingDataSizeIsTwo() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);

    tradingData.add(pricePoint);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData);

    // Assert
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(2, tradingData2.size());
    assertEquals(2L, actualTradePeriod.getVolume());
    assertSame(pricePoint, tradingData2.get(1));
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List)}.
   * <ul>
   *   <li>Then TradingData first return {@link Trade}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  @DisplayName("Test new TradePeriod(InputStreamType, List); then TradingData first return Trade")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List)"})
  void testNewTradePeriod_thenTradingDataFirstReturnTrade() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    Trade trade = new Trade("Asset Symbol", 1L, Double.MAX_VALUE, 1L);

    tradingData.add(trade);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData);

    // Assert
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(1, tradingData2.size());
    TradingData getResult = tradingData2.get(0);
    assertTrue(getResult instanceof Trade);
    assertEquals(Double.MAX_VALUE, ((Trade) getResult).getPrice());
    assertEquals(Double.MAX_VALUE, actualTradePeriod.getClosePrice());
    assertEquals(Double.MAX_VALUE, actualTradePeriod.getHighPrice());
    assertEquals(Double.MAX_VALUE, actualTradePeriod.getLowPrice());
    assertEquals(Double.MAX_VALUE, actualTradePeriod.getOpenPrice());
    assertSame(trade, getResult);
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}.
   * <ul>
   *   <li>When pricePoint {@code Asset}.</li>
   *   <li>Then return {@link TradePeriod#inputStreamType} Asset is {@code Asset}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}
   */
  @Test
  @DisplayName("Test new TradePeriod(InputStreamType, List, int, int); when pricePoint 'Asset'; then return inputStreamType Asset is 'Asset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List, int, int)"})
  void testNewTradePeriod_whenPricePointAsset_thenReturnInputStreamTypeAssetIsAsset() {
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
    assertEquals(1L, actualTradePeriod.getVolume());
    assertEquals(Type.PricePoint, inputStreamType2.getType());
    assertSame(pricePoint, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}.
   * <ul>
   *   <li>When pricePoint {@code Asset}.</li>
   *   <li>Then return TradingData size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}
   */
  @Test
  @DisplayName("Test new TradePeriod(InputStreamType, List, int, int); when pricePoint 'Asset'; then return TradingData size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List, int, int)"})
  void testNewTradePeriod_whenPricePointAsset_thenReturnTradingDataSizeIsTwo() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);

    tradingData.add(pricePoint);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData, 2, 1);

    // Assert
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(2, tradingData2.size());
    assertEquals(2L, actualTradePeriod.getVolume());
    assertSame(pricePoint, tradingData2.get(1));
  }

  /**
   * Test {@link TradePeriod#usingPricePoints(List)}.
   * <p>
   * Method under test: {@link TradePeriod#usingPricePoints(List)}
   */
  @Test
  @DisplayName("Test usingPricePoints(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.usingPricePoints(List)"})
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
   * Test {@link TradePeriod#usingPricePoints(List)}.
   * <ul>
   *   <li>Then {@link TradePeriod#TradePeriod()} HighPrice is {@link Double#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriod#usingPricePoints(List)}
   */
  @Test
  @DisplayName("Test usingPricePoints(List); then TradePeriod() HighPrice is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.usingPricePoints(List)"})
  void testUsingPricePoints_thenTradePeriodHighPriceIsMin_value() {
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
   * Test {@link TradePeriod#usingPricePoints(List)}.
   * <ul>
   *   <li>Then {@link TradePeriod#TradePeriod()} LowPrice is {@link Double#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriod#usingPricePoints(List)}
   */
  @Test
  @DisplayName("Test usingPricePoints(List); then TradePeriod() LowPrice is MAX_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.usingPricePoints(List)"})
  void testUsingPricePoints_thenTradePeriodLowPriceIsMax_value() {
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
   * Test {@link TradePeriod#usingTrades(List)}.
   * <ul>
   *   <li>Then {@link TradePeriod#TradePeriod()} ClosePrice is {@link Double#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriod#usingTrades(List)}
   */
  @Test
  @DisplayName("Test usingTrades(List); then TradePeriod() ClosePrice is MAX_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.usingTrades(List)"})
  void testUsingTrades_thenTradePeriodClosePriceIsMax_value() {
    // Arrange
    TradePeriod tradePeriod = new TradePeriod();

    ArrayList<Trade> trades = new ArrayList<>();
    trades.add(new Trade("Asset Symbol", 1L, Double.MAX_VALUE, 1L));

    // Act
    tradePeriod.usingTrades(trades);

    // Assert
    assertEquals(Double.MAX_VALUE, tradePeriod.getClosePrice());
    assertEquals(Double.MAX_VALUE, tradePeriod.getHighPrice());
    assertEquals(Double.MAX_VALUE, tradePeriod.getLowPrice());
    assertEquals(Double.MAX_VALUE, tradePeriod.getOpenPrice());
  }

  /**
   * Test {@link TradePeriod#usingTrades(List)}.
   * <ul>
   *   <li>Then {@link TradePeriod#TradePeriod()} ClosePrice is {@link Double#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriod#usingTrades(List)}
   */
  @Test
  @DisplayName("Test usingTrades(List); then TradePeriod() ClosePrice is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.usingTrades(List)"})
  void testUsingTrades_thenTradePeriodClosePriceIsMin_value() {
    // Arrange
    TradePeriod tradePeriod = new TradePeriod();

    ArrayList<Trade> trades = new ArrayList<>();
    trades.add(new Trade("Asset Symbol", 1L, Double.MIN_VALUE, 1L));

    // Act
    tradePeriod.usingTrades(trades);

    // Assert
    assertEquals(Double.MIN_VALUE, tradePeriod.getClosePrice());
    assertEquals(Double.MIN_VALUE, tradePeriod.getHighPrice());
    assertEquals(Double.MIN_VALUE, tradePeriod.getLowPrice());
    assertEquals(Double.MIN_VALUE, tradePeriod.getOpenPrice());
  }

  /**
   * Test {@link TradePeriod#usingTrades(List)}.
   * <ul>
   *   <li>Then {@link TradePeriod#TradePeriod()} ClosePrice is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradePeriod#usingTrades(List)}
   */
  @Test
  @DisplayName("Test usingTrades(List); then TradePeriod() ClosePrice is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradePeriod.usingTrades(List)"})
  void testUsingTrades_thenTradePeriodClosePriceIsTen() {
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
  }
}
