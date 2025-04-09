package uni.cs.tradingclient.dao.service;

import java.util.List;
import uni.cs.tradingclient.dao.implementation.PortfolioDAO;
import uni.cs.tradingclient.model.Portfolio;

/**
 *
 * @author lucakoelzsch
 */
public class PortfolioService {

    private PortfolioDAO portfolioDAO;

    public PortfolioService() {
        this.portfolioDAO = new PortfolioDAO();
    }

    public List<Portfolio> getAllPortfolios() {
        return portfolioDAO.getAllPortfolios();
    }

    public Portfolio getPortfolioById(int portfolioID) {
        return portfolioDAO.getPortfolioById(portfolioID);
    }

    public boolean savePortfolio(Portfolio portfolio) {
        return portfolioDAO.savePortfolio(portfolio);
    }

    public boolean updatePortfolio(Portfolio portfolio) {
        return portfolioDAO.updatePortfolio(portfolio);
    }

    public boolean deletePortfolio(int portfolioID) {
        return portfolioDAO.deletePortfolio(portfolioID);
    }
}
