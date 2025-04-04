package uni.cs.tradingclient.dao.service;

import java.util.List;
import uni.cs.tradingclient.dao.implementation.UserDAO;
import uni.cs.tradingclient.model.User;

/**
 *
 * @author lucakoelzsch
 */
public class UserService {
    
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    public boolean saveUser(User user) {
        return userDAO.saveUser(user);
    }

    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public boolean deleteUser(int userId) {
        return userDAO.deleteUser(userId);
    }
    
}
