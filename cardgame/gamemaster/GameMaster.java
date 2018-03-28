package gamemaster;

import card.Card;
import card.Suite;
import deck.Deck;
import deck.DeckCreatorImpl;
import hand.Hand;
import player.Player;
import shuffler.DeckDistributorImpl;

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


        int numPlayers = 4;

        DeckDistributorImpl deckShuffler = new DeckDistributorImpl();

        Player[] players = new Player[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            Player player = new Player();
            player.setPlayerId(String.valueOf(i));
            players[i] = player;
        }

        deckShuffler.shuffle(randomDeck, players);

        printPlayerCards(numPlayers, players);

        Random random = new Random(System.currentTimeMillis());
        int randomInt = random.nextInt(numPlayers - 1);

        Suite trumpSuite = Suite.values()[randomInt];
        System.out.println("TRUMP is " + trumpSuite);


        int startingPlayerId = random.nextInt(3);

        for (int numHands = 0; numHands < 52 / numPlayers; numHands++) {
            Hand hand = new hand.Hand();
            for (int i = 0; i < numPlayers; i++) {
                Player player = players[startingPlayerId + i % 4];
                player.playCard(hand, trumpSuite);
            }
            startingPlayerId = hand.getCurrentlyWinningPlayer();
            System.out.println("Hand won by " + hand.getCurrentlyWinningPlayer());
        }
    }

    private static void printPlayerCards(int numPlayers, Player[] players) {
        for (int i = 0; i < numPlayers; i++) {
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
    }

    public static void main(String[] args) {
        playGame();
    }
}