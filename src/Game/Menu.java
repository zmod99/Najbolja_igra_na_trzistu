package Game;

import java.util.Scanner;


public class Menu {
    public static int counter = 0;

    public static Avatar showMenu1(Avatar yourAvatar, Avatar wolf, Avatar bear, Avatar lizard, Avatar rat) {   // public method meaning its members
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Forest Encounter v1 by zmod studios");
        System.out.print("A)Play game\nB)Credits\nC)Exit\n> ");
        switch (scanner.next().toUpperCase().charAt(0)) {

            case 'A':
                yourAvatar = showMenu2(wolf, bear, lizard, rat);
                break;
            case 'B':
                long previousTime = System.currentTimeMillis();
                long currentTime = System.currentTimeMillis();
                System.out.print("Created ");
                while ((currentTime - previousTime) < 500) {
                    currentTime = System.currentTimeMillis();
                }
                System.out.print("by ");
                while ((currentTime - previousTime) < 1000) {
                    currentTime = System.currentTimeMillis();
                }
                System.out.print("zmod ");

                while ((currentTime - previousTime) < 1500) {
                    currentTime = System.currentTimeMillis();
                }
                System.out.print("studios ");
                while ((currentTime - previousTime) < 2000) {
                    currentTime = System.currentTimeMillis();
                }
                System.out.print("- 2022\n\n");
                break;
            case 'C':
                System.exit(1);
                break;
            default:
                System.out.println("Wrong input");

        }

        return yourAvatar;


    }

