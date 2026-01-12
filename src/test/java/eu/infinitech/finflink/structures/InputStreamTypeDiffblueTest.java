package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.InputStreamType.Type;
import eu.infinitech.finflink.transformations.data.ToTradeFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InputStreamTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Asset is {@code BTC,1640000000,50000.0,100}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InputStreamType#InputStreamType(Type, String)}
   *   <li>{@link InputStreamType#getAsset()}
   *   <li>{@link InputStreamType#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Asset is 'BTC,1640000000,50000.0,100'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InputStreamType.<init>(Type)",
    "void InputStreamType.<init>(Type, String)",
    "String InputStreamType.getAsset()",
    "Type InputStreamType.getType()"
  })
  void testGettersAndSetters_thenReturnAssetIsBtc1640000000500000100() {
    // Arrange and Act
    InputStreamType actualInputStreamType =
        new InputStreamType(Type.Trade, ToTradeFactory.createValidTradeDataString());
    String actualAsset = actualInputStreamType.getAsset();

    // Assert
    assertEquals("BTC,1640000000,50000.0,100", actualAsset);
    assertEquals(Type.Trade, actualInputStreamType.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Trade}.
   *   <li>Then return Asset is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InputStreamType#InputStreamType(Type)}
   *   <li>{@link InputStreamType#getAsset()}
   *   <li>{@link InputStreamType#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Trade'; then return Asset is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InputStreamType.<init>(Type)",
    "void InputStreamType.<init>(Type, String)",
    "String InputStreamType.getAsset()",
    "Type InputStreamType.getType()"
  })
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
   *
   * <p>Method under test: {@link InputStreamType#trade()}
   */
  @Test
  @DisplayName("Test trade()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link InputStreamType#pricePoint(String)}
   */
  @Test
  @DisplayName("Test pricePoint(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStreamType InputStreamType.pricePoint(String)"})
  void testPricePoint() {
    // Arrange and Act
    InputStreamType actualPricePointResult =
        InputStreamType.pricePoint(ToTradeFactory.createValidTradeDataString());

    // Assert
    assertEquals("BTC,1640000000,50000.0,100", actualPricePointResult.getAsset());
    assertEquals(Type.PricePoint, actualPricePointResult.getType());
  }
}
