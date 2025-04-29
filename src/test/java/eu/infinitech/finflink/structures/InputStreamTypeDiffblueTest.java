package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.InputStreamType.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InputStreamTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Asset}.</li>
   *   <li>Then return {@code Asset}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InputStreamType#InputStreamType(Type, String)}
   *   <li>{@link InputStreamType#getAsset()}
   *   <li>{@link InputStreamType#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Asset'; then return 'Asset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputStreamType.<init>(Type)", "void InputStreamType.<init>(Type, String)",
      "String InputStreamType.getAsset()", "Type InputStreamType.getType()"})
  void testGettersAndSetters_whenAsset_thenReturnAsset() {
    // Arrange and Act
    InputStreamType actualInputStreamType = new InputStreamType(Type.Trade, "Asset");
    String actualAsset = actualInputStreamType.getAsset();

    // Assert
    assertEquals("Asset", actualAsset);
    assertEquals(Type.Trade, actualInputStreamType.getType());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Trade}.</li>
   *   <li>Then return Asset is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InputStreamType#InputStreamType(Type)}
   *   <li>{@link InputStreamType#getAsset()}
   *   <li>{@link InputStreamType#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Trade'; then return Asset is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InputStreamType.<init>(Type)", "void InputStreamType.<init>(Type, String)",
      "String InputStreamType.getAsset()", "Type InputStreamType.getType()"})
  void testGettersAndSetters_whenTrade_thenReturnAssetIsNull() {
    // Arrange and Act
    InputStreamType actualInputStreamType = new InputStreamType(Type.Trade);
    String actualAsset = actualInputStreamType.getAsset();

    // Assert
    assertNull(actualAsset);
    assertEquals(Type.Trade, actualInputStreamType.getType());
  }

  /**
   * Test {@link InputStreamType#trade()}.
   * <p>
   * Method under test: {@link InputStreamType#trade()}
   */
  @Test
  @DisplayName("Test trade()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InputStreamType InputStreamType.trade()"})
  void testTrade() {
    // Arrange and Act
    InputStreamType actualTradeResult = InputStreamType.trade();

    // Assert
    assertNull(actualTradeResult.getAsset());
    assertEquals(Type.Trade, actualTradeResult.getType());
  }

  /**
   * Test {@link InputStreamType#pricePoint(String)}.
   * <p>
   * Method under test: {@link InputStreamType#pricePoint(String)}
   */
  @Test
  @DisplayName("Test pricePoint(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InputStreamType InputStreamType.pricePoint(String)"})
  void testPricePoint() {
    // Arrange and Act
    InputStreamType actualPricePointResult = InputStreamType.pricePoint("Asset");

    // Assert
    assertEquals("Asset", actualPricePointResult.getAsset());
    assertEquals(Type.PricePoint, actualPricePointResult.getType());
  }
}
