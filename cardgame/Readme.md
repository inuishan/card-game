This simulates a simple card game. Rules of the games are as follows:

Played with a deck of 52 cards with 4 suites and 13 number cards

4 players plays the game.


1. distribute cards among players randomly
2. decide random trump for the game
3. choose a player randomly to start the game
4. game starts 


game strategy : 
each player tries to win maximum no. of hands greedily. at each turn, player tries to win it. 

1. if player has cards of same suit, it puts forth the highest available, given the highest card is higher than the highest played card till then in the hand
2. if player has cards of same suit but no card is higher than the highest played card, he puts the smallest card of same suit
3. if player doesn't have card of same suit, he puts smallest available trump card that would win the hand till that time
4. if player doesn't have big enough trump card, or he doesn't have trump at all, he puts smallest available card of any other suit, in case of conflict choose random


<b>Please not that while playing the first card of the hand, the player does not play his highest card, he chosses a random suite except tump and plays the highest card of that trump.</b>


A sample simulation of the game:

PLAYER 0
♣ -> 13 6 1 
♠ -> 7 3 
♥ -> 11 9 8 6 
♦ -> 10 9 6 4 
-------------------------------------
PLAYER 1
♣ -> 12 10 8 3 
♠ -> 13 11 5 
♥ -> 7 5 
♦ -> 11 8 5 1 
-------------------------------------
PLAYER 2
♣ -> 9 5 2 
♠ -> 10 6 
♥ -> 13 12 10 1 
♦ -> 12 7 3 2 
-------------------------------------
PLAYER 3
♣ -> 11 7 4 
♠ -> 12 9 8 4 2 1 
♥ -> 4 3 2 
♦ -> 13 
-------------------------------------
TRUMP is ♣
Starting Hand 1
Player 0 played a card 7 of ♠
Player 1 played a card 13 of ♠
Player 2 played a card 6 of ♠
Player 3 played a card 1 of ♠
Hand won by player 1
PLAYER 0
♣ -> 13 6 1 
♠ -> 3 
♥ -> 11 9 8 6 
♦ -> 10 9 6 4 
-------------------------------------
PLAYER 1
♣ -> 12 10 8 3 
♠ -> 11 5 
♥ -> 7 5 
♦ -> 11 8 5 1 
-------------------------------------
PLAYER 2
♣ -> 9 5 2 
♠ -> 10 
♥ -> 13 12 10 1 
♦ -> 12 7 3 2 
-------------------------------------
PLAYER 3
♣ -> 11 7 4 
♠ -> 12 9 8 4 2 
♥ -> 4 3 2 
♦ -> 13 
-------------------------------------
Starting Hand 2
Player 1 played a card 11 of ♠
Player 2 played a card 10 of ♠
Player 3 played a card 12 of ♠
Player 0 played a card 3 of ♠
Hand won by player 3
PLAYER 0
♣ -> 13 6 1 
♠ -> 
♥ -> 11 9 8 6 
♦ -> 10 9 6 4 
-------------------------------------
PLAYER 1
♣ -> 12 10 8 3 
♠ -> 5 
♥ -> 7 5 
♦ -> 11 8 5 1 
-------------------------------------
PLAYER 2
♣ -> 9 5 2 
♠ -> 
♥ -> 13 12 10 1 
♦ -> 12 7 3 2 
-------------------------------------
PLAYER 3
♣ -> 11 7 4 
♠ -> 9 8 4 2 
♥ -> 4 3 2 
♦ -> 13 
-------------------------------------
Starting Hand 3
Player 3 played a card 9 of ♠
Player 0 played a card 1 of ♣
Player 1 played a card 5 of ♠
Player 2 played a card 2 of ♣
Hand won by player 2
PLAYER 0
♣ -> 13 6 
♠ -> 
♥ -> 11 9 8 6 
♦ -> 10 9 6 4 
-------------------------------------
PLAYER 1
♣ -> 12 10 8 3 
♠ -> 
♥ -> 7 5 
♦ -> 11 8 5 1 
-------------------------------------
PLAYER 2
♣ -> 9 5 
♠ -> 
♥ -> 13 12 10 1 
♦ -> 12 7 3 2 
-------------------------------------
PLAYER 3
♣ -> 11 7 4 
♠ -> 8 4 2 
♥ -> 4 3 2 
♦ -> 13 
-------------------------------------
Starting Hand 4
Player 2 played a card 12 of ♦
Player 3 played a card 13 of ♦
Player 0 played a card 4 of ♦
Player 1 played a card 1 of ♦
Hand won by player 3
PLAYER 0
♣ -> 13 6 
♠ -> 
♥ -> 11 9 8 6 
♦ -> 10 9 6 
-------------------------------------
PLAYER 1
♣ -> 12 10 8 3 
♠ -> 
♥ -> 7 5 
♦ -> 11 8 5 
-------------------------------------
PLAYER 2
♣ -> 9 5 
♠ -> 
♥ -> 13 12 10 1 
♦ -> 7 3 2 
-------------------------------------
PLAYER 3
♣ -> 11 7 4 
♠ -> 8 4 2 
♥ -> 4 3 2 
♦ -> 
-------------------------------------
Starting Hand 5
Player 3 played a card 4 of ♥
Player 0 played a card 11 of ♥
Player 1 played a card 5 of ♥
Player 2 played a card 13 of ♥
Hand won by player 2
PLAYER 0
♣ -> 13 6 
♠ -> 
♥ -> 9 8 6 
♦ -> 10 9 6 
-------------------------------------
PLAYER 1
♣ -> 12 10 8 3 
♠ -> 
♥ -> 7 
♦ -> 11 8 5 
-------------------------------------
PLAYER 2
♣ -> 9 5 
♠ -> 
♥ -> 12 10 1 
♦ -> 7 3 2 
-------------------------------------
PLAYER 3
♣ -> 11 7 4 
♠ -> 8 4 2 
♥ -> 3 2 
♦ -> 
-------------------------------------
Starting Hand 6
Player 2 played a card 7 of ♦
Player 3 played a card 4 of ♣
Player 0 played a card 6 of ♦
Player 1 played a card 5 of ♦
Hand won by player 3
PLAYER 0
♣ -> 13 6 
♠ -> 
♥ -> 9 8 6 
♦ -> 10 9 
-------------------------------------
PLAYER 1
♣ -> 12 10 8 3 
♠ -> 
♥ -> 7 
♦ -> 11 8 
-------------------------------------
PLAYER 2
♣ -> 9 5 
♠ -> 
♥ -> 12 10 1 
♦ -> 3 2 
-------------------------------------
PLAYER 3
♣ -> 11 7 
♠ -> 8 4 2 
♥ -> 3 2 
♦ -> 
-------------------------------------
Starting Hand 7
Player 3 played a card 3 of ♥
Player 0 played a card 9 of ♥
Player 1 played a card 7 of ♥
Player 2 played a card 12 of ♥
Hand won by player 2
PLAYER 0
♣ -> 13 6 
♠ -> 
♥ -> 8 6 
♦ -> 10 9 
-------------------------------------
PLAYER 1
♣ -> 12 10 8 3 
♠ -> 
♥ -> 
♦ -> 11 8 
-------------------------------------
PLAYER 2
♣ -> 9 5 
♠ -> 
♥ -> 10 1 
♦ -> 3 2 
-------------------------------------
PLAYER 3
♣ -> 11 7 
♠ -> 8 4 2 
♥ -> 2 
♦ -> 
-------------------------------------
Starting Hand 8
Player 2 played a card 3 of ♦
Player 3 played a card 7 of ♣
Player 0 played a card 9 of ♦
Player 1 played a card 8 of ♦
Hand won by player 3
PLAYER 0
♣ -> 13 6 
♠ -> 
♥ -> 8 6 
♦ -> 10 
-------------------------------------
PLAYER 1
♣ -> 12 10 8 3 
♠ -> 
♥ -> 
♦ -> 11 
-------------------------------------
PLAYER 2
♣ -> 9 5 
♠ -> 
♥ -> 10 1 
♦ -> 2 
-------------------------------------
PLAYER 3
♣ -> 11 
♠ -> 8 4 2 
♥ -> 2 
♦ -> 
-------------------------------------
Starting Hand 9
Player 3 played a card 2 of ♥
Player 0 played a card 8 of ♥
Player 1 played a card 3 of ♣
Player 2 played a card 1 of ♥
Hand won by player 1
PLAYER 0
♣ -> 13 6 
♠ -> 
♥ -> 6 
♦ -> 10 
-------------------------------------
PLAYER 1
♣ -> 12 10 8 
♠ -> 
♥ -> 
♦ -> 11 
-------------------------------------
PLAYER 2
♣ -> 9 5 
♠ -> 
♥ -> 10 
♦ -> 2 
-------------------------------------
PLAYER 3
♣ -> 11 
♠ -> 8 4 2 
♥ -> 
♦ -> 
-------------------------------------
Starting Hand 10
Player 1 played a card 11 of ♦
Player 2 played a card 2 of ♦
Player 3 played a card 11 of ♣
Player 0 played a card 10 of ♦
Hand won by player 3
PLAYER 0
♣ -> 13 6 
♠ -> 
♥ -> 6 
♦ -> 
-------------------------------------
PLAYER 1
♣ -> 12 10 8 
♠ -> 
♥ -> 
♦ -> 
-------------------------------------
PLAYER 2
♣ -> 9 5 
♠ -> 
♥ -> 10 
♦ -> 
-------------------------------------
PLAYER 3
♣ -> 
♠ -> 8 4 2 
♥ -> 
♦ -> 
-------------------------------------
Starting Hand 11
Player 3 played a card 8 of ♠
Player 0 played a card 6 of ♣
Player 1 played a card 8 of ♣
Player 2 played a card 9 of ♣
Hand won by player 2
PLAYER 0
♣ -> 13 
♠ -> 
♥ -> 6 
♦ -> 
-------------------------------------
PLAYER 1
♣ -> 12 10 
♠ -> 
♥ -> 
♦ -> 
-------------------------------------
PLAYER 2
♣ -> 5 
♠ -> 
♥ -> 10 
♦ -> 
-------------------------------------
PLAYER 3
♣ -> 
♠ -> 4 2 
♥ -> 
♦ -> 
-------------------------------------
Starting Hand 12
Player 2 played a card 10 of ♥
Player 3 played a card 2 of ♠
Player 0 played a card 6 of ♥
Player 1 played a card 10 of ♣
Hand won by player 1
PLAYER 0
♣ -> 13 
♠ -> 
♥ -> 
♦ -> 
-------------------------------------
PLAYER 1
♣ -> 12 
♠ -> 
♥ -> 
♦ -> 
-------------------------------------
PLAYER 2
♣ -> 5 
♠ -> 
♥ -> 
♦ -> 
-------------------------------------
PLAYER 3
♣ -> 
♠ -> 4 
♥ -> 
♦ -> 
-------------------------------------
Starting Hand 13
Player 1 played a card 12 of ♣
Player 2 played a card 5 of ♣
Player 3 played a card 4 of ♠
Player 0 played a card 13 of ♣
Hand won by player 0
--------STATS-------
Player 0 won 1 hands
Player 1 won 3 hands
Player 2 won 4 hands
Player 3 won 5 hands
