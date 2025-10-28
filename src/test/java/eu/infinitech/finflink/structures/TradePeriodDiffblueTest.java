package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.InputStreamType.Type;
import eu.infinitech.finflink.transformations.data.ToTradeFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TradePeriodDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TradePeriod.<init>()",
    "double TradePeriod.getClosePrice()",
    "double TradePeriod.getHighPrice()",
    "double TradePeriod.getLowPrice()",
    "double TradePeriod.getOpenPrice()",
    "long TradePeriod.getStartTime()",
    "long TradePeriod.getStopTime()",
    "List TradePeriod.getTradingData()",
    "long TradePeriod.getVolume()",
    "void TradePeriod.setClosePrice(double)",
    "void TradePeriod.setHighPrice(double)",
    "void TradePeriod.setLowPrice(double)",
    "void TradePeriod.setOpenPrice(double)",
    "void TradePeriod.setStartTime(long)",
    "void TradePeriod.setStopTime(long)",
    "void TradePeriod.setTradingData(List)",
    "void TradePeriod.setVolume(long)"
  })
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
   *
   * <p>Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  @DisplayName("Test new TradePeriod(InputStreamType, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List)"})
  void testNewTradePeriod() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    Trade trade = new Trade(ToTradeFactory.createTradeDataString(), 1L, 10.0d, 1L);
    tradingData.add(trade);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData);

    // Assert
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(1, tradingData2.size());
    assertSame(trade, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}.
   *
   * <p>Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}
   */
  @Test
  @DisplayName("Test new TradePeriod(InputStreamType, List, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List, int, int)"})
  void testNewTradePeriod2() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint);
    Trade trade = new Trade(ToTradeFactory.createTradeDataString(), 1L, 10.0d, 1L);
    tradingData.add(trade);
    PricePoint pricePoint2 = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint2);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData, 2, 1);

    // Assert
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(1, tradingData2.size());
    assertSame(trade, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List)}.
   *
   * <ul>
   *   <li>Given {@link Trade#Trade()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Trade#Trade()}.
   *   <li>Then return ClosePrice is zero.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  @DisplayName(
      "Test new TradePeriod(InputStreamType, List); given Trade(); when ArrayList() add Trade(); then return ClosePrice is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link Trade#Trade()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Trade#Trade()}.
   *   <li>Then return ClosePrice is zero.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TradePeriod(InputStreamType, List, int, int); given Trade(); when ArrayList() add Trade(); then return ClosePrice is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List, int, int)"})
  void testNewTradePeriod_givenTrade_whenArrayListAddTrade_thenReturnClosePriceIsZero2() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint);
    Trade trade = new Trade();
    tradingData.add(trade);
    PricePoint pricePoint2 = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint2);

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
   *
   * <ul>
   *   <li>Then return {@link TradePeriod#inputStreamType} Asset is {@code AAPL,1000000,150.5,1000}.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  @DisplayName(
      "Test new TradePeriod(InputStreamType, List); then return inputStreamType Asset is 'AAPL,1000000,150.5,1000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List)"})
  void testNewTradePeriod_thenReturnInputStreamTypeAssetIsAapl100000015051000() {
    // Arrange
    InputStreamType inputStreamType =
        InputStreamType.pricePoint(ToTradeFactory.createTradeDataString());

    ArrayList<TradingData> tradingData = new ArrayList<>();
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData);

    // Assert
    InputStreamType inputStreamType2 = actualTradePeriod.inputStreamType;
    assertEquals("AAPL,1000000,150.5,1000", inputStreamType2.getAsset());
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(1, tradingData2.size());
    assertEquals(Type.PricePoint, inputStreamType2.getType());
    assertSame(pricePoint, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}.
   *
   * <ul>
   *   <li>Then return {@link TradePeriod#inputStreamType} Asset is {@code AAPL,1000000,150.5,1000}.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TradePeriod(InputStreamType, List, int, int); then return inputStreamType Asset is 'AAPL,1000000,150.5,1000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List, int, int)"})
  void testNewTradePeriod_thenReturnInputStreamTypeAssetIsAapl1000000150510002() {
    // Arrange
    InputStreamType inputStreamType =
        InputStreamType.pricePoint(ToTradeFactory.createTradeDataString());

    ArrayList<TradingData> tradingData = new ArrayList<>();
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint);
    PricePoint pricePoint2 = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint2);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData, 2, 1);

    // Assert
    InputStreamType inputStreamType2 = actualTradePeriod.inputStreamType;
    assertEquals("AAPL,1000000,150.5,1000", inputStreamType2.getAsset());
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(1, tradingData2.size());
    assertEquals(1L, actualTradePeriod.getVolume());
    assertEquals(Type.PricePoint, inputStreamType2.getType());
    assertSame(pricePoint2, tradingData2.get(0));
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List)}.
   *
   * <ul>
   *   <li>Then return TradingData size is two.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  @DisplayName("Test new TradePeriod(InputStreamType, List); then return TradingData size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List)"})
  void testNewTradePeriod_thenReturnTradingDataSizeIsTwo() {
    // Arrange
    InputStreamType inputStreamType =
        InputStreamType.pricePoint(ToTradeFactory.createTradeDataString());

    ArrayList<TradingData> tradingData = new ArrayList<>();
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint);
    PricePoint pricePoint2 = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint2);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData);

    // Assert
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(2, tradingData2.size());
    assertEquals(2L, actualTradePeriod.getVolume());
    assertSame(pricePoint2, tradingData2.get(1));
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}.
   *
   * <ul>
   *   <li>Then return TradingData size is two.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TradePeriod(InputStreamType, List, int, int); then return TradingData size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List, int, int)"})
  void testNewTradePeriod_thenReturnTradingDataSizeIsTwo2() {
    // Arrange
    InputStreamType inputStreamType =
        InputStreamType.pricePoint(ToTradeFactory.createTradeDataString());

    ArrayList<TradingData> tradingData = new ArrayList<>();
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint);
    PricePoint pricePoint2 = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint2);
    PricePoint pricePoint3 = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint3);
    PricePoint pricePoint4 = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint4);

    // Act
    TradePeriod actualTradePeriod = new TradePeriod(inputStreamType, tradingData, 2, 1);

    // Assert
    List<TradingData> tradingData2 = actualTradePeriod.getTradingData();
    assertEquals(2, tradingData2.size());
    assertEquals(2L, actualTradePeriod.getVolume());
    assertSame(pricePoint4, tradingData2.get(1));
  }

  /**
   * Test {@link TradePeriod#TradePeriod(InputStreamType, List)}.
   *
   * <ul>
   *   <li>Then TradingData first return {@link Trade}.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#TradePeriod(InputStreamType, List)}
   */
  @Test
  @DisplayName("Test new TradePeriod(InputStreamType, List); then TradingData first return Trade")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.<init>(InputStreamType, List)"})
  void testNewTradePeriod_thenTradingDataFirstReturnTrade() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    Trade trade = new Trade(ToTradeFactory.createTradeDataString(), 1L, Double.MAX_VALUE, 1L);
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
   * Test {@link TradePeriod#usingPricePoints(List)}.
   *
   * <p>Method under test: {@link TradePeriod#usingPricePoints(List)}
   */
  @Test
  @DisplayName("Test usingPricePoints(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.usingPricePoints(List)"})
  void testUsingPricePoints() {
    // Arrange
    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();

    ArrayList<PricePoint> pricePoints = new ArrayList<>();
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    pricePoints.add(pricePoint);

    // Act
    createTradePeriodResult.usingPricePoints(pricePoints);

    // Assert
    assertEquals(10.0d, createTradePeriodResult.getClosePrice());
    assertEquals(10.0d, createTradePeriodResult.getHighPrice());
    assertEquals(10.0d, createTradePeriodResult.getLowPrice());
    assertEquals(10.0d, createTradePeriodResult.getOpenPrice());
    assertEquals(1L, createTradePeriodResult.getStartTime());
    assertEquals(1L, createTradePeriodResult.getStopTime());
    assertEquals(1L, createTradePeriodResult.getVolume());
  }

  /**
   * Test {@link TradePeriod#usingPricePoints(List)}.
   *
   * <ul>
   *   <li>Then createTradePeriod HighPrice is {@link Double#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#usingPricePoints(List)}
   */
  @Test
  @DisplayName("Test usingPricePoints(List); then createTradePeriod HighPrice is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.usingPricePoints(List)"})
  void testUsingPricePoints_thenCreateTradePeriodHighPriceIsMin_value() {
    // Arrange
    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();

    ArrayList<PricePoint> pricePoints = new ArrayList<>();
    PricePoint pricePoint =
        new PricePoint(1L, 10.0d, Double.MIN_VALUE, 10.0d, 10.0d, 1L, (short) 1);
    pricePoints.add(pricePoint);

    // Act
    createTradePeriodResult.usingPricePoints(pricePoints);

    // Assert
    assertEquals(10.0d, createTradePeriodResult.getClosePrice());
    assertEquals(10.0d, createTradePeriodResult.getLowPrice());
    assertEquals(10.0d, createTradePeriodResult.getOpenPrice());
    assertEquals(1L, createTradePeriodResult.getStartTime());
    assertEquals(1L, createTradePeriodResult.getStopTime());
    assertEquals(1L, createTradePeriodResult.getVolume());
    assertEquals(Double.MIN_VALUE, createTradePeriodResult.getHighPrice());
  }

  /**
   * Test {@link TradePeriod#usingPricePoints(List)}.
   *
   * <ul>
   *   <li>Then createTradePeriod LowPrice is {@link Double#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#usingPricePoints(List)}
   */
  @Test
  @DisplayName("Test usingPricePoints(List); then createTradePeriod LowPrice is MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.usingPricePoints(List)"})
  void testUsingPricePoints_thenCreateTradePeriodLowPriceIsMax_value() {
    // Arrange
    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();

    ArrayList<PricePoint> pricePoints = new ArrayList<>();
    PricePoint pricePoint =
        new PricePoint(1L, 10.0d, 10.0d, Double.MAX_VALUE, 10.0d, 1L, (short) 1);
    pricePoints.add(pricePoint);

    // Act
    createTradePeriodResult.usingPricePoints(pricePoints);

    // Assert
    assertEquals(10.0d, createTradePeriodResult.getClosePrice());
    assertEquals(10.0d, createTradePeriodResult.getHighPrice());
    assertEquals(10.0d, createTradePeriodResult.getOpenPrice());
    assertEquals(1L, createTradePeriodResult.getStartTime());
    assertEquals(1L, createTradePeriodResult.getStopTime());
    assertEquals(1L, createTradePeriodResult.getVolume());
    assertEquals(Double.MAX_VALUE, createTradePeriodResult.getLowPrice());
  }

  /**
   * Test {@link TradePeriod#usingTrades(List)}.
   *
   * <ul>
   *   <li>Then createTradePeriod ClosePrice is {@link Double#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#usingTrades(List)}
   */
  @Test
  @DisplayName("Test usingTrades(List); then createTradePeriod ClosePrice is MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.usingTrades(List)"})
  void testUsingTrades_thenCreateTradePeriodClosePriceIsMax_value() {
    // Arrange
    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();

    ArrayList<Trade> trades = new ArrayList<>();
    Trade trade = new Trade(ToTradeFactory.createTradeDataString(), 1L, Double.MAX_VALUE, 1L);
    trades.add(trade);

    // Act
    createTradePeriodResult.usingTrades(trades);

    // Assert
    assertEquals(Double.MAX_VALUE, createTradePeriodResult.getClosePrice());
    assertEquals(Double.MAX_VALUE, createTradePeriodResult.getHighPrice());
    assertEquals(Double.MAX_VALUE, createTradePeriodResult.getLowPrice());
    assertEquals(Double.MAX_VALUE, createTradePeriodResult.getOpenPrice());
  }

  /**
   * Test {@link TradePeriod#usingTrades(List)}.
   *
   * <ul>
   *   <li>Then createTradePeriod ClosePrice is {@link Double#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#usingTrades(List)}
   */
  @Test
  @DisplayName("Test usingTrades(List); then createTradePeriod ClosePrice is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.usingTrades(List)"})
  void testUsingTrades_thenCreateTradePeriodClosePriceIsMin_value() {
    // Arrange
    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();

    ArrayList<Trade> trades = new ArrayList<>();
    Trade trade = new Trade(ToTradeFactory.createTradeDataString(), 1L, Double.MIN_VALUE, 1L);
    trades.add(trade);

    // Act
    createTradePeriodResult.usingTrades(trades);

    // Assert
    assertEquals(Double.MIN_VALUE, createTradePeriodResult.getClosePrice());
    assertEquals(Double.MIN_VALUE, createTradePeriodResult.getHighPrice());
    assertEquals(Double.MIN_VALUE, createTradePeriodResult.getLowPrice());
    assertEquals(Double.MIN_VALUE, createTradePeriodResult.getOpenPrice());
  }

  /**
   * Test {@link TradePeriod#usingTrades(List)}.
   *
   * <ul>
   *   <li>Then createTradePeriod ClosePrice is ten.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#usingTrades(List)}
   */
  @Test
  @DisplayName("Test usingTrades(List); then createTradePeriod ClosePrice is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.usingTrades(List)"})
  void testUsingTrades_thenCreateTradePeriodClosePriceIsTen() {
    // Arrange
    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();

    ArrayList<Trade> trades = new ArrayList<>();
    Trade trade = new Trade(ToTradeFactory.createTradeDataString(), 1L, 10.0d, 1L);
    trades.add(trade);

    // Act
    createTradePeriodResult.usingTrades(trades);

    // Assert
    assertEquals(10.0d, createTradePeriodResult.getClosePrice());
    assertEquals(10.0d, createTradePeriodResult.getHighPrice());
    assertEquals(10.0d, createTradePeriodResult.getLowPrice());
    assertEquals(10.0d, createTradePeriodResult.getOpenPrice());
  }

  /**
   * Test {@link TradePeriod#initializeTradePeriod(List)}.
   *
   * <ul>
   *   <li>Given {@link Trade#Trade()}.
   *   <li>Then createTradePeriod ClosePrice is zero.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#initializeTradePeriod(List)}
   */
  @Test
  @DisplayName(
      "Test initializeTradePeriod(List); given Trade(); then createTradePeriod ClosePrice is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.initializeTradePeriod(List)"})
  void testInitializeTradePeriod_givenTrade_thenCreateTradePeriodClosePriceIsZero() {
    // Arrange
    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new Trade());

    // Act
    createTradePeriodResult.initializeTradePeriod(tradingData);

    // Assert
    assertEquals(0.0d, createTradePeriodResult.getClosePrice());
    assertEquals(0.0d, createTradePeriodResult.getLowPrice());
    assertEquals(0.0d, createTradePeriodResult.getOpenPrice());
    assertEquals(0L, createTradePeriodResult.getStartTime());
    assertEquals(0L, createTradePeriodResult.getStopTime());
    assertEquals(0L, createTradePeriodResult.getVolume());
    assertEquals(Double.MIN_VALUE, createTradePeriodResult.getHighPrice());
  }

  /**
   * Test {@link TradePeriod#initializeTradePeriod(List)}.
   *
   * <ul>
   *   <li>Then createTradePeriod ClosePrice is ten.
   * </ul>
   *
   * <p>Method under test: {@link TradePeriod#initializeTradePeriod(List)}
   */
  @Test
  @DisplayName("Test initializeTradePeriod(List); then createTradePeriod ClosePrice is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradePeriod.initializeTradePeriod(List)"})
  void testInitializeTradePeriod_thenCreateTradePeriodClosePriceIsTen() {
    // Arrange
    TradePeriod createTradePeriodResult = TradePeriodFactory.createTradePeriod();

    ArrayList<TradingData> tradingData = new ArrayList<>();
    Trade trade = new Trade(ToTradeFactory.createTradeDataString(), 1L, 10.0d, 1L);
    tradingData.add(trade);

    // Act
    createTradePeriodResult.initializeTradePeriod(tradingData);

    // Assert
    assertEquals(10.0d, createTradePeriodResult.getClosePrice());
    assertEquals(10.0d, createTradePeriodResult.getHighPrice());
    assertEquals(10.0d, createTradePeriodResult.getLowPrice());
    assertEquals(10.0d, createTradePeriodResult.getOpenPrice());
    assertEquals(1L, createTradePeriodResult.getStartTime());
    assertEquals(1L, createTradePeriodResult.getStopTime());
    assertEquals(1L, createTradePeriodResult.getVolume());
  }
}
