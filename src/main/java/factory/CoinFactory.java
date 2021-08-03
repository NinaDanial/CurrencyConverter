package factory;

import enums.Coins;
import impl.Coin;
import impl.ILS;
import impl.USD;

public class CoinFactory {
    public static Coin getCoinInstance(Coins coinType) {
        switch (coinType) {
            case ILS:
                return new ILS();
            case USD:
                return new USD();
        }

        return null;
    }
}
