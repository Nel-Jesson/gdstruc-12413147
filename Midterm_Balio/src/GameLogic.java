import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class GameLogic {
    public CardStack playerDeck;
    private CardStack discardedPile;
    private List<Card> playerHand;
    private Random random;

    private static final int initialDeckSize = 30;
    private static final String[] cardNames = {"Fire", "Water", "Nihility", "Light", "Electric"};

    public GameLogic()
    {
        this.playerDeck = initialDeckSize();
        this.discardedPile = new CardStack();
        this.playerHand = new ArrayList<>();
        this.random = random = new Random();
    }

    private CardStack initialDeckSize()
    {
        CardStack deck = new CardStack();
        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < initialDeckSize; i++)
        {
            String name = cardNames[i % cardNames.length];
            cards.add(new Card(name));
        }

        deck.addAll(cards);
        deck.shuffle();
        return deck;
    }

    private void drawCards()
    {
        int count = random.nextInt(5) + 1;
        count = Math.min(count, playerDeck.size());

        if (count == 0)
        {
            System.out.println("-> Console: Draw 0 cards (The deck is empty).");
            return;
        }

        for (int i = 0; i < count; i++)
        {
            Card drawnCard = playerDeck.pop();
            playerHand.add(drawnCard);
        }
        //Found out about %d
        System.out.printf("-> Console: Draw %d card(s) from the deck.\n", count);
    }

    private void discardCards()
    {
        int count = random.nextInt(5) + 1;
         count = Math.min(count, playerHand.size());

         if (count == 0)
         {
             System.out.println("-> Console: discarded 0 cards (The hand is empty).");
                return;
         }

         for (int i = 0; i < count; i++)
         {
             Card disardedCard = playerHand.remove(playerHand.size() - 1);
             discardedPile.push(disardedCard);
         }
         System.out.printf(" -> Console: Discarded %d card(s) to the pile.\n", count);
    }

    private void getFromDiscard()
    {
        int count = random.nextInt(5) + 1;
        count = Math.min(count, discardedPile.size());

        if (count == 0)
        {
            System.out.println("-> Console: Get 0 cards (Discarded pile is empty).");
            return;
        }

        List<Card> retrievedCards = discardedPile.pop(count);
        playerHand.addAll(retrievedCards);

        System.out.printf("-> Console: get %d card(s) from Discarded pile (Top-most cards).\n", retrievedCards.size());
    }

    private void displayInfo(int turn)
    {
        System.out.println("\n === Turn " + turn + "===");
        System.out.println("List of cards that you're currently holding: " + playerHand.toString());
        System.out.println("Number of remaining cards in your deck: " + playerDeck.size());
        System.out.println("Number of cards in the discarded pile: " + discardedPile.size());
        System.out.println("=======================");
    }

    public void runTurn(int turn)
    {
        int commandType = random.nextInt(3);

        System.out.println("\n### Starting Turn " + turn + "###");

        if (commandType == 0)
        {
            drawCards();
        }
        else if (commandType == 1)
        {
            discardCards();
        }
        else
        {
            getFromDiscard();
        }

        displayInfo(turn);
    }

    public boolean isGameOver()
    {
        return playerDeck.isEmpty();
    }
}
