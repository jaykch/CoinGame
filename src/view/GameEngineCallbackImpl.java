package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.LogManager;

import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback {
	private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

	public GameEngineCallbackImpl() {

		// Get rid of any handlers the root logger has so it does not interfere with the
		// logger here
		LogManager.getLogManager().reset();

		// Set logger level
		logger.setLevel(Level.FINE);

		// Declare handler to override default logger
		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.FINE);
		logger.addHandler(ch);
	}

	public void playerCoinUpdate(Player player, Coin coin, GameEngine engine) {

		logger.log(Level.FINE,
				player.getPlayerName() + " coin " + coin.getNumber() + " flipped to " + coin.toString().substring(7));
	}

	public void playerResult(Player player, CoinPair coinPair, GameEngine engine) {

		logger.log(Level.INFO, player.getPlayerName() + ", final result= " + coinPair.toString());
	}

	@Override
	public void spinnerCoinUpdate(Coin coin, GameEngine engine) {
		String spinnerName = "Spinner";
		logger.log(Level.FINE,
				spinnerName + " coin " + coin.getNumber() + " flipped to " + coin.toString().substring(7));
	}

	@Override
	public void spinnerResult(CoinPair coinPair, GameEngine engine) {
		String spinnerName = "Spinner";
		logger.log(Level.INFO, spinnerName + ", final result=" + coinPair.toString());

		String finalResult = "Final Player Results\n";
		for (Player player : engine.getAllPlayers()) {
			finalResult += String.format("Player: %s#n", player.toString() + "\n");
		}
		logger.log(Level.INFO, finalResult);
	}
}