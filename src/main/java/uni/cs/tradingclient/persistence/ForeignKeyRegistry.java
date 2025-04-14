package uni.cs.tradingclient.persistence;

import java.util.*;
/**
 *
 * @author lucakoelzsch
 */
public class ForeignKeyRegistry {

    private static final Map<String, Map<String, List<String>>> foreignKeyMap = new HashMap<>();

    static {
        foreignKeyMap.put("User", Map.of(
            "User_ID", List.of("Portfolio")
        ));

        foreignKeyMap.put("Portfolio", Map.of(
            "Portfolio_ID", List.of("Transaction")
        ));

        foreignKeyMap.put("Transaction", Map.of(
            "Transaction_ID", List.of("Portfolio")
        ));

        foreignKeyMap.put("Stock", Map.of(
            "ISIN", List.of("Transaction")
        ));
    }

    public static List<String> getReferencingTables(String tableName, String columnName) {
        return foreignKeyMap.getOrDefault(tableName, Map.of())
                            .getOrDefault(columnName, List.of());
    }
}
