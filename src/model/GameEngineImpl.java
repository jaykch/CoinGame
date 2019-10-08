package model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import model.enumeration.BetType;
import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {

	// Declare hashmap to store players and game engine callback

	private Map<String, Player> players;
	private Set<GameEngineCallback> gameEngineCallbacks;

	// Constructor to instantiate game engine

	public GameEngineImpl() {
		super();

		// Instantiate players and callback collection

		players = new HashMap<String, Player>();
		gameEngineCallbacks = new LinkedHashSet<GameEngineCallback>();
	}

	@Override
	public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2) throws IllegalArgumentException {

		// Instantiate a coin pair for the player

		CoinPair coinPair = new CoinPairImpl();

		// Call method to spin coins

		this.spinCoins(player, initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2,
				coinPair);

		for (GameEngineCallback callback : gameEngineCallbacks) {
			callback.playerResult(player, coinPair, this);
		}
	}

	@Override
	public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) throws IllegalArgumentException {

		// Instantiate a coin pair for the spinner

		CoinPair coinPair = new CoinPairImpl();

		// Call method to spin coins

		this.spinCoins(null, initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2,
				coinPair);

		// Apply bet results and call the final results

		this.applyBetResults(coinPair);

		for (GameEngineCallback callback : gameEngineCallbacks) {
			callback.spinnerResult(coinPair, this);
		}

		// Set bets to 0 at the end
		for (Player player : getAllPlayers()) {
			player.setBet(0);
		}
	}

	// Spin method for coins for both spinner and player

	private void spinCoins(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2, CoinPair coinPair) {

		Coin coin1;
		Coin coin2;

		if (player != null) {
			player.setResult(coinPair);
			coin1 = player.getResult().getCoin1();
			coin2 = player.getResult().getCoin2();
		} else {
			coin1 = coinPair.getCoin1();
			coin2 = coinPair.getCoin2();
		}

		int currentDelay1 = initialDelay1;

		while (currentDelay1 < finalDelay1) {

			this.delay(currentDelay1);

			if (currentDelay1 <= finalDelay1) {

				if (player != null) {
					coin1.flip();

					for (GameEngineCallback callback : gameEngineCallbacks) {
						callback.playerCoinUpdate(player, coin1, this);
					}
					coin2.flip();
					for (GameEngineCallback callback : gameEngineCallbacks) {
						callback.playerCoinUpdate(player, coin2, this);
					}
				} else {
					coin1.flip();
					for (GameEngineCallback callback : gameEngineCallbacks) {
						callback.spinnerCoinUpdate(coin1, this);
					}
					coin2.flip();
					for (GameEngineCallback callback : gameEngineCallbacks) {
						callback.spinnerCoinUpdate(coin2, this);
					}
				}

			}
			currentDelay1 += delayIncrement1;
		}
	}

	@Override
	public void applyBetResults(CoinPair spinnerResult) {
		for (Player player : getAllPlayers()) {
			player.getBetType().applyWinLoss(player, spinnerResult);
		}
	}

	@Override
	public void addPlayer(Player player) {
		if (player != null) {
			players.put(player.getPlayerId(), player);
		}
	}

	@Override
	public Player getPlayer(String id) {
		return players.get(id);
	}

	@Override
	public boolean removePlayer(Player player) {
		return players.remove(player.getPlayerId(), player);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		gameEngineCallbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		return gameEngineCallbacks.remove(gameEngineCallback);
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return Collections.unmodifiableCollection(this.players.values());
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) {
		player.setBetType(betType);
		return player.setBet(bet);
	}

	// Method to add delay to flipping of coins

	private void delay(int delay) {
		//validation
		// if less than or equal to 0, throw illegal argument exception if it is more than final delay
		// if it doesnt outline write a method, validate spin parameters
	
		
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
