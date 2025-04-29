package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TradingDataAccumulatorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TradingDataAccumulator#TradingDataAccumulator()}
   *   <li>{@link TradingDataAccumulator#setTradingData(List)}
   *   <li>{@link TradingDataAccumulator#getTradingData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradingDataAccumulator.<init>()", "void TradingDataAccumulator.<init>(List)",
      "List TradingDataAccumulator.getTradingData()", "void TradingDataAccumulator.setTradingData(List)"})
  void testGettersAndSetters() {
    // Arrange and Act
    TradingDataAccumulator actualTradingDataAccumulator = new TradingDataAccumulator();
    ArrayList<TradingData> tradingData = new ArrayList<>();
    actualTradingDataAccumulator.setTradingData(tradingData);
    List<TradingData> actualTradingData = actualTradingDataAccumulator.getTradingData();

    // Assert
    assertTrue(actualTradingData.isEmpty());
    assertSame(tradingData, actualTradingData);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TradingDataAccumulator#TradingDataAccumulator(List)}
   *   <li>{@link TradingDataAccumulator#setTradingData(List)}
   *   <li>{@link TradingDataAccumulator#getTradingData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TradingDataAccumulator.<init>()", "void TradingDataAccumulator.<init>(List)",
      "List TradingDataAccumulator.getTradingData()", "void TradingDataAccumulator.setTradingData(List)"})
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    TradingDataAccumulator actualTradingDataAccumulator = new TradingDataAccumulator(new ArrayList<>());
    ArrayList<TradingData> tradingData = new ArrayList<>();
    actualTradingDataAccumulator.setTradingData(tradingData);
    List<TradingData> actualTradingData = actualTradingDataAccumulator.getTradingData();

    // Assert
    assertTrue(actualTradingData.isEmpty());
    assertSame(tradingData, actualTradingData);
  }
}
