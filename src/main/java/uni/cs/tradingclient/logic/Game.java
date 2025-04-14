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
    
    private List<User> users;
    private List<Stock> stocks;
    
    public Game() {
        init();
        
        
        userService = new UserService();
        stockService = new StockService();
        
        users = userService.getAllUsers();
        stocks = stockService.getAllStocks();
        
        
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
 
}
