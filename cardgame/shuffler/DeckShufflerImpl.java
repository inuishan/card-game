package com.ishan.graph.cardgame.shuffler;

import com.ishan.graph.cardgame.Player;
import com.ishan.graph.cardgame.deck.Deck;

/**
 * @author ishanjain
 * @since 28/03/18
 */
public class DeckShufflerImpl implements DeckShuffler {

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
                    "This implementation assumes that deck is being shuffeled anong 4 players");
        }
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
