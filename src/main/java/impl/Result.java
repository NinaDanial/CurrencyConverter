package impl;

import enums.Coins;

public class Result {
    private Coins coin;
    private Coins convertedCoin;
    private double amount;
    private double result;


    public Coins getCoin() {
        return coin;
    }

    public void setCoin(Coins coin) {
        this.coin = coin;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Coins getConvertedCoin() {
        return convertedCoin;
    }

    public void setConvertedCoin(Coins convertedCoin) {
        this.convertedCoin = convertedCoin;
    }
}
