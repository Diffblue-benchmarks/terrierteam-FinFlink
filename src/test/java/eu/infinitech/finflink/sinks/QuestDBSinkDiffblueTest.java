package eu.infinitech.finflink.sinks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import eu.infinitech.finflink.transformations.data.ToTradeFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class QuestDBSinkDiffblueTest {
  /**
   * Test {@link QuestDBSink#QuestDBSink(String, List)}.
   *
   * <ul>
   *   <li>Given createValidTradeDataString.
   * </ul>
   *
   * <p>Method under test: {@link QuestDBSink#QuestDBSink(String, List)}
   */
  @Test
  @DisplayName("Test new QuestDBSink(String, List); given createValidTradeDataString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QuestDBSink.<init>(String, List)"})
  void testNewQuestDBSink_givenCreateValidTradeDataString() {
    // Arrange
    String dbUrl = ToTradeFactory.createValidTradeDataString();

    ArrayList<String> columNames = new ArrayList<>();
    columNames.add(ToTradeFactory.createValidTradeDataString());

    // Act
    QuestDBSink actualQuestDBSink = new QuestDBSink(dbUrl, columNames);

    // Assert
    assertEquals("BTC,1640000000,50000.0,100", actualQuestDBSink.getDbUrl());
    assertSame(columNames, actualQuestDBSink.getColumNames());
  }

  /**
   * Test {@link QuestDBSink#QuestDBSink(String, List)}.
   *
   * <ul>
   *   <li>Given {@code QUESTDB_SERVICE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code QUESTDB_SERVICE}.
   * </ul>
   *
   * <p>Method under test: {@link QuestDBSink#QuestDBSink(String, List)}
   */
  @Test
  @DisplayName(
      "Test new QuestDBSink(String, List); given 'QUESTDB_SERVICE'; when ArrayList() add 'QUESTDB_SERVICE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QuestDBSink.<init>(String, List)"})
  void testNewQuestDBSink_givenQuestdbService_whenArrayListAddQuestdbService() {
    // Arrange
    String dbUrl = ToTradeFactory.createValidTradeDataString();

    ArrayList<String> columNames = new ArrayList<>();
    columNames.add("QUESTDB_SERVICE");
    columNames.add(ToTradeFactory.createValidTradeDataString());

    // Act
    QuestDBSink actualQuestDBSink = new QuestDBSink(dbUrl, columNames);

    // Assert
    assertEquals("BTC,1640000000,50000.0,100", actualQuestDBSink.getDbUrl());
    assertSame(columNames, actualQuestDBSink.getColumNames());
  }

  /**
   * Test {@link QuestDBSink#QuestDBSink(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return ColumNames Empty.
   * </ul>
   *
   * <p>Method under test: {@link QuestDBSink#QuestDBSink(String, List)}
   */
  @Test
  @DisplayName("Test new QuestDBSink(String, List); when ArrayList(); then return ColumNames Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QuestDBSink.<init>(String, List)"})
  void testNewQuestDBSink_whenArrayList_thenReturnColumNamesEmpty() {
    // Arrange
    String dbUrl = ToTradeFactory.createValidTradeDataString();
    ArrayList<String> columNames = new ArrayList<>();

    // Act
    QuestDBSink actualQuestDBSink = new QuestDBSink(dbUrl, columNames);

    // Assert
    assertEquals("BTC,1640000000,50000.0,100", actualQuestDBSink.getDbUrl());
    List columNames2 = actualQuestDBSink.getColumNames();
    assertTrue(columNames2.isEmpty());
    assertSame(columNames, columNames2);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QuestDBSink#getColumNames()}
   *   <li>{@link QuestDBSink#getDbUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List QuestDBSink.getColumNames()", "String QuestDBSink.getDbUrl()"})
  void testGettersAndSetters() {
    // Arrange
    String dbUrl = ToTradeFactory.createValidTradeDataString();
    ArrayList<String> columNames = new ArrayList<>();

    QuestDBSink questDBSink = new QuestDBSink(dbUrl, columNames);

    // Act
    List actualColumNames = questDBSink.getColumNames();

    // Assert
    assertEquals("BTC,1640000000,50000.0,100", questDBSink.getDbUrl());
    assertSame(columNames, actualColumNames);
  }
}
