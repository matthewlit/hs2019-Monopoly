public class Tax extends Space {
    private String name;
    private int amount;

    public Tax(String taxName, int taxAmount, int spaceNum){
        super(taxName, spaceNum);
        amount = taxAmount;
    }
    public void landedOn(Player temp){
        System.out.println(temp.getName() + " paid $" + amount + " in " + super.getName() + ".");
        temp.changeMoney(-1 * amount);
        temp.printMoney();
        FreeParking.addMoney(amount);
    }
}
