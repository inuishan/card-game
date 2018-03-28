package shuffler;


import deck.Deck;
import player.Player;

/**
 * @author ishanjain
 * @since 28/03/18
 */
public class DeckDistributorImpl implements DeckDistributor {

    /**
     * This shuffles the deck to the players passed
     *
     * @param deck    The {@link Deck} to be shuffled.
     * @param players The players in order
     * @implSpec This takes the first 13 cards and assigns it to the first player
     */
    @Override
    public void shuffle(Deck deck, Player[] players) {
        if (players == null || players.length != 4) {
            throw new IllegalArgumentException(
                    "This implementation assumes that deck is being shuffeled among 4 players");
        }
        // Note that this is assuming 4 players, which is wrong. It should calculate based on players array size.
        // For the sake of simplicity, this has been coded because if only 2players were there then we need to remove 2 cards
        // 1 of club & diamond.
        int playerIndex = 0;
        for (int cardIndex = 0; cardIndex < 52; cardIndex++) {
            Player player = players[playerIndex];
            player.addCard(deck.getCards().get(cardIndex));
            if (cardIndex > 0 && cardIndex % 13 == 0) {
                playerIndex++;
            }
        }
    }
}
