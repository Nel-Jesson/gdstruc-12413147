import java.util.Scanner;

 void main() {
     //Something to note
     //Wanted to manually add in players
     //Found out during testing the amount of players that could be added during the game
     //'nah' let's not do that
     Scanner scanner = new Scanner(System.in);
     Matchmaker matchmaker = new Matchmaker();
     int turn = 1;

     System.out.println("~~~ Starting Matchmaking program ~~~");

     while (!matchmaker.isGoalReached())
     {
         System.out.print("\nPlease press Enter to end Turn " + turn + " and run the matchmaking (Or simply type 'quit to end): ");
         String input = scanner.nextLine();

         if (input.equalsIgnoreCase("quit"))
         {
             System.out.println("Okay, the program has stopped.");
             break;
         }

         matchmaker.runTurn(turn);
         turn++;
     }

     if (matchmaker.isGoalReached())
     {
         System.out.println("\n ### Program has been terminated ###");
         System.out.println("The game has end. 10 games have been completed.");
     }

     scanner.close();
}
