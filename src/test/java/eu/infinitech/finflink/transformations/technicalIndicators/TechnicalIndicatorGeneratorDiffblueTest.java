package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.IndicatorRequirements;
import org.junit.jupiter.api.Test;

class TechnicalIndicatorGeneratorDiffblueTest {
  /**
   * Method under test: {@link TechnicalIndicatorGenerator#getTimePeriod()}
   */
  @Test
  void testGetTimePeriod() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AverageDirectionalIndex()).getTimePeriod());
  }

  /**
   * Method under test: {@link TechnicalIndicatorGenerator#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("AverageDirectionalIndex", (new AverageDirectionalIndex()).getName());
  }

  /**
   * Method under test: {@link TechnicalIndicatorGenerator#getProperties()}
   */
  @Test
  void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue((new AverageDirectionalIndex()).getProperties().isEmpty());
  }

  /**
   * Method under test: {@link TechnicalIndicatorGenerator#setTimePeriod(long)}
   */
  @Test
  void testSetTimePeriod() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();

    // Act
    averageDirectionalIndex.setTimePeriod(10L);

    // Assert
    assertEquals(10L, averageDirectionalIndex.getTimePeriod());
  }

  /**
   * Method under test:
   * {@link TechnicalIndicatorGenerator#getIndicatorRequirements()}
   */
  @Test
  void testGetIndicatorRequirements() {
    // Arrange, Act and Assert
    assertNull((new AverageDirectionalIndex()).getIndicatorRequirements());
  }

  /**
   * Method under test:
   * {@link TechnicalIndicatorGenerator#setIndicatorRequirements(IndicatorRequirements)}
   */
  @Test
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
