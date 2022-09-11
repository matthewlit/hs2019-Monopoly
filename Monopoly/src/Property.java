public class Property extends Space implements Landed{

    private int price;
    private int mortgage;
    private boolean mortgaged;
    private int rent;
    private int oneHouse;
    private int twoHouse;
    private int threeHouse;
    private int fourHouse;
    private int houseCost;
    private int hotel; /* this will be treated like a fifth house for mathematical calculations*/
    private int numHouses;


    public Property(){

    }

    public Property(String name, int propertyPrice, int propertyRent, int oneHouseRent, int twoHouseRent, int threeHouseRent, int fourHouseRent, int hotelRent, int propertyHouseCost, int spaceNum){
        super(name, spaceNum);
        price = propertyPrice;
        rent = propertyRent;
        oneHouse = oneHouseRent;
        twoHouse = twoHouseRent;
        threeHouse = threeHouseRent;
        fourHouse = fourHouseRent;
        hotel = hotelRent;
        houseCost = propertyHouseCost;
        mortgage = price / 2;
        mortgaged = false;
    }
    public void landedOn(Player temp) throws InterruptedException{
        if(temp instanceof AI){

        }
        if (!super.getOwnerName().equals("no one")) {
            if(!super.getOwner().equals(temp)) {
                System.out.println(temp.getName() + " paid $" + rent + " in rent to " + getOwnerName() + ".");
                chargeRent(temp);
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
                System.out.println(temp.getName() + " bought " + super.getName() + " for $" + price );
            }
        }
    }

    public void chargeRent(Player temp) {

        if(numHouses == 0) {
            if (temp.hasASet(temp.getCurrentSpace())) {
                temp.changeMoney(-2 * rent);
                temp.printMoney();
                super.getOwner().changeMoney(2 * rent);
                super.getOwner().printMoney();
            } else {
                temp.changeMoney(-1 * rent);
                temp.printMoney();
                super.getOwner().changeMoney(rent);
                super.getOwner().printMoney();
            }
        }
        else if(numHouses == 1){
            temp.changeMoney(-1 * oneHouse);
            temp.printMoney();
            super.getOwner().changeMoney(oneHouse);
            super.getOwner().printMoney();
        }
        else if(numHouses == 2){
            temp.changeMoney(-1 * twoHouse);
            temp.printMoney();
            super.getOwner().changeMoney(twoHouse);
            super.getOwner().printMoney();
        }
        else if(numHouses == 3){
            temp.changeMoney(-1 * threeHouse);
            temp.printMoney();
            super.getOwner().changeMoney(threeHouse);
            super.getOwner().printMoney();
        }
        else if(numHouses == 4){
            temp.changeMoney(-1 * fourHouse);
            temp.printMoney();
            super.getOwner().changeMoney(fourHouse);
            super.getOwner().printMoney();
        }
        else if(numHouses == 5){
            temp.changeMoney(-1 * hotel);
            temp.printMoney();
            super.getOwner().changeMoney(hotel);super.getOwner().printMoney();
        }
    }
    public void addHouse(){
        numHouses++;
    }
    public void setMortgaged(boolean set){
        mortgaged = set;
    }
    public boolean isMortgaged(){
        return mortgaged;
    }
    public int getMortgage(){
        return mortgage;
    }
    public int getPriceOfHouse(){
        return houseCost;
    }
    public int getNumHouses(){
        return numHouses;
    }
    public int getSpaceNumber(){
        return super.getSpaceNumber();
    }
    public String toString(){
        return super.getName() + "\nOwned by: " + super.getOwner() + "\nPrice: " + price + "\nRent: " + rent;
    }
}
