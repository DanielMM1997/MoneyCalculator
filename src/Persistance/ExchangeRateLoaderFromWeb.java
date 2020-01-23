package Persistance;

import Model.Currency;
import Model.ExchangeRate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ExchangeRateLoaderFromWeb implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            URL url = new URL("https://api.exchangeratesapi.io/latest?base=" +
                                from.getCode());
            URLConnection connection = url.openConnection();
            return new ExchangeRate(from, to, 
                    getNumberFromConnection(connection, to));
            
        } 
        catch (MalformedURLException ex) {} 
        catch (IOException ex) {}
        return new ExchangeRate(from, to, 0.0);
    }
    
    private double getNumberFromConnection(URLConnection connection, Currency to){
        String line;
        try (BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
                line = reader.readLine();
                int ini = line.indexOf(to.getCode())+5;
                int fin = line.indexOf(",", ini);
                line = line.substring(ini, fin);
        } catch (Exception e){
            return 1.0;
        }
        return Double.parseDouble(line);
    }
}
