package uni.cs.tradingclient.model;

/**
 *
 * @author lucakoelzsch
 */
public class Portfolio {

    private int portfolioID, userID;

    public Portfolio(int portfolioID, int userID) {
        this.portfolioID = portfolioID;
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
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
