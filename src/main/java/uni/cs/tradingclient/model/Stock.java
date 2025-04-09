package uni.cs.tradingclient.model;

/**
 *
 * @author lucakoelzsch
 */
public class Stock {
    
    private String ISIN, name;
    private double value;

    public Stock(String ISIN, String name, double value) {
        this.ISIN = ISIN;
        this.name = name;
        this.value = value;
    }

    public Stock() {
    }

    public String getISIN() {
        return ISIN;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    
    
    
}
