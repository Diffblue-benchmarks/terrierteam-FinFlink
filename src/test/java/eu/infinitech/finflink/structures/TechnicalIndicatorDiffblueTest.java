package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TechnicalIndicatorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TechnicalIndicator.<init>()", "String TechnicalIndicator.getName()",
      "Map TechnicalIndicator.getProperties()", "double TechnicalIndicator.getValue()",
      "void TechnicalIndicator.setName(String)", "void TechnicalIndicator.setProperties(Map)",
      "void TechnicalIndicator.setValue(double)"})
  void testGettersAndSetters() {
    // Arrange and Act
    TechnicalIndicator actualTechnicalIndicator = new TechnicalIndicator();
    actualTechnicalIndicator.setName("Name");
    HashMap<String, String> properties = new HashMap<>();
    actualTechnicalIndicator.setProperties(properties);
    actualTechnicalIndicator.setValue(10.0d);
    String actualName = actualTechnicalIndicator.getName();
    Map<String, String> actualProperties = actualTechnicalIndicator.getProperties();

    // Assert
    assertEquals("Name", actualName);
    assertEquals(10.0d, actualTechnicalIndicator.getValue());
    assertTrue(actualProperties.isEmpty());
    assertSame(properties, actualProperties);
  }

  /**
   * Test {@link TechnicalIndicator#TechnicalIndicator(String, double, Map)}.
   * <p>
   * Method under test: {@link TechnicalIndicator#TechnicalIndicator(String, double, Map)}
   */
  @Test
  @DisplayName("Test new TechnicalIndicator(String, double, Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TechnicalIndicator.<init>(String, double, Map)"})
  void testNewTechnicalIndicator() {
    // Arrange and Act
    TechnicalIndicator actualTechnicalIndicator = new TechnicalIndicator("Name", 10.0d, new HashMap<>());

    // Assert
    assertEquals("Name", actualTechnicalIndicator.getName());
    assertEquals(10.0d, actualTechnicalIndicator.getValue());
    assertTrue(actualTechnicalIndicator.getProperties().isEmpty());
  }
}
