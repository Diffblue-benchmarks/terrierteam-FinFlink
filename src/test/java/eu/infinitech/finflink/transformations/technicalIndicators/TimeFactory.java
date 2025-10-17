package eu.infinitech.finflink.transformations.technicalIndicators;

import com.diffblue.cover.annotations.InterestingTestFactory;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * Factory class for creating Time instances for testing purposes.
 */
public class TimeFactory {

  /**
   * Creates a valid Time instance for use with TechnicalIndicatorGenerator methods.
   * This factory method ensures that the Time parameter is not null,
   * which is required for the setTimePeriodLength method to work correctly
   * without throwing NullPointerException.
   *
   * @return a Time instance representing 1 second
   */
  @InterestingTestFactory
  public static Time createTime() {
    return Time.seconds(1);
  }
}
