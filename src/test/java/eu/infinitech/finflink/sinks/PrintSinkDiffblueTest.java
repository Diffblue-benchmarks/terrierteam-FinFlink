package eu.infinitech.finflink.sinks;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrintSinkDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PrintSink}
   *   <li>{@link PrintSink#isInitialized()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintSink.<init>()", "boolean PrintSink.isInitialized()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new PrintSink().isInitialized());
  }
}
