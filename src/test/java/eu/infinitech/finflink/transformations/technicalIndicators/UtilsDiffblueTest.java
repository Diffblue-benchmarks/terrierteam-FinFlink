package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.TradePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UtilsDiffblueTest {
  /**
   * Test {@link Utils#sum(List)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link ArrayList#ArrayList()} add ten.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#sum(List)}
   */
  @Test
  @DisplayName("Test sum(List); given ten; when ArrayList() add ten; then return ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Utils.sum(List)"})
  void testSum_givenTen_whenArrayListAddTen_thenReturnTen() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(10.0d);

    // Act and Assert
    assertEquals(10.0d, Utils.sum(in));
  }

  /**
   * Test {@link Utils#sum(List)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#sum(List)}
   */
  @Test
  @DisplayName("Test sum(List); given zero; when ArrayList() add zero; then return ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Utils.sum(List)"})
  void testSum_givenZero_whenArrayListAddZero_thenReturnTen() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(0.0d);
    in.add(10.0d);

    // Act and Assert
    assertEquals(10.0d, Utils.sum(in));
  }

  /**
   * Test {@link Utils#sum(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#sum(List)}
   */
  @Test
  @DisplayName("Test sum(List); when ArrayList(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Utils.sum(List)"})
  void testSum_whenArrayList_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, Utils.sum(new ArrayList<>()));
  }

  /**
   * Test {@link Utils#mean(List)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link ArrayList#ArrayList()} add ten.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#mean(List)}
   */
  @Test
  @DisplayName("Test mean(List); given ten; when ArrayList() add ten; then return ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Utils.mean(List)"})
  void testMean_givenTen_whenArrayListAddTen_thenReturnTen() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(10.0d);

    // Act and Assert
    assertEquals(10.0d, Utils.mean(in));
  }

  /**
   * Test {@link Utils#mean(List)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#mean(List)}
   */
  @Test
  @DisplayName("Test mean(List); given zero; when ArrayList() add zero; then return five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Utils.mean(List)"})
  void testMean_givenZero_whenArrayListAddZero_thenReturnFive() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(0.0d);
    in.add(10.0d);

    // Act and Assert
    assertEquals(5.0d, Utils.mean(in));
  }

  /**
   * Test {@link Utils#mean(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#mean(List)}
   */
  @Test
  @DisplayName("Test mean(List); when ArrayList(); then return NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Utils.mean(List)"})
  void testMean_whenArrayList_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, Utils.mean(new ArrayList<>()));
  }

  /**
   * Test {@link Utils#std(List)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link ArrayList#ArrayList()} add ten.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#std(List)}
   */
  @Test
  @DisplayName("Test std(List); given ten; when ArrayList() add ten; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Utils.std(List)"})
  void testStd_givenTen_whenArrayListAddTen_thenReturnZero() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(10.0d);

    // Act and Assert
    assertEquals(0.0d, Utils.std(in));
  }

  /**
   * Test {@link Utils#std(List)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#std(List)}
   */
  @Test
  @DisplayName("Test std(List); given zero; when ArrayList() add zero; then return five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Utils.std(List)"})
  void testStd_givenZero_whenArrayListAddZero_thenReturnFive() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(0.0d);
    in.add(10.0d);

    // Act and Assert
    assertEquals(5.0d, Utils.std(in));
  }

  /**
   * Test {@link Utils#std(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#std(List)}
   */
  @Test
  @DisplayName("Test std(List); when ArrayList(); then return NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Utils.std(List)"})
  void testStd_whenArrayList_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, Utils.std(new ArrayList<>()));
  }

  /**
   * Test {@link Utils#cumSum(List)}.
   * <ul>
   *   <li>Given {@code 0.5}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 0.5}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#cumSum(List)}
   */
  @Test
  @DisplayName("Test cumSum(List); given '0.5'; when ArrayList() add '0.5'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Utils.cumSum(List)"})
  void testCumSum_given05_whenArrayListAdd05_thenReturnSizeIsTwo() {
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
   * Test {@link Utils#cumSum(List)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link ArrayList#ArrayList()} add ten.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#cumSum(List)}
   */
  @Test
  @DisplayName("Test cumSum(List); given ten; when ArrayList() add ten; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Utils.cumSum(List)"})
  void testCumSum_givenTen_whenArrayListAddTen_thenReturnArrayList() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(10.0d);

    // Act
    List<Double> actualCumSumResult = Utils.cumSum(in);

    // Assert
    assertEquals(in, actualCumSumResult);
  }

  /**
   * Test {@link Utils#cumSum(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#cumSum(List)}
   */
  @Test
  @DisplayName("Test cumSum(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Utils.cumSum(List)"})
  void testCumSum_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Double> actualCumSumResult = Utils.cumSum(new ArrayList<>());

    // Assert
    assertTrue(actualCumSumResult.isEmpty());
  }

  /**
   * Test {@link Utils#ewm(List, int)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#ewm(List, int)}
   */
  @Test
  @DisplayName("Test ewm(List, int); given one; when ArrayList() add one; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Utils.ewm(List, int)"})
  void testEwm_givenOne_whenArrayListAddOne_thenReturnArrayList() {
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
   * Test {@link Utils#ewm(List, int)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#ewm(List, int)}
   */
  @Test
  @DisplayName("Test ewm(List, int); given two; when ArrayList() add two; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Utils.ewm(List, int)"})
  void testEwm_givenTwo_whenArrayListAddTwo_thenReturnArrayList() {
    // Arrange
    ArrayList<Double> in = new ArrayList<>();
    in.add(2.0d);

    // Act
    List<Double> actualEwmResult = Utils.ewm(in, 1);

    // Assert
    assertEquals(in, actualEwmResult);
  }

  /**
   * Test {@link Utils#ewm(List, int)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#ewm(List, int)}
   */
  @Test
  @DisplayName("Test ewm(List, int); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Utils.ewm(List, int)"})
  void testEwm_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Double> actualEwmResult = Utils.ewm(new ArrayList<>(), 1);

    // Assert
    assertTrue(actualEwmResult.isEmpty());
  }

  /**
   * Test {@link Utils#trueRange(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#trueRange(List)}
   */
  @Test
  @DisplayName("Test trueRange(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Utils.trueRange(List)"})
  void testTrueRange_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnSizeIsOne() {
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
   * Test {@link Utils#trueRange(List)}.
   * <ul>
   *   <li>Given {@link TradePeriod#TradePeriod()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#trueRange(List)}
   */
  @Test
  @DisplayName("Test trueRange(List); given TradePeriod(); when ArrayList() add TradePeriod(); then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Utils.trueRange(List)"})
  void testTrueRange_givenTradePeriod_whenArrayListAddTradePeriod_thenReturnSizeIsTwo() {
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
   * Test {@link Utils#trueRange(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#trueRange(List)}
   */
  @Test
  @DisplayName("Test trueRange(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Utils.trueRange(List)"})
  void testTrueRange_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Double> actualTrueRangeResult = Utils.trueRange(new ArrayList<>());

    // Assert
    assertTrue(actualTrueRangeResult.isEmpty());
  }

  /**
   * Test {@link Utils#diff(List)}.
   * <ul>
   *   <li>Given {@code 0.5}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 0.5}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#diff(List)}
   */
  @Test
  @DisplayName("Test diff(List); given '0.5'; when ArrayList() add '0.5'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Utils.diff(List)"})
  void testDiff_given05_whenArrayListAdd05_thenReturnSizeIsTwo() {
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
   * Test {@link Utils#diff(List)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link ArrayList#ArrayList()} add ten.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#diff(List)}
   */
  @Test
  @DisplayName("Test diff(List); given ten; when ArrayList() add ten; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Utils.diff(List)"})
  void testDiff_givenTen_whenArrayListAddTen_thenReturnSizeIsOne() {
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
   * Test {@link Utils#diff(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#diff(List)}
   */
  @Test
  @DisplayName("Test diff(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Utils.diff(List)"})
  void testDiff_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Double> actualDiffResult = Utils.diff(new ArrayList<>());

    // Assert
    assertTrue(actualDiffResult.isEmpty());
  }

  /**
   * Test {@link Utils#truePrice(TradePeriod)}.
   * <ul>
   *   <li>When {@link TradePeriod#TradePeriod()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#truePrice(TradePeriod)}
   */
  @Test
  @DisplayName("Test truePrice(TradePeriod); when TradePeriod(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Utils.truePrice(TradePeriod)"})
  void testTruePrice_whenTradePeriod_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, Utils.truePrice(new TradePeriod()));
  }

  /**
   * Test {@link Utils#sliding(List, long)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#sliding(List, long)}
   */
  @Test
  @DisplayName("Test sliding(List, long); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream Utils.sliding(List, long)"})
  void testSliding_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");

    // Act
    Stream<List<Object>> actualSlidingResult = Utils.sliding(list, 3L);

    // Assert
    assertTrue(actualSlidingResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Utils#sliding(List, long)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#sliding(List, long)}
   */
  @Test
  @DisplayName("Test sliding(List, long); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream Utils.sliding(List, long)"})
  void testSliding_given42_whenArrayListAdd422() {
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
   * Test {@link Utils#sliding(List, long)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#sliding(List, long)}
   */
  @Test
  @DisplayName("Test sliding(List, long); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream Utils.sliding(List, long)"})
  void testSliding_whenArrayList() {
    // Arrange and Act
    Stream<List<Object>> actualSlidingResult = Utils.sliding(new ArrayList<>(), 3L);

    // Assert
    assertTrue(actualSlidingResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Utils#expanding(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return limit five collect toList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#expanding(List)}
   */
  @Test
  @DisplayName("Test expanding(List); given '42'; then return limit five collect toList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream Utils.expanding(List)"})
  void testExpanding_given42_thenReturnLimitFiveCollectToListSizeIsOne() {
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

  /**
   * Test {@link Utils#expanding(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#expanding(List)}
   */
  @Test
  @DisplayName("Test expanding(List); given '42'; when ArrayList() add '42'; then return limit five collect toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream Utils.expanding(List)"})
  void testExpanding_given42_whenArrayListAdd42_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");

    // Act
    Stream<List<Object>> actualExpandingResult = Utils.expanding(list);

    // Assert
    assertTrue(actualExpandingResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Utils#expanding(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Utils#expanding(List)}
   */
  @Test
  @DisplayName("Test expanding(List); when ArrayList(); then return limit five collect toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream Utils.expanding(List)"})
  void testExpanding_whenArrayList_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<List<Object>> actualExpandingResult = Utils.expanding(new ArrayList<>());

    // Assert
    assertTrue(actualExpandingResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
