public class Chance extends Space implements Landed{
    private String statement;
    private int type;
    private int spaceToMoveTo;
    private boolean passGo;
    private int money;

    public Chance(){
        type = 0;
    }
    public Chance(String cardStatement, int t){
      statement = cardStatement;
      type = t;
    }
    public Chance(String cardStatement, int t, int x, boolean g){
        statement = cardStatement;
        type = t;
        spaceToMoveTo = x;
        passGo = g;
    }
    public Chance(String cardStatement, int t, int m){
        statement = cardStatement;
        type = t;
        money = m;
    }
    public String getName(){
        return "Chance";
    }
    public void landedOn(Player x)throws InterruptedException{
        if(type == 0){
            RandomCards.getRandomChance().landedOn(x);
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
                if (x.getCurrentSpace() > 34 && x.getCurrentSpace() < 5) {
                    x.setCurrentSpace(5);
                    RailRoad temp = (RailRoad) Properties.getSpace(5);
                    temp.landedOn(x, true);
                }
                else if (x.getCurrentSpace() > 4 && x.getCurrentSpace() < 15) {
                    x.setCurrentSpace(15);
                    RailRoad temp = (RailRoad) Properties.getSpace(15);
                    temp.landedOn(x, true);
                }
                else if (x.getCurrentSpace() > 14 && x.getCurrentSpace() < 25) {
                    x.setCurrentSpace(25);
                    RailRoad temp = (RailRoad) Properties.getSpace(25);
                    temp.landedOn(x, true);
                }
                else if (x.getCurrentSpace() > 24 && x.getCurrentSpace() < 35) {
                    x.setCurrentSpace(35);
                    RailRoad temp = (RailRoad) Properties.getSpace(35);
                    temp.landedOn(x, true);
                }
            }
            if (type == 4) {
                if (x.getCurrentSpace() > 11 && x.getCurrentSpace() < 28) {
                    x.setCurrentSpace(28);
                    Utility temp = (Utility) Properties.getSpace(28);
                    temp.landedOn(x, true);
                }
                else if (x.getCurrentSpace() > 27 && x.getCurrentSpace() < 12) {
                    x.setCurrentSpace(12);
                    Utility temp = (Utility) Properties.getSpace(12);
                    temp.landedOn(x, true);
                }
            }
            if (type == 6) {
                x.setCurrentSpace(x.getCurrentSpace() - 3);
                Properties.getSpace(x.getCurrentSpace()).landedOn(x);
            }
            if (type == 7) {
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
                x.changeMoney((totalHouses * 25) + (totalHotels * 100));
                x.printMoney();
            }
            if (type == 8) {
                for (int i = 0; i < MonopolyRunner.players.size(); i++) {
                    if (MonopolyRunner.players.get(i) != x) {
                        MonopolyRunner.players.get(i).changeMoney(50);
                        MonopolyRunner.players.get(i).printMoney();
                        x.changeMoney(-50);
                    }
                }
                x.printMoney();
            }
        }
    }
    public String toString(){
        return "You are on Chance";
    }
}

