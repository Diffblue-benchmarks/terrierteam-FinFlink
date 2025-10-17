package eu.infinitech.finflink.transformations.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.InputStreamType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InputParserDiffblueTest {
  /**
   * Test {@link InputParser#selectMapper(InputStreamType)}.
   *
   * <ul>
   *   <li>When pricePoint createTradeDataString.
   *   <li>Then return {@link ToPricePoint}.
   * </ul>
   *
   * <p>Method under test: {@link InputParser#selectMapper(InputStreamType)}
   */
  @Test
  @DisplayName(
      "Test selectMapper(InputStreamType); when pricePoint createTradeDataString; then return ToPricePoint")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputMapper InputParser.selectMapper(InputStreamType)"})
  void testSelectMapper_whenPricePointCreateTradeDataString_thenReturnToPricePoint() {
    // Arrange and Act
    InputMapper actualSelectMapperResult =
        InputParser.selectMapper(
            InputStreamType.pricePoint(ToTradeFactory.createTradeDataString()));

    // Assert
    assertTrue(actualSelectMapperResult instanceof ToPricePoint);
    assertEquals("AAPL,1000000,150.5,1000", ((ToPricePoint) actualSelectMapperResult).assetSymbol);
  }

  /**
   * Test {@link InputParser#selectMapper(InputStreamType)}.
   *
   * <ul>
   *   <li>When trade.
   *   <li>Then return {@link ToTrade}.
   * </ul>
   *
   * <p>Method under test: {@link InputParser#selectMapper(InputStreamType)}
   */
  @Test
  @DisplayName("Test selectMapper(InputStreamType); when trade; then return ToTrade")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputMapper InputParser.selectMapper(InputStreamType)"})
  void testSelectMapper_whenTrade_thenReturnToTrade() {
    // Arrange, Act and Assert
    assertTrue(InputParser.selectMapper(InputStreamType.trade()) instanceof ToTrade);
  }
}
