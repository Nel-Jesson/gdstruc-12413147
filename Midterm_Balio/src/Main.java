import java.util.Scanner;

void main() {

    Scanner scanner = new Scanner(System.in);

    GameLogic gameLogic = new GameLogic();

    int turn = 1;

    System.out.println("=== Card Deck Program ===");
    System.out.println("Initial Deck Size: " + gameLogic.playerDeck.size());

    while (!gameLogic.isGameOver())
    {
        //For user input
        System.out.print("\nPress enter to proceed to Turn " + turn + " (or just type 'quit' to end the program): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("quit"))
        {
            break;
        }

        //Runs the game. One turn at a time
        gameLogic.runTurn(turn);
        turn++;
    }

    System.out.println("\n=== Game End ===");
    System.out.println("Your deck has been emptied after " + (turn - 1) + " turns.");
    scanner.close();
}
