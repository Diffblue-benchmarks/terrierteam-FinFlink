package eu.infinitech.finflink.transformations.technicalIndicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import eu.infinitech.finflink.structures.InputStreamType;
import eu.infinitech.finflink.structures.PricePoint;
import eu.infinitech.finflink.structures.TechnicalIndicator;
import eu.infinitech.finflink.structures.TradingData;
import eu.infinitech.finflink.structures.TradingDataAccumulator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.junit.jupiter.api.Test;

class TechnicalIndicatorPipelineDiffblueTest {
  /**
   * Method under test:
   * {@link TechnicalIndicatorPipeline#add(TradingData, TradingDataAccumulator)}
   */
  @Test
  void testAdd() {
    // Arrange
    TechnicalIndicatorPipeline technicalIndicatorPipeline = new TechnicalIndicatorPipeline();
    PricePoint value = new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1);

    TradingDataAccumulator accumulator = new TradingDataAccumulator();

    // Act and Assert
    assertSame(accumulator, technicalIndicatorPipeline.add(value, accumulator));
  }

  /**
   * Method under test:
   * {@link TechnicalIndicatorPipeline#getResult(TradingDataAccumulator)}
   */
  @Test
  void testGetResult() {
    // Arrange
    TechnicalIndicatorPipeline technicalIndicatorPipeline = new TechnicalIndicatorPipeline();
    technicalIndicatorPipeline.setPipeline(new ArrayList<>());

    // Act and Assert
    assertTrue(technicalIndicatorPipeline.getResult(new TradingDataAccumulator()).getIndicators().isEmpty());
  }

  /**
   * Method under test:
   * {@link TechnicalIndicatorPipeline#getResult(TradingDataAccumulator)}
   */
  @Test
  void testGetResult2() {
    // Arrange
    ArrayList<TechnicalIndicatorGenerator> pipeline = new ArrayList<>();
    pipeline.add(new AverageDirectionalIndex());

    TechnicalIndicatorPipeline technicalIndicatorPipeline = new TechnicalIndicatorPipeline();
    technicalIndicatorPipeline.setPipeline(pipeline);

    // Act and Assert
    List<TechnicalIndicator> indicators = technicalIndicatorPipeline.getResult(new TradingDataAccumulator())
        .getIndicators();
    assertEquals(1, indicators.size());
    TechnicalIndicator getResult = indicators.get(0);
    assertEquals("null-AverageDirectionalIndex-0.0", getResult.getName());
    assertTrue(getResult.getProperties().isEmpty());
    assertEquals(Double.NaN, getResult.getValue());
  }

  /**
   * Method under test:
   * {@link TechnicalIndicatorPipeline#getResult(TradingDataAccumulator)}
   */
  @Test
  void testGetResult3() {
    // Arrange
    ArrayList<TechnicalIndicatorGenerator> pipeline = new ArrayList<>();
    pipeline.add(new AccumulationDistributionIndex(Time.of(3L, TimeUnit.NANOSECONDS)));

    TechnicalIndicatorPipeline technicalIndicatorPipeline = new TechnicalIndicatorPipeline();
    technicalIndicatorPipeline.setPipeline(pipeline);

    // Act and Assert
    List<TechnicalIndicator> indicators = technicalIndicatorPipeline.getResult(new TradingDataAccumulator())
        .getIndicators();
    assertEquals(1, indicators.size());
    TechnicalIndicator getResult = indicators.get(0);
    assertEquals("null-AccumulationDistributionIndex-0.0", getResult.getName());
    assertEquals(0.0d, getResult.getValue());
    assertTrue(getResult.getProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link TechnicalIndicatorPipeline#getResult(TradingDataAccumulator)}
   */
  @Test
  void testGetResult4() {
    // Arrange
    AverageDirectionalIndex averageDirectionalIndex = new AverageDirectionalIndex();
    averageDirectionalIndex.setTimePeriod(10L);

    ArrayList<TechnicalIndicatorGenerator> pipeline = new ArrayList<>();
    pipeline.add(averageDirectionalIndex);
    InputStreamType inputStreamType = InputStreamType.pricePoint("Asset");

    TechnicalIndicatorPipeline technicalIndicatorPipeline = new TechnicalIndicatorPipeline("Pipeline ID",
        inputStreamType, new ArrayList<>());
    technicalIndicatorPipeline.setPipeline(pipeline);

    ArrayList<TradingData> tradingData = new ArrayList<>();
    tradingData.add(new PricePoint(1L, 10.0d, 10.0d, 10.0d, 10.0d, 1L, (short) 1));

    TradingDataAccumulator accumulator = new TradingDataAccumulator();
    accumulator.setTradingData(tradingData);

    // Act and Assert
    List<TechnicalIndicator> indicators = technicalIndicatorPipeline.getResult(accumulator).getIndicators();
    assertEquals(1, indicators.size());
    TechnicalIndicator getResult = indicators.get(0);
    assertEquals("Pipeline ID-AverageDirectionalIndex-0.16666666666666666", getResult.getName());
    assertTrue(getResult.getProperties().isEmpty());
    assertEquals(Double.NaN, getResult.getValue());
  }

  /**
   * Method under test:
   * {@link TechnicalIndicatorPipeline#merge(TradingDataAccumulator, TradingDataAccumulator)}
   */
  @Test
  void testMerge() {
    // Arrange
    TechnicalIndicatorPipeline technicalIndicatorPipeline = new TechnicalIndicatorPipeline();
    TradingDataAccumulator a = new TradingDataAccumulator();

    // Act and Assert
    assertTrue(technicalIndicatorPipeline.merge(a, new TradingDataAccumulator()).getTradingData().isEmpty());
  }

  /**
   * Method under test: {@link TechnicalIndicatorPipeline#createAccumulator()}
   */
  @Test
  void testCreateAccumulator() {
    // Arrange, Act and Assert
    assertTrue((new TechnicalIndicatorPipeline()).createAccumulator().getTradingData().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TechnicalIndicatorPipeline#TechnicalIndicatorPipeline()}
   *   <li>{@link TechnicalIndicatorPipeline#setPipeline(List)}
   *   <li>{@link TechnicalIndicatorPipeline#setPipelineID(String)}
   *   <li>{@link TechnicalIndicatorPipeline#getPipeline()}
   *   <li>{@link TechnicalIndicatorPipeline#getPipelineID()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TechnicalIndicatorPipeline actualTechnicalIndicatorPipeline = new TechnicalIndicatorPipeline();
    ArrayList<TechnicalIndicatorGenerator> pipeline = new ArrayList<>();
    actualTechnicalIndicatorPipeline.setPipeline(pipeline);
    actualTechnicalIndicatorPipeline.setPipelineID("Pipeline ID");
    List<TechnicalIndicatorGenerator> actualPipeline = actualTechnicalIndicatorPipeline.getPipeline();

    // Assert that nothing has changed
    assertEquals("Pipeline ID", actualTechnicalIndicatorPipeline.getPipelineID());
    assertTrue(actualPipeline.isEmpty());
    assertSame(pipeline, actualPipeline);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TechnicalIndicatorPipeline#TechnicalIndicatorPipeline(String, InputStreamType, List)}
   *   <li>{@link TechnicalIndicatorPipeline#setPipeline(List)}
   *   <li>{@link TechnicalIndicatorPipeline#setPipelineID(String)}
   *   <li>{@link TechnicalIndicatorPipeline#getPipeline()}
   *   <li>{@link TechnicalIndicatorPipeline#getPipelineID()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    InputStreamType inputStreamType = InputStreamType.trade();

    // Act
    TechnicalIndicatorPipeline actualTechnicalIndicatorPipeline = new TechnicalIndicatorPipeline("Pipeline ID",
        inputStreamType, new ArrayList<>());
    ArrayList<TechnicalIndicatorGenerator> pipeline = new ArrayList<>();
    actualTechnicalIndicatorPipeline.setPipeline(pipeline);
    actualTechnicalIndicatorPipeline.setPipelineID("Pipeline ID");
    List<TechnicalIndicatorGenerator> actualPipeline = actualTechnicalIndicatorPipeline.getPipeline();

    // Assert that nothing has changed
    assertEquals("Pipeline ID", actualTechnicalIndicatorPipeline.getPipelineID());
    assertEquals(InputStreamType.Type.Trade, actualTechnicalIndicatorPipeline.inputStreamType.getType());
    assertTrue(actualPipeline.isEmpty());
    assertSame(pipeline, actualPipeline);
  }
}
