package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.Trade;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TechnicalIndicatorDiffblueTest {
  /**
   * Test {@link TechnicalIndicator#add(Trade, IndicatorState)} with {@code Trade}, {@code IndicatorState}.
   * <ul>
   *   <li>When {@link TrueRange} (default constructor).</li>
   *   <li>Then return {@link TrueRange} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TechnicalIndicator#add(Trade, IndicatorState)}
   */
  @Test
  @DisplayName("Test add(Trade, IndicatorState) with 'Trade', 'IndicatorState'; when TrueRange (default constructor); then return TrueRange (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IndicatorState TechnicalIndicator.add(Trade, IndicatorState)"})
  void testAddWithTradeIndicatorState_whenTrueRange_thenReturnTrueRange() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>();
    Trade value = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    TrueRange accumulator = new TrueRange();

    // Act and Assert
    assertSame(accumulator, technicalIndicator.add(value, accumulator));
  }

  /**
   * Test {@link TechnicalIndicator#getResult(IndicatorState)} with {@code IndicatorState}.
   * <ul>
   *   <li>When {@link TrueRange} (default constructor).</li>
   *   <li>Then return doubleValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TechnicalIndicator#getResult(IndicatorState)}
   */
  @Test
  @DisplayName("Test getResult(IndicatorState) with 'IndicatorState'; when TrueRange (default constructor); then return doubleValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Double TechnicalIndicator.getResult(IndicatorState)"})
  void testGetResultWithIndicatorState_whenTrueRange_thenReturnDoubleValueIsZero() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>();

    // Act and Assert
    assertEquals(0.0d, technicalIndicator.getResult(new TrueRange()).doubleValue());
  }

  /**
   * Test {@link TechnicalIndicator#merge(IndicatorState, IndicatorState)} with {@code IndicatorState}, {@code IndicatorState}.
   * <ul>
   *   <li>When {@link TrueRange} (default constructor).</li>
   *   <li>Then return {@link TrueRange} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TechnicalIndicator#merge(IndicatorState, IndicatorState)}
   */
  @Test
  @DisplayName("Test merge(IndicatorState, IndicatorState) with 'IndicatorState', 'IndicatorState'; when TrueRange (default constructor); then return TrueRange (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IndicatorState TechnicalIndicator.merge(IndicatorState, IndicatorState)"})
  void testMergeWithIndicatorStateIndicatorState_whenTrueRange_thenReturnTrueRange() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>();
    TrueRange a = new TrueRange();

    // Act and Assert
    assertSame(a, technicalIndicator.merge(a, new TrueRange()));
  }

  /**
   * Test {@link TechnicalIndicator#createAccumulator()}.
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} return {@link TrueRange} (default constructor).</li>
   *   <li>Then return {@link TrueRange} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TechnicalIndicator#createAccumulator()}
   */
  @Test
  @DisplayName("Test createAccumulator(); given Supplier get() return TrueRange (default constructor); then return TrueRange (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IndicatorState TechnicalIndicator.createAccumulator()"})
  void testCreateAccumulator_givenSupplierGetReturnTrueRange_thenReturnTrueRange() {
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
