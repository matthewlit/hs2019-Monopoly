public class Utility extends Space implements Landed{
    private String name;
    private int price;
    private int mortgage;
    private boolean mortgaged;

    public Utility(String utilityName, int spaceNum) {
        super(utilityName, spaceNum);
        price = 150;
        mortgage = 75;
        mortgaged = false;
    }
    public void landedOn(Player temp, boolean times10)throws InterruptedException{
        if(temp instanceof AI){

        }
        if (!super.getOwnerName().equals("no one")) {
            if(!super.getOwnerName().equals(temp.getName())) {
                chargeRent(temp,times10);
            }
        }
        else{
            int choice;
            choice = temp.calculateBuyProperty(price);
            if(choice == 1){
                temp.changeMoney(-1 * price);
                temp.printMoney();
                changeOwner(temp);
                temp.buyProperty(this);
                Thread.sleep(100);
                System.out.println(temp.getName() + " bought " + super.getName() + " for " + price );
            }
        }
    }

    public void chargeRent(Player temp, boolean times10)throws InterruptedException {
        //Checks if property is owned or if the player that landed on it already owns it
        int ownedUtilities = 0;

        if (Properties.getSpace(12).getOwner().equals(super.getOwner())) {
            ownedUtilities++;
        }
        if (Properties.getSpace(28).getOwner().equals(super.getOwner())) {
            ownedUtilities++;
        }
        if (!times10) {
            if (ownedUtilities == 1) {
                temp.changeMoney(-1 * temp.getLastRoll() * 4);
                temp.printMoney();
                super.getOwner().changeMoney(temp.getLastRoll() * 4);
                super.getOwner().printMoney();
                Thread.sleep(100);
                System.out.println(temp.getName() + " paid $" + temp.getLastRoll() * 4 + " in rent to " + getOwnerName() + ".");
            }
        }
        if (times10 || ownedUtilities == 2) {
            if (ownedUtilities == 1) {
                temp.changeMoney(-1 * temp.getLastRoll() * 10);
                temp.printMoney();
                super.getOwner().changeMoney(temp.getLastRoll() * 10);
                super.getOwner().printMoney();
                Thread.sleep(100);
                System.out.println(temp.getName() + " paid $" + temp.getLastRoll() * 10 + " in rent to " + getOwnerName() + ".");
            }
        }
    }
    public int getMortgage(){
        return mortgage;
    }
    public void setMortgaged(boolean set){
        mortgaged = set;
    }
    public boolean isMortgaged(){
        return mortgaged;
    }
    public void changeOwner (Player temp){
        super.changeOwner(temp);
    }
    public String getName(){
        if(mortgaged == true)
            return super.getName() + " (Mortgaged)";
        return super.getName();
    }
}
