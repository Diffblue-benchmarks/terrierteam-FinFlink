package eu.infinitech.finflink.keys;

import static org.junit.jupiter.api.Assertions.assertNull;
import eu.infinitech.finflink.structures.PricePoint;
import eu.infinitech.finflink.structures.TradingData;
import org.junit.jupiter.api.Test;

class KeyByAssetIDDiffblueTest {
  /**
   * Method under test: {@link KeyByAssetID#getKey(TradingData)}
   */
  @Test
  void testGetKey() throws Exception {
    // Arrange
    KeyByAssetID keyByAssetID = new KeyByAssetID();

    // Act and Assert
    assertNull(keyByAssetID.getKey(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1)));
  }
}
