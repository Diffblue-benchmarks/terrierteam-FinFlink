package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.IndicatorRequirements;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TechnicalIndicatorGeneratorDiffblueTest {
  /**
   * Test {@link TechnicalIndicatorGenerator#setTimePeriodLength(Time)}.
   *
   * <ul>
   *   <li>Then {@link AverageDirectionalIndex#AverageDirectionalIndex()} TimePeriod is one
   *       thousand.
   * </ul>
   *
   * <p>Method under test: {@link TechnicalIndicatorGenerator#setTimePeriodLength(Time)}
   */
  @Test
  @DisplayName(
      "Test setTimePeriodLength(Time); then AverageDirectionalIndex() TimePeriod is one thousand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TechnicalIndicatorGenerator.setTimePeriodLength(Time)"})
  void testSetTimePeriodLength_thenAverageDirectionalIndexTimePeriodIsOneThousand() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();

    // Act
    averageDirectionalIndex.setTimePeriodLength(TimeFactory.createTime());

    // Assert
    assertEquals(1000L, averageDirectionalIndex.getTimePeriod());
  }

  /**
   * Test {@link TechnicalIndicatorGenerator#getTimePeriod()}.
   *
   * <p>Method under test: {@link TechnicalIndicatorGenerator#getTimePeriod()}
   */
  @Test
  @DisplayName("Test getTimePeriod()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TechnicalIndicatorGenerator.getTimePeriod()"})
  void testGetTimePeriod() {
    // Arrange, Act and Assert
    assertEquals(0L, new AverageDirectionalIndex().getTimePeriod());
  }

  /**
   * Test {@link TechnicalIndicatorGenerator#getName()}.
   *
   * <p>Method under test: {@link TechnicalIndicatorGenerator#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TechnicalIndicatorGenerator.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("AverageDirectionalIndex", new AverageDirectionalIndex().getName());
  }

  /**
   * Test {@link TechnicalIndicatorGenerator#getProperties()}.
   *
   * <p>Method under test: {@link TechnicalIndicatorGenerator#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map TechnicalIndicatorGenerator.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue(new AverageDirectionalIndex().getProperties().isEmpty());
  }

  /**
   * Test {@link TechnicalIndicatorGenerator#setTimePeriod(long)} with {@code long}.
   *
   * <p>Method under test: {@link TechnicalIndicatorGenerator#setTimePeriod(long)}
   */
  @Test
  @DisplayName("Test setTimePeriod(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link TechnicalIndicatorGenerator#setTimePeriod(Time)} with {@code Time}.
   *
   * <ul>
   *   <li>Then {@link AverageDirectionalIndex#AverageDirectionalIndex()} TimePeriod is one
   *       thousand.
   * </ul>
   *
   * <p>Method under test: {@link TechnicalIndicatorGenerator#setTimePeriod(Time)}
   */
  @Test
  @DisplayName(
      "Test setTimePeriod(Time) with 'Time'; then AverageDirectionalIndex() TimePeriod is one thousand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TechnicalIndicatorGenerator.setTimePeriod(Time)"})
  void testSetTimePeriodWithTime_thenAverageDirectionalIndexTimePeriodIsOneThousand() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();

    // Act
    averageDirectionalIndex.setTimePeriod(TimeFactory.createTime());

    // Assert
    assertEquals(1000L, averageDirectionalIndex.getTimePeriod());
  }

  /**
   * Test {@link TechnicalIndicatorGenerator#getIndicatorRequirements()}.
   *
   * <p>Method under test: {@link TechnicalIndicatorGenerator#getIndicatorRequirements()}
   */
  @Test
  @DisplayName("Test getIndicatorRequirements()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IndicatorRequirements TechnicalIndicatorGenerator.getIndicatorRequirements()"
  })
  void testGetIndicatorRequirements() {
    // Arrange, Act and Assert
    assertNull(new AverageDirectionalIndex().getIndicatorRequirements());
  }

  /**
   * Test {@link TechnicalIndicatorGenerator#setIndicatorRequirements(IndicatorRequirements)}.
   *
   * <p>Method under test: {@link
   * TechnicalIndicatorGenerator#setIndicatorRequirements(IndicatorRequirements)}
   */
  @Test
  @DisplayName("Test setIndicatorRequirements(IndicatorRequirements)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TechnicalIndicatorGenerator.setIndicatorRequirements(IndicatorRequirements)"
  })
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
