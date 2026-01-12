package eu.infinitech.finflink.transformations.data;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.InputStreamType;
import eu.infinitech.finflink.structures.InputStreamType.Type;
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
    // Arrange and Act
    InputMapper actualSelectMapperResult =
        InputParser.selectMapper(new InputStreamType(Type.PricePoint));

    // Assert
    assertTrue(actualSelectMapperResult instanceof ToPricePoint);
    assertNull(((ToPricePoint) actualSelectMapperResult).assetSymbol);
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
    // Arrange and Act
    InputMapper actualSelectMapperResult = InputParser.selectMapper(InputStreamType.trade());

    // Assert
    assertTrue(actualSelectMapperResult instanceof ToTrade);
    assertTrue(((ToTrade) actualSelectMapperResult).isInitialized());
  }
}
