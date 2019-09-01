package model.enumeration;

import model.interfaces.CoinPair;
import model.interfaces.Player;

/**
 * Provided enum type for Further Programming representing a type of Bet<br>
 * See inline comments for where you need to provide additional code
 * 
 * @author Caspar Ryan
 * 
 */
public enum BetType {
	COIN1 {
		@Override
		public void applyWinLoss(Player player, CoinPair spinnerResult) {
			if (spinnerResult.getCoin1().equals(player.getResult().getCoin1())) {
				player.setPoints(player.getPoints() + player.getBet() * 1);
			} else {
				player.setPoints(player.getPoints() - player.getBet() * 1);
			}
		}
	},
	COIN2 {
		@Override
		public void applyWinLoss(Player player, CoinPair spinnerResult) {
			if (spinnerResult.getCoin2().equals(player.getResult().getCoin2())) {
				player.setPoints(player.getPoints() + player.getBet() * 1);
			} else {
				player.setPoints(player.getPoints() - player.getBet() * 1);
			}
		}
	},
	BOTH {
		@Override
		public void applyWinLoss(Player player, CoinPair spinnerResult) {
			if (spinnerResult.equals(player.getResult())) {
				player.setPoints(player.getPoints() + player.getBet() * 2);
			} else {
				player.setPoints(player.getPoints() - player.getBet() * 1);
			}
		}
	},
	NO_BET {
		@Override
		public void applyWinLoss(Player player, CoinPair spinnerResult) {
			// Set points to what they were before
			player.setPoints(player.getPoints());
		}
	};

	/**
	 * This method is to be overridden for each bet type<br>
	 * see assignment specification for betting odds and how win/loss is applied
	 * 
	 * @param player        - the player to apply the win/loss points balance
	 *                      adjustment
	 * @param spinnerResult - the CoinPair result of the spinner to compare to
	 */
	public abstract void applyWinLoss(Player player, CoinPair spinnerResult);
}