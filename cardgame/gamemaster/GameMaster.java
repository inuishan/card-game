package gamemaster;

import card.Card;
import card.Suite;
import deck.Deck;
import deck.DeckCreatorImpl;
import player.Player;
import shuffler.DeckShufflerImpl;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * This controls the game
 *
 * @author ishanjain
 * @since 28/03/18
 */
public class GameMaster {

    public static void playGame() {

        DeckCreatorImpl deckCreator = new DeckCreatorImpl();
        Deck randomDeck = deckCreator.createRandomDeck();

        DeckShufflerImpl deckShuffler = new DeckShufflerImpl();

        Player[] players = new Player[4];

        for (int i = 0; i < 4; i++) {
            Player player = new Player();
            player.setPlayerId(String.valueOf(i));
            players[i] = player;
        }

        deckShuffler.shuffle(randomDeck, players);

        for (int i = 0; i < 4; i++) {
            Player player = players[i];
            System.out.println("PLAYER " + player.getPlayerId());
            Map<Suite, List<Card>> suiteVsCards = player.getSuiteVsCards();
            for (Map.Entry<Suite, List<Card>> entry : suiteVsCards.entrySet()) {
                System.out.println(entry.getKey());
                List<Card> value = entry.getValue();
                for (Card card : value) {
                    System.out.print(card.getValue() + " ");
                }
                System.out.println("");
            }
        }

        Random random = new Random(System.currentTimeMillis());
        int randomInt = random.nextInt(3);

        Suite trumpSuite = Suite.values()[randomInt];
        System.out.println("TRUMP is " + trumpSuite);

        //player.Player startingPlayer = players[0];
        //
        //for (int numHands = 0; numHands < 13; numHands++) {
        //    hand.Hand hand = new hand.Hand();
        //    for (int i = 0; i < 4; i++) {
        //        players[i].playCard(hand, trumpSuite);
        //
        //    }
        //    System.out.println("hand.Hand won by " + hand.getCurrentlyWinningPlayer());
        //}
    }

    public static void main(String[] args) {
        playGame();
    }
}