package uni.cs.tradingclient.logic;

import uni.cs.tradingclient.model.User;

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
    }
    
}
