import enums.Coins;
import factory.CoinFactory;
import impl.Coin;
import impl.Result;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Result> allResult = new ArrayList<>();
    private static Coin coin;
    private static double amount;
    private static Coins currCurrency;
    private static Coins convertedCoin;

    public static void main(String[] args) {
        try {
            showFirstTillThirdScreen();
        } catch (IOException exp) {
            System.out.println("Could not write to a file" + exp.getMessage());
        } catch (Exception e) {
            System.out.println("exception was thrown" + e.getMessage());
        }

    }

    private static void showFirstTillThirdScreen() throws IOException {
        showWelcomeScreen();
        showChoiceScreen();
        showResultScreen();
    }

    private static void showResultScreen() throws IOException {
        double currResult = coin.calculate(amount);
        System.out.println("The result is " + currResult);
        saveResultInList(currResult);
        System.out.println("Would you like to start over ? Y/N");
        String res = getStartOver();
        if (res.equalsIgnoreCase("Y")) {
            showFirstTillThirdScreen();
        }
        if (res.equalsIgnoreCase("N")) {
            showFourthScreen();
        }
    }

    private static void showFourthScreen() throws IOException {
        System.out.println("Thanks for using our currency converter");
        StringBuilder sb = new StringBuilder();

        for (Result result : allResult) {
            String convertMsg = "You have converted " + result.getAmount() + " " + result.getCoin().name();
            System.out.println(convertMsg);
            String resultMsg = "You have received " + result.getResult() + " " + result.getConvertedCoin().name();
            System.out.println(resultMsg);
            System.out.println("----------------------------------");
            sb.append(convertMsg);
            sb.append("\n");
            sb.append(resultMsg);
        }
        writeResultToFile(sb.toString(), "results.txt");

    }

    private static void saveResultInList(double currResult) {
        Result res = new Result();
        res.setAmount(amount);
        res.setResult(currResult);
        res.setCoin(currCurrency);
        res.setConvertedCoin(convertedCoin);
        allResult.add(res);
    }

    private static void showChoiceScreen() {
        System.out.println("Please enter an amount to convert");
        amount = getAmount();
    }

    private static void showWelcomeScreen() {

        try {
            System.out.println("welcome to currency convertor");

            System.out.println("Please choose an option(1/2)");
            System.out.println("1.Dollars to Shekels");
            System.out.println("2.Shekels to Dollars");
            int choice = getUserDecision();

            if (choice == 1) {
                currCurrency = Coins.USD;
                convertedCoin = Coins.ILS;
                coin = CoinFactory.getCoinInstance(Coins.USD);
                return;
            }
            if (choice == 2) {
                currCurrency = Coins.ILS;
                convertedCoin = Coins.USD;
                coin = CoinFactory.getCoinInstance(Coins.ILS);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException exp) {
            System.out.println("Invalid Choice, please try again");
            showWelcomeScreen();
        }
    }

    /**
     * @return user decision in first screen options , valid values are 1 or 2
     */
    private static int getUserDecision() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * @return user amount to convert
     */
    private static double getAmount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    /**
     * @return start over answer , valid values : Y char
     */
    private static String getStartOver() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


    /**
     * @param content
     * @param fileName
     * @throws IOException
     */
    private static void writeResultToFile(String content, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(content);
        writer.close();
    }


}



