package model;

import model.enumeration.CoinFace;
import model.interfaces.Coin;

public class CoinImpl implements Coin {

	private int number;

	// Declare variable to store coin face
	private CoinFace face;

	public CoinImpl(int number) {
		this.number = number;
		this.face = CoinFace.values()[(int) (Math.random() * CoinFace.values().length)];
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
		if (this.face == coin.getFace()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object coin) {
		return this.equals(((Coin) coin));
	}

	@Override
	public int hashCode() {
		return this.hashCode();
	}

	@Override
	public String toString() {
		final CoinFace capitaliseFace = this.face;
		return "Coin" + this.number + ": " + capitaliseFace.toString().substring(0, 1)
				+ capitaliseFace.toString().substring(1).toLowerCase();
	}
}
