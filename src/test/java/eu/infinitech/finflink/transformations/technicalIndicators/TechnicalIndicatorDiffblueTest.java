package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.Trade;
import eu.infinitech.finflink.transformations.data.ToTradeFactory;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TechnicalIndicatorDiffblueTest {
  /**
   * Test {@link TechnicalIndicator#add(Trade, IndicatorState)} with {@code Trade}, {@code
   * IndicatorState}.
   *
   * <ul>
   *   <li>When createTrueRange.
   *   <li>Then return createTrueRange.
   * </ul>
   *
   * <p>Method under test: {@link TechnicalIndicator#add(Trade, IndicatorState)}
   */
  @Test
  @DisplayName(
      "Test add(Trade, IndicatorState) with 'Trade', 'IndicatorState'; when createTrueRange; then return createTrueRange")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IndicatorState TechnicalIndicator.add(Trade, IndicatorState)"})
  void testAddWithTradeIndicatorState_whenCreateTrueRange_thenReturnCreateTrueRange() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>();
    Trade value = new Trade(ToTradeFactory.createTradeDataString(), 1L, 10.0d, 1L);
    TrueRange accumulator = TrueRangeFactory.createTrueRange();

    // Act
    IndicatorState actualAddResult = technicalIndicator.add(value, accumulator);

    // Assert
    assertSame(accumulator, actualAddResult);
  }

  /**
   * Test {@link TechnicalIndicator#getResult(IndicatorState)} with {@code IndicatorState}.
   *
   * <ul>
   *   <li>When createTrueRange.
   *   <li>Then return doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TechnicalIndicator#getResult(IndicatorState)}
   */
  @Test
  @DisplayName(
      "Test getResult(IndicatorState) with 'IndicatorState'; when createTrueRange; then return doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Double TechnicalIndicator.getResult(IndicatorState)"})
  void testGetResultWithIndicatorState_whenCreateTrueRange_thenReturnDoubleValueIsZero() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>();

    // Act and Assert
    assertEquals(
        0.0d, technicalIndicator.getResult(TrueRangeFactory.createTrueRange()).doubleValue());
  }

  /**
   * Test {@link TechnicalIndicator#merge(IndicatorState, IndicatorState)} with {@code
   * IndicatorState}, {@code IndicatorState}.
   *
   * <ul>
   *   <li>Then return createTrueRange.
   * </ul>
   *
   * <p>Method under test: {@link TechnicalIndicator#merge(IndicatorState, IndicatorState)}
   */
  @Test
  @DisplayName(
      "Test merge(IndicatorState, IndicatorState) with 'IndicatorState', 'IndicatorState'; then return createTrueRange")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IndicatorState TechnicalIndicator.merge(IndicatorState, IndicatorState)"})
  void testMergeWithIndicatorStateIndicatorState_thenReturnCreateTrueRange() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>();
    TrueRange a = TrueRangeFactory.createTrueRange();

    // Act
    IndicatorState actualMergeResult =
        technicalIndicator.merge(a, TrueRangeFactory.createTrueRange());

    // Assert
    assertSame(a, actualMergeResult);
  }

  /**
   * Test {@link TechnicalIndicator#createAccumulator()}.
   *
   * <ul>
   *   <li>Then return createTrueRange.
   * </ul>
   *
   * <p>Method under test: {@link TechnicalIndicator#createAccumulator()}
   */
  @Test
  @DisplayName("Test createAccumulator(); then return createTrueRange")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IndicatorState TechnicalIndicator.createAccumulator()"})
  void testCreateAccumulator_thenReturnCreateTrueRange() {
    // Arrange
    Supplier<IndicatorState> supplier = mock(Supplier.class);
    TrueRange createTrueRangeResult = TrueRangeFactory.createTrueRange();
    when(supplier.get()).thenReturn(createTrueRangeResult);
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>(supplier);

    // Act
    IndicatorState actualCreateAccumulatorResult = technicalIndicator.createAccumulator();

    // Assert
    verify(supplier).get();
    assertSame(createTrueRangeResult, actualCreateAccumulatorResult);
  }
}
