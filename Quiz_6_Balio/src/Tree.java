public class Tree {
    private Node root;

    public void insert(int value)
    {
        if (root == null)
        {
            root = new Node(value);
        }
        else
        {
           root.insert(value);
        }
    }

    public void traverseInOrder()
    {
        if (root != null)
        {
            root.traverseInOrder();
        }
    }

    public Node getMin() // find the least value on the tree. Or goes null when it's empty
    {
        if (root == null)
        {
            return null;
        }
        return root.getMin();
    }

    public Node getMax() // Similar to Min but just for Max.
    {
        if (root == null)
        {
            return null;
        }
        return root.getMax();
    }

    public void traverseInOrderDescending() // Traverses the tree through in-order method... Self-explanatory tbh.
    {
        if (root != null)
        {
            root.traversInOrderDescending();
        }
    }

    public Node get(int value)
    {
        if (root != null)
        {
            return root.get(value);
        }
        return null;
    }

}
