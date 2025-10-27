package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.Trade;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class TrueRangeDiffblueTest {
  /**
   * Method under test: {@link TrueRange#getResult()}
   */
  @Test
  void testGetResult() {
    // Arrange, Act and Assert
    assertEquals(0.0d, (new TrueRange()).getResult().doubleValue());
  }

  /**
   * Method under test: {@link TrueRange#getResult()}
   */
  @Test
  void testGetResult2() {
    // Arrange
    TrueRange trueRange = new TrueRange();
    trueRange.add(new Trade("Asset Symbol", 1L, 10.0d, 1L));
    trueRange.add(new Trade("Asset Symbol", 2L, 10.0d, 2L));

    // Act and Assert
    assertEquals(10.0d, trueRange.getResult().doubleValue());
  }

  /**
   * Method under test: {@link TrueRange#getResult()}
   */
  @Test
  void testGetResult3() {
    // Arrange
    TrueRange trueRange = new TrueRange();
    trueRange.add(new Trade("Asset Symbol", -1L, 10.0d, 1L));
    trueRange.add(new Trade("Asset Symbol", 2L, 10.0d, 2L));

    // Act and Assert
    assertEquals(0.0d, trueRange.getResult().doubleValue());
  }

  /**
   * Method under test: {@link TrueRange#add(Trade)}
   */
  @Test
  void testAdd() {
    // Arrange
    TrueRange trueRange = new TrueRange();
    Trade value = new Trade("Asset Symbol", 1L, 10.0d, 1L);

    // Act
    trueRange.add(value);

    // Assert
    IndicatorState getResult = trueRange.get();
    assertTrue(getResult instanceof TrueRange);
    IndicatorState getResult2 = getResult.get();
    assertTrue(getResult2 instanceof TrueRange);
    IndicatorState getResult3 = getResult2.get();
    assertTrue(getResult3 instanceof TrueRange);
    IndicatorState getResult4 = getResult3.get();
    assertTrue(getResult4 instanceof TrueRange);
    IndicatorState getResult5 = getResult4.get();
    assertTrue(getResult5 instanceof TrueRange);
    IndicatorState getResult6 = getResult5.get();
    assertTrue(getResult6 instanceof TrueRange);
    IndicatorState getResult7 = getResult6.get();
    assertTrue(getResult7 instanceof TrueRange);
    IndicatorState getResult8 = getResult7.get();
    assertTrue(getResult8 instanceof TrueRange);
    List<Trade> trades = trueRange.getTrades();
    assertEquals(1, trades.size());
    assertTrue(((TrueRange) getResult2).getTrades().isEmpty());
    assertTrue(((TrueRange) getResult3).getTrades().isEmpty());
    assertTrue(((TrueRange) getResult4).getTrades().isEmpty());
    assertTrue(((TrueRange) getResult5).getTrades().isEmpty());
    assertTrue(((TrueRange) getResult6).getTrades().isEmpty());
    assertTrue(((TrueRange) getResult7).getTrades().isEmpty());
    assertEquals(((TrueRange) getResult8).getTrades(), ((TrueRange) getResult8).getTrades());
    assertSame(value, trades.get(0));
  }

  /**
   * Method under test: {@link TrueRange#get()}
   */
  @Test
  void testGet() {
    // Arrange and Act
    IndicatorState actualGetResult = (new TrueRange()).get();

    // Assert
    assertTrue(actualGetResult instanceof TrueRange);
    assertEquals(0.0d, actualGetResult.getResult().doubleValue());
    assertTrue(((TrueRange) actualGetResult).getTrades().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TrueRange}
   *   <li>{@link TrueRange#setTrades(List)}
   *   <li>{@link TrueRange#getTrades()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TrueRange actualTrueRange = new TrueRange();
    ArrayList<Trade> trades = new ArrayList<>();
    actualTrueRange.setTrades(trades);
    List<Trade> actualTrades = actualTrueRange.getTrades();

    // Assert that nothing has changed
    assertTrue(actualTrades.isEmpty());
    assertSame(trades, actualTrades);
  }
}
