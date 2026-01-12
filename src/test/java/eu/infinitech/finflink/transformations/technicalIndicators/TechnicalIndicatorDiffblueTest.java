package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Supplier is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TechnicalIndicator#TechnicalIndicator()}
   *   <li>{@link TechnicalIndicator#getSupplier()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Supplier is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TechnicalIndicator.<init>()",
    "void TechnicalIndicator.<init>(Supplier)",
    "Supplier TechnicalIndicator.getSupplier()"
  })
  void testGettersAndSetters_thenReturnSupplierIsNull() {
    // Arrange and Act
    TechnicalIndicator<IndicatorState> actualTechnicalIndicator = new TechnicalIndicator<>();

    // Assert
    assertNull(actualTechnicalIndicator.getSupplier());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Supplier}.
   *   <li>Then return {@link Supplier}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TechnicalIndicator#TechnicalIndicator(Supplier)}
   *   <li>{@link TechnicalIndicator#getSupplier()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Supplier; then return Supplier")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TechnicalIndicator.<init>()",
    "void TechnicalIndicator.<init>(Supplier)",
    "Supplier TechnicalIndicator.getSupplier()"
  })
  void testGettersAndSetters_whenSupplier_thenReturnSupplier() {
    // Arrange
    Supplier<IndicatorState> supplier = mock(Supplier.class);

    // Act
    TechnicalIndicator<IndicatorState> actualTechnicalIndicator =
        new TechnicalIndicator<>(supplier);

    // Assert
    assertSame(supplier, actualTechnicalIndicator.getSupplier());
  }

  /**
   * Test {@link TechnicalIndicator#add(Trade, IndicatorState)} with {@code Trade}, {@code
   * IndicatorState}.
   *
   * <ul>
   *   <li>When {@link TrueRange} (default constructor).
   *   <li>Then return {@link TrueRange} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TechnicalIndicator#add(Trade, IndicatorState)}
   */
  @Test
  @DisplayName(
      "Test add(Trade, IndicatorState) with 'Trade', 'IndicatorState'; when TrueRange (default constructor); then return TrueRange (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IndicatorState TechnicalIndicator.add(Trade, IndicatorState)"})
  void testAddWithTradeIndicatorState_whenTrueRange_thenReturnTrueRange() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>();
    Trade value = new Trade(ToTradeFactory.createValidTradeDataString(), 1L, 10.0d, 1L);
    TrueRange accumulator = new TrueRange();

    // Act
    IndicatorState actualAddResult = technicalIndicator.add(value, accumulator);

    // Assert
    assertSame(accumulator, actualAddResult);
  }

  /**
   * Test {@link TechnicalIndicator#getResult(IndicatorState)} with {@code IndicatorState}.
   *
   * <ul>
   *   <li>When {@link TrueRange} (default constructor).
   *   <li>Then return doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TechnicalIndicator#getResult(IndicatorState)}
   */
  @Test
  @DisplayName(
      "Test getResult(IndicatorState) with 'IndicatorState'; when TrueRange (default constructor); then return doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Double TechnicalIndicator.getResult(IndicatorState)"})
  void testGetResultWithIndicatorState_whenTrueRange_thenReturnDoubleValueIsZero() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>();

    // Act and Assert
    assertEquals(0.0d, technicalIndicator.getResult(new TrueRange()).doubleValue());
  }

  /**
   * Test {@link TechnicalIndicator#merge(IndicatorState, IndicatorState)} with {@code
   * IndicatorState}, {@code IndicatorState}.
   *
   * <ul>
   *   <li>When {@link TrueRange} (default constructor).
   *   <li>Then return {@link TrueRange} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TechnicalIndicator#merge(IndicatorState, IndicatorState)}
   */
  @Test
  @DisplayName(
      "Test merge(IndicatorState, IndicatorState) with 'IndicatorState', 'IndicatorState'; when TrueRange (default constructor); then return TrueRange (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IndicatorState TechnicalIndicator.merge(IndicatorState, IndicatorState)"})
  void testMergeWithIndicatorStateIndicatorState_whenTrueRange_thenReturnTrueRange() {
    // Arrange
    TechnicalIndicator<IndicatorState> technicalIndicator = new TechnicalIndicator<>();
    TrueRange a = new TrueRange();

    // Act
    IndicatorState actualMergeResult = technicalIndicator.merge(a, new TrueRange());

    // Assert
    assertSame(a, actualMergeResult);
  }

  /**
   * Test {@link TechnicalIndicator#createAccumulator()}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} return {@link TrueRange} (default
   *       constructor).
   *   <li>Then return {@link TrueRange} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TechnicalIndicator#createAccumulator()}
   */
  @Test
  @DisplayName(
      "Test createAccumulator(); given Supplier get() return TrueRange (default constructor); then return TrueRange (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
