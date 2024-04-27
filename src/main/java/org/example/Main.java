package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.example.CurrencyConverter.currencyNameMap;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueConverting = true;

        try {
            String apiKey = "d19dca5bb2e3bb73d6bea52c";
            CurrencyConverter converter = new CurrencyConverter(apiKey);

            while (continueConverting) {
                System.out.println("Bienvenido al conversor de monedas.");

                // Obtener monedas filtradas (10 principales y las de América)
                List<String> filteredCurrencies = converter.getFilteredCurrencies();

                // Mostrar el submenú de monedas disponibles con nombres completos
                System.out.println("Monedas disponibles:");
                for (int i = 0; i < filteredCurrencies.size(); i++) {
                    String currencyCode = filteredCurrencies.get(i);
                    String currencyName = currencyNameMap.getOrDefault(currencyCode, "Desconocido");
                    System.out.printf("%d. %s (%s)\n", i + 1, currencyCode, currencyName);
                }

                // Pedir al usuario que seleccione la moneda de origen
                System.out.print("Selecciona la moneda de origen (número): ");
                int fromCurrencyIndex = scanner.nextInt() - 1;
                String fromCurrency = filteredCurrencies.get(fromCurrencyIndex);

                // Pedir cantidad a convertir
                System.out.print("Introduce la cantidad a convertir: ");
                double amount = scanner.nextDouble();

                // Pedir al usuario que seleccione la moneda de destino
                System.out.print("Selecciona la moneda de destino (número): ");
                int toCurrencyIndex = scanner.nextInt() - 1;
                String toCurrency = filteredCurrencies.get(toCurrencyIndex);

                // Realizar la conversión
                double convertedAmount = converter.convert(fromCurrency, toCurrency, amount);
                System.out.println("Cantidad convertida: " + convertedAmount);

                // Preguntar si el usuario quiere seguir convirtiendo
                System.out.print("¿Desea realizar otra conversión? (1 para sí, 0 para no): ");
                int respuesta = scanner.nextInt();

                // Salir si el usuario elige 0
                continueConverting = respuesta == 1;
            }

            System.out.println("Gracias por usar el conversor de monedas. ¡Adiós!");

        } catch (IOException e) {
            System.err.println("Error durante la conversión: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Índice fuera de rango. Asegúrate de seleccionar un número válido.");
        } finally {
            scanner.close();
        }
    }
}