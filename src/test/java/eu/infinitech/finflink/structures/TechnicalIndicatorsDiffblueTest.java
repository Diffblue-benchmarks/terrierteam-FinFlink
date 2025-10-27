package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class TechnicalIndicatorsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TechnicalIndicators#TechnicalIndicators()}
   *   <li>{@link TechnicalIndicators#setIndicators(List)}
   *   <li>{@link TechnicalIndicators#getIndicators()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TechnicalIndicators actualTechnicalIndicators = new TechnicalIndicators();
    ArrayList<TechnicalIndicator> indicators = new ArrayList<>();
    actualTechnicalIndicators.setIndicators(indicators);
    List<TechnicalIndicator> actualIndicators = actualTechnicalIndicators.getIndicators();

    // Assert that nothing has changed
    assertTrue(actualIndicators.isEmpty());
    assertSame(indicators, actualIndicators);
  }

  /**
   * Method under test: {@link TechnicalIndicators#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("[]", (new TechnicalIndicators()).toString());
  }

  /**
   * Method under test: {@link TechnicalIndicators#toString()}
   */
  @Test
  void testToString2() {
    // Arrange
    ArrayList<TechnicalIndicator> indicators = new ArrayList<>();
    indicators.add(new TechnicalIndicator());

    TechnicalIndicators technicalIndicators = new TechnicalIndicators();
    technicalIndicators.setIndicators(indicators);

    // Act and Assert
    assertEquals("[null:0.0]", technicalIndicators.toString());
  }

  /**
   * Method under test: {@link TechnicalIndicators#toString()}
   */
  @Test
  void testToString3() {
    // Arrange
    ArrayList<TechnicalIndicator> indicators = new ArrayList<>();
    indicators.add(new TechnicalIndicator());
    indicators.add(new TechnicalIndicator());

    TechnicalIndicators technicalIndicators = new TechnicalIndicators();
    technicalIndicators.setIndicators(indicators);

    // Act and Assert
    assertEquals("[null:0.0, null:0.0]", technicalIndicators.toString());
  }

  /**
   * Method under test: {@link TechnicalIndicators#toString()}
   */
  @Test
  void testToString4() {
    // Arrange
    HashMap<String, String> properties = new HashMap<>();
    properties.computeIfPresent("foo", mock(BiFunction.class));
    TechnicalIndicator technicalIndicator = new TechnicalIndicator("[", 10.0d, properties);

    ArrayList<TechnicalIndicator> indicators = new ArrayList<>();
    indicators.add(technicalIndicator);

    TechnicalIndicators technicalIndicators = new TechnicalIndicators();
    technicalIndicators.setIndicators(indicators);

    // Act and Assert
    assertEquals("[[:10.0]", technicalIndicators.toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TechnicalIndicators#TechnicalIndicators(List)}
   *   <li>{@link TechnicalIndicators#setIndicators(List)}
   *   <li>{@link TechnicalIndicators#getIndicators()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    TechnicalIndicators actualTechnicalIndicators = new TechnicalIndicators(new ArrayList<>());
    ArrayList<TechnicalIndicator> indicators = new ArrayList<>();
    actualTechnicalIndicators.setIndicators(indicators);
    List<TechnicalIndicator> actualIndicators = actualTechnicalIndicators.getIndicators();

    // Assert that nothing has changed
    assertTrue(actualIndicators.isEmpty());
    assertSame(indicators, actualIndicators);
  }
}
