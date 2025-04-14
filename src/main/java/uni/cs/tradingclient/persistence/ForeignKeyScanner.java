package uni.cs.tradingclient.persistence;

import java.util.Set;
import org.reflections.Reflections;

/**
 *
 * @author lucakoelzsch
 */
public class ForeignKeyScanner {
    
    public static void scanAndRegister(String basePackage) {
        Reflections reflections = new Reflections(basePackage);
        Set<Class<?>> daoClasses = reflections.getTypesAnnotatedWith(ReferencedBy.class, true);

        for (Class<?> daoClass : daoClasses) {
            ReferencedBy[] refs = daoClass.getAnnotationsByType(ReferencedBy.class);
            for (ReferencedBy ref : refs) {
                ForeignKeyRegistry.registerReference(ref.table(), ref.column(), daoClass);
            }
        }
    }
    
}
