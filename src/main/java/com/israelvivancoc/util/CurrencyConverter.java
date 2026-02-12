package com.israelvivancoc.util;

import com.israelvivancoc.model.DataPoint;
import java.util.Scanner;

public class CurrencyConverter {

    public static void showConversionMenu(DataPoint data) {
        Scanner scanner = new Scanner(System.in);

        try {
            double exchangeRate = Double.parseDouble(data.getDato());

            System.out.println("\n --- CURRENCY CONVERTER ---");
            System.out.println("Rate of the day: " + exchangeRate + " MXN/USD");
            System.out.print("Enter amount in MXN to convert to USD: ");

            double mxnAmount = scanner.nextDouble();
            double usdAmount = mxnAmount / exchangeRate;

            System.out.println("------------------------------");
            System.out.printf("Result: $%.2f MXN = $%.2f USD%n", mxnAmount, usdAmount);
            System.out.println("------------------------------\n");

        } catch (NumberFormatException e) {
            System.err.println(" Error: Exchange rate format is invalid.");
        } catch (Exception e) {
            System.err.println(" Error: Please enter a valid numeric amount.");
        }
    }
}