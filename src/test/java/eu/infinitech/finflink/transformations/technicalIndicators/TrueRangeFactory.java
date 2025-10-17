package eu.infinitech.finflink.transformations.technicalIndicators;

import com.diffblue.cover.annotations.InterestingTestFactory;
import eu.infinitech.finflink.structures.Trade;
import java.util.ArrayList;

/**
 * Factory class for creating TrueRange instances for testing purposes.
 */
public class TrueRangeFactory {

  /**
   * Creates a TrueRange instance with a properly initialized trades list.
   * This factory method ensures that the trades field is not null,
   * which is required for the merge method to work correctly.
   *
   * @return a TrueRange instance with an initialized empty trades list
   */
  @InterestingTestFactory
  public static TrueRange createTrueRange() {
    TrueRange trueRange = new TrueRange();
    // Ensure trades list is never null by explicitly setting it to an empty ArrayList
    if (trueRange.getTrades() == null) {
      trueRange.setTrades(new ArrayList<Trade>());
    }
    return trueRange;
  }
}
