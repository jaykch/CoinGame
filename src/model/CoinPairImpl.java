package model;

import model.interfaces.CoinPair;
import model.interfaces.Coin;

public class CoinPairImpl implements CoinPair {

	// TODO check if this is right? What do they mean by specified constructor of
	// CoinImpl?

	private Coin coin1;
	private Coin coin2;

	public CoinPairImpl() {
		this.coin1 = new CoinImpl(1);
		this.coin2 = new CoinImpl(2);
	}

	// TODO use coinImpl instead of coin?

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
		// TODO Capitalise faces use to string method if else statement ask in
		// discussions convert to title case
		return "Coin 1: " + this.coin1.getFace() + "Coin 2: " + this.coin2.getFace();
	}

	@Override
	public boolean equals(CoinPair coinPair) {
		// TODO we are comparing coin pairs I assume?
		// TODO compare the face as well
		if (coinPair.getCoin1().equals(coin1) && coinPair.getCoin2().equals(coin2)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object coinPair) {
		// TODO first check if this method is an instance of coinpair and and then call
		// coinpair method from above
		if (((CoinPair) coinPair).getCoin1().equals(coin1) && ((CoinPair) coinPair).getCoin2().equals(coin2)) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.hashCode();
	}

}