package uni.cs.tradingclient.dao.implementation;

import uni.cs.tradingclient.persistence.CommunicationHandler;
import uni.cs.tradingclient.persistence.ForeignKeyRegistry;

/**
 *
 * @author lucakoelzsch
 */
public abstract class AbstractDAO {

    protected CommunicationHandler handler;
    protected abstract String getTableName();

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

}
