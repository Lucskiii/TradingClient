package uni.cs.tradingclient.logic;

import java.util.List;
import uni.cs.tradingclient.dao.service.UserService;
import uni.cs.tradingclient.model.*;

/**
 *
 * @author lucakoelzsch
 */
public class Game {
    
    private UserService userService;
    private List<User> users;
    
    public Game() {
        userService = new UserService();
        users = userService.getAllUsers();
    }

    public List<User> getUsers() {
        return users;
    }
    
    
    
}
