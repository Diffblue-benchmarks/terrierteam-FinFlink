package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TradeDiffblueTest {
  /**
   * Method under test: {@link Trade#compareTo(TradingData)}
   */
  @Test
  void testCompareTo() {
    // Arrange
    Trade trade = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    // Act and Assert
    assertEquals(0, trade.compareTo(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1)));
  }

  /**
   * Method under test: {@link Trade#compareTo(TradingData)}
   */
  @Test
  void testCompareTo2() {
    // Arrange
    Trade trade = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    // Act and Assert
    assertEquals(0, trade.compareTo(new Trade("Asset Symbol", 1L, 10.0d, 1L)));
  }

  /**
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

    // Assert that nothing has changed
    assertEquals("Asset Symbol", actualAssetSymbol);
    assertEquals(10.0d, actualPrice);
    assertEquals(1L, actualUnixDate);
    assertEquals(1L, actualTrade.getVolume());
  }

  /**
   * Method under test: {@link Trade#Trade(String, long, double, long)}
   */
  @Test
  void testNewTrade() {
    // Arrange and Act
    Trade actualTrade = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    // Assert
    assertEquals("Asset Symbol", actualTrade.getAssetSymbol());
    assertEquals(10.0d, actualTrade.getPrice());
    assertEquals(1L, actualTrade.getUnixDate());
    assertEquals(1L, actualTrade.getVolume());
  }
}
