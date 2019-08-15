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
		
		// Get rid of any handlers the root logger has so it does not interfere with the logger here
		LogManager.getLogManager().reset();
		
		// NOTE need to also set the console to FINE in
		// %JRE_HOME%\lib\logging.properties
		logger.setLevel(Level.FINE);
		
		//TODO declaring handler
		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.FINE);
		logger.addHandler(ch);
	}

	public void playerCoinUpdate(Player player, Coin coin, GameEngine engine) {
	
		//TODO should I use two string here?
		
		logger.log(Level.FINE, player.getPlayerName() + " coin " + coin.getNumber() + " flipped to " + coin.getFace());
		// TODO: how to write the playerCoinUpdate
	}

	public void playerResult(Player player, CoinPair coinPair, GameEngine engine) {
		// final results logged at Level.INFO
		logger.log(Level.INFO, "Result data to log .. String.format() is good here!");
		// TODO: complete this method to log results
	}

	@Override
	public void spinnerCoinUpdate(Coin coin, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void spinnerResult(CoinPair coinPair, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	// TODO: implement rest of interface
}