    public static Avatar showMenu2(Avatar wolf, Avatar bear, Avatar lizard, Avatar rat) {
        boolean isEmpty;
        Avatar yourAvatar = new Avatar();
        do {
            isEmpty = false;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose your animal:\nA)Wolf\nB)Bear\nC)Lizard\nD)Rat\n> ");

            switch (scanner.next().toUpperCase().charAt(0)) {
                case 'A':
                    System.out.println("You are now playing as a wolf!\n");
                    yourAvatar.agility = wolf.agility;
                    yourAvatar.defense = wolf.defense;
                    yourAvatar.damage = wolf.damage;
                    yourAvatar.health = wolf.health;
                    yourAvatar.armor = wolf.armor;
                    yourAvatar.animal = wolf.animal;
                    break;
                case 'B':
                    System.out.println("You are now playing as a bear!\n");
                    yourAvatar.agility = (int) (0.8 * bear.agility);
                    yourAvatar.defense = (int) (0.8 * bear.defense);
                    yourAvatar.damage = (int) (0.8 * bear.damage);
                    yourAvatar.armor = (int) (0.8 * bear.armor);
                    yourAvatar.health = bear.health;
                    yourAvatar.animal = bear.animal;
                    break;
                case 'C':
                    System.out.println("You are now playing as a lizard!\n");
                    yourAvatar.agility = lizard.agility;
                    yourAvatar.defense = lizard.defense;
                    yourAvatar.damage = lizard.damage;
                    yourAvatar.health = lizard.health;
                    yourAvatar.armor = lizard.armor;
                    yourAvatar.animal = lizard.animal;
                    break;
                case 'D':
                    System.out.println("You are now playing as a rat\n");
                    yourAvatar.agility = rat.agility;
                    yourAvatar.defense = rat.defense;
                    yourAvatar.damage = rat.damage;
                    yourAvatar.health = rat.health;
                    yourAvatar.armor = rat.armor;
                    yourAvatar.animal = rat.animal;
                    break;
                default:
                    System.out.println("Wrong input");
                    isEmpty = true;

            }
        } while (isEmpty);
        return yourAvatar;

    }

    public static boolean showMenu3(Avatar yourAvatar, Avatar wolf, Avatar bear, Avatar lizard, Avatar rat) {
        Scanner scanner = new Scanner(System.in);
        int n = (int) (Math.floor(Math.random() * 6));  //0,1,2,3,4,5
        System.out.print("A)Roam the jungle & fight\nB)Train\nC)Show stats\nD)Healing Grounds\nE)Exit the game\n\n> ");
        switch (scanner.next().toUpperCase().charAt(0)) {
            case 'A':
                if (n == 5) {
                    Game.Fight.fightBear(yourAvatar, bear);
                    break;
                } else if (n == 4) {
                    Game.Fight.fightWolf(yourAvatar, wolf);
                    break;
                } else if (n > 1) {
                    Game.Fight.fightLizard(yourAvatar, lizard);
                    break;
                } else {
                    Game.Fight.fightRat(yourAvatar, rat);
                    break;
                }
            case 'B':
                int aCost = yourAvatar.agilityCost * 10;
                int dCost = yourAvatar.defenseCost * 10;
                int dmgCost = yourAvatar.damageCost * 10;
                int armCost = yourAvatar.armorCost * 10;
                boolean isRight = false;
                do {
                    System.out.printf("Put a point in:\nA)Agility - %d gold\nB)Defense - %d gold\nC)Damage - %d gold\nD)Armor - %d gold\nE)Exit to menu\n\n> ", aCost, dCost, dmgCost, armCost);
                    switch (scanner.next().toUpperCase().charAt(0)) {
                        case 'A':
                            if (yourAvatar.gold < aCost) {
                                System.out.println("Not enough gold!");
                                break;
                            } else {
                                yourAvatar.agility += 1;
                                yourAvatar.gold -= aCost;
                                yourAvatar.agilityCost += 1;
                                System.out.print("You have put 1 point in agility\n\n");
                            }
                            break;
                        case 'B':
                            if (yourAvatar.gold < dCost) {
                                System.out.println("Not enough gold!");
                                break;
                            } else {
                                yourAvatar.defense += 1;
                                yourAvatar.gold -= dCost;
                                yourAvatar.defenseCost += 1;
                                System.out.print("You have put 1 point in Defense\n\n");
                            }
                            break;
                        case 'C':
                            if (yourAvatar.gold < dmgCost) {
                                System.out.println("Not enough gold!");
                                break;
                            } else {
                                yourAvatar.damage += yourAvatar.level * 2;              // random, ne znam kako balansirati sve
                                yourAvatar.gold -= dmgCost;
                                yourAvatar.damageCost += 1;
                                System.out.print("You have put 1 point in Damage\n\n");
                            }
                            break;
                        case 'D':
                            if (yourAvatar.gold < armCost) {
                                System.out.println("Not enough gold!");
                                break;
                            } else {
                                yourAvatar.damage += 1;              // random, ne znam kako balansirati sve
                                yourAvatar.gold -= armCost;
                                yourAvatar.armorCost += 1;
                                System.out.print("You have put 1 point in Armor\n\n");
                            }
                            break;
                        case 'E':
                            isRight = true;
                        default:
                            System.out.println("Wrong input");

                    }

                } while (!isRight);
                break;

            case 'C':
                System.out.println("Your stats : ");
                System.out.printf("\nAvatar: %s\n", yourAvatar.animal.toUpperCase());
                System.out.printf("Health:%d\n", yourAvatar.health);
                System.out.printf("Damage:%d\n", yourAvatar.damage);
                System.out.printf("Agility:%d\n", yourAvatar.agility);
                System.out.printf("Defense:%d\n", yourAvatar.defense);
                System.out.printf("Armor:%d\n", yourAvatar.armor);
                System.out.printf("\nYou have %d gold.\n", yourAvatar.gold);
                break;
            case 'D':
                System.out.print("You have entered healing grounds\n\nYou regenerate 5 health per second\n\nHealing always takes time...\n\nEnter anything to stop healing process\n> ");
                long previousTime = System.currentTimeMillis();
                long currentTime = 0;
                int healed;
                if (scanner.hasNext()) {
                    currentTime = System.currentTimeMillis();
                }
                healed = (int) ((currentTime - previousTime) / 1000);
                healed *= 5;
                yourAvatar.health += healed;
                if (yourAvatar.health > 100) {
                    yourAvatar.health = 100;
                    System.out.println("You healed to full health\n");
                    break;

                }
                System.out.printf("You healed for %d and now your health is %d/100", healed, yourAvatar.health);
                System.out.println();
                break;

            case 'E':
                return true;
            default:
        }

        return false;

    }

}

