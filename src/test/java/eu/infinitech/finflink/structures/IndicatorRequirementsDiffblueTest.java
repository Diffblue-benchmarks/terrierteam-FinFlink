package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IndicatorRequirementsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IndicatorRequirements}
   *   <li>{@link IndicatorRequirements#needsClose()}
   *   <li>{@link IndicatorRequirements#needsHigh()}
   *   <li>{@link IndicatorRequirements#needsLow()}
   *   <li>{@link IndicatorRequirements#needsOpen()}
   *   <li>{@link IndicatorRequirements#needsVolume()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IndicatorRequirements.<init>()", "IndicatorRequirements IndicatorRequirements.needsClose()",
      "IndicatorRequirements IndicatorRequirements.needsHigh()",
      "IndicatorRequirements IndicatorRequirements.needsLow()",
      "IndicatorRequirements IndicatorRequirements.needsOpen()",
      "IndicatorRequirements IndicatorRequirements.needsVolume()"})
  void testGettersAndSetters() {
    // Arrange and Act
    IndicatorRequirements actualIndicatorRequirements = new IndicatorRequirements();
    IndicatorRequirements actualNeedsCloseResult = actualIndicatorRequirements.needsClose();
    IndicatorRequirements actualNeedsHighResult = actualIndicatorRequirements.needsHigh();
    IndicatorRequirements actualNeedsLowResult = actualIndicatorRequirements.needsLow();
    IndicatorRequirements actualNeedsOpenResult = actualIndicatorRequirements.needsOpen();

    // Assert
    assertSame(actualIndicatorRequirements, actualNeedsCloseResult);
    assertSame(actualIndicatorRequirements, actualNeedsHighResult);
    assertSame(actualIndicatorRequirements, actualNeedsLowResult);
    assertSame(actualIndicatorRequirements, actualNeedsOpenResult);
    assertSame(actualIndicatorRequirements, actualIndicatorRequirements.needsVolume());
  }

  /**
   * Test {@link IndicatorRequirements#checkVolume()}.
   * <p>
   * Method under test: {@link IndicatorRequirements#checkVolume()}
   */
  @Test
  @DisplayName("Test checkVolume()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IndicatorRequirements.checkVolume()"})
  void testCheckVolume() {
    // Arrange, Act and Assert
    assertFalse((new IndicatorRequirements()).checkVolume());
  }

  /**
   * Test {@link IndicatorRequirements#checkOpen()}.
   * <p>
   * Method under test: {@link IndicatorRequirements#checkOpen()}
   */
  @Test
  @DisplayName("Test checkOpen()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IndicatorRequirements.checkOpen()"})
  void testCheckOpen() {
    // Arrange, Act and Assert
    assertFalse((new IndicatorRequirements()).checkOpen());
  }

  /**
   * Test {@link IndicatorRequirements#checkClose()}.
   * <p>
   * Method under test: {@link IndicatorRequirements#checkClose()}
   */
  @Test
  @DisplayName("Test checkClose()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IndicatorRequirements.checkClose()"})
  void testCheckClose() {
    // Arrange, Act and Assert
    assertFalse((new IndicatorRequirements()).checkClose());
  }

  /**
   * Test {@link IndicatorRequirements#checkHigh()}.
   * <p>
   * Method under test: {@link IndicatorRequirements#checkHigh()}
   */
  @Test
  @DisplayName("Test checkHigh()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IndicatorRequirements.checkHigh()"})
  void testCheckHigh() {
    // Arrange, Act and Assert
    assertFalse((new IndicatorRequirements()).checkHigh());
  }

  /**
   * Test {@link IndicatorRequirements#checkLow()}.
   * <p>
   * Method under test: {@link IndicatorRequirements#checkLow()}
   */
  @Test
  @DisplayName("Test checkLow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IndicatorRequirements.checkLow()"})
  void testCheckLow() {
    // Arrange, Act and Assert
    assertFalse((new IndicatorRequirements()).checkLow());
  }
}
