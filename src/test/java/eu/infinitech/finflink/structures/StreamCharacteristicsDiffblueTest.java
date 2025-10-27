package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.transformations.technicalIndicators.AccumulationDistributionIndex;
import eu.infinitech.finflink.transformations.technicalIndicators.AverageDirectionalIndex;
import eu.infinitech.finflink.transformations.technicalIndicators.HighPriceDirectionalMomentum;
import eu.infinitech.finflink.transformations.technicalIndicators.TechnicalIndicatorGenerator;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class StreamCharacteristicsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StreamCharacteristics}
   *   <li>{@link StreamCharacteristics#hasClose()}
   *   <li>{@link StreamCharacteristics#hasHigh()}
   *   <li>{@link StreamCharacteristics#hasLow()}
   *   <li>{@link StreamCharacteristics#hasOpen()}
   *   <li>{@link StreamCharacteristics#hasVolume()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    StreamCharacteristics actualStreamCharacteristics = new StreamCharacteristics();
    StreamCharacteristics actualHasCloseResult = actualStreamCharacteristics.hasClose();
    StreamCharacteristics actualHasHighResult = actualStreamCharacteristics.hasHigh();
    StreamCharacteristics actualHasLowResult = actualStreamCharacteristics.hasLow();
    StreamCharacteristics actualHasOpenResult = actualStreamCharacteristics.hasOpen();

    // Assert
    assertSame(actualStreamCharacteristics, actualHasCloseResult);
    assertSame(actualStreamCharacteristics, actualHasHighResult);
    assertSame(actualStreamCharacteristics, actualHasLowResult);
    assertSame(actualStreamCharacteristics, actualHasOpenResult);
    assertSame(actualStreamCharacteristics, actualStreamCharacteristics.hasVolume());
  }

  /**
   * Method under test:
   * {@link StreamCharacteristics#meetsRequirements(IndicatorRequirements)}
   */
  @Test
  void testMeetsRequirements() {
    // Arrange
    StreamCharacteristics streamCharacteristics = new StreamCharacteristics();

    // Act and Assert
    assertTrue(streamCharacteristics.meetsRequirements(new IndicatorRequirements()));
  }

  /**
   * Method under test:
   * {@link StreamCharacteristics#meetsRequirements(TechnicalIndicatorGenerator)}
   */
  @Test
  void testMeetsRequirements2() {
    // Arrange
    StreamCharacteristics streamCharacteristics = new StreamCharacteristics();

    // Act and Assert
    assertFalse(streamCharacteristics
        .meetsRequirements(new AccumulationDistributionIndex(Time.of(3L, TimeUnit.NANOSECONDS), 1, 1)));
  }

  /**
   * Method under test:
   * {@link StreamCharacteristics#meetsRequirements(TechnicalIndicatorGenerator)}
   */
  @Test
  void testMeetsRequirements3() {
    // Arrange
    StreamCharacteristics streamCharacteristics = new StreamCharacteristics();

    // Act and Assert
    assertFalse(
        streamCharacteristics.meetsRequirements(new AverageDirectionalIndex(Time.of(3L, TimeUnit.NANOSECONDS))));
  }

  /**
   * Method under test:
   * {@link StreamCharacteristics#meetsRequirements(TechnicalIndicatorGenerator)}
   */
  @Test
  void testMeetsRequirements4() {
    // Arrange
    StreamCharacteristics streamCharacteristics = new StreamCharacteristics();

    AverageDirectionalIndex technicalIndicatorGenerator = new AverageDirectionalIndex();
    technicalIndicatorGenerator.setIndicatorRequirements(new IndicatorRequirements());

    // Act and Assert
    assertTrue(streamCharacteristics.meetsRequirements(technicalIndicatorGenerator));
  }

  /**
   * Method under test:
   * {@link StreamCharacteristics#meetsRequirements(TechnicalIndicatorGenerator)}
   */
  @Test
  void testMeetsRequirements5() {
    // Arrange
    StreamCharacteristics streamCharacteristics = new StreamCharacteristics();

    // Act and Assert
    assertFalse(
        streamCharacteristics.meetsRequirements(new HighPriceDirectionalMomentum(Time.of(3L, TimeUnit.NANOSECONDS))));
  }
}
