package eu.infinitech.finflink.transformations.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.PricePoint;
import org.junit.jupiter.api.Test;

class ToPricePointDiffblueTest {
  /**
   * Method under test: {@link ToPricePoint#map(String)}
   */
  @Test
  void testMap() throws Exception {
    // Arrange and Act
    PricePoint actualMapResult = (new ToPricePoint("Asset Symbol")).map("Date");

    // Assert
    assertEquals("Asset Symbol", actualMapResult.getAssetSymbol());
    assertEquals(0.0d, actualMapResult.getClosePrice());
    assertEquals(0.0d, actualMapResult.getHighPrice());
    assertEquals(0.0d, actualMapResult.getLowPrice());
    assertEquals(0.0d, actualMapResult.getOpenPrice());
    assertEquals(0L, actualMapResult.getUnixDate());
    assertEquals(0L, actualMapResult.getVolume());
    assertEquals((short) 0, actualMapResult.getOpenInt());
    assertTrue(actualMapResult.isIgnore());
  }

  /**
   * Method under test: {@link ToPricePoint#map(String)}
   */
  @Test
  void testMap2() throws Exception {
    // Arrange and Act
    PricePoint actualMapResult = (new ToPricePoint(null)).map("Date");

    // Assert
    assertNull(actualMapResult.getAssetSymbol());
    assertEquals(0.0d, actualMapResult.getClosePrice());
    assertEquals(0.0d, actualMapResult.getHighPrice());
    assertEquals(0.0d, actualMapResult.getLowPrice());
    assertEquals(0.0d, actualMapResult.getOpenPrice());
    assertEquals(0L, actualMapResult.getUnixDate());
    assertEquals(0L, actualMapResult.getVolume());
    assertEquals((short) 0, actualMapResult.getOpenInt());
    assertTrue(actualMapResult.isIgnore());
  }

  /**
   * Method under test: {@link ToPricePoint#ToPricePoint()}
   */
  @Test
  void testNewToPricePoint() {
    // Arrange, Act and Assert
    assertNull((new ToPricePoint()).assetSymbol);
    assertEquals("Asset Symbol", (new ToPricePoint("Asset Symbol")).assetSymbol);
  }
}
