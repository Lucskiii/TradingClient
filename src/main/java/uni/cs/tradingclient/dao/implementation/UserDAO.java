package uni.cs.tradingclient.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import uni.cs.tradingclient.model.User;
import uni.cs.tradingclient.persistence.ReferencedBy;

/**
 *
 * @author lucakoelzsch
 */
@ReferencedBy(table = "Portfolio", column = "User_ID")
public class UserDAO extends AbstractDAO {


    public UserDAO() {
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
        String sql = "INSERT INTO Users (Email, IBAN, FirstName, LastName) VALUES (?, ?, ?, ?)";
        return handler.executeUpdate(sql, user.getEmail(), user.getFirstname(), user.getLastname());
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE Users SET Email = ?, IBAN = ?, FirstName = ?, LastName = ? WHERE User_ID = ?";
        return handler.executeUpdate(sql, user.getEmail(), user.getFirstname(), user.getLastname(), user.getUserID());
    }

    public boolean deleteUser(int userId) {
        if (!canDelete(userId)) return false;
        
        String sql = "DELETE FROM Users WHERE User_ID = ?";
        return handler.executeUpdate(sql, userId);
    }

    @Override
    protected String getPrimaryKeyColumnName() {
        return "User_ID";
    }

}
