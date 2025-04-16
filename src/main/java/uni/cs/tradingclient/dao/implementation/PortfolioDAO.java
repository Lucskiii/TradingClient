package uni.cs.tradingclient.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import uni.cs.tradingclient.model.Portfolio;
import uni.cs.tradingclient.persistence.ReferencedBy;

/**
 *
 * @author lucakoelzsch
 */
@ReferencedBy(table = "Transactions", column = "Portfolio_ID")
public class PortfolioDAO extends AbstractDAO {

    public PortfolioDAO() {
    }

    public List<Portfolio> getAllPortfolios() {
        List<Portfolio> portfolios = new ArrayList<>();
        List<Map<String, Object>> data = handler.executeQuery("SELECT * FROM Portfolios");

        for (Map<String, Object> map : data) {
            Portfolio portfolio = new Portfolio(
                    (Integer) map.get("Portfolio_ID"),
                    (Integer) map.get("User_ID")
            );
            portfolios.add(portfolio);
        }
        return portfolios;
    }

    public Portfolio getPortfolioById(int portfolioID) {
        List<Map<String, Object>> data = handler.executeQuery("SELECT * FROM Portfolios WHERE Portfolio_ID = ?", portfolioID);
        if (data.isEmpty()) {
            return null;
        }
        Map<String, Object> map = data.get(0);
        return new Portfolio(
                (Integer) map.get("Portfolio_ID"),
                (Integer) map.get("User_ID")
        );
    }

    public boolean savePortfolio(Portfolio portfolio) {
        String sql = "INSERT INTO Portfolios (Transaction_ID, User_ID) VALUES (?, ?)";
        return handler.executeUpdate(sql, portfolio.getUserID());
    }

    public boolean updatePortfolio(Portfolio portfolio) {
        String sql = "UPDATE Portfolios SET Transaction_ID = ?, User_ID = ? WHERE Portfolio_ID = ?";
        return handler.executeUpdate(sql, portfolio.getUserID(), portfolio.getPortfolioID());
    }

    public boolean deletePortfolio(int portfolioID) {
        if (!canDelete(portfolioID)) return false;
        
        String sql = "DELETE FROM Portfolios WHERE Portfolio_ID = ?";
        return handler.executeUpdate(sql, portfolioID);
    }

    @Override
    protected String getTableName() {
        return "Portfolios";
    }

    @Override
    protected String getPrimaryKeyColumnName() {
        return "Portfolio_ID";
    }
}
