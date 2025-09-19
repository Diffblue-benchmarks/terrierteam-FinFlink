package eu.infinitech.finflink.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.PricePoint;
import eu.infinitech.finflink.structures.TradingData;
import org.apache.flink.api.common.eventtime.TimestampAssigner;
import org.apache.flink.api.common.eventtime.TimestampAssignerSupplier;
import org.apache.flink.api.common.eventtime.TimestampAssignerSupplier.Context;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TradingDataTimeAssignerDiffblueTest {
  /**
   * Test {@link TradingDataTimeAssigner#extractTimestamp(TradingData, long)} with {@code
   * TradingData}, {@code long}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TradingDataTimeAssigner#extractTimestamp(TradingData, long)}
   */
  @Test
  @DisplayName(
      "Test extractTimestamp(TradingData, long) with 'TradingData', 'long'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TradingDataTimeAssigner.extractTimestamp(TradingData, long)"})
  void testExtractTimestampWithTradingDataLong_thenReturnOne() {
    // Arrange
    TradingDataTimeAssigner tradingDataTimeAssigner = new TradingDataTimeAssigner();
    PricePoint tradingData = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);

    // Act and Assert
    assertEquals(1L, tradingDataTimeAssigner.extractTimestamp(tradingData, 1L));
  }

  /**
   * Test {@link TradingDataTimeAssigner#createTimestampAssigner(Context)}.
   *
   * <ul>
   *   <li>Then return {@link TradingDataTimeAssigner}.
   * </ul>
   *
   * <p>Method under test: {@link TradingDataTimeAssigner#createTimestampAssigner(Context)}
   */
  @Test
  @DisplayName("Test createTimestampAssigner(Context); then return TradingDataTimeAssigner")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimestampAssigner TradingDataTimeAssigner.createTimestampAssigner(Context)"})
  void testCreateTimestampAssigner_thenReturnTradingDataTimeAssigner() {
    // Arrange and Act
    TimestampAssigner<TradingData> actualCreateTimestampAssignerResult =
        new TradingDataTimeAssigner().createTimestampAssigner(mock(Context.class));
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    long actualExtractTimestampResult =
        actualCreateTimestampAssignerResult.extractTimestamp(pricePoint, 1L);

    // Assert
    assertTrue(actualCreateTimestampAssignerResult instanceof TradingDataTimeAssigner);
    assertEquals(1L, actualExtractTimestampResult);
  }
}
