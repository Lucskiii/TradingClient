package uni.cs.tradingclient.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import uni.cs.tradingclient.model.User;
import uni.cs.tradingclient.persistence.CommunicationHandler;

/**
 *
 * @author lucakoelzsch
 */
public class UserDAO {

    private CommunicationHandler handler;

    public UserDAO() {
        handler = new CommunicationHandler();
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        List<Map<String, Object>> data = handler.executeQuery("SELECT * FROM Users");

        for (Map<String, Object> map : data) {
            User user = new User(
                    (Integer) map.get("User_ID"),
                    (String) map.get("Email"),
                    (String) map.get("FirstName"),
                    (String) map.get("LastName")
            );
            users.add(user);
        }
        return users;
    }

    public User getUserById(int id) {
        List<Map<String, Object>> data = handler.executeQuery("SELECT * FROM User WHERE User_ID = ?", id);
        if (data.isEmpty()) {
            return null;
        }
        Map<String, Object> map = data.get(0);
        return new User(
                (Integer) map.get("User_ID"),
                (String) map.get("Email"),
                (String) map.get("FirstName"),
                (String) map.get("LastName")
        );
    }

    public boolean saveUser(User user) {
        String sql = "INSERT INTO User (Email, IBAN, FirstName, LastName) VALUES (?, ?, ?, ?)";
        return handler.executeUpdate(sql, user.getEmail(), user.getFirstname(), user.getLastname());
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE User SET Email = ?, IBAN = ?, FirstName = ?, LastName = ? WHERE User_ID = ?";
        return handler.executeUpdate(sql, user.getEmail(), user.getFirstname(), user.getLastname(), user.getUserID());
    }

    public boolean deleteUser(int userId) {
        String sql = "DELETE FROM User WHERE User_ID = ?";
        return handler.executeUpdate(sql, userId);
    }

}
