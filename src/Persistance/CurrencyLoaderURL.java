package Persistance;

import Model.Currency;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import Model.CurrencyList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStreamReader;

//funcionaria si se le poner una key que no caduque

public class CurrencyLoaderURL implements CurrencyListLoader {
    
    @Override
    public CurrencyList load() {
        CurrencyList currencies = new CurrencyList();
        Gson gson = new Gson();
        try {
            URL url = new URL("https://free.currconv.com/api/v7/currencies?apiKey=1f5e721121618d26434f");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            JsonParser parser = new JsonParser();
            JsonArray jArray = (JsonArray) parser.parse(fixJson(line)).getAsJsonObject().get("results");
            for (JsonElement elem : jArray){
                JsonObject obj = elem.getAsJsonObject();
                for (String currencyID : obj.keySet()){
                    JsonObject jsonCurrencyObject = (JsonObject) obj.get(currencyID);
                    currencies.add(getCurrencyFromJsonObject(jsonCurrencyObject));
                }
            }
            return currencies;
        } catch (MalformedURLException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
    
    private String fixJson(String JSON) {
        String fixedJson = JSON.substring(11, JSON.length()-1);
        fixedJson= "{\"results\":" + "[" + fixedJson + "]}";
        return fixedJson;
    }
    
    private Currency getCurrencyFromJsonObject(JsonObject jsonCurrencyObject) {
        String currencyName = jsonCurrencyObject.get("currencyName").toString().replaceAll("\"","");
        String currencyID = jsonCurrencyObject.get("id").toString().replaceAll("\"","");
        String currencySymbol;
        try{ currencySymbol =jsonCurrencyObject.get("currencySymbol").toString().replaceAll("\"",""); }
        catch(Exception e){ currencySymbol = "?";}
        return new Currency(currencyID, currencyName,currencySymbol);
    }
}
