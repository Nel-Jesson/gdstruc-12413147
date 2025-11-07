

void main() {

        Player Era = new Player(14, "Era", 45);
        Player Shiro = new Player(19, "Shiro", 39);
        Player XueQi = new Player(27, "XueQi", 40);
        Player Mint = new Player(31, "Mint", 38);
        Player MeiYei = new Player(6, "MeiYei", 37);

        SimpleHashtable hashtable = new SimpleHashtable();

        //Get the actual keys from player objects (And plus used for the test)
        String shiroKey = Shiro.getUserName();
        String xueqiKey = XueQi.getUserName();

        System.out.println("Adding in the keys...");
        hashtable.put(Era.getUserName(),Era);
        hashtable.put(Shiro.getUserName(), Shiro);
        hashtable.put(XueQi.getUserName(), XueQi);
        hashtable.put(Mint.getUserName(), Mint);
        hashtable.put(MeiYei.getUserName(), MeiYei);

        hashtable.printHashedTable();

        System.out.println("\nCommencing Retrieval and Removal Test...");

        System.out.println("Putting XueQi before the removal " + hashtable.get(xueqiKey));

        System.out.println("Now removing Shiro (Which is the colliding with XuiQi): ");
        Player removedPlayer = hashtable.remove(shiroKey);
        System.out.println("Removed " + removedPlayer + " successfully.");

        hashtable.printHashedTable();

        System.out.println("\nNow the Probing Test...");
        System.out.println("With XueQi in after Shiro's removal: " + hashtable.get(xueqiKey));

        System.out.println("======================================");
        System.out.println("Testing has been completed. XueQi is in the list while Shiro as been eliminated");
        System.out.println("Ending program now...");
        System.out.println("======================================");
}
