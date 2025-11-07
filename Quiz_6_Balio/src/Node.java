public class Node {
    private int data;
    private Node rightChild;
    private Node leftChild;

    public void insert(int value)
    {
        if(value == data) //Doesn't accept duplicate data
        {
            return;
        }

        if (value < data)
        {
            if (leftChild == null)
            {
                leftChild = new Node(value);
            }
            else
            {
                leftChild.insert(value);
            }
        }
        else
        {
           if (rightChild == null)
           {
               rightChild = new Node(value);
           }
           else
           {
               rightChild.insert(value);
           }
        }
    }

    public void traverseInOrder()
    {
        if (leftChild != null)
        {
            leftChild.traverseInOrder();
        }
        System.out.println("Data: " + data);

        if (rightChild != null)
        {
            rightChild.traverseInOrder();
        }
    }

    public Node getMin()
    {
        if (leftChild == null)
        {
            return this; //for the minimum (i.e leftmost)
        }
        return leftChild.getMin(); // step to left
    }

    public Node getMax()
    {
        if (rightChild == null)
        {
            return this; //to the max!! (Just the rightmost)
        }
        return rightChild.getMax(); // step to right
    }

    public void traversInOrderDescending() // Cha Cha real smooth (I hope someone gets this)
    {
        if (rightChild != null)
        {
            rightChild.traverseInOrder();
        }
        System.out.println("Data: " + data);

        if (leftChild != null)
        {
            leftChild.traverseInOrder();
        }
    }

    public Node get(int value)
    {
        if (value == data)
        {
            return this;
        }

        if (value < data)
        {
           if (leftChild != null)
           {
               return leftChild.get(value);
           }
        }
        else
        {
            if (rightChild != null)
            {
                return rightChild.get(value);
            }
        }

        return null;
    }

    public Node(int _data)
    {
        this.data = _data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
