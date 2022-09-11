import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MonopolyRunner {
    public static ArrayList<Player> players = new ArrayList<>();
    public static void main(String args[]) throws InterruptedException{
        System.out.println("___________________________________________\nWelcome to Java Monopoly!\nCreated by: Matthew Kelleher\n___________________________________________");
        Scanner scan = new Scanner(System.in);
        int option = 0;
        int startingMoney = 1500;
        int passingGoAmount = 200;
        boolean taxes = true;
        int moneyOnFreeParking = 0;
        RandomCards rand = new RandomCards();
        while(option != 1) {
            Thread.sleep(100);
            System.out.println("\n1:Start Game\n2:Change House Rules\n");
            option = scan.nextInt();
            if (option == 2) {
                Thread.sleep(100);
                System.out.println("What would you like the starting money per player to be? ($1500 is default)");
                startingMoney = scan.nextInt();
                Thread.sleep(100);
                System.out.println("What would you like the money for passing go to be? ($200 is default)");
                passingGoAmount = scan.nextInt();
                Thread.sleep(100);
                System.out.println("Would you like the money on free parking to from taxes or a set-amount? (taxes is default)");
                String h = scan.next();
                h = h.toLowerCase();
                if(!h.contains("tax")){
                    taxes = false;
                    Thread.sleep(100);
                    System.out.println("How much money do you want on free parking?");
                    moneyOnFreeParking = scan.nextInt();
                }
            }
            else if(option != 1) {
                Thread.sleep(100);
                System.out.println("Not Valid!");
            }
        }
        Properties prop = new Properties();
        Player.setPassGo(passingGoAmount);
        FreeParking.setTaxes(taxes,moneyOnFreeParking);
        int numOfPlayers = 0;
        int numOfHumanPlayers = 0;
        int numOfAIPlayers = 0;
        do {
            do {
                System.out.println("\nHow many human players would like to play? (8 players max)");
                numOfHumanPlayers = scan.nextInt();
            } while (numOfPlayers + numOfHumanPlayers > 8);
            scan.nextLine();
            for (int i = 1; i <= numOfHumanPlayers; i++) {
                Thread.sleep(100);
                System.out.println("\nWhat is Player " + i + "'s name?");
                String name = scan.nextLine();
                players.add(new Human(name, startingMoney));
                Thread.sleep(100);
                System.out.println(name + " has entered the game!");
                numOfPlayers++;
            }
            do {
                System.out.println("\nHow many AI players do you want to play? (" + (8 - numOfPlayers) + " AI players max)");
                numOfAIPlayers = scan.nextInt();
            } while (numOfPlayers + numOfAIPlayers > 8);
            for (int i = 1; i <= numOfAIPlayers; i++) {
                String name = "AI" + i;
                players.add(new AI(name,startingMoney));
                Thread.sleep(100);
                System.out.println(name + " has entered to the game!");
                numOfPlayers++;
            }
        } while (numOfPlayers == 0);
        //Start game
        int i = 0;
        boolean justRolled = false;
        while (players.size() != 1) {
            if (players.get(i) instanceof Human) {
                if(!justRolled) {
                    Thread.sleep(100);
                    System.out.println("\n" + players.get(i).getName() + " it's your Turn!\nYou have $" + players.get(i).getMoney() + " left!\nYou are on " + players.get(i).getCurrentSpaceName() + "!\n");
                    Thread.sleep(100);
                    System.out.println("What would you like to do?\n1: Roll\n2: Owned Properties\n3: Trade\n4: Buy Houses and Hotels\n5: Player Info\n6: Free Parking\n7: Mortgage\n8: Un-mortgage");
                    if (players.get(i).getInJail()) {
                        System.out.print("9: Pay To Get Out Of Jail\n");
                    }
                    else if(justRolled)
                        System.out.println("10: End turn");
                }
                else{
                    System.out.println("What would you like to do next? Remember, you already rolled, so you can't pick that again. Type 10 to end you turn.");
                }

                try {
                    int choice = scan.nextInt();
                    System.out.println();
                    if (choice == 1) {
                        //Dice is rolled, player moves, option to buy property if not owned, pays rant if owned, mortgage if $0, if in jail roll to get out
                        if(!justRolled) {
                            players.get(i).roll();

                            if (players.get(i).getInJail()) {
                                if (players.get(i).getDaysInJail() == 3) {
                                    players.get(i).changeMoney(-50);
                                    players.get(i).setInJail(false);
                                } else if (players.get(i).getDoublesInSuccession() > 0) {
                                    players.get(i).setInJail(false);
                                    players.get(i).resetDoublesInSuccession();
                                } else if (players.get(i).getDoublesInSuccession() == 0) {
                                    players.get(i).addDayInJail();
                                }
                            }
                            if (!players.get(i).getInJail()) {
                                prop.getSpace(players.get(i).getCurrentSpace()).landedOn(players.get(i));
                            }
                            if (players.get(i).getMoney() < 0) {
                                players.get(i).mortgage();
                                if (players.get(i).getMoney() < 0)
                                    players.remove(players.get(i));
                            }
                        }
                        if(players.get(i).getDoublesInSuccession() == 0){
                            justRolled = true;
                        }
                    } else if (choice == 2) {
                        for (Player player : players) {
                            System.out.println(player.propertiesOwned(false));
                        }
                    } else if (choice == 3) {
                        //Asks what you want to trade and for what; trades if the player wants to
                        System.out.println("Who would you like to trade with?");
                        for (int k = 0; k < players.size(); k++) {
                            System.out.println((k + 1) + ":" + players.get(k).getName());
                        }
                        System.out.println("Press any other number to quite trading");
                        int who = scan.nextInt();
                        if (who <= players.size()) {
                            players.get(i).makeTrade(players.get(i), players.get(who - 1));
                        }


                    } else if (choice == 4) {
                        //Tells players where they can place houses and hotels; lets the player buy houses and hotels
                        ArrayList<Property> validForHouse = new ArrayList<>();
                        System.out.println("You can place a house on:");
                        boolean foundSet = false;
                        for (int l = 1; l < 40; l++) {
                            if (Properties.getSpace(l) instanceof Property) {
                                if (players.get(i).hasASet(l) && ((Property) Properties.getSpace(l)).getNumHouses() < 5) {
                                    foundSet = true;
                                    validForHouse.add((Property) Properties.getSpace(l));
                                    System.out.println(validForHouse.size() + ": " + Properties.getSpace(l) + " for $" + ((Property) Properties.getSpace(l)).getPriceOfHouse());
                                }
                            }
                        }
                        if (foundSet) {
                            int propertyToPutHouseOn = scan.nextInt();
                            if (propertyToPutHouseOn <= validForHouse.size()) {
                                validForHouse.get(propertyToPutHouseOn - 1).addHouse();
                            } else {
                                System.out.println("Not Valid!");
                            }
                        }
                        if (!foundSet)
                            System.out.println("Nothing");

                    } else if (choice == 5) {
                        //Lists all players and their info
                        for (Player player : players) {
                            System.out.println(player);
                        }
                    } else if (choice == 6) {
                        //Prints FreeParking
                        System.out.println(Properties.getSpace(20));
                    } else if (choice == 7) {
                        //Mortgage
                        players.get(i).mortgage();
                    } else if (choice == 8) {
                        //UN-MORTGAGE
                        players.get(i).unmortgage();
                    } else if (players.get(i).getInJail() && choice == 9) {
                        //Pay to get out of jail
                        players.get(i).changeMoney(-50);
                        players.get(i).setInJail(false);
                    }else if(choice == 10){
                        justRolled = false;
                        i++;
                    }
                    else {
                        if (!players.get(i).getInJail())
                            System.out.println("Not Valid! Type a number between 1 and 8");
                        else {
                            System.out.println("Not Valid! Type a number between 1 and 9");
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Not Valid! Type a number!");
                    scan.next();
                }

            }
            //AI Turn
            else if (players.get(i) instanceof AI) {
                AI temp = (AI) players.get(i);
                System.out.println("\nIt's " + temp.getName() + "'s Turn!\n" + temp.getName() + " has $" + temp.getMoney() + " left!\n" + temp.getName() + " is on " + players.get(i).getCurrentSpaceName() + "!\n");
                temp.roll();
                if (temp.getInJail()) {
                    if (temp.getDaysInJail() == 3) {
                        temp.changeMoney(-50);
                        temp.setInJail(false);
                    } else if (temp.getDoublesInSuccession() > 0) {
                        temp.setInJail(false);
                        temp.resetDoublesInSuccession();
                    } else if (temp.getDoublesInSuccession() == 0) {
                        temp.addDayInJail();
                    }
                }
                temp.calculateBuyHouse();
                if(temp.getProperties().size() > 5) {
                    temp.calculateTrade();
                }
                if(!players.get(i).getInJail()) {
                    Properties.getSpace(players.get(i).getCurrentSpace()).landedOn(players.get(i));
                }
                boolean removed = false;
                if (players.get(i).getMoney() < 0) {
                    if (players.get(i).getMoney() < 0){
                        players.remove(players.get(i));
                        removed = true;
                    }
                }

                if (!removed && players.get(i).getDoublesInSuccession() == 0) {
                    i++;
                }
            }
            if (i >= players.size()) {
                i = 0;
            }
        }
        System.out.println("\n" + players.get(0).getName() + " WINS!");
    }
}
