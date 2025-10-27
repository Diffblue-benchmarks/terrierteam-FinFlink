package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class UtilsDiffblueTest {
  /**
   * Method under test: {@link Utils#sum(List)}
   */
  @Test
  void testSum() {
    // Arrange, Act and Assert
    assertEquals(0.0d, Utils.sum(new ArrayList<>()));
  }

  /**
   * Method under test: {@link Utils#sum(List)}
   */
  @Test
  void testSum2() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(10.0d);

    // Act and Assert
    assertEquals(10.0d, Utils.sum(in));
  }

  /**
   * Method under test: {@link Utils#sum(List)}
   */
  @Test
  void testSum3() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(0.0d);
    in.add(10.0d);

    // Act and Assert
    assertEquals(10.0d, Utils.sum(in));
  }

  /**
   * Method under test: {@link Utils#mean(List)}
   */
  @Test
  void testMean() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, Utils.mean(new ArrayList<>()));
  }

  /**
   * Method under test: {@link Utils#mean(List)}
   */
  @Test
  void testMean2() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(10.0d);

    // Act and Assert
    assertEquals(10.0d, Utils.mean(in));
  }

  /**
   * Method under test: {@link Utils#mean(List)}
   */
  @Test
  void testMean3() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(0.0d);
    in.add(10.0d);

    // Act and Assert
    assertEquals(5.0d, Utils.mean(in));
  }

  /**
   * Method under test: {@link Utils#std(List)}
   */
  @Test
  void testStd() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, Utils.std(new ArrayList<>()));
  }

  /**
   * Method under test: {@link Utils#std(List)}
   */
  @Test
  void testStd2() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(10.0d);

    // Act and Assert
    assertEquals(0.0d, Utils.std(in));
  }

  /**
   * Method under test: {@link Utils#std(List)}
   */
  @Test
  void testStd3() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(0.0d);
    in.add(10.0d);

    // Act and Assert
    assertEquals(5.0d, Utils.std(in));
  }

  /**
   * Method under test: {@link Utils#cumSum(List)}
   */
  @Test
  void testCumSum() {
    // Arrange and Act
    List<Double> actualCumSumResult = Utils.cumSum(new ArrayList<>());

    // Assert
    assertTrue(actualCumSumResult.isEmpty());
  }

  /**
   * Method under test: {@link Utils#cumSum(List)}
   */
  @Test
  void testCumSum2() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(10.0d);

    // Act
    List<Double> actualCumSumResult = Utils.cumSum(in);

    // Assert
    assertEquals(1, actualCumSumResult.size());
    assertEquals(10.0d, actualCumSumResult.get(0).doubleValue());
  }

  /**
   * Method under test: {@link Utils#cumSum(List)}
   */
  @Test
  void testCumSum3() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(0.5d);
    in.add(10.0d);

    // Act
    List<Double> actualCumSumResult = Utils.cumSum(in);

    // Assert
    assertEquals(2, actualCumSumResult.size());
    assertEquals(0.5d, actualCumSumResult.get(0).doubleValue());
    assertEquals(10.5d, actualCumSumResult.get(1).doubleValue());
  }

  /**
   * Method under test: {@link Utils#ewm(List, int)}
   */
  @Test
  void testEwm() {
    // Arrange and Act
    List<Double> actualEwmResult = Utils.ewm(new ArrayList<>(), 1);

    // Assert
    assertTrue(actualEwmResult.isEmpty());
  }

  /**
   * Method under test: {@link Utils#ewm(List, int)}
   */
  @Test
  void testEwm2() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(2.0d);

    // Act
    List<Double> actualEwmResult = Utils.ewm(in, 1);

    // Assert
    assertEquals(1, actualEwmResult.size());
    assertEquals(2.0d, actualEwmResult.get(0).doubleValue());
  }

  /**
   * Method under test: {@link Utils#ewm(List, int)}
   */
  @Test
  void testEwm3() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(1.0d);
    in.add(2.0d);

    // Act
    List<Double> actualEwmResult = Utils.ewm(in, 1);

    // Assert
    assertEquals(in, actualEwmResult);
  }

  /**
   * Method under test: {@link Utils#trueRange(List)}
   */
  @Test
  void testTrueRange() {
    // Arrange and Act
    List<Double> actualTrueRangeResult = Utils.trueRange(new ArrayList<>());

    // Assert
    assertTrue(actualTrueRangeResult.isEmpty());
  }

  /**
   * Method under test: {@link Utils#trueRange(List)}
   */
  @Test
  void testTrueRange2() {
    // Arrange
    ArrayList<TradePeriod> in = new ArrayList<>();
    in.add(new TradePeriod());

    // Act
    List<Double> actualTrueRangeResult = Utils.trueRange(in);

    // Assert
    assertEquals(1, actualTrueRangeResult.size());
    assertEquals(0.0d, actualTrueRangeResult.get(0).doubleValue());
  }

  /**
   * Method under test: {@link Utils#trueRange(List)}
   */
  @Test
  void testTrueRange3() {
    // Arrange
    ArrayList<TradePeriod> in = new ArrayList<>();
    in.add(new TradePeriod());
    in.add(new TradePeriod());

    // Act
    List<Double> actualTrueRangeResult = Utils.trueRange(in);

    // Assert
    assertEquals(2, actualTrueRangeResult.size());
    assertEquals(0.0d, actualTrueRangeResult.get(0).doubleValue());
    assertEquals(0.0d, actualTrueRangeResult.get(1).doubleValue());
  }

  /**
   * Method under test: {@link Utils#diff(List)}
   */
  @Test
  void testDiff() {
    // Arrange and Act
    List<Double> actualDiffResult = Utils.diff(new ArrayList<>());

    // Assert
    assertTrue(actualDiffResult.isEmpty());
  }

  /**
   * Method under test: {@link Utils#diff(List)}
   */
  @Test
  void testDiff2() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(10.0d);

    // Act
    List<Double> actualDiffResult = Utils.diff(in);

    // Assert
    assertEquals(1, actualDiffResult.size());
    assertEquals(0.0d, actualDiffResult.get(0).doubleValue());
  }

  /**
   * Method under test: {@link Utils#diff(List)}
   */
  @Test
  void testDiff3() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(0.5d);
    in.add(10.0d);

    // Act
    List<Double> actualDiffResult = Utils.diff(in);

    // Assert
    assertEquals(2, actualDiffResult.size());
    assertEquals(0.0d, actualDiffResult.get(0).doubleValue());
    assertEquals(9.5d, actualDiffResult.get(1).doubleValue());
  }

  /**
   * Method under test: {@link Utils#truePrice(TradePeriod)}
   */
  @Test
  void testTruePrice() {
    // Arrange, Act and Assert
    assertEquals(0.0d, Utils.truePrice(new TradePeriod()));
  }

  /**
   * Method under test: {@link Utils#sliding(List, long)}
   */
  @Test
  void testSliding() {
    // Arrange and Act
    Stream<List<Object>> actualSlidingResult = Utils.sliding(new ArrayList<>(), 3L);

    // Assert
    assertTrue(actualSlidingResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link Utils#sliding(List, long)}
   */
  @Test
  void testSliding2() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");

    // Act
    Stream<List<Object>> actualSlidingResult = Utils.sliding(list, 3L);

    // Assert
    assertTrue(actualSlidingResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link Utils#sliding(List, long)}
   */
  @Test
  void testSliding3() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");
    list.add("42");

    // Act
    Stream<List<Object>> actualSlidingResult = Utils.sliding(list, 3L);

    // Assert
    assertTrue(actualSlidingResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link Utils#expanding(List)}
   */
  @Test
  void testExpanding() {
    // Arrange and Act
    Stream<List<Object>> actualExpandingResult = Utils.expanding(new ArrayList<>());

    // Assert
    assertTrue(actualExpandingResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link Utils#expanding(List)}
   */
  @Test
  void testExpanding2() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");

    // Act
    Stream<List<Object>> actualExpandingResult = Utils.expanding(list);

    // Assert
    assertTrue(actualExpandingResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link Utils#expanding(List)}
   */
  @Test
  void testExpanding3() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");
    list.add("42");

    // Act
    Stream<List<Object>> actualExpandingResult = Utils.expanding(list);

    // Assert
    List<List<Object>> collectResult = actualExpandingResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertTrue(collectResult.get(0).isEmpty());
  }
}
