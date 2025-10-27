package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import eu.infinitech.finflink.structures.Trade;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class TechnicalIndicatorDiffblueTest {
  /**
   * Method under test: {@link TechnicalIndicator#add(Trade, IndicatorState)}
   */
  @Test
  void testAdd() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>();
    Trade value = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    TrueRange accumulator = new TrueRange();

    // Act and Assert
    assertSame(accumulator, technicalIndicator.add(value, accumulator));
  }

  /**
   * Method under test: {@link TechnicalIndicator#add(Trade, IndicatorState)}
   */
  @Test
  void testAdd2() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>(mock(Supplier.class));
    Trade value = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    TrueRange accumulator = new TrueRange();

    // Act and Assert
    assertSame(accumulator, technicalIndicator.add(value, accumulator));
  }

  /**
   * Method under test: {@link TechnicalIndicator#getResult(IndicatorState)}
   */
  @Test
  void testGetResult() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>();

    // Act and Assert
    assertEquals(0.0d, technicalIndicator.getResult(new TrueRange()).doubleValue());
  }

  /**
   * Method under test: {@link TechnicalIndicator#getResult(IndicatorState)}
   */
  @Test
  void testGetResult2() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>(mock(Supplier.class));

    // Act and Assert
    assertEquals(0.0d, technicalIndicator.getResult(new TrueRange()).doubleValue());
  }

  /**
   * Method under test:
   * {@link TechnicalIndicator#merge(IndicatorState, IndicatorState)}
   */
  @Test
  void testMerge() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>();
    TrueRange a = new TrueRange();

    // Act and Assert
    assertSame(a, technicalIndicator.merge(a, new TrueRange()));
  }

  /**
   * Method under test:
   * {@link TechnicalIndicator#merge(IndicatorState, IndicatorState)}
   */
  @Test
  void testMerge2() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>(mock(Supplier.class));
    TrueRange a = new TrueRange();

    // Act and Assert
    assertSame(a, technicalIndicator.merge(a, new TrueRange()));
  }

  /**
   * Method under test: {@link TechnicalIndicator#createAccumulator()}
   */
  @Test
  void testCreateAccumulator() {
    // Arrange
    Supplier<IndicatorState> supplier = mock(Supplier.class);
    TrueRange trueRange = new TrueRange();
    when(supplier.get()).thenReturn(trueRange);
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>(supplier);

    // Act
    IndicatorState actualCreateAccumulatorResult = technicalIndicator.createAccumulator();

    // Assert
    verify(supplier).get();
    assertSame(trueRange, actualCreateAccumulatorResult);
  }
}
