package model;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

public class SimplePlayer implements Player {

	// Instantiate variables for player
	private String playerId;
	private String playerName;
	private int points;
	private int bet;
	private BetType betType;
	private CoinPair coinPair;

	public SimplePlayer(String playerId, String playerName, int initialPoints) {
		// Assign player information
		this.playerId = playerId;
		this.playerName = playerName;
		this.points = initialPoints;
	}

	@Override
	public String getPlayerName() {
		return this.playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public int getPoints() {
		return this.points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String getPlayerId() {
		return this.playerId;
	}

	@Override
	public boolean setBet(int bet) {
		if (bet > 0 && bet <= this.getPoints()) {
			this.bet = bet;
			return true;
		}
		return false;
	}

	@Override
	public int getBet() {
		return this.bet;
	}

	@Override
	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	@Override
	public BetType getBetType() {
		return this.betType;
	}

	@Override
	public void resetBet() {
		this.bet = 0;
		//TODO: is this correct? that we need no bet instead of null
		this.betType = BetType.NO_BET;
	}

	@Override
	public CoinPair getResult() {
		return this.coinPair;
	}

	@Override
	public void setResult(CoinPair coinPair) {
		this.coinPair = coinPair;
	}

	@Override
	public String toString() {
		return "Player: id=" + this.playerId + ", name=" + this.playerName + ", bet=" + this.bet + ", betType="
				+ this.betType + ", points=" + this.points + ", Result .. Coin 1: "
				+ this.coinPair.getCoin1().toString().substring(7) + ", Coin 2: "
				+ this.coinPair.getCoin2().toString().substring(7);
	}
}