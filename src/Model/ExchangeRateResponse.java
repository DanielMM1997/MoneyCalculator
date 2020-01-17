package Model;


import java.util.Date;
import java.util.Map;

public class ExchangeRateResponse {

    private Map<String, Double> rates;
    private String base;
    private Date date;

    public Map<String, Double> getRates() {
        return rates;
    }

    public String getBase() {
        return base;
    }

    public Date getDate() {
        return date;
    }

    public ExchangeRateResponse(Map<String, Double> rates, String base, Date date) {
        this.rates = rates;
        this.base = base;
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExchangeRateResponse{" +
                "rates=" + rates +
                ", base='" + base + '\'' +
                ", date=" + date +
                '}';
    }
}