package eu.infinitech.finflink.structures;

import com.diffblue.cover.annotations.InterestingTestFactory;

/**
 * Factory class for creating TradePeriod instances for testing purposes.
 */
public class TradePeriodFactory {

  /**
   * Creates a TradePeriod instance with a properly initialized inputStreamType field.
   * This factory method ensures that the inputStreamType field is not null,
   * which is required for the initializeTradePeriod method to work correctly.
   *
   * @return a TradePeriod instance with inputStreamType set to trade type
   */
  @InterestingTestFactory
  public static TradePeriod createTradePeriod() {
    TradePeriod tradePeriod = new TradePeriod();
    tradePeriod.inputStreamType = InputStreamType.trade();
    return tradePeriod;
  }
}
