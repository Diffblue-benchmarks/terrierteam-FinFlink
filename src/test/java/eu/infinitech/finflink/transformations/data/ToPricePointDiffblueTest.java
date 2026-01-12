package eu.infinitech.finflink.transformations.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.PricePoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ToPricePointDiffblueTest {
  /**
   * Test {@link ToPricePoint#ToPricePoint(String)}.
   *
   * <ul>
   *   <li>Then return {@link ToPricePoint#assetSymbol} is {@code BTC,1640000000,50000.0,100}.
   * </ul>
   *
   * <p>Method under test: {@link ToPricePoint#ToPricePoint(String)}
   */
  @Test
  @DisplayName(
      "Test new ToPricePoint(String); then return assetSymbol is 'BTC,1640000000,50000.0,100'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToPricePoint.<init>()", "void ToPricePoint.<init>(String)"})
  void testNewToPricePoint_thenReturnAssetSymbolIsBtc1640000000500000100() {
    // Arrange, Act and Assert
    assertEquals(
        "BTC,1640000000,50000.0,100",
        new ToPricePoint(ToTradeFactory.createValidTradeDataString()).assetSymbol);
  }

  /**
   * Test {@link ToPricePoint#ToPricePoint()}.
   *
   * <ul>
   *   <li>Then return {@link ToPricePoint#assetSymbol} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToPricePoint#ToPricePoint()}
   */
  @Test
  @DisplayName("Test new ToPricePoint(); then return assetSymbol is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ToPricePoint.<init>()", "void ToPricePoint.<init>(String)"})
  void testNewToPricePoint_thenReturnAssetSymbolIsNull() {
    // Arrange, Act and Assert
    assertNull(new ToPricePoint().assetSymbol);
  }

  /**
   * Test {@link ToPricePoint#map(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return AssetSymbol is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ToPricePoint#map(String)}
   */
  @Test
  @DisplayName("Test map(String) with 'String'; then return AssetSymbol is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PricePoint ToPricePoint.map(String)"})
  void testMapWithString_thenReturnAssetSymbolIsNull() throws Exception {
    // Arrange and Act
    PricePoint actualMapResult = new ToPricePoint(null).map("Date");

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
   *
   * <ul>
   *   <li>When {@code Date}.
   *   <li>Then return AssetSymbol is {@code BTC,1640000000,50000.0,100}.
   * </ul>
   *
   * <p>Method under test: {@link ToPricePoint#map(String)}
   */
  @Test
  @DisplayName(
      "Test map(String) with 'String'; when 'Date'; then return AssetSymbol is 'BTC,1640000000,50000.0,100'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PricePoint ToPricePoint.map(String)"})
  void testMapWithString_whenDate_thenReturnAssetSymbolIsBtc1640000000500000100() throws Exception {
    // Arrange and Act
    PricePoint actualMapResult =
        new ToPricePoint(ToTradeFactory.createValidTradeDataString()).map("Date");

    // Assert
    assertEquals("BTC,1640000000,50000.0,100", actualMapResult.getAssetSymbol());
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
