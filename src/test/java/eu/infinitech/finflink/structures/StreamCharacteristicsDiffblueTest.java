package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.transformations.technicalIndicators.AccumulationDistributionIndex;
import eu.infinitech.finflink.transformations.technicalIndicators.AverageDirectionalIndex;
import eu.infinitech.finflink.transformations.technicalIndicators.HighPriceDirectionalMomentum;
import eu.infinitech.finflink.transformations.technicalIndicators.TechnicalIndicatorGenerator;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StreamCharacteristicsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StreamCharacteristics.<init>()", "StreamCharacteristics StreamCharacteristics.hasClose()",
      "StreamCharacteristics StreamCharacteristics.hasHigh()", "StreamCharacteristics StreamCharacteristics.hasLow()",
      "StreamCharacteristics StreamCharacteristics.hasOpen()",
      "StreamCharacteristics StreamCharacteristics.hasVolume()"})
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
   * Test {@link StreamCharacteristics#meetsRequirements(IndicatorRequirements)} with {@code indicatorRequirements}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamCharacteristics#meetsRequirements(IndicatorRequirements)}
   */
  @Test
  @DisplayName("Test meetsRequirements(IndicatorRequirements) with 'indicatorRequirements'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StreamCharacteristics.meetsRequirements(IndicatorRequirements)"})
  void testMeetsRequirementsWithIndicatorRequirements_thenReturnTrue() {
    // Arrange
    StreamCharacteristics streamCharacteristics = new StreamCharacteristics();

    // Act and Assert
    assertTrue(streamCharacteristics.meetsRequirements(new IndicatorRequirements()));
  }

  /**
   * Test {@link StreamCharacteristics#meetsRequirements(TechnicalIndicatorGenerator)} with {@code technicalIndicatorGenerator}.
   * <p>
   * Method under test: {@link StreamCharacteristics#meetsRequirements(TechnicalIndicatorGenerator)}
   */
  @Test
  @DisplayName("Test meetsRequirements(TechnicalIndicatorGenerator) with 'technicalIndicatorGenerator'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StreamCharacteristics.meetsRequirements(TechnicalIndicatorGenerator)"})
  void testMeetsRequirementsWithTechnicalIndicatorGenerator() {
    // Arrange
    StreamCharacteristics streamCharacteristics = new StreamCharacteristics();

    // Act and Assert
    assertFalse(streamCharacteristics
        .meetsRequirements(new AccumulationDistributionIndex(Time.of(3L, TimeUnit.NANOSECONDS), 1, 1)));
  }

  /**
   * Test {@link StreamCharacteristics#meetsRequirements(TechnicalIndicatorGenerator)} with {@code technicalIndicatorGenerator}.
   * <p>
   * Method under test: {@link StreamCharacteristics#meetsRequirements(TechnicalIndicatorGenerator)}
   */
  @Test
  @DisplayName("Test meetsRequirements(TechnicalIndicatorGenerator) with 'technicalIndicatorGenerator'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StreamCharacteristics.meetsRequirements(TechnicalIndicatorGenerator)"})
  void testMeetsRequirementsWithTechnicalIndicatorGenerator2() {
    // Arrange
    StreamCharacteristics streamCharacteristics = new StreamCharacteristics();

    // Act and Assert
    assertFalse(
        streamCharacteristics.meetsRequirements(new AverageDirectionalIndex(Time.of(3L, TimeUnit.NANOSECONDS))));
  }

  /**
   * Test {@link StreamCharacteristics#meetsRequirements(TechnicalIndicatorGenerator)} with {@code technicalIndicatorGenerator}.
   * <p>
   * Method under test: {@link StreamCharacteristics#meetsRequirements(TechnicalIndicatorGenerator)}
   */
  @Test
  @DisplayName("Test meetsRequirements(TechnicalIndicatorGenerator) with 'technicalIndicatorGenerator'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StreamCharacteristics.meetsRequirements(TechnicalIndicatorGenerator)"})
  void testMeetsRequirementsWithTechnicalIndicatorGenerator3() {
    // Arrange
    StreamCharacteristics streamCharacteristics = new StreamCharacteristics();

    // Act and Assert
    assertFalse(
        streamCharacteristics.meetsRequirements(new HighPriceDirectionalMomentum(Time.of(3L, TimeUnit.NANOSECONDS))));
  }

  /**
   * Test {@link StreamCharacteristics#meetsRequirements(TechnicalIndicatorGenerator)} with {@code technicalIndicatorGenerator}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamCharacteristics#meetsRequirements(TechnicalIndicatorGenerator)}
   */
  @Test
  @DisplayName("Test meetsRequirements(TechnicalIndicatorGenerator) with 'technicalIndicatorGenerator'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StreamCharacteristics.meetsRequirements(TechnicalIndicatorGenerator)"})
  void testMeetsRequirementsWithTechnicalIndicatorGenerator_thenReturnTrue() {
    // Arrange
    StreamCharacteristics streamCharacteristics = new StreamCharacteristics();

    AverageDirectionalIndex technicalIndicatorGenerator = new AverageDirectionalIndex();
    technicalIndicatorGenerator.setIndicatorRequirements(new IndicatorRequirements());

    // Act and Assert
    assertTrue(streamCharacteristics.meetsRequirements(technicalIndicatorGenerator));
  }
}
