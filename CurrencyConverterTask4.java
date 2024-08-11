package com.example.mypractice.daily_task;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverterTask4 {
/*//    private static final String API_URL = "https://api.exchangeratesapi.io/latest?base=";
//private static final String API_URL = "https://api.exchangerate.host/latest?base=";
private static final String API_URL = "https://www.freeforexapi.com/api/live";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Currency Selection
        System.out.print("Enter the base currency (e.g., USD, EUR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency (e.g., INR, EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Amount Input
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        try {
            // Fetch exchange rate
            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

            // Currency Conversion
            double convertedAmount = amount * exchangeRate;

            // Display Result
            System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
        } catch (Exception e) {
            System.out.println("Error fetching exchange rate: " + e.getMessage());
        }

        scanner.close();
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
//        String urlStr = API_URL + baseCurrency;
//        String urlStr = API_URL + baseCurrency + "&symbols=" + targetCurrency;
        String urlStr = API_URL + "?pairs=" + baseCurrency + targetCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        String response = content.toString();
        System.out.println("Raw JSON Response: " + response);
        // Parse JSON response
        JSONObject jsonResponse = new JSONObject(response);
        JSONObject rates = jsonResponse.getJSONObject("rates");
        String currencyPair = baseCurrency + targetCurrency;

        // Check if the currency pair exists in the response
        if (!rates.has(currencyPair)) {
            throw new Exception("Currency pair not found in the response.");
        }
        JSONObject rate = rates.getJSONObject(currencyPair);

        // Return the exchange rate
        return rate.getDouble("rate");
    }*/

    // Predefined exchange rates
    private static final Map<String, Double> EXCHANGE_RATES = new HashMap<>();

    static {
        // Base currency: USD
        EXCHANGE_RATES.put("USDEUR", 0.93); // Example rate
        EXCHANGE_RATES.put("USDINR", 82.50); // Example rate
        EXCHANGE_RATES.put("USDGBP", 0.82);   // USD to GBP
        EXCHANGE_RATES.put("USDCAD", 1.36);   // USD to CAD
        EXCHANGE_RATES.put("USDJPY", 149.50); // USD to JPY
        EXCHANGE_RATES.put("USDCHF", 0.90);   // USD to CHF
        EXCHANGE_RATES.put("USDAUD", 1.47);   // USD to AUD
        EXCHANGE_RATES.put("USDNZD", 1.58);   // USD to NZD
        EXCHANGE_RATES.put("USDSGD", 1.36);   // USD to SGD
        EXCHANGE_RATES.put("USDHKD", 7.85);   // USD to HKD
        EXCHANGE_RATES.put("USDMXN", 18.25);  // USD to MXN
        EXCHANGE_RATES.put("USDKRW", 1327.80); // USD to KRW
        EXCHANGE_RATES.put("USDSEK", 10.40);  // USD to SEK
        EXCHANGE_RATES.put("USDBRL", 5.35);   // USD to BRL
        EXCHANGE_RATES.put("USDDKK", 6.97);   // USD to DKK

        // Add more currency pairs as needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Currency Selection
        System.out.print("Enter the base currency (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Amount Input
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        try {
            // Currency Conversion
            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
            double convertedAmount = amount * exchangeRate;

            // Display Result
            System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        String currencyPair = baseCurrency + targetCurrency;

        // Check if the exchange rate is available
        if (!EXCHANGE_RATES.containsKey(currencyPair)) {
            throw new Exception("Exchange rate for " + baseCurrency + " to " + targetCurrency + " not found.");
        }

        // Return the exchange rate
        return EXCHANGE_RATES.get(currencyPair);
    }
}
