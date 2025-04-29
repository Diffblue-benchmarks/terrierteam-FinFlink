package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TechnicalIndicatorsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TechnicalIndicators#TechnicalIndicators()}
   *   <li>{@link TechnicalIndicators#setIndicators(List)}
   *   <li>{@link TechnicalIndicators#getIndicators()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TechnicalIndicators.<init>()", "void TechnicalIndicators.<init>(List)",
      "List TechnicalIndicators.getIndicators()", "void TechnicalIndicators.setIndicators(List)"})
  void testGettersAndSetters() {
    // Arrange and Act
    TechnicalIndicators actualTechnicalIndicators = new TechnicalIndicators();
    ArrayList<TechnicalIndicator> indicators = new ArrayList<>();
    actualTechnicalIndicators.setIndicators(indicators);
    List<TechnicalIndicator> actualIndicators = actualTechnicalIndicators.getIndicators();

    // Assert
    assertTrue(actualIndicators.isEmpty());
    assertSame(indicators, actualIndicators);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TechnicalIndicators#TechnicalIndicators(List)}
   *   <li>{@link TechnicalIndicators#setIndicators(List)}
   *   <li>{@link TechnicalIndicators#getIndicators()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TechnicalIndicators.<init>()", "void TechnicalIndicators.<init>(List)",
      "List TechnicalIndicators.getIndicators()", "void TechnicalIndicators.setIndicators(List)"})
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    TechnicalIndicators actualTechnicalIndicators = new TechnicalIndicators(new ArrayList<>());
    ArrayList<TechnicalIndicator> indicators = new ArrayList<>();
    actualTechnicalIndicators.setIndicators(indicators);
    List<TechnicalIndicator> actualIndicators = actualTechnicalIndicators.getIndicators();

    // Assert
    assertTrue(actualIndicators.isEmpty());
    assertSame(indicators, actualIndicators);
  }

  /**
   * Test {@link TechnicalIndicators#toString()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link TechnicalIndicator#TechnicalIndicator()}.</li>
   *   <li>Then return {@code [null:0.0]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TechnicalIndicators#toString()}
   */
  @Test
  @DisplayName("Test toString(); given ArrayList() add TechnicalIndicator(); then return '[null:0.0]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String TechnicalIndicators.toString()"})
  void testToString_givenArrayListAddTechnicalIndicator_thenReturnNull00() {
    // Arrange
    ArrayList<TechnicalIndicator> indicators = new ArrayList<>();
    indicators.add(new TechnicalIndicator());

    TechnicalIndicators technicalIndicators = new TechnicalIndicators();
    technicalIndicators.setIndicators(indicators);

    // Act and Assert
    assertEquals("[null:0.0]", technicalIndicators.toString());
  }

  /**
   * Test {@link TechnicalIndicators#toString()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link TechnicalIndicator#TechnicalIndicator()}.</li>
   *   <li>Then return {@code [null:0.0, null:0.0]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TechnicalIndicators#toString()}
   */
  @Test
  @DisplayName("Test toString(); given ArrayList() add TechnicalIndicator(); then return '[null:0.0, null:0.0]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String TechnicalIndicators.toString()"})
  void testToString_givenArrayListAddTechnicalIndicator_thenReturnNull00Null00() {
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
   * Test {@link TechnicalIndicators#toString()}.
   * <ul>
   *   <li>Then return {@code []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TechnicalIndicators#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String TechnicalIndicators.toString()"})
  void testToString_thenReturnLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("[]", (new TechnicalIndicators()).toString());
  }
}
