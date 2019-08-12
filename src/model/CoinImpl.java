package model;

import model.enumeration.CoinFace;
import model.interfaces.Coin;

public class CoinImpl implements Coin {

	private int number;

	// TODO check these variables
	private CoinFace face;

	public CoinImpl(int number) {
		this.number = number;
		// TODO randomly initialise coinface
	}

	@Override
	public int getNumber() {
		return this.number;
	}

	@Override
	public CoinFace getFace() {
		return this.face;
	}

	@Override
	public void flip() {
		// TODO Not sure about this

		if (this.face == CoinFace.HEADS) {
			this.face = CoinFace.TAILS;
		} else if (this.face == CoinFace.TAILS) {
			this.face = CoinFace.HEADS;
		}
	}

	@Override
	public boolean equals(Coin coin) {
		// TODO Check this and ask if can return false without else
		if (this.face == coin.getFace()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object coin) {
		// TODO Check this to see if this is how cast works
		if (this.face == ((Coin) coin).getFace()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO how is hash code generated?
		return 0;
	}

	@Override
	public String toString() {
		// TODO how to capitalise enum switch statement?
		return "Coin" + this.number + ": " + this.face;
	}
}
