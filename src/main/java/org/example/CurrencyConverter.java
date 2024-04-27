package org.example;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.*;

public class CurrencyConverter {

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();
    private final String apiKey;
    private final String apiUrl = "https://v6.exchangerate-api.com/v6/";
    static final Map<String, String> currencyNameMap = new HashMap<>();
    static {
        currencyNameMap.put("USD", "Dólar estadounidense");
        currencyNameMap.put("EUR", "Euro");
        currencyNameMap.put("JPY", "Yen japonés");
        currencyNameMap.put("GBP", "Libra esterlina");
        currencyNameMap.put("AUD", "Dólar australiano");
        currencyNameMap.put("CAD", "Dólar canadiense");
        currencyNameMap.put("CHF", "Franco suizo");
        currencyNameMap.put("CNY", "Yuan chino");
        currencyNameMap.put("NZD", "Dólar neozelandés");
        currencyNameMap.put("SEK", "Corona sueca");
        currencyNameMap.put("MXN", "Peso mexicano");
        currencyNameMap.put("BRL", "Real brasileño");
        currencyNameMap.put("ARS", "Peso argentino");
        currencyNameMap.put("COP", "Peso colombiano");
        currencyNameMap.put("CLP", "Peso chileno");
        currencyNameMap.put("PEN", "Sol peruano");
        currencyNameMap.put("UYU", "Peso uruguayo");
    }

    public CurrencyConverter(String apiKey) {
        this.apiKey = apiKey;
    }

    private Map<String, Double> getRates(String baseCurrency) throws IOException {
        String url = apiUrl + apiKey + "/latest/" + baseCurrency;
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Error en la solicitud a la API");
        }
        String responseBody = response.body().string();
        Map<String, Object> result = gson.fromJson(responseBody, Map.class);
        return (Map<String, Double>) result.get("conversion_rates");
    }

    public List<String> getFilteredCurrencies() throws IOException {
        Set<String> availableCurrencies = getRates("USD").keySet();  // Obtener todas las monedas
        List<String> filteredCurrencies = new ArrayList<>();

        // Agregar  monedas
        List<String> majorCurrencies = Arrays.asList("USD", "EUR", "JPY", "GBP", "AUD", "CAD", "CHF", "CNY", "NZD", "SEK");
        for (String currency : majorCurrencies) {
            if (availableCurrencies.contains(currency)) {
                filteredCurrencies.add(currency);
            }
        }

        // Agregar monedas de América
        List<String> americanCurrencies = Arrays.asList("MXN", "BRL", "ARS", "COP", "CLP", "PEN", "UYU");
        for (String currency : americanCurrencies) {
            if (!filteredCurrencies.contains(currency) && availableCurrencies.contains(currency)) {
                filteredCurrencies.add(currency);
            }
        }

        return filteredCurrencies;
    }

    public double convert(String from, String to, double amount) throws IOException {
        Map<String, Double> rates = getRates(from);
        if (!rates.containsKey(to)) {
            throw new IllegalArgumentException("Moneda no soportada: " + to);
        }
        double rate = rates.get(to);
        return amount * rate;
    }
}