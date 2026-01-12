package eu.infinitech.finflink.transformations.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.Trade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ToTradeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ToTrade}
   *   <li>{@link ToTrade#isInitialized()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToTrade.<init>()", "boolean ToTrade.isInitialized()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new ToTrade().isInitialized());
  }

  /**
   * Test {@link ToTrade#map(String)} with {@code String}.
   *
   * <ul>
   *   <li>When createValidTradeDataString.
   *   <li>Then return AssetSymbol is {@code BTC}.
   * </ul>
   *
   * <p>Method under test: {@link ToTrade#map(String)}
   */
  @Test
  @DisplayName(
      "Test map(String) with 'String'; when createValidTradeDataString; then return AssetSymbol is 'BTC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Trade ToTrade.map(String)"})
  void testMapWithString_whenCreateValidTradeDataString_thenReturnAssetSymbolIsBtc()
      throws Exception {
    // Arrange
    ToTrade createToTradeResult = ToTradeFactory.createToTrade();

    // Act
    Trade actualMapResult = createToTradeResult.map(ToTradeFactory.createValidTradeDataString());

    // Assert
    assertEquals("BTC", actualMapResult.getAssetSymbol());
    assertEquals(100L, actualMapResult.getVolume());
    assertEquals(1640000000000L, actualMapResult.getUnixDate());
    assertEquals(50000.0d, actualMapResult.getPrice());
  }
}
