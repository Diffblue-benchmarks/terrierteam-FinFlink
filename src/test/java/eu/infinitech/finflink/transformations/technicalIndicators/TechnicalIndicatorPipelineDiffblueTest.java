package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.structures.InputStreamType;
import eu.infinitech.finflink.structures.InputStreamType.Type;
import eu.infinitech.finflink.structures.PricePoint;
import eu.infinitech.finflink.structures.TechnicalIndicator;
import eu.infinitech.finflink.structures.TechnicalIndicators;
import eu.infinitech.finflink.structures.TradingData;
import eu.infinitech.finflink.structures.TradingDataAccumulator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TechnicalIndicatorPipelineDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TechnicalIndicatorPipeline#TechnicalIndicatorPipeline()}
   *   <li>{@link TechnicalIndicatorPipeline#setPipeline(List)}
   *   <li>{@link TechnicalIndicatorPipeline#setPipelineID(String)}
   *   <li>{@link TechnicalIndicatorPipeline#getPipeline()}
   *   <li>{@link TechnicalIndicatorPipeline#getPipelineID()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TechnicalIndicatorPipeline.<init>()",
    "void TechnicalIndicatorPipeline.<init>(String, InputStreamType, List)",
    "List TechnicalIndicatorPipeline.getPipeline()",
    "String TechnicalIndicatorPipeline.getPipelineID()",
    "void TechnicalIndicatorPipeline.setPipeline(List)",
    "void TechnicalIndicatorPipeline.setPipelineID(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TechnicalIndicatorPipeline actualTechnicalIndicatorPipeline = new TechnicalIndicatorPipeline();
    ArrayList<TechnicalIndicatorGenerator> pipeline = new ArrayList<>();
    actualTechnicalIndicatorPipeline.setPipeline(pipeline);
    actualTechnicalIndicatorPipeline.setPipelineID("Pipeline ID");
    List<TechnicalIndicatorGenerator> actualPipeline =
        actualTechnicalIndicatorPipeline.getPipeline();

    // Assert
    assertEquals("Pipeline ID", actualTechnicalIndicatorPipeline.getPipelineID());
    assertTrue(actualPipeline.isEmpty());
    assertSame(pipeline, actualPipeline);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Pipeline ID}.
   *   <li>Then return {@link TechnicalIndicatorPipeline#inputStreamType} Asset is {@code Asset}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TechnicalIndicatorPipeline#TechnicalIndicatorPipeline(String, InputStreamType,
   *       List)}
   *   <li>{@link TechnicalIndicatorPipeline#setPipeline(List)}
   *   <li>{@link TechnicalIndicatorPipeline#setPipelineID(String)}
   *   <li>{@link TechnicalIndicatorPipeline#getPipeline()}
   *   <li>{@link TechnicalIndicatorPipeline#getPipelineID()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'Pipeline ID'; then return inputStreamType Asset is 'Asset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TechnicalIndicatorPipeline.<init>()",
    "void TechnicalIndicatorPipeline.<init>(String, InputStreamType, List)",
    "List TechnicalIndicatorPipeline.getPipeline()",
    "String TechnicalIndicatorPipeline.getPipelineID()",
    "void TechnicalIndicatorPipeline.setPipeline(List)",
    "void TechnicalIndicatorPipeline.setPipelineID(String)"
  })
  void testGettersAndSetters_whenPipelineId_thenReturnInputStreamTypeAssetIsAsset() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    // Act
    TechnicalIndicatorPipeline actualTechnicalIndicatorPipeline =
        new TechnicalIndicatorPipeline("Pipeline ID", inputStreamType, new ArrayList<>());
    ArrayList<TechnicalIndicatorGenerator> pipeline = new ArrayList<>();
    actualTechnicalIndicatorPipeline.setPipeline(pipeline);
    actualTechnicalIndicatorPipeline.setPipelineID("Pipeline ID");
    List<TechnicalIndicatorGenerator> actualPipeline =
        actualTechnicalIndicatorPipeline.getPipeline();
    String actualPipelineID = actualTechnicalIndicatorPipeline.getPipelineID();

    // Assert
    InputStreamType inputStreamType2 = actualTechnicalIndicatorPipeline.inputStreamType;
    assertEquals("Asset", inputStreamType2.getAsset());
    assertEquals("Pipeline ID", actualPipelineID);
    assertEquals(Type.PricePoint, inputStreamType2.getType());
    assertTrue(actualPipeline.isEmpty());
    assertSame(pipeline, actualPipeline);
  }

  /**
   * Test {@link TechnicalIndicatorPipeline#add(TradingData, TradingDataAccumulator)} with {@code
   * TradingData}, {@code TradingDataAccumulator}.
   *
   * <ul>
   *   <li>Then return {@link TradingDataAccumulator#TradingDataAccumulator()}.
   * </ul>
   *
   * <p>Method under test: {@link TechnicalIndicatorPipeline#add(TradingData,
   * TradingDataAccumulator)}
   */
  @Test
  @DisplayName(
      "Test add(TradingData, TradingDataAccumulator) with 'TradingData', 'TradingDataAccumulator'; then return TradingDataAccumulator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TradingDataAccumulator TechnicalIndicatorPipeline.add(TradingData, TradingDataAccumulator)"
  })
  void testAddWithTradingDataTradingDataAccumulator_thenReturnTradingDataAccumulator() {
    // Arrange
    TechnicalIndicatorPipeline technicalIndicatorPipeline = new TechnicalIndicatorPipeline();
    PricePoint value = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    TradingDataAccumulator accumulator = new TradingDataAccumulator();

    // Act
    TradingDataAccumulator actualAddResult = technicalIndicatorPipeline.add(value, accumulator);

    // Assert
    assertSame(accumulator, actualAddResult);
  }

  /**
   * Test {@link TechnicalIndicatorPipeline#getResult(TradingDataAccumulator)} with {@code
   * TradingDataAccumulator}.
   *
   * <p>Method under test: {@link TechnicalIndicatorPipeline#getResult(TradingDataAccumulator)}
   */
  @Test
  @DisplayName("Test getResult(TradingDataAccumulator) with 'TradingDataAccumulator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TechnicalIndicators TechnicalIndicatorPipeline.getResult(TradingDataAccumulator)"
  })
  void testGetResultWithTradingDataAccumulator() {
    // Arrange
    ArrayList<TechnicalIndicatorGenerator> pipeline = new ArrayList<>();
    pipeline.add(new AverageDirectionalIndex());

    TechnicalIndicatorPipeline technicalIndicatorPipeline = new TechnicalIndicatorPipeline();
    technicalIndicatorPipeline.setPipeline(pipeline);

    // Act and Assert
    List<TechnicalIndicator> indicators =
        technicalIndicatorPipeline.getResult(new TradingDataAccumulator()).getIndicators();
    assertEquals(1, indicators.size());
    TechnicalIndicator getResult = indicators.get(0);
    assertEquals("null-AverageDirectionalIndex-0.0", getResult.getName());
    assertTrue(getResult.getProperties().isEmpty());
    assertEquals(Double.NaN, getResult.getValue());
  }

  /**
   * Test {@link TechnicalIndicatorPipeline#getResult(TradingDataAccumulator)} with {@code
   * TradingDataAccumulator}.
   *
   * <p>Method under test: {@link TechnicalIndicatorPipeline#getResult(TradingDataAccumulator)}
   */
  @Test
  @DisplayName("Test getResult(TradingDataAccumulator) with 'TradingDataAccumulator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TechnicalIndicators TechnicalIndicatorPipeline.getResult(TradingDataAccumulator)"
  })
  void testGetResultWithTradingDataAccumulator2() {
    // Arrange
    ArrayList<TechnicalIndicatorGenerator> pipeline = new ArrayList<>();
    Time timePeriod = Time.of(3L, TimeUnit.NANOSECONDS);
    pipeline.add(new AccumulationDistributionIndex(timePeriod));

    TechnicalIndicatorPipeline technicalIndicatorPipeline = new TechnicalIndicatorPipeline();
    technicalIndicatorPipeline.setPipeline(pipeline);

    // Act and Assert
    List<TechnicalIndicator> indicators =
        technicalIndicatorPipeline.getResult(new TradingDataAccumulator()).getIndicators();
    assertEquals(1, indicators.size());
    TechnicalIndicator getResult = indicators.get(0);
    assertEquals("null-AccumulationDistributionIndex-0.0", getResult.getName());
    assertEquals(0.0d, getResult.getValue());
    assertTrue(getResult.getProperties().isEmpty());
  }

  /**
   * Test {@link TechnicalIndicatorPipeline#getResult(TradingDataAccumulator)} with {@code
   * TradingDataAccumulator}.
   *
   * <p>Method under test: {@link TechnicalIndicatorPipeline#getResult(TradingDataAccumulator)}
   */
  @Test
  @DisplayName("Test getResult(TradingDataAccumulator) with 'TradingDataAccumulator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TechnicalIndicators TechnicalIndicatorPipeline.getResult(TradingDataAccumulator)"
  })
  void testGetResultWithTradingDataAccumulator3() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();
    averageDirectionalIndex.setTimePeriod(10L);

    ArrayList<TechnicalIndicatorGenerator> pipeline = new ArrayList<>();
    pipeline.add(averageDirectionalIndex);
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    TechnicalIndicatorPipeline technicalIndicatorPipeline =
        new TechnicalIndicatorPipeline("Pipeline ID", inputStreamType, new ArrayList<>());
    technicalIndicatorPipeline.setPipeline(pipeline);

    ArrayList<TradingData> tradingData = new ArrayList<>();
    PricePoint pricePoint = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);
    tradingData.add(pricePoint);

    // Act
    TechnicalIndicators actualResult =
        technicalIndicatorPipeline.getResult(new TradingDataAccumulator(tradingData));

    // Assert
    List<TechnicalIndicator> indicators = actualResult.getIndicators();
    assertEquals(1, indicators.size());
    TechnicalIndicator getResult = indicators.get(0);
    assertEquals("Pipeline ID-AverageDirectionalIndex-0.16666666666666666", getResult.getName());
    assertTrue(getResult.getProperties().isEmpty());
    assertEquals(Double.NaN, getResult.getValue());
  }

  /**
   * Test {@link TechnicalIndicatorPipeline#getResult(TradingDataAccumulator)} with {@code
   * TradingDataAccumulator}.
   *
   * <ul>
   *   <li>Then return Indicators Empty.
   * </ul>
   *
   * <p>Method under test: {@link TechnicalIndicatorPipeline#getResult(TradingDataAccumulator)}
   */
  @Test
  @DisplayName(
      "Test getResult(TradingDataAccumulator) with 'TradingDataAccumulator'; then return Indicators Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TechnicalIndicators TechnicalIndicatorPipeline.getResult(TradingDataAccumulator)"
  })
  void testGetResultWithTradingDataAccumulator_thenReturnIndicatorsEmpty() {
    // Arrange
    TechnicalIndicatorPipeline technicalIndicatorPipeline = new TechnicalIndicatorPipeline();
    technicalIndicatorPipeline.setPipeline(new ArrayList<>());

    // Act and Assert
    assertTrue(
        technicalIndicatorPipeline
            .getResult(new TradingDataAccumulator())
            .getIndicators()
            .isEmpty());
  }

  /**
   * Test {@link TechnicalIndicatorPipeline#merge(TradingDataAccumulator, TradingDataAccumulator)}
   * with {@code TradingDataAccumulator}, {@code TradingDataAccumulator}.
   *
   * <p>Method under test: {@link TechnicalIndicatorPipeline#merge(TradingDataAccumulator,
   * TradingDataAccumulator)}
   */
  @Test
  @DisplayName(
      "Test merge(TradingDataAccumulator, TradingDataAccumulator) with 'TradingDataAccumulator', 'TradingDataAccumulator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TradingDataAccumulator TechnicalIndicatorPipeline.merge(TradingDataAccumulator, TradingDataAccumulator)"
  })
  void testMergeWithTradingDataAccumulatorTradingDataAccumulator() {
    // Arrange
    TechnicalIndicatorPipeline technicalIndicatorPipeline = new TechnicalIndicatorPipeline();
    TradingDataAccumulator a = new TradingDataAccumulator();

    // Act and Assert
    assertTrue(
        technicalIndicatorPipeline
            .merge(a, new TradingDataAccumulator())
            .getTradingData()
            .isEmpty());
  }

  /**
   * Test {@link TechnicalIndicatorPipeline#createAccumulator()}.
   *
   * <p>Method under test: {@link TechnicalIndicatorPipeline#createAccumulator()}
   */
  @Test
  @DisplayName("Test createAccumulator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TradingDataAccumulator TechnicalIndicatorPipeline.createAccumulator()"})
  void testCreateAccumulator() {
    // Arrange, Act and Assert
    assertTrue(new TechnicalIndicatorPipeline().createAccumulator().getTradingData().isEmpty());
  }
}
