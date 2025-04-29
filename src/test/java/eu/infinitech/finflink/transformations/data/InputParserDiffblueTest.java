package eu.infinitech.finflink.transformations.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.InputStreamType;
import eu.infinitech.finflink.structures.InputStreamType.Type;
import eu.infinitech.finflink.structures.PricePoint;
import eu.infinitech.finflink.structures.TradingData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InputParserDiffblueTest {
  /**
   * Test {@link InputParser#selectMapper(InputStreamType)}.
   * <ul>
   *   <li>When pricePoint {@code ,}.</li>
   *   <li>Then map {@code Date} return {@link PricePoint}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputParser#selectMapper(InputStreamType)}
   */
  @Test
  @DisplayName("Test selectMapper(InputStreamType); when pricePoint ','; then map 'Date' return PricePoint")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InputMapper InputParser.selectMapper(InputStreamType)"})
  void testSelectMapper_whenPricePointComma_thenMapDateReturnPricePoint() throws Exception {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.pricePoint(",");

    // Act
    InputMapper actualSelectMapperResult = InputParser.selectMapper(inputStreamType);
    TradingData actualMapResult = actualSelectMapperResult.map("Date");

    // Assert
    assertTrue(actualMapResult instanceof PricePoint);
    assertTrue(actualSelectMapperResult instanceof ToPricePoint);
    assertEquals(",", inputStreamType.getAsset());
    assertEquals(",", actualMapResult.getAssetSymbol());
    assertEquals(",", ((ToPricePoint) actualSelectMapperResult).assetSymbol);
    assertEquals(0.0d, ((PricePoint) actualMapResult).getClosePrice());
    assertEquals(0.0d, ((PricePoint) actualMapResult).getHighPrice());
    assertEquals(0.0d, ((PricePoint) actualMapResult).getLowPrice());
    assertEquals(0.0d, ((PricePoint) actualMapResult).getOpenPrice());
    assertEquals(0L, ((PricePoint) actualMapResult).getVolume());
    assertEquals(0L, actualMapResult.getUnixDate());
    assertEquals((short) 0, ((PricePoint) actualMapResult).getOpenInt());
    assertEquals(Type.PricePoint, inputStreamType.getType());
    assertTrue(((PricePoint) actualMapResult).isIgnore());
  }

  /**
   * Test {@link InputParser#selectMapper(InputStreamType)}.
   * <ul>
   *   <li>When trade.</li>
   *   <li>Then return {@link ToTrade}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InputParser#selectMapper(InputStreamType)}
   */
  @Test
  @DisplayName("Test selectMapper(InputStreamType); when trade; then return ToTrade")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InputMapper InputParser.selectMapper(InputStreamType)"})
  void testSelectMapper_whenTrade_thenReturnToTrade() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    // Act and Assert
    assertTrue(InputParser.selectMapper(inputStreamType) instanceof ToTrade);
    assertNull(inputStreamType.getAsset());
    assertEquals(Type.Trade, inputStreamType.getType());
  }
}
