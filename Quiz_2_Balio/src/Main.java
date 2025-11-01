//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.chrono.Era;
import java.util.ArrayList;
import java.util.List;

public class Main {

        public static void main(String[] args){


            Player Era = new Player( 1, "Era", 25);
            Player Charles = new Player(2, "Charles",  29);
            Player Shiro = new Player( 3,  "Shiro", 23);
            Player Aki = new Player(4, "Aki", 20);
            Player Jayce = new Player(5, "Jayce", 22);

            PlayerLinkedList playerLinkedList = new PlayerLinkedList();
            System.out.println("--------------\n");
            System.out.println("Initial Size: " + playerLinkedList.getSize());
            System.out.println("\n-----------------\n");

            playerLinkedList.addToFront(Era);
            playerLinkedList.addToFront(Charles);
            playerLinkedList.addToFront(Shiro);
            playerLinkedList.addToFront(Aki);
            playerLinkedList.addToFront(Jayce);

            Player removed = playerLinkedList.removeFromFront();
            if (removed != null) {
                System.out.println("Removed player: " + removed);
            }

            System.out.println("\n-----------------\n");
            System.out.println("List before removal [Aside from earlier remove player] (Size: " + playerLinkedList.getSize() + "):");
            playerLinkedList.printList();
            System.out.println("\n-----------------\n");

            Player removed1 = playerLinkedList.removeFromFront();
            if (removed1 != null) {
                System.out.println("Removed player: " + removed1 + ". New Size: " + playerLinkedList.getSize());
            }

            System.out.println("\n-----------------\n");
            System.out.println("Checking for Shiro in the list... " + playerLinkedList.contains(Shiro));
            System.out.println("Shiro's index is: " + playerLinkedList.indexOf(Shiro));
            System.out.println("\n-----------------");


            System.out.println("\nFinal List (Size: " + playerLinkedList.getSize() + "):");
            playerLinkedList.printList();
        }
}
