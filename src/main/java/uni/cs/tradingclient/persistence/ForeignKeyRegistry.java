package uni.cs.tradingclient.persistence;

import java.util.*;
/**
 *
 * @author lucakoelzsch
 */
public class ForeignKeyRegistry {
    
    private static final Map<String, List<Reference>> references = new HashMap<>();

    public static void registerReference(String table, String column, Class<?> referringClass) {
        String key = table + "." + column;
        references.computeIfAbsent(key, k -> new ArrayList<>())
                  .add(new Reference(referringClass));
    }

    public static boolean isReferenced(String table, Object keyValue) {
        String lookupKeyPrefix = table + ".";
        for (String key : references.keySet()) {
            if (key.startsWith(lookupKeyPrefix)) {
                return true;
            }
        }
        return false;
    }

    public static List<Reference> getReferences(String table, String column) {
        return references.getOrDefault(table + "." + column, Collections.emptyList());
    }

    public record Reference(Class<?> referencingClass) {}
    
}
