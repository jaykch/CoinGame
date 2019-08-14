package model;

import model.enumeration.CoinFace;
import model.interfaces.Coin;

public class CoinImpl implements Coin {

	private int number;

	// TODO check these variables use math random
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
		// TODO how is hash code generated? there is method called coHashutilitiy method objects.utils method 
		return 0;
	}

	@Override
	public String toString() {
		// TODO if else or to string
		return "Coin" + this.number + ": " + this.face;
	}
}
