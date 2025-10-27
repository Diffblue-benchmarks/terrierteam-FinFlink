package eu.infinitech.finflink.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import eu.infinitech.finflink.structures.PricePoint;
import eu.infinitech.finflink.structures.TradingData;
import org.apache.flink.api.common.eventtime.TimestampAssigner;
import org.apache.flink.api.common.eventtime.TimestampAssignerSupplier;
import org.junit.jupiter.api.Test;

class TradingDataTimeAssignerDiffblueTest {
  /**
   * Method under test:
   * {@link TradingDataTimeAssigner#extractTimestamp(TradingData, long)}
   */
  @Test
  void testExtractTimestamp() {
    // Arrange
    TradingDataTimeAssigner tradingDataTimeAssigner = new TradingDataTimeAssigner();

    // Act and Assert
    assertEquals(1L,
        tradingDataTimeAssigner.extractTimestamp(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1), 1L));
  }

  /**
   * Method under test:
   * {@link TradingDataTimeAssigner#createTimestampAssigner(TimestampAssignerSupplier.Context)}
   */
  @Test
  void testCreateTimestampAssigner() {
    // Arrange and Act
    TimestampAssigner<TradingData> actualCreateTimestampAssignerResult = (new TradingDataTimeAssigner())
        .createTimestampAssigner(mock(TimestampAssignerSupplier.Context.class));

    // Assert
    assertTrue(actualCreateTimestampAssignerResult instanceof TradingDataTimeAssigner);
    assertEquals(1L, actualCreateTimestampAssignerResult
        .extractTimestamp(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1), 1L));
  }
}
