package model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

//TODO do I need to add my name to every class I make

public class GameEngineImpl implements GameEngine {

	// TODO is this correct implementation? hashmap
	private Map<String, Player> players;

	public GameEngineImpl() {
		super();
		players = new HashMap<String, Player>();
	}

	@Override
	public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2) throws IllegalArgumentException {
		// TODO Math random face.values.length

	}

	@Override
	public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) throws IllegalArgumentException {
		// TODO Auto-generated method stub

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
		// TODO add game engine callback to collection

	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub
		return false;
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
