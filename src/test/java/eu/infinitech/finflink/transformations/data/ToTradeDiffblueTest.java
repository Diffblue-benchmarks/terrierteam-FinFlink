package eu.infinitech.finflink.transformations.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.Trade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ToTradeDiffblueTest {
  /**
   * Test {@link ToTrade#map(String)} with {@code String}.
   *
   * <ul>
   *   <li>When createTradeDataString.
   *   <li>Then return AssetSymbol is {@code AAPL}.
   * </ul>
   *
   * <p>Method under test: {@link ToTrade#map(String)}
   */
  @Test
  @DisplayName(
      "Test map(String) with 'String'; when createTradeDataString; then return AssetSymbol is 'AAPL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Trade ToTrade.map(String)"})
  void testMapWithString_whenCreateTradeDataString_thenReturnAssetSymbolIsAapl() throws Exception {
    // Arrange
    ToTrade toTrade = new ToTrade();

    // Act
    Trade actualMapResult = toTrade.map(ToTradeFactory.createTradeDataString());

    // Assert
    assertEquals("AAPL", actualMapResult.getAssetSymbol());
    assertEquals(1000000000L, actualMapResult.getUnixDate());
    assertEquals(1000L, actualMapResult.getVolume());
    assertEquals(150.5d, actualMapResult.getPrice());
  }
}
