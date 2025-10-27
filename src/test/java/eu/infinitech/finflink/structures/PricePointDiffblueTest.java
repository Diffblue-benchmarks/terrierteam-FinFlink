package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PricePointDiffblueTest {
  /**
   * Method under test: {@link PricePoint#compareTo(TradingData)}
   */
  @Test
  void testCompareTo() {
    // Arrange
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);

    // Act and Assert
    assertEquals(0, pricePoint.compareTo(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1)));
  }

  /**
   * Method under test: {@link PricePoint#compareTo(TradingData)}
   */
  @Test
  void testCompareTo2() {
    // Arrange
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);

    // Act and Assert
    assertEquals(0, pricePoint.compareTo(new Trade("Asset Symbol", 1L, 10.0d, 1L)));
  }

  /**
   * Method under test: {@link PricePoint#compareTo(TradingData)}
   */
  @Test
  void testCompareTo3() {
    // Arrange
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    pricePoint.setIgnore(true);

    // Act and Assert
    assertEquals(-1, pricePoint.compareTo(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PricePoint#PricePoint()}
   *   <li>{@link PricePoint#setAssetSymbol(String)}
   *   <li>{@link PricePoint#setClosePrice(double)}
   *   <li>{@link PricePoint#setHighPrice(double)}
   *   <li>{@link PricePoint#setIgnore(boolean)}
   *   <li>{@link PricePoint#setLowPrice(double)}
   *   <li>{@link PricePoint#setOpenInt(short)}
   *   <li>{@link PricePoint#setOpenPrice(double)}
   *   <li>{@link PricePoint#setUnixDate(long)}
   *   <li>{@link PricePoint#setVolume(long)}
   *   <li>{@link PricePoint#getAssetSymbol()}
   *   <li>{@link PricePoint#getClosePrice()}
   *   <li>{@link PricePoint#getHighPrice()}
   *   <li>{@link PricePoint#getLowPrice()}
   *   <li>{@link PricePoint#getOpenInt()}
   *   <li>{@link PricePoint#getOpenPrice()}
   *   <li>{@link PricePoint#getUnixDate()}
   *   <li>{@link PricePoint#getVolume()}
   *   <li>{@link PricePoint#isIgnore()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PricePoint actualPricePoint = new PricePoint();
    actualPricePoint.setAssetSymbol("Asset Symbol");
    actualPricePoint.setClosePrice(10.0d);
    actualPricePoint.setHighPrice(10.0d);
    actualPricePoint.setIgnore(true);
    actualPricePoint.setLowPrice(10.0d);
    actualPricePoint.setOpenInt((short) 1);
    actualPricePoint.setOpenPrice(10.0d);
    actualPricePoint.setUnixDate(1L);
    actualPricePoint.setVolume(1L);
    String actualAssetSymbol = actualPricePoint.getAssetSymbol();
    double actualClosePrice = actualPricePoint.getClosePrice();
    double actualHighPrice = actualPricePoint.getHighPrice();
    double actualLowPrice = actualPricePoint.getLowPrice();
    short actualOpenInt = actualPricePoint.getOpenInt();
    double actualOpenPrice = actualPricePoint.getOpenPrice();
    long actualUnixDate = actualPricePoint.getUnixDate();
    long actualVolume = actualPricePoint.getVolume();

    // Assert that nothing has changed
    assertEquals("Asset Symbol", actualAssetSymbol);
    assertEquals(10.0d, actualClosePrice);
    assertEquals(10.0d, actualHighPrice);
    assertEquals(10.0d, actualLowPrice);
    assertEquals(10.0d, actualOpenPrice);
    assertEquals(1L, actualUnixDate);
    assertEquals(1L, actualVolume);
    assertEquals((short) 1, actualOpenInt);
    assertTrue(actualPricePoint.isIgnore());
  }

  /**
   * Method under test:
   * {@link PricePoint#PricePoint(long, double, double, double, double, long, short)}
   */
  @Test
  void testNewPricePoint() {
    // Arrange and Act
    PricePoint actualPricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);

    // Assert
    assertNull(actualPricePoint.getAssetSymbol());
    assertEquals(10.0d, actualPricePoint.getClosePrice());
    assertEquals(10.0d, actualPricePoint.getHighPrice());
    assertEquals(10.0d, actualPricePoint.getLowPrice());
    assertEquals(10.0d, actualPricePoint.getOpenPrice());
    assertEquals(1L, actualPricePoint.getUnixDate());
    assertEquals(1L, actualPricePoint.getVolume());
    assertEquals((short) 1, actualPricePoint.getOpenInt());
    assertFalse(actualPricePoint.isIgnore());
  }

  /**
   * Method under test:
   * {@link PricePoint#PricePoint(long, double, double, double, double, long, short, String)}
   */
  @Test
  void testNewPricePoint2() {
    // Arrange and Act
    PricePoint actualPricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1, "Asset Symbol");

    // Assert
    assertEquals("Asset Symbol", actualPricePoint.getAssetSymbol());
    assertEquals(10.0d, actualPricePoint.getClosePrice());
    assertEquals(10.0d, actualPricePoint.getHighPrice());
    assertEquals(10.0d, actualPricePoint.getLowPrice());
    assertEquals(10.0d, actualPricePoint.getOpenPrice());
    assertEquals(1L, actualPricePoint.getUnixDate());
    assertEquals(1L, actualPricePoint.getVolume());
    assertEquals((short) 1, actualPricePoint.getOpenInt());
    assertFalse(actualPricePoint.isIgnore());
  }
}
