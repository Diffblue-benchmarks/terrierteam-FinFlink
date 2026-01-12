package eu.infinitech.finflink.structures;

import com.diffblue.cover.annotations.InterestingTestFactory;
import java.util.ArrayList;
import java.util.List;

public class TradePeriodFactory {

    @InterestingTestFactory
    public static TradePeriod createTradePeriod() {
        TradePeriod tradePeriod = new TradePeriod();

        // Initialize with a valid InputStreamType to avoid NullPointerException at line 89
        tradePeriod.inputStreamType = InputStreamType.trade();

        // Create a sample trade list with at least one trade
        List<TradingData> tradingData = new ArrayList<>();
        Trade trade = new Trade("BTC", 1640000000000L, 50000.0, 100L);
        tradingData.add(trade);

        tradePeriod.tradingData = tradingData;

        return tradePeriod;
    }
}
