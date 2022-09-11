import java.util.*;
public class AI extends Player {
    public AI(String playerName, int startingMoney){
        super(playerName,startingMoney);
    }


    public int calculateBuyProperty(int price) {
        if (price * 2 <= this.getMoney()) {
            return 1;
        }
        if (price > this.getMoney()) {
            return 0;
        } else {
            int choice = (int) Math.random() * (this.getMoney() / price) * 10;
            if (choice >= 14) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    public void calculateBuyHouse() throws InterruptedException{
        ArrayList<Property> validForHouse = new ArrayList<>();
        boolean foundSet = false;
        for (int l = 1; l < 40; l++) {
            if (Properties.getSpace(l) instanceof Property) {
                if (hasASet(l) && ((Property) Properties.getSpace(l)).getNumHouses() < 5) {
                    foundSet = true;
                    validForHouse.add((Property) Properties.getSpace(l));
                }
            }
        }
        if (foundSet == true) {
                for(int i = validForHouse.size() - 1; i >= 0; i--) {
                    int buy = 0;
                    if(getMoney() >= 1000)
                        buy = 1;
                    if(getMoney() < 1000) {
                        Random rand = new Random();
                        buy = rand.nextInt(2);
                    }
                    if(getMoney() - validForHouse.get(i).getPriceOfHouse() > 500 && buy == 1) {
                        validForHouse.get(i).addHouse();
                        Thread.sleep(100);
                        System.out.println(getName() + " bought a house on " + validForHouse.get(i).getName() + " for $" + validForHouse.get(i).getPriceOfHouse());
                    }
                }
            }
    }
    public void calculateTrade() throws InterruptedException {
        Space forTrade = Properties.getSpace(0);
        for(int i = 0; i < 40; i ++){
            if(Properties.getSpace(i) instanceof Property || Properties.getSpace(i) instanceof Utility || Properties.getSpace(i) instanceof RailRoad) {
                if (Properties.getSpace(i).getOwnerName().equals(super.getName()) && hasASet(i)) {
                    forTrade = Properties.getSpace(i);
                }
            }
        }
        if(forTrade != Properties.getSpace(0)) {
            if (!playerHasWantedProperty(forTrade.getSpaceNumber()).getName().equals("no one") && !playerHasWantedProperty(forTrade.getSpaceNumber()).getName().equals(super.getName())) {

                makeTrade(this, playerHasWantedProperty(forTrade.getSpaceNumber()));
            }
        }
    }
    public Player playerHasWantedProperty(int space){
        if(space == 1 || space == 3){
            if(!Properties.getSpace(3).getOwnerName().equals("no one") && !Properties.getSpace(3).getOwnerName().equals(super.getName())){
                return Properties.getSpace(3).getOwner();
            }
            if(Properties.getSpace(1).getOwnerName().equals("no one") && !Properties.getSpace(1).getOwnerName().equals(super.getName())){
                return Properties.getSpace(1).getOwner();
            }
        }
        if(space == 6 || space == 8 || space == 9){
            if(Properties.getSpace(9).getOwnerName().equals("no one") && !Properties.getSpace(9).getOwnerName().equals(super.getName())){
                return Properties.getSpace(9).getOwner();
            }
            if(Properties.getSpace(8).getOwnerName().equals("no one") && !Properties.getSpace(8).getOwnerName().equals(super.getName())){
                return Properties.getSpace(8).getOwner();
            }
            if(Properties.getSpace(6).getOwnerName().equals("no one") && !Properties.getSpace(6).getOwnerName().equals(super.getName())){
                return Properties.getSpace(6).getOwner();
            }
        }
        if(space == 11 || space == 13 || space == 14){
            if(Properties.getSpace(14).getOwnerName().equals("no one") && !Properties.getSpace(14).getOwnerName().equals(super.getName())){
                return Properties.getSpace(14).getOwner();
            }
            if(Properties.getSpace(13).getOwnerName().equals("no one") && !Properties.getSpace(13).getOwnerName().equals(super.getName())){
                return Properties.getSpace(13).getOwner();
            }
            if(Properties.getSpace(11).getOwnerName().equals("no one") && !Properties.getSpace(11).getOwnerName().equals(super.getName())){
                return Properties.getSpace(11).getOwner();
            }
        }
        if(space == 16 || space == 18 || space == 19){
            if(Properties.getSpace(19).getOwnerName().equals("no one") && !Properties.getSpace(19).getOwnerName().equals(super.getName())){
                return Properties.getSpace(19).getOwner();
            }
            if(Properties.getSpace(18).getOwnerName().equals("no one") && !Properties.getSpace(18).getOwnerName().equals(super.getName())){
                return Properties.getSpace(18).getOwner();
            }
            if(Properties.getSpace(16).getOwnerName().equals("no one") && !Properties.getSpace(16).getOwnerName().equals(super.getName())){
                return Properties.getSpace(16).getOwner();
            }
        }
        if(space == 21 || space == 23 || space == 24){
            if(Properties.getSpace(24).getOwnerName().equals("no one") && !Properties.getSpace(24).getOwnerName().equals(super.getName())){
                return Properties.getSpace(24).getOwner();
            }
            if(Properties.getSpace(23).getOwnerName().equals("no one") && !Properties.getSpace(23).getOwnerName().equals(super.getName())){
                return Properties.getSpace(23).getOwner();
            }
            if(Properties.getSpace(23).getOwnerName().equals("no one") && !Properties.getSpace(23).getOwnerName().equals(super.getName())){
                return Properties.getSpace(21).getOwner();
            }
        }
        if(space == 26 || space == 27 || space == 29){
            if(Properties.getSpace(29).getOwnerName().equals("no one") && !Properties.getSpace(29).getOwnerName().equals(super.getName())){
                return Properties.getSpace(29).getOwner();
            }
            if(Properties.getSpace(27).getOwnerName().equals("no one") && !Properties.getSpace(27).getOwnerName().equals(super.getName())){
                return Properties.getSpace(27).getOwner();
            }
            if(Properties.getSpace(26).getOwnerName().equals("no one") && !Properties.getSpace(26).getOwnerName().equals(super.getName())){
                return Properties.getSpace(26).getOwner();
            }
        }
        if(space == 31 || space == 32 || space == 34){
            if(Properties.getSpace(34).getOwnerName().equals("no one") && !Properties.getSpace(34).getOwnerName().equals(super.getName())){
                return Properties.getSpace(34).getOwner();
            }
            if(Properties.getSpace(32).getOwnerName().equals("no one") && !Properties.getSpace(32).getOwnerName().equals(super.getName())){
                return Properties.getSpace(32).getOwner();
            }
            if(Properties.getSpace(31).getOwnerName().equals("no one") && !Properties.getSpace(31).getOwnerName().equals(super.getName())){
                return Properties.getSpace(31).getOwner();
            }
        }
        if(space == 37 || space == 39){
            if(Properties.getSpace(39).getOwnerName().equals("no one") && !Properties.getSpace(39).getOwnerName().equals(super.getName())){
                return Properties.getSpace(39).getOwner();
            }
            if(Properties.getSpace(37).getOwnerName().equals("no one") && !Properties.getSpace(37).getOwnerName().equals(super.getName())){
                return Properties.getSpace(37).getOwner();
            }
        }
        return this;
    }
}
