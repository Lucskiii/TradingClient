package uni.cs.tradingclient.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;

/**
 *
 * @author lucakoelzsch
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ReferencedBy.List.class)
public @interface ReferencedBy {

    String table();

    String column();

    @Retention(RetentionPolicy.RUNTIME)
    @interface List {

        ReferencedBy[] value();
    }
}
