package shuffler;


import deck.Deck;
import player.Player;

/**
 * @author ishanjain
 * @since 28/03/18
 */
public interface DeckDistributor {

    void shuffle(Deck deck, Player[] players);
}