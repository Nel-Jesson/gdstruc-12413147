public class Main {
    //After for like... 9-ish commits I finally found out how to use properly public class Main
    //And public static void when I was doing some testing....
    //I'm really slow huh....

    public static void main(String[] args) {
            Tree tree = new Tree();

            tree.insert(32);
            tree.insert(1);
            tree.insert(-20);
            tree.insert(-5);
            tree.insert(37);
            tree.insert(15);
            tree.insert(42);

            System.out.println("=== Getting the Minium Value... ===");
            Node minNode = tree.getMin();
            if (minNode != null)
            {
                System.out.println("The minimum value is " + minNode);
            }
            else
            {
                System.out.println("Huh... The tree is empty at the moment...");
            } //Just for when there's no values

            System.out.println("\n=== Getting the Maximum Value...");
             Node maxNode = tree.getMin();
            if (maxNode != null)
            {
                System.out.println("The maximum value is " + maxNode);
            }
            else
            {
                System.out.println("Huh... The tree is empty at the moment...");
            }

            System.out.println("\n=== Now for the Traverse in Descending order...");
            tree.traverseInOrderDescending();

            System.out.println("\n=== This is the Standard Order...");
            tree.traverseInOrder();

            System.out.println("\n=== That's all, ending program...");
    }
}
