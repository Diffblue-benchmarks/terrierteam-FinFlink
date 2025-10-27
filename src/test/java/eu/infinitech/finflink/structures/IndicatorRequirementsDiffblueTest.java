package eu.infinitech.finflink.structures;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class IndicatorRequirementsDiffblueTest {
  /**
   * Method under test: {@link IndicatorRequirements#checkVolume()}
   */
  @Test
  void testCheckVolume() {
    // Arrange, Act and Assert
    assertFalse((new IndicatorRequirements()).checkVolume());
  }

  /**
   * Method under test: {@link IndicatorRequirements#checkOpen()}
   */
  @Test
  void testCheckOpen() {
    // Arrange, Act and Assert
    assertFalse((new IndicatorRequirements()).checkOpen());
  }

  /**
   * Method under test: {@link IndicatorRequirements#checkClose()}
   */
  @Test
  void testCheckClose() {
    // Arrange, Act and Assert
    assertFalse((new IndicatorRequirements()).checkClose());
  }

  /**
   * Method under test: {@link IndicatorRequirements#checkHigh()}
   */
  @Test
  void testCheckHigh() {
    // Arrange, Act and Assert
    assertFalse((new IndicatorRequirements()).checkHigh());
  }

  /**
   * Method under test: {@link IndicatorRequirements#checkLow()}
   */
  @Test
  void testCheckLow() {
    // Arrange, Act and Assert
    assertFalse((new IndicatorRequirements()).checkLow());
  }

  /**
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
}
