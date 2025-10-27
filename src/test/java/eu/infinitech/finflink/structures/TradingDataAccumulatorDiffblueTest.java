package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class TradingDataAccumulatorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TradingDataAccumulator#TradingDataAccumulator()}
   *   <li>{@link TradingDataAccumulator#setTradingData(List)}
   *   <li>{@link TradingDataAccumulator#getTradingData()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TradingDataAccumulator actualTradingDataAccumulator = new TradingDataAccumulator();
    ArrayList<TradingData> tradingData = new ArrayList<>();
    actualTradingDataAccumulator.setTradingData(tradingData);
    List<TradingData> actualTradingData = actualTradingDataAccumulator.getTradingData();

    // Assert that nothing has changed
    assertTrue(actualTradingData.isEmpty());
    assertSame(tradingData, actualTradingData);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TradingDataAccumulator#TradingDataAccumulator(List)}
   *   <li>{@link TradingDataAccumulator#setTradingData(List)}
   *   <li>{@link TradingDataAccumulator#getTradingData()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    TradingDataAccumulator actualTradingDataAccumulator = new TradingDataAccumulator(new ArrayList<>());
    ArrayList<TradingData> tradingData = new ArrayList<>();
    actualTradingDataAccumulator.setTradingData(tradingData);
    List<TradingData> actualTradingData = actualTradingDataAccumulator.getTradingData();

    // Assert that nothing has changed
    assertTrue(actualTradingData.isEmpty());
    assertSame(tradingData, actualTradingData);
  }
}
