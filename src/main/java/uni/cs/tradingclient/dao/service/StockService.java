package uni.cs.tradingclient.dao.service;

import java.util.List;
import uni.cs.tradingclient.dao.implementation.StockDAO;
import uni.cs.tradingclient.model.Stock;

/**
 *
 * @author lucakoelzsch
 */
public class StockService {
    
    private StockDAO stockDAO;

    public StockService() {
        this.stockDAO = new StockDAO();
    }

    public List<Stock> getAllStocks() {
        return stockDAO.getAllStocks();
    }

    public Stock getStockByISIN(String isin) {
        return stockDAO.getStockByISIN(isin);
    }

    public boolean saveStock(Stock stock) {
        return stockDAO.saveStock(stock);
    }

    public boolean updateStock(Stock stock) {
        return stockDAO.updateStock(stock);
    }

    public boolean deleteStock(String isin) {
        return stockDAO.deleteStock(isin);
    }
}
