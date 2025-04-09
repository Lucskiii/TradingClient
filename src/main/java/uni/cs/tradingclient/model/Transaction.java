package uni.cs.tradingclient.model;

/**
 *
 * @author lucakoelzsch
 */
public class Transaction {
    
    private int transactionID, portfolioID;
    private String ISIN;
    private double transactionPrice;
    private int quanityChnge;

    public Transaction(int transactionID, int portfolioID, String ISIN, double transactionPrice, int quanityChnge) {
        this.transactionID = transactionID;
        this.portfolioID = portfolioID;
        this.ISIN = ISIN;
        this.transactionPrice = transactionPrice;
        this.quanityChnge = quanityChnge;
    }

    public Transaction() {
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getPortfolioID() {
        return portfolioID;
    }

    public void setPortfolioID(int portfolioID) {
        this.portfolioID = portfolioID;
    }

    public String getISIN() {
        return ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    public double getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(double transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    public int getQuanityChnge() {
        return quanityChnge;
    }

    public void setQuanityChnge(int quanityChnge) {
        this.quanityChnge = quanityChnge;
    }
    
    
    
}
