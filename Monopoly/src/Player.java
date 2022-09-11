import java.util.*;
public class Player {
    private  String name;
    private  ArrayList <Space> properties;
    private int money;
    private boolean inJail;
    private int lastRoll;
    private int currentSpace;
    private int doublesInSuccession;
    private int daysInJail;
    private static int passGo;

    public Player(){

    }
    public Player(String playerName, int startingMoney){
        name = playerName;
        properties = new ArrayList();
        money = startingMoney;
        inJail = false;
        currentSpace = 0;
    }
    public void roll()throws InterruptedException{
        int die1 = (int) (Math.random() * 6 + 1);
        int die2 = (int) (Math.random() *6 + 1);
        if(die1 == die2)
            doublesInSuccession++;
        if(die1 != die2)
            doublesInSuccession = 0;
        lastRoll =  die1 + die2;
        if(doublesInSuccession == 3){
            Thread.sleep(100);
            System.out.println(name + " rolled 3 doubles.");
            setInJail(true);
            doublesInSuccession = 0;
        }
        if(inJail == false) {
            currentSpace += lastRoll;
            Thread.sleep(100);
            System.out.println(getName() + " rolled a " + lastRoll);
            if(die1 == die2){
                Thread.sleep(100);
                System.out.println(getName() + " rolled a double");
            }
            if (currentSpace >= 40) {
                Thread.sleep(100);
                System.out.println(name + " passed GO. You get $" + passGo);
                money += passGo;
            }
            currentSpace = currentSpace % 40;
            Thread.sleep(100);
            System.out.println(name + " landed on " + Properties.getSpace(currentSpace).getName());
        }
    }
    public int getDoublesInSuccession(){
        return doublesInSuccession;
    }
    public int calculateBuyProperty(int price) throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        Thread.sleep(100);
        System.out.println("Would you like to buy " + getCurrentSpaceName() + " for $" + price + "?\n1:Buy\n2:Pass");
        int pick = scan.nextInt();
        return pick;
    }
    public void buyProperty(Space x){
        properties.add(x);
    }
    public ArrayList getProperties(){
        return properties;
    }
    public String propertiesOwned(boolean numbered)throws InterruptedException{
        String ownedProps = name + " owns: ";
        if(numbered == true){
            ownedProps += "\n";
            if(properties.size()>0) {
                for (int i = 0; i < properties.size() - 1; i++) {
                    ownedProps += (i + 1) + ": " + properties.get(i).getName() + "\n";
                }
                ownedProps += properties.size() + ": " + properties.get(properties.size() - 1).getName() + ".";
            }
            else{
                return name + " owns: no properties.";
            }
            return ownedProps;
        }
        if(properties.size()>0) {
            for (int i = 0; i < properties.size() - 1; i++) {
                ownedProps += properties.get(i).getName() + ", ";
            }
            ownedProps += properties.get(properties.size() - 1).getName() + ".";
        }
        else{
            return name + " owns: no properties.";
        }
        return ownedProps;
    }
    public void setInJail(boolean x) throws InterruptedException{
        Thread.sleep(100);
        System.out.println(name + " is now in jail.");
        inJail = x;
        currentSpace = 10;
        if(x == true)
            daysInJail = 0;
    }
    public int getDaysInJail(){
        return daysInJail;
    }
    public void addDayInJail(){
        daysInJail++;
    }
    public boolean getInJail(){
        return inJail;
    }
    public int getLastRoll(){
        return lastRoll;
    }
    public String getName(){
        return name;
    }
    public String getCurrentSpaceName(){
        return Properties.getSpace(currentSpace).getName();
    }
    public int getCurrentSpace(){
        return currentSpace;
    }
    public int getMoney(){
        return money;
    }

    public boolean hasASet(int space){
        if(space == 1 || space == 3){
            if(Properties.getSpace(1).getOwnerName().equals(name) && Properties.getSpace(3).getOwnerName().equals(name)){
                return true;
            }
        }
        if(space == 6 || space == 8 || space == 9){
            if(Properties.getSpace(6).getOwnerName().equals(name) && Properties.getSpace(8).getOwnerName().equals(name) && Properties.getSpace(9).getOwnerName().equals(name)){
                return true;
            }
        }
        if(space == 11 || space == 13 || space == 14){
            if(Properties.getSpace(11).getOwnerName().equals(name) && Properties.getSpace(13).getOwnerName().equals(name) && Properties.getSpace(14).getOwnerName().equals(name)){
                return true;
            }
        }
        if(space == 16 || space == 18 || space == 19){
            if(Properties.getSpace(16).getOwnerName().equals(name) && Properties.getSpace(18).getOwnerName().equals(name) && Properties.getSpace(19).getOwnerName().equals(name)){
                return true;
            }
        }
        if(space == 26 || space == 27 || space == 29){
            if(Properties.getSpace(26).getOwnerName().equals(name) && Properties.getSpace(27).getOwnerName().equals(name) && Properties.getSpace(29).getOwnerName().equals(name)){
                return true;
            }
        }
        if(space == 31 || space == 32 || space == 34){
            if(Properties.getSpace(31).getOwnerName().equals(name) && Properties.getSpace(32).getOwnerName().equals(name) && Properties.getSpace(34).getOwnerName().equals(name)){
                return true;
            }
        }
        if(space == 37 || space == 39){
            if(Properties.getSpace(37).getOwnerName().equals(name) && Properties.getSpace(39).getOwnerName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public void changeMoney(int amount){
        money += amount;
    }
    public String printMoney(){
        return name +" has $" + money + ".";
    }
    public void makeTrade(Player trader, Player tradie)throws InterruptedException {
        int toTradeWith = -1;
        Scanner scanned = new Scanner(System.in);
        Thread.sleep(100);
        System.out.println("Choose what you want to trade.(press a different number to not trade a property)");
        System.out.println(propertiesOwned(true));
        int pickWith = scanned.nextInt();
        if (pickWith <= properties.size()) {
            toTradeWith = pickWith - 1;
        }
        Thread.sleep(100);
        System.out.println("How much money will you trade?");
        int moneyToTrade = scanned.nextInt();
        while(moneyToTrade > trader.getMoney() && moneyToTrade > 0){
            System.out.println("You need to pick an amount that is not greater than what you have or less than zero.");
            moneyToTrade = scanned.nextInt();
        }

        int toTradeFor = -1;
        Thread.sleep(100);
        System.out.println("Choose what you want to trade for.(press a different number to not trade a property)");
        System.out.println(tradie.propertiesOwned(true));
        int pickFor = scanned.nextInt();
        if (pickFor <= tradie.properties.size()) {
            toTradeFor = pickFor - 1;
        }
        Thread.sleep(100);
        System.out.println("How much money will you trade for?");
        int moneyToTradeFor = scanned.nextInt();
        while(moneyToTradeFor > tradie.getMoney() && moneyToTradeFor > 0){
            Thread.sleep(100);
            System.out.println("You need to pick an amount that is not greater than what you have or less than zero.");
            moneyToTradeFor = scanned.nextInt();
        }

        if (toTradeWith != -1 && toTradeWith < properties.size()) {
            Thread.sleep(100);
            System.out.print(trader.getName() + " would like to trade " + properties.get(toTradeWith).getName() + " and $" + moneyToTrade);
        } else {
            Thread.sleep(100);
            System.out.print(trader.getName() + " would like to trade $" + moneyToTrade);
        }
        if (toTradeFor != -1 && toTradeFor < tradie.properties.size()) {
            Thread.sleep(100);
            System.out.println(" for " + tradie.properties.get(toTradeFor).getName() + " and $" + moneyToTradeFor);
        } else {
            Thread.sleep(100);
            System.out.println(" for $" + moneyToTradeFor);
        }
        Thread.sleep(100);
        System.out.println("Press 1 for yes, or 2 for no.");
        int pick = scanned.nextInt();
        if (pick == 1) {
            if (toTradeWith != -1 && toTradeWith < properties.size()) {
                trader.properties.get(toTradeWith).changeOwner(tradie);
                tradie.properties.add(trader.properties.get(toTradeWith));
                trader.properties.remove((toTradeWith));
            }
            if (toTradeFor != -1 && toTradeFor < tradie.properties.size()) {
                tradie.properties.get(toTradeFor).changeOwner(trader);
                trader.properties.add(tradie.properties.get(toTradeFor));
                tradie.properties.remove((tradie.properties.get(toTradeFor)));
            }
            trader.changeMoney(moneyToTradeFor);
            trader.changeMoney(-1 * moneyToTrade);
            trader.printMoney();
            tradie.changeMoney(moneyToTrade);
            tradie.changeMoney(moneyToTradeFor * -1);
            tradie.printMoney();
        }
    }
    public void mortgage()throws InterruptedException {
        ArrayList<Space> validForMortgage = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Thread.sleep(100);
        System.out.println("You can mortgage:");
        for (int l = 1; l < 40; l++) {
            if (Properties.getSpace(l).getOwnerName().equals(name) && Properties.getSpace(l).isMortgaged() == false) {
                if (Properties.getSpace(l) instanceof Property || Properties.getSpace(l) instanceof Utility || Properties.getSpace(l) instanceof RailRoad) {
                    validForMortgage.add(Properties.getSpace(l));
                    System.out.println(validForMortgage.size() + ": " + Properties.getSpace(l) + " for $" + (Properties.getSpace(l)).getMortgage());
                }
            }
            if (validForMortgage.size() > 0) {
                int propertyToMortgage = scan.nextInt();
                if (propertyToMortgage <= validForMortgage.size()) {
                    validForMortgage.get(propertyToMortgage - 1).setMortgaged(true);
                } else {
                    Thread.sleep(100);
                    System.out.println("Not Valid!");
                }
            } else {
                Thread.sleep(100);
                System.out.println("Nothing");
            }
        }
    }
    public void unmortgage()throws InterruptedException{
        ArrayList<Space> validForUnMortgage = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Thread.sleep(100);
        System.out.println("You can un-mortgage:");
        for (int l = 1; l < 40; l++) {
            if (Properties.getSpace(l).getOwner().equals(name) && Properties.getSpace(l).isMortgaged() == true) {
                if (Properties.getSpace(l) instanceof Property || Properties.getSpace(l) instanceof Utility || Properties.getSpace(l) instanceof RailRoad) {
                    validForUnMortgage.add(Properties.getSpace(l));
                    System.out.println(validForUnMortgage.size() + ": " + Properties.getSpace(l) + " for $" + (Properties.getSpace(l)).getMortgage());
                }
            }
        }
        if (validForUnMortgage.size() > 0) {
            int propertyToMortgage = scan.nextInt();
            if (propertyToMortgage <= validForUnMortgage.size()) {
                validForUnMortgage.get(propertyToMortgage - 1).setMortgaged(false);
            } else {
                Thread.sleep(100);
                System.out.println("Not Valid!");
            }
        } else {
            Thread.sleep(100);
            System.out.println("Nothing");
        }
    }
    public void resetDoublesInSuccession(){
        doublesInSuccession = 0;
    }
    public void setCurrentSpace(int x){
        currentSpace = x;
    }

    public static void setPassGo(int x) {
        passGo = x;
    }
    public static int getPassGo(){
        return passGo;
    }
    public String toString(){
        return name + " is on " + getCurrentSpaceName() + " and has $" + money + " left";
    }
}
