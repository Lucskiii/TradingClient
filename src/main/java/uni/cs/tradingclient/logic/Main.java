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
        
        for (Transaction transaction : game.getTransactions()) {
            System.out.println("Aktien in Transaktion: " + transaction.getISIN());
        }
        
        try {
            game.deleteStock("DE0005190003");
        } catch (Exception e) {
            System.out.println("Löschen fehlgeschlagen");
        }
       

        
    }
    
}
