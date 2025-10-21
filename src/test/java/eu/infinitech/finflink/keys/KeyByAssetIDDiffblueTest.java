package eu.infinitech.finflink.keys;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.PricePoint;
import eu.infinitech.finflink.structures.TradingData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KeyByAssetIDDiffblueTest {
  /**
   * Test {@link KeyByAssetID#getKey(TradingData)} with {@code TradingData}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyByAssetID#getKey(TradingData)}
   */
  @Test
  @DisplayName("Test getKey(TradingData) with 'TradingData'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String KeyByAssetID.getKey(TradingData)"})
  void testGetKeyWithTradingData_thenReturnNull() throws Exception {
    // Arrange
    KeyByAssetID keyByAssetID = new KeyByAssetID();

    // Act and Assert
    assertNull(keyByAssetID.getKey(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1)));
  }
}
