public class SimpleHashtable {
    private StoredPlayer[] hashtable;
    private static final StoredPlayer End = new StoredPlayer(null, null);

    public SimpleHashtable()
    {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key)
    {
        if (key == null)
        {
            return 0;
        }
        return key.length() % hashtable.length;
    }

    public void put(String key, Player value)
    {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey)) // liner probing
        {
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length -1 )
            {
                hashedKey = 0;
            }
            else
            {
                hashedKey++;
            }

            while (isOccupied(hashedKey) && hashedKey != stoppingIndex)
            {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey))
        {
            System.out.println("Hey, there's already an element at position " + hashedKey);
        }
        else
        {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    public Player remove(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            return null; // for when key is not found
        }

        Player removePlayer = hashtable[hashedKey].value;

        hashtable[hashedKey] = End;

        System.out.println("Remove key " + key + " (Slot " + hashedKey + " has been deleted)");
        return removePlayer;
    }

    public Player get(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            return null;
        }
        return hashtable[hashedKey].value;
    }

    private int findKey(String key)
    {
        int hashedKey = hashKey(key);
        int stoppingIndex = hashedKey;

        while (hashtable[hashedKey] != null)
        {
            if (hashtable[hashedKey] != End
                    && hashtable[hashedKey].key.equals(key))
            {
                return hashedKey;
            }

            hashedKey = (hashedKey + 1) % hashtable.length;

            if (hashedKey == stoppingIndex)
            {
                return -1;
            }
        }
        return -1;
    }

    private boolean isOccupied(int index)
    {
        return hashtable[index] != null;
    }

    public void printHashedTable()
    {
        System.out.println("======================================");
        for (int i = 0; i < hashtable.length; i++)
        {
            if (hashtable[i] != null) {
                System.out.println("Element " + i + " " + hashtable[i].value);
            }
            else
            {
                System.out.println("Element " + i + " null");
            }
        }

        System.out.println("======================================");
    }
}
