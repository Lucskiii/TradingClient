package uni.cs.tradingclient.dao.implementation;

import uni.cs.tradingclient.persistence.ForeignKeyRegistry;

/**
 *
 * @author lucakoelzsch
 */
public abstract class AbstractDAO {

    protected abstract String getTableName();

    protected abstract String getPrimaryKeyColumnName();

    // Diese Methode muss von der konkreten DAO aufgerufen werden, bevor DELETE passiert
    protected boolean canDelete(Object id) {
        String table = getTableName();
        String column = getPrimaryKeyColumnName();

        if (!ForeignKeyRegistry.getReferences(table, column).isEmpty()) {
            System.err.println("Datensatz kann nicht gelöscht werden – Fremdschlüsselbeziehung vorhanden!");
            return false;
        }

        return true;
    }

    // Optional: du kannst hier auch direkt ein delete() Template implementieren
    public abstract boolean delete(Object id);

}
