package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class InputStreamTypeDiffblueTest {
  /**
   * Method under test: {@link InputStreamType#trade()}
   */
  @Test
  void testTrade() {
    // Arrange and Act
    InputStreamType actualTradeResult = InputStreamType.trade();

    // Assert
    assertNull(actualTradeResult.getAsset());
    assertEquals(InputStreamType.Type.Trade, actualTradeResult.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InputStreamType#InputStreamType(InputStreamType.Type)}
   *   <li>{@link InputStreamType#getAsset()}
   *   <li>{@link InputStreamType#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    InputStreamType actualInputStreamType = new InputStreamType(InputStreamType.Type.Trade);
    String actualAsset = actualInputStreamType.getAsset();

    // Assert
    assertNull(actualAsset);
    assertEquals(InputStreamType.Type.Trade, actualInputStreamType.getType());
  }

  /**
   * Method under test: {@link InputStreamType#pricePoint(String)}
   */
  @Test
  void testPricePoint() {
    // Arrange and Act
    InputStreamType actualPricePointResult = InputStreamType.pricePoint("Asset");

    // Assert
    assertEquals("Asset", actualPricePointResult.getAsset());
    assertEquals(InputStreamType.Type.PricePoint, actualPricePointResult.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InputStreamType#InputStreamType(InputStreamType.Type, String)}
   *   <li>{@link InputStreamType#getAsset()}
   *   <li>{@link InputStreamType#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    InputStreamType actualInputStreamType = new InputStreamType(InputStreamType.Type.Trade, "Asset");
    String actualAsset = actualInputStreamType.getAsset();

    // Assert
    assertEquals("Asset", actualAsset);
    assertEquals(InputStreamType.Type.Trade, actualInputStreamType.getType());
  }
}
