package uni.cs.tradingclient.logic;

import uni.cs.tradingclient.model.*;

/**
 *
 * @author lucakoelzsch
 */
public class Main {
    
    
    
    public static void main(String[] args) {
        Game game = new Game();
        
        for (User user : game.getUsers()) {
            System.out.println("Name: " + user.getFirstname() + " " + user.getLastname());
        }
        
        for (Stock stock : game.getStocks()) {
            System.out.println("Name: " + stock.getName());
        }
    }
    
}
