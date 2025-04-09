package uni.cs.tradingclient.dao.service;

import java.util.List;
import uni.cs.tradingclient.dao.implementation.TransactionDAO;
import uni.cs.tradingclient.model.Transaction;

/**
 *
 * @author lucakoelzsch
 */
public class TransactionService {

    private TransactionDAO transactionDAO;

    public TransactionService() {
        this.transactionDAO = new TransactionDAO();
    }

    public List<Transaction> getAllTransactions() {
        return transactionDAO.getAllTransactions();
    }

    public Transaction getTransactionById(int transactionID) {
        return transactionDAO.getTransactionById(transactionID);
    }

    public boolean saveTransaction(Transaction transaction) {
        return transactionDAO.saveTransaction(transaction);
    }

    public boolean updateTransaction(Transaction transaction) {
        return transactionDAO.updateTransaction(transaction);
    }

    public boolean deleteTransaction(int transactionID) {
        return transactionDAO.deleteTransaction(transactionID);
    }
}
