package eu.infinitech.finflink.transformations.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.PricePoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ToPricePointDiffblueTest {
  /**
   * Test {@link ToPricePoint#ToPricePoint()}.
   * <ul>
   *   <li>Then return {@link ToPricePoint#assetSymbol} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToPricePoint#ToPricePoint()}
   */
  @Test
  @DisplayName("Test new ToPricePoint(); then return assetSymbol is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToPricePoint.<init>()", "void ToPricePoint.<init>(String)"})
  void testNewToPricePoint_thenReturnAssetSymbolIsNull() {
    // Arrange, Act and Assert
    assertNull((new ToPricePoint()).assetSymbol);
  }

  /**
   * Test {@link ToPricePoint#ToPricePoint(String)}.
   * <ul>
   *   <li>When {@code Asset Symbol}.</li>
   *   <li>Then return {@code Asset Symbol}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToPricePoint#ToPricePoint(String)}
   */
  @Test
  @DisplayName("Test new ToPricePoint(String); when 'Asset Symbol'; then return 'Asset Symbol'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToPricePoint.<init>()", "void ToPricePoint.<init>(String)"})
  void testNewToPricePoint_whenAssetSymbol_thenReturnAssetSymbol() {
    // Arrange, Act and Assert
    assertEquals("Asset Symbol", (new ToPricePoint("Asset Symbol")).assetSymbol);
  }

  /**
   * Test {@link ToPricePoint#map(String)} with {@code String}.
   * <ul>
   *   <li>Then return AssetSymbol is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToPricePoint#map(String)}
   */
  @Test
  @DisplayName("Test map(String) with 'String'; then return AssetSymbol is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PricePoint ToPricePoint.map(String)"})
  void testMapWithString_thenReturnAssetSymbolIsNull() throws Exception {
    // Arrange and Act
    PricePoint actualMapResult = (new ToPricePoint(null)).map("Date");

    // Assert
    assertNull(actualMapResult.getAssetSymbol());
    assertEquals(0.0d, actualMapResult.getClosePrice());
    assertEquals(0.0d, actualMapResult.getHighPrice());
    assertEquals(0.0d, actualMapResult.getLowPrice());
    assertEquals(0.0d, actualMapResult.getOpenPrice());
    assertEquals(0L, actualMapResult.getUnixDate());
    assertEquals(0L, actualMapResult.getVolume());
    assertEquals((short) 0, actualMapResult.getOpenInt());
    assertTrue(actualMapResult.isIgnore());
  }

  /**
   * Test {@link ToPricePoint#map(String)} with {@code String}.
   * <ul>
   *   <li>When {@code Date}.</li>
   *   <li>Then return {@code Asset Symbol}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToPricePoint#map(String)}
   */
  @Test
  @DisplayName("Test map(String) with 'String'; when 'Date'; then return 'Asset Symbol'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PricePoint ToPricePoint.map(String)"})
  void testMapWithString_whenDate_thenReturnAssetSymbol() throws Exception {
    // Arrange and Act
    PricePoint actualMapResult = (new ToPricePoint("Asset Symbol")).map("Date");

    // Assert
    assertEquals("Asset Symbol", actualMapResult.getAssetSymbol());
    assertEquals(0.0d, actualMapResult.getClosePrice());
    assertEquals(0.0d, actualMapResult.getHighPrice());
    assertEquals(0.0d, actualMapResult.getLowPrice());
    assertEquals(0.0d, actualMapResult.getOpenPrice());
    assertEquals(0L, actualMapResult.getUnixDate());
    assertEquals(0L, actualMapResult.getVolume());
    assertEquals((short) 0, actualMapResult.getOpenInt());
    assertTrue(actualMapResult.isIgnore());
  }
}
