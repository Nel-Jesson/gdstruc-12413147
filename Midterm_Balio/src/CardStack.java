import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class CardStack {
    private LinkedList<Card> stack;

    public CardStack()
    {
        stack = new LinkedList<>();
    }

    public void push(Card card)
    {
        stack.push(card);
    }

    public Card pop()
    {
        if (stack.isEmpty())
        {
            return null;
        }
        return stack.pop();
    }

    public List<Card> pop(int count)
    {
        List<Card> poppedCards = new java.util.ArrayList<>();

        for (int i = 0; i < count && !stack.isEmpty(); i++)
        {
            poppedCards.add(stack.pop());
        }
        return poppedCards;
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public int size()
    {
        return stack.size();
    }

    public void addAll(List<Card> cards)
    {
        stack.addAll(cards);
    }

    public void shuffle()
    {
        Collections.shuffle(stack);
    }

    @Override
    public String toString()
    {
        return "Total Cards (" + size() + "): " + stack.toString();
    }
}
