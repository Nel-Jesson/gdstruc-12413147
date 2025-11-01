public class PlayerLinkedList {
    private PlayerNode head;
    private int size;

    public int getSize() {
        return size;
    }

    public void addToFront(Player player)
    {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        head = playerNode;
        size++;
    }

    public Player removeFromFront() {
        if (head == null) {
            return null;
        }
        PlayerNode removedNode = head;
        Player removedPlayer = removedNode.getPlayer();
        head = head.getNextPlayer();
        removedNode.setNextPlayer(null);

        size--;

        return removedPlayer;
    }

    public void printList() {
        PlayerNode current = head;
        System.out.print("Head -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNextPlayer();
        }
        System.out.println("Null");
    }

    public boolean contains(Player player) {
        PlayerNode current = head;

        while (current != null) {
            if (current.getPlayer().equals(player)){
                return true;
            }
            current = current.getNextPlayer();
        }
        return false;
    }

    public int indexOf(Player player) {
        PlayerNode current = head;
        int index = 0;

        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return index;
            }
            current = current.getNextPlayer();
            index++;
        }
        return -1;
    }
}
