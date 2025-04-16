package uni.cs.tradingclient.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import uni.cs.tradingclient.persistence.CommunicationHandler;
import uni.cs.tradingclient.persistence.ForeignKeyRegistry;
import uni.cs.tradingclient.persistence.ReferencedBy;

/**
 *
 * @author lucakoelzsch
 */
public abstract class AbstractDAO {

    protected CommunicationHandler handler;

    protected abstract String getPrimaryKeyColumnName();

    public AbstractDAO() {
        handler = new CommunicationHandler();
    }

    protected boolean canDelete(Object id) {
        String table = getTableName();
        String column = getPrimaryKeyColumnName();

        if (!ForeignKeyRegistry.getReferences(table, column).isEmpty()) {
            System.err.println("Datensatz kann nicht gelöscht werden – Fremdschlüsselbeziehung vorhanden!");
            return false;
        }

        return true;
    }

    protected String getTableName() {
        ReferencedBy annotation = this.getClass().getAnnotation(ReferencedBy.class);
        if (annotation != null) {
            return annotation.table();
        }
        return null;
    }

}
