package model;

import model.interfaces.CoinPair;
import model.interfaces.Coin;

public class CoinPairImpl implements CoinPair {

	private Coin coin1;
	private Coin coin2;

	public CoinPairImpl() {
		this.coin1 = new CoinImpl(1);
		this.coin2 = new CoinImpl(2);
	}

	@Override
	public Coin getCoin1() {
		return this.coin1;
	}

	@Override
	public Coin getCoin2() {
		return this.coin2;
	}

	@Override
	public String toString() {

		return "Coin 1: " + this.coin1.toString().substring(7) + ", Coin 2: "
				+ this.coin2.toString().substring(7);
	}

	@Override
	public boolean equals(CoinPair coinPair) {
		if (coinPair.getCoin1().equals(coin1) && coinPair.getCoin2().equals(coin2)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object coinPair) {
		return this.equals(((CoinPair) coinPair));
	}

	@Override
	public int hashCode() {
		return this.hashCode();
	}

}