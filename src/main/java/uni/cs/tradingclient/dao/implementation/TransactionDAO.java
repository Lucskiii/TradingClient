package uni.cs.tradingclient.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import uni.cs.tradingclient.model.Transaction;
import uni.cs.tradingclient.persistence.ReferencedBy;

/**
 *
 * @author lucakoelzsch
 */
@ReferencedBy(table = "Transaction", column = "ISIN")
public class TransactionDAO extends AbstractDAO {


    public TransactionDAO() {
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        List<Map<String, Object>> data = handler.executeQuery("SELECT * FROM Transactions");

        for (Map<String, Object> map : data) {
            Transaction transaction = new Transaction(
                    (Integer) map.get("Transaction_ID"),
                    (Integer) map.get("Portfolio_ID"),
                    (String) map.get("ISIN"),
                    (Double) map.get("Transaction_Price"),
                    (Integer) map.get("Quantity_Change")
            );
            transactions.add(transaction);
        }
        return transactions;
    }

    public Transaction getTransactionById(int transactionID) {
        List<Map<String, Object>> data = handler.executeQuery("SELECT * FROM Transaction WHERE Transaction_ID = ?", transactionID);
        if (data.isEmpty()) {
            return null;
        }
        Map<String, Object> map = data.get(0);
        return new Transaction(
                (Integer) map.get("Transaction_ID"),
                (Integer) map.get("Portfolio_ID"),
                (String) map.get("ISIN"),
                (Double) map.get("Transaction_Price"),
                (Integer) map.get("Quantity_Change")
        );
    }

    public boolean saveTransaction(Transaction transaction) {
        String sql = "INSERT INTO Transaction (Portfolio_ID, ISIN, Transaction_Price, Quantity_Change) VALUES (?, ?, ?, ?)";
        return handler.executeUpdate(sql, transaction.getPortfolioID(), transaction.getISIN(), transaction.getTransactionPrice(), transaction.getQuanityChnge());
    }

    public boolean updateTransaction(Transaction transaction) {
        String sql = "UPDATE Transaction SET Portfolio_ID = ?, ISIN = ?, Transaction_Price = ?, Quantity_Change = ? WHERE Transaction_ID = ?";
        return handler.executeUpdate(sql, transaction.getPortfolioID(), transaction.getISIN(), transaction.getTransactionPrice(), transaction.getQuanityChnge(), transaction.getTransactionID());
    }

    public boolean deleteTransaction(int transactionID) {
        String sql = "DELETE FROM Transaction WHERE Transaction_ID = ?";
        return handler.executeUpdate(sql, transactionID);
    }

    @Override
    protected String getTableName() {
        return "Transactions";
    }

    @Override
    protected String getPrimaryKeyColumnName() {
        return "Transaction_ID";
    }
}

