package uni.cs.tradingclient.logic;

import java.util.List;
import uni.cs.tradingclient.dao.service.*;
import uni.cs.tradingclient.model.*;
import uni.cs.tradingclient.persistence.ForeignKeyScanner;

/**
 *
 * @author lucakoelzsch
 */
public class Game {
    
    private UserService userService;
    private StockService stockService;
    private TransactionService transactionService;
    
    private List<User> users;
    private List<Stock> stocks;
    private List<Transaction> transactions;
    
    public Game() {
        init();
        
        //Services
        userService = new UserService();
        stockService = new StockService();
        transactionService = new TransactionService();
        
        //Lists
        users = userService.getAllUsers();
        stocks = stockService.getAllStocks();
        transactions = transactionService.getAllTransactions();
        
    }
    
    public boolean deleteStock(String isin) {
        return stockService.deleteStock(isin);
    }
    
    private void init() {
        ForeignKeyScanner.scanAndRegister("uni.cs.tradingclient.dao.implementation");
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    
 
}
