package model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.enumeration.BetType;
import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;

//TODO do I need to add my name to every class I make

public class GameEngineImpl implements GameEngine {

	// TODO is this correct implementation? hashmap
	private Map<String, Player> players;
	private Map<Integer, GameEngineCallback> gameEngineCallbacks;

	public GameEngineImpl() {
		super();
		players = new HashMap<String, Player>();
		gameEngineCallbacks = new HashMap<Integer, GameEngineCallback>();
	}

	@Override
	public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2) throws IllegalArgumentException {

		this.spinCoins(player, initialDelay1, delayIncrement1, finalDelay1, initialDelay2, finalDelay2,
				delayIncrement2);
	}

	@Override
	public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) throws IllegalArgumentException {

		// TODO where to initialise spinner
		final Player spinner = new SimplePlayer("4", "Spinner", 0);

		this.spinCoins(spinner, initialDelay1, delayIncrement1, finalDelay1, initialDelay2, finalDelay2,
				delayIncrement2);
	}

	// Method to spin coins to avoid code duplication

	private void spinCoins(Player player, int initialDelay1, int delayIncrement1, int finalDelay1, int initialDelay2,
			int finalDelay2, int delayIncrement2) {
		
		//TODO is this the correct way for game engine callback?		
		GameEngineCallback callback = new GameEngineCallbackImpl();

		CoinPair coinPair = new CoinPairImpl();
		player.setResult(coinPair);

		Coin coin1 = player.getResult().getCoin1();
		Coin coin2 = player.getResult().getCoin2();

		int currentDelay1 = initialDelay1;
		int currentDelay2 = initialDelay2;

		while (currentDelay1 <= finalDelay1 || currentDelay2 <= finalDelay2) {

			// TODO find out what they are doing with the sleep of both delays? Are we
			// supposed to sleep after each coin flip and if this is the case, using this
			// logic spinner's coins spin too many times

			try {
				Thread.sleep(currentDelay1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			currentDelay1 += delayIncrement1;
			currentDelay2 += delayIncrement2;

			if (currentDelay1 <= finalDelay1) {
				coin1.flip();
				callback.playerCoinUpdate(player, coin1, this);
				//System.out.println(player.getPlayerName() + " " + coin1.toString());
			}
			if (currentDelay2 <= finalDelay2) {
				coin2.flip();
				callback.playerCoinUpdate(player, coin2, this);
				//System.out.println(player.getPlayerName() + " " + coin2.toString());
			}
		}
		callback.playerResult(player, coinPair, this);
	}

	@Override
	public void applyBetResults(CoinPair spinnerResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPlayer(Player player) {
		// TODO check if this is good
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
		// TODO check if gives boolean
		return players.remove(player.getPlayerId(), player);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		gameEngineCallbacks.put(gameEngineCallback.hashCode(), gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO check if this works
		return gameEngineCallbacks.remove(gameEngineCallback.hashCode(), gameEngineCallback);
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return Collections.unmodifiableCollection(this.players.values());
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) {
		// TODO Auto-generated method stub
		return false;
	}

}
