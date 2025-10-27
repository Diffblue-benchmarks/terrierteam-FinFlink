package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class TechnicalIndicatorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TechnicalIndicator#TechnicalIndicator()}
   *   <li>{@link TechnicalIndicator#setName(String)}
   *   <li>{@link TechnicalIndicator#setProperties(Map)}
   *   <li>{@link TechnicalIndicator#setValue(double)}
   *   <li>{@link TechnicalIndicator#getName()}
   *   <li>{@link TechnicalIndicator#getProperties()}
   *   <li>{@link TechnicalIndicator#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TechnicalIndicator actualTechnicalIndicator = new TechnicalIndicator();
    actualTechnicalIndicator.setName("Name");
    HashMap<String, String> properties = new HashMap<>();
    actualTechnicalIndicator.setProperties(properties);
    actualTechnicalIndicator.setValue(10.0d);
    String actualName = actualTechnicalIndicator.getName();
    Map<String, String> actualProperties = actualTechnicalIndicator.getProperties();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(10.0d, actualTechnicalIndicator.getValue());
    assertTrue(actualProperties.isEmpty());
    assertSame(properties, actualProperties);
  }

  /**
   * Method under test:
   * {@link TechnicalIndicator#TechnicalIndicator(String, double, Map)}
   */
  @Test
  void testNewTechnicalIndicator() {
    // Arrange
    HashMap<String, String> properties = new HashMap<>();

    // Act
    TechnicalIndicator actualTechnicalIndicator = new TechnicalIndicator("Name", 10.0d, properties);

    // Assert
    assertEquals("Name", actualTechnicalIndicator.getName());
    assertEquals(10.0d, actualTechnicalIndicator.getValue());
    Map<String, String> properties2 = actualTechnicalIndicator.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }

  /**
   * Method under test:
   * {@link TechnicalIndicator#TechnicalIndicator(String, double, Map)}
   */
  @Test
  void testNewTechnicalIndicator2() {
    // Arrange
    HashMap<String, String> properties = new HashMap<>();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    TechnicalIndicator actualTechnicalIndicator = new TechnicalIndicator("Name", 10.0d, properties);

    // Assert
    assertEquals("Name", actualTechnicalIndicator.getName());
    assertEquals(10.0d, actualTechnicalIndicator.getValue());
    Map<String, String> properties2 = actualTechnicalIndicator.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }
}
