package uni.cs.tradingclient.model;

/**
 *
 * @author lucakoelzsch
 */
public class Portfolio {

    private int portfolioID, transactionID, userID;

    public Portfolio(int portfolioID, int transactionID, int userID) {
        this.portfolioID = portfolioID;
        this.transactionID = transactionID;
        this.userID = userID;
    }

    public Portfolio() {
    }

    public int getPortfolioID() {
        return portfolioID;
    }

    public void setPortfolioID(int portfolioID) {
        this.portfolioID = portfolioID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
