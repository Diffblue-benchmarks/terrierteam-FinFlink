package eu.infinitech.finflink.keys;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.PricePoint;
import eu.infinitech.finflink.structures.TradingData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KeyByAssetIDDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link KeyByAssetID}
   *   <li>{@link KeyByAssetID#isInitialized()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KeyByAssetID.<init>()", "boolean KeyByAssetID.isInitialized()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new KeyByAssetID().isInitialized());
  }

  /**
   * Test {@link KeyByAssetID#getKey(TradingData)} with {@code TradingData}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link KeyByAssetID#getKey(TradingData)}
   */
  @Test
  @DisplayName("Test getKey(TradingData) with 'TradingData'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String KeyByAssetID.getKey(TradingData)"})
  void testGetKeyWithTradingData_thenReturnNull() throws Exception {
    // Arrange
    KeyByAssetID keyByAssetID = new KeyByAssetID();
    PricePoint value = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);

    // Act
    String actualKey = keyByAssetID.getKey(value);

    // Assert
    assertNull(actualKey);
  }
}
