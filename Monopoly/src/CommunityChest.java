public class CommunityChest extends Space implements Landed{

    private String statement;
    private int type;
    private int spaceToMoveTo;
    private boolean passGo;
    private int money;

    public CommunityChest(){
        type = 0;
    }
    public CommunityChest(String cardStatement, int t){
        statement = cardStatement;
        type = t;
    }
    public CommunityChest(String cardStatement, int t, int x, boolean g){
        statement = cardStatement;
        type = t;
        spaceToMoveTo = x;
        passGo = g;
    }
    public CommunityChest(String cardStatement, int t, int m){
        statement = cardStatement;
        type = t;
        money = m;
    }
    public String getName(){
        return "Community Chest";
    }
    public void landedOn(Player x)throws InterruptedException{
        if(type == 0){
            RandomCards.getRandomChest().landedOn(x);
        }
        else {
            System.out.println(statement);
            if (type == 1) {
                x.setCurrentSpace(spaceToMoveTo);
                if (passGo == true) {
                    x.changeMoney(Player.getPassGo());
                    x.printMoney();
                }
                if (spaceToMoveTo == 10)
                    x.setInJail(true);
            }
            if (type == 2) {
                x.changeMoney(money);
                x.printMoney();
            }
            if (type == 3) {
                for (int i = 0; i < MonopolyRunner.players.size(); i++) {
                    if (MonopolyRunner.players.get(i) != x) {
                        MonopolyRunner.players.get(i).changeMoney(money);
                        MonopolyRunner.players.get(i).printMoney();
                        x.changeMoney(-1 * money);
                    }
                }
                x.printMoney();
            }
            if (type == 5) {
                int totalHouses = 0;
                int totalHotels = 0;
                for (int i = 0; i < 40; i++) {
                    if (Properties.getSpace(i) instanceof Property) {
                        Property temp = (Property) Properties.getSpace(i);
                        if (temp.getOwner() == x) {
                            if (temp.getNumHouses() > 1 && temp.getNumHouses() < 5)
                                totalHouses += temp.getNumHouses();
                            if (temp.getNumHouses() == 5)
                                totalHotels++;
                        }
                    }
                }
                x.changeMoney((totalHouses * 40) + (totalHotels * 115));
                x.printMoney();
            }
        }
    }
    public String toString(){
        return "You are on Community Chest";
    }
}

