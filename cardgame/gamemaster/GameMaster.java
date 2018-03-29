package gamemaster;

import card.Card;
import card.Suite;
import deck.Deck;
import deck.DeckCreator;
import deck.DeckCreatorImpl;
import hand.Hand;
import player.Player;
import shuffler.DeckDistributor;
import shuffler.DeckDistributorImpl;

import java.util.HashMap;
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

    private static void playGame() {

        DeckCreator deckCreator = new DeckCreatorImpl();
        Deck randomDeck = deckCreator.createRandomDeck();


        int numPlayers = 4;

        DeckDistributor deckDistributor = new DeckDistributorImpl();

        Player[] players = new Player[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            Player player = new Player();
            player.setPlayerId(i);
            players[i] = player;
        }

        deckDistributor.shuffle(randomDeck, players);

        printPlayerCards(numPlayers, players);

        Random random = new Random(System.currentTimeMillis());
        int randomInt = random.nextInt(numPlayers - 1);

        Suite trumpSuite = Suite.values()[randomInt];
        System.out.println("TRUMP is " + trumpSuite.getDisplayCode());


        int startingPlayerId = random.nextInt(numPlayers);

        Map<Integer, Integer> playerIdVsHandsWon = new HashMap<>();

        for (int numHands = 0; numHands < 52 / numPlayers; numHands++) {
            System.out.println("Starting Hand " + (numHands + 1));
            Hand hand = new Hand();
            for (int i = 0; i < numPlayers; i++) {
                Player player = players[(startingPlayerId + i) % numPlayers];
                Card card = player.playCard(hand, trumpSuite);
                System.out.println("Player " + player.getPlayerId() + " played a card " + card.getValue() + " of " +
                        card.getSuite().getDisplayCode());
                hand.addCardToHand(player.getPlayerId(), card, trumpSuite);
            }
            startingPlayerId = hand.getCurrentlyWinningPlayer();
            System.out.println("Hand won by player " + startingPlayerId);

            Integer handsWon = playerIdVsHandsWon.get(startingPlayerId);
            if (handsWon == null) {
                handsWon = 0;
            }
            playerIdVsHandsWon.put(startingPlayerId, handsWon + 1);
            if (numHands != 52 / numPlayers - 1) {
                //do not want to print the cards after last hand
                printPlayerCards(numPlayers, players);
            }
        }

        System.out.println("--------STATS-------");
        for (Map.Entry<Integer, Integer> entry : playerIdVsHandsWon.entrySet()) {
            System.out.println("Player " + entry.getKey() + " won " + entry.getValue() + " hands");
        }
    }

    private static void printPlayerCards(int numPlayers, Player[] players) {
        for (int i = 0; i < numPlayers; i++) {
            Player player = players[i];
            System.out.println("PLAYER " + player.getPlayerId());
            Map<Suite, List<Card>> suiteVsCards = player.getSuiteVsCards();
            for (Map.Entry<Suite, List<Card>> entry : suiteVsCards.entrySet()) {
                System.out.print(entry.getKey().getDisplayCode() + " -> ");
                List<Card> value = entry.getValue();
                for (Card card : value) {
                    System.out.print(card.getValue() + " ");
                }
                System.out.println("");
            }
            System.out.println("-------------------------------------");
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}