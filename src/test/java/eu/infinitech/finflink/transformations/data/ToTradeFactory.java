package eu.infinitech.finflink.transformations.data;

import com.diffblue.cover.annotations.InterestingTestFactory;

public class ToTradeFactory {

    @InterestingTestFactory
    public static ToTrade createToTrade() {
        // ToTrade constructor doesn't require any parameters and is self-contained
        // The factory simply returns a properly initialized instance
        return new ToTrade();
    }

    @InterestingTestFactory
    public static String createValidTradeDataString() {
        // Create a valid trade data string with all 4 required parts
        // Format: assetSymbol,unixDate,price,volume
        // This avoids the ArrayIndexOutOfBoundsException at ToTrade.java:30
        return "BTC,1640000000,50000.0,100";
    }
}
