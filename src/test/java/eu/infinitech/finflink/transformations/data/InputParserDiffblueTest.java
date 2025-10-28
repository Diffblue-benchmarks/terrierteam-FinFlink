package eu.infinitech.finflink.transformations.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.InputStreamType;
import eu.infinitech.finflink.structures.InputStreamType.Type;
import eu.infinitech.finflink.structures.Trade;
import eu.infinitech.finflink.structures.TradingData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InputParserDiffblueTest {
  /**
   * Test {@link InputParser#selectMapper(InputStreamType)}.
   *
   * <ul>
   *   <li>When {@link InputStreamType#InputStreamType(Type)} with type is {@code PricePoint}.
   *   <li>Then return {@link ToPricePoint}.
   * </ul>
   *
   * <p>Method under test: {@link InputParser#selectMapper(InputStreamType)}
   */
  @Test
  @DisplayName(
      "Test selectMapper(InputStreamType); when InputStreamType(Type) with type is 'PricePoint'; then return ToPricePoint")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputMapper InputParser.selectMapper(InputStreamType)"})
  void testSelectMapper_whenInputStreamTypeWithTypeIsPricePoint_thenReturnToPricePoint() {
    // Arrange
    InputStreamType inputStreamType = new InputStreamType(Type.PricePoint);

    // Act
    InputMapper actualSelectMapperResult = InputParser.selectMapper(inputStreamType);

    // Assert
    assertTrue(actualSelectMapperResult instanceof ToPricePoint);
    assertNull(inputStreamType.getAsset());
    assertNull(((ToPricePoint) actualSelectMapperResult).assetSymbol);
    assertEquals(Type.PricePoint, inputStreamType.getType());
  }

  /**
   * Test {@link InputParser#selectMapper(InputStreamType)}.
   *
   * <ul>
   *   <li>When trade.
   *   <li>Then map createTradeDataString return {@link Trade}.
   * </ul>
   *
   * <p>Method under test: {@link InputParser#selectMapper(InputStreamType)}
   */
  @Test
  @DisplayName(
      "Test selectMapper(InputStreamType); when trade; then map createTradeDataString return Trade")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputMapper InputParser.selectMapper(InputStreamType)"})
  void testSelectMapper_whenTrade_thenMapCreateTradeDataStringReturnTrade() throws Exception {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    // Act
    InputMapper actualSelectMapperResult = InputParser.selectMapper(inputStreamType);
    TradingData actualMapResult =
        actualSelectMapperResult.map(ToTradeFactory.createTradeDataString());

    // Assert
    assertTrue(actualMapResult instanceof Trade);
    assertTrue(actualSelectMapperResult instanceof ToTrade);
    assertEquals("AAPL", actualMapResult.getAssetSymbol());
    assertNull(inputStreamType.getAsset());
    assertEquals(1000000000L, actualMapResult.getUnixDate());
    assertEquals(1000L, ((Trade) actualMapResult).getVolume());
    assertEquals(150.5d, ((Trade) actualMapResult).getPrice());
    assertEquals(Type.Trade, inputStreamType.getType());
  }
}
