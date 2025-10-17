package eu.infinitech.finflink.transformations.data;

import com.diffblue.cover.annotations.InterestingTestFactory;

/**
 * Factory class for creating String parameters for ToTrade.map testing.
 */
public class ToTradeFactory {

  /**
   * Creates a properly formatted String parameter for the ToTrade.map method.
   * The string contains comma-separated values in the format:
   * assetSymbol,unixDate,price,volume
   *
   * This ensures that the map method has enough parts to avoid
   * ArrayIndexOutOfBoundsException when splitting and accessing array indices.
   *
   * @return a properly formatted trade data string
   */
  @InterestingTestFactory
  public static String createTradeDataString() {
    return "AAPL,1000000,150.5,1000";
  }
}
