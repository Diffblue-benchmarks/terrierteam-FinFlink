package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.IndicatorRequirements;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TechnicalIndicatorGeneratorDiffblueTest {
  /**
   * Test {@link TechnicalIndicatorGenerator#getTimePeriod()}.
   * <p>
   * Method under test: {@link TechnicalIndicatorGenerator#getTimePeriod()}
   */
  @Test
  @DisplayName("Test getTimePeriod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TechnicalIndicatorGenerator.getTimePeriod()"})
  void testGetTimePeriod() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AverageDirectionalIndex()).getTimePeriod());
  }

  /**
   * Test {@link TechnicalIndicatorGenerator#getName()}.
   * <p>
   * Method under test: {@link TechnicalIndicatorGenerator#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String TechnicalIndicatorGenerator.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("AverageDirectionalIndex", (new AverageDirectionalIndex()).getName());
  }

  /**
   * Test {@link TechnicalIndicatorGenerator#getProperties()}.
   * <p>
   * Method under test: {@link TechnicalIndicatorGenerator#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map TechnicalIndicatorGenerator.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue((new AverageDirectionalIndex()).getProperties().isEmpty());
  }

  /**
   * Test {@link TechnicalIndicatorGenerator#setTimePeriod(long)} with {@code long}.
   * <p>
   * Method under test: {@link TechnicalIndicatorGenerator#setTimePeriod(long)}
   */
  @Test
  @DisplayName("Test setTimePeriod(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TechnicalIndicatorGenerator.setTimePeriod(long)"})
  void testSetTimePeriodWithLong() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();

    // Act
    averageDirectionalIndex.setTimePeriod(10L);

    // Assert
    assertEquals(10L, averageDirectionalIndex.getTimePeriod());
  }

  /**
   * Test {@link TechnicalIndicatorGenerator#getIndicatorRequirements()}.
   * <p>
   * Method under test: {@link TechnicalIndicatorGenerator#getIndicatorRequirements()}
   */
  @Test
  @DisplayName("Test getIndicatorRequirements()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IndicatorRequirements TechnicalIndicatorGenerator.getIndicatorRequirements()"})
  void testGetIndicatorRequirements() {
    // Arrange, Act and Assert
    assertNull((new AverageDirectionalIndex()).getIndicatorRequirements());
  }

  /**
   * Test {@link TechnicalIndicatorGenerator#setIndicatorRequirements(IndicatorRequirements)}.
   * <p>
   * Method under test: {@link TechnicalIndicatorGenerator#setIndicatorRequirements(IndicatorRequirements)}
   */
  @Test
  @DisplayName("Test setIndicatorRequirements(IndicatorRequirements)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TechnicalIndicatorGenerator.setIndicatorRequirements(IndicatorRequirements)"})
  void testSetIndicatorRequirements() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();
    IndicatorRequirements indicatorRequirements = new IndicatorRequirements();

    // Act
    averageDirectionalIndex.setIndicatorRequirements(indicatorRequirements);

    // Assert
    assertSame(indicatorRequirements, averageDirectionalIndex.getIndicatorRequirements());
  }
}
