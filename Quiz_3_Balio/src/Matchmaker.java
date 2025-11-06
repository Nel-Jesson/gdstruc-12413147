import java.util.List;
import java.util.Random;

public class Matchmaker {
    private final int GameGoal = 10;
    private final int MinPlayerForGame = 5;

    private ArrayQueue matchQueue;
    private int gameMade;
    private Random random;

    public Matchmaker()
    {
        this.matchQueue = new ArrayQueue(50);
        this.gameMade = 0;
        this.random = new Random();
    }

    public void runTurn(int turn)
    {
        int newPlayers = random.nextInt(7) + 1;
        System.out.printf("=== Turn %d ===\n", turn);
        System.out.printf("-> %d new player(s) joined the queue.\n", newPlayers);

        for (int i = 0; i <newPlayers; i++)
        {
            //Made it separate since it's too long
            Player newPlayer = new Player(random.nextInt(1000), "Player" + (random.nextInt(900) + 100),
                    random.nextInt(99) + 1);
            matchQueue.add(newPlayer);
        }

        if (matchQueue.size() >= MinPlayerForGame)
        {
            startNewGame();
        }
        else
        {
            System.out.printf("-> Not enough players (%d needed).\n",
                    MinPlayerForGame - matchQueue.size());
        }

        displayInfo();
    }

    private void startNewGame()
    {
        System.out.println("\n### Game has Began ###");
        List<Player> gameRoster = new java.util.ArrayList<>();

        for (int i = 0; i < MinPlayerForGame; i++)
        {
            Player p = matchQueue.remove();
            gameRoster.add(p);
        }

        gameMade++;
        System.out.printf("-> Game #%d has successfully created! Current Roster: %s%n",
                gameMade, gameRoster.toString()); // Pretty much uses the Player's toString. And also found out about %s
    }

    private void displayInfo()
    {
       System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       System.out.printf("Games done: %d / %d%n", gameMade, GameGoal);
       System.out.printf("The Queue Size: %d player(s)%n", matchQueue.size());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public boolean isGoalReached()
    {
        return gameMade >= GameGoal;
    }
}
