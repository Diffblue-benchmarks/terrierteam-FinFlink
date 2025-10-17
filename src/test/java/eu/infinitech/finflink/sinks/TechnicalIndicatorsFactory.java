package eu.infinitech.finflink.sinks;

import com.diffblue.cover.annotations.InterestingTestFactory;
import eu.infinitech.finflink.structures.TechnicalIndicator;
import eu.infinitech.finflink.structures.TechnicalIndicators;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Factory class for creating TechnicalIndicators instances for testing purposes.
 */
public class TechnicalIndicatorsFactory {

  /**
   * Creates a TechnicalIndicators instance with a properly initialized indicators list.
   * This factory method ensures that the indicators field is not null,
   * which is required for the toString method to work correctly without throwing
   * NullPointerException.
   *
   * @return a TechnicalIndicators instance with an initialized indicators list
   */
  @InterestingTestFactory
  public static TechnicalIndicators createTechnicalIndicators() {
    TechnicalIndicators technicalIndicators = new TechnicalIndicators();
    // Ensure indicators list is initialized (constructor already does this, but being explicit)
    if (technicalIndicators.getIndicators() == null) {
      technicalIndicators.setIndicators(new ArrayList<TechnicalIndicator>());
    }
    return technicalIndicators;
  }
}
