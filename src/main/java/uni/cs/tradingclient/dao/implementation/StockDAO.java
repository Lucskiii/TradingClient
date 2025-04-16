package uni.cs.tradingclient.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import uni.cs.tradingclient.model.Stock;
import uni.cs.tradingclient.persistence.ReferencedBy;

/**
 *
 * @author lucakoelzsch
 */
@ReferencedBy(table = "Transactions", column = "ISIN")
public class StockDAO extends AbstractDAO {

    public StockDAO() {
    }

    public List<Stock> getAllStocks() {
        List<Stock> stocks = new ArrayList<>();
        List<Map<String, Object>> data = handler.executeQuery("SELECT * FROM Stocks");

        for (Map<String, Object> map : data) {
            Stock stock = new Stock(
                    (String) map.get("ISIN"),
                    (String) map.get("Name"),
                    (Double) map.get("Value")
            );
            stocks.add(stock);
        }
        return stocks;
    }

    public Stock getStockByISIN(String isin) {
        List<Map<String, Object>> data = handler.executeQuery("SELECT * FROM Stocks WHERE ISIN = ?", isin);
        if (data.isEmpty()) {
            return null;
        }
        Map<String, Object> map = data.get(0);
        return new Stock(
                (String) map.get("ISIN"),
                (String) map.get("Name"),
                (Double) map.get("Value")
        );
    }

    public boolean saveStock(Stock stock) {
        String sql = "INSERT INTO Stock (ISIN, Name, Value) VALUES (?, ?, ?)";
        return handler.executeUpdate(sql, stock.getISIN(), stock.getName(), stock.getValue());
    }

    public boolean updateStock(Stock stock) {
        String sql = "UPDATE Stock SET Name = ?, Value = ? WHERE ISIN = ?";
        return handler.executeUpdate(sql, stock.getName(), stock.getValue(), stock.getISIN());
    }

    public boolean deleteStock(String isin) {
        String sql = "DELETE FROM Stock WHERE ISIN = ?";
        return handler.executeUpdate(sql, isin);
    }

    @Override
    protected String getTableName() {
        return "Stocks";
    }

    @Override
    protected String getPrimaryKeyColumnName() {
        return "ISIN";
    }
}
