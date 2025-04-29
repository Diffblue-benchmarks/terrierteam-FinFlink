package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TradeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Trade#Trade()}
   *   <li>{@link Trade#setAssetSymbol(String)}
   *   <li>{@link Trade#setPrice(double)}
   *   <li>{@link Trade#setUnixDate(long)}
   *   <li>{@link Trade#setVolume(long)}
   *   <li>{@link Trade#getAssetSymbol()}
   *   <li>{@link Trade#getPrice()}
   *   <li>{@link Trade#getUnixDate()}
   *   <li>{@link Trade#getVolume()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Trade.<init>()", "String Trade.getAssetSymbol()", "double Trade.getPrice()",
      "long Trade.getUnixDate()", "long Trade.getVolume()", "void Trade.setAssetSymbol(String)",
      "void Trade.setPrice(double)", "void Trade.setUnixDate(long)", "void Trade.setVolume(long)"})
  void testGettersAndSetters() {
    // Arrange and Act
    Trade actualTrade = new Trade();
    actualTrade.setAssetSymbol("Asset Symbol");
    actualTrade.setPrice(10.0d);
    actualTrade.setUnixDate(1L);
    actualTrade.setVolume(1L);
    String actualAssetSymbol = actualTrade.getAssetSymbol();
    double actualPrice = actualTrade.getPrice();
    long actualUnixDate = actualTrade.getUnixDate();

    // Assert
    assertEquals("Asset Symbol", actualAssetSymbol);
    assertEquals(10.0d, actualPrice);
    assertEquals(1L, actualUnixDate);
    assertEquals(1L, actualTrade.getVolume());
  }

  /**
   * Test {@link Trade#Trade(String, long, double, long)}.
   * <p>
   * Method under test: {@link Trade#Trade(String, long, double, long)}
   */
  @Test
  @DisplayName("Test new Trade(String, long, double, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Trade.<init>(String, long, double, long)"})
  void testNewTrade() {
    // Arrange and Act
    Trade actualTrade = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    // Assert
    assertEquals("Asset Symbol", actualTrade.getAssetSymbol());
    assertEquals(10.0d, actualTrade.getPrice());
    assertEquals(1L, actualTrade.getUnixDate());
    assertEquals(1L, actualTrade.getVolume());
  }

  /**
   * Test {@link Trade#compareTo(TradingData)} with {@code TradingData}.
   * <p>
   * Method under test: {@link Trade#compareTo(TradingData)}
   */
  @Test
  @DisplayName("Test compareTo(TradingData) with 'TradingData'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Trade.compareTo(TradingData)"})
  void testCompareToWithTradingData() {
    // Arrange
    Trade trade = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    // Act and Assert
    assertEquals(0, trade.compareTo(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1)));
  }

  /**
   * Test {@link Trade#compareTo(TradingData)} with {@code TradingData}.
   * <p>
   * Method under test: {@link Trade#compareTo(TradingData)}
   */
  @Test
  @DisplayName("Test compareTo(TradingData) with 'TradingData'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Trade.compareTo(TradingData)"})
  void testCompareToWithTradingData2() {
    // Arrange
    Trade trade = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    // Act and Assert
    assertEquals(0, trade.compareTo(new Trade("Asset Symbol", 1L, 10.0d, 1L)));
  }
}
