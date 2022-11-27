package Game;

import java.math.*;


public class Fight {

    static char[] shield = Character.toChars(0x1F6E1);
    static char[] sword = Character.toChars(0x1F5E1);
    static char[] trophy = Character.toChars(0x1F3C6);

    public static void beginningSequence(String animal) {
        double currentTime = 0;
        long previousTime = System.currentTimeMillis();
        System.out.println("You are looking for your next prey as you are pacing through the forest...");
        while ((currentTime - previousTime < 2000)) {
            currentTime = System.currentTimeMillis();
        }
        System.out.println("You can smell your next prey as you hear something shushing..");

        while ((currentTime - previousTime < 4000)) {
            currentTime = System.currentTimeMillis();
        }
        switch (animal) {
            case "bear":
                System.out.printf("You see a fucking %s that is looking at you and the combat begins !\n\n", animal);
                break;
            case "wolf":
                System.out.printf("You see a %s sneaking up and the combat begins !\n\n", animal);
                break;
            case "lizard":
                System.out.printf("You see angry %s looking for a fight and the combat begins!\n\n", animal);
                break;
            default:
                System.out.printf("You see a %s that won't run from you and the combat begins!\n\n", animal);

        }
        while ((currentTime - previousTime < 6000)) {
            currentTime = System.currentTimeMillis();
        }
    }

    public static void fightDelay(long previousTime) {
        long currentTime = System.currentTimeMillis();
        while ((currentTime - previousTime) < 1000) {
            currentTime = System.currentTimeMillis();
        }
    }


    public static void fightBear(Avatar yourAvatar, Avatar bear) {
        beginningSequence(bear.animal);
        boolean yourTurn = true;
        while (yourAvatar.health > 0 && bear.health > 0) {
            int damageDealt;
            int Attack;
            int Defense;
            while (yourAvatar.health > 0 && bear.health > 0) {
                if (yourTurn) {
                    Attack = (int) (Math.floor(Math.random() * 30)) + yourAvatar.agility;
                    Defense = (int) (Math.floor(Math.random() * 30)) + bear.defense;
                    if (Attack > Defense) {
                        damageDealt = (int) (((1 / (1 + ((float) bear.armor / 10)))) * (float) yourAvatar.damage);
                        bear.health -= damageDealt;
                        System.out.print(sword);
                        System.out.printf(" You (%s) smack %s across the face dealing %d damage\n\n", yourAvatar.animal.toUpperCase(), bear.animal.toUpperCase(), damageDealt);
                        System.out.printf("Your health: %d\n", yourAvatar.health);
                        System.out.printf("Enemy health: %d\n\n", bear.health);
                    } else if (Attack < Defense) {
                        System.out.print(shield);
                        System.out.printf(" %s(your) attack has been blocked!\n\n", yourAvatar.animal.toUpperCase());
                    } else {
                        System.out.println("You both block and 0 damage is dealt\n\n");
                    }
                    yourTurn = false;
                } else {
                    Attack = (int) (Math.floor(Math.random() * 30)) + bear.agility;
                    Defense = (int) (Math.floor(Math.random() * 30)) + yourAvatar.defense;
                    if (Attack > Defense) {
                        damageDealt = (int) (((1 / (1 + ((float) yourAvatar.armor / 10)))) * (float) bear.damage);
                        yourAvatar.health -= damageDealt;
                        System.out.print(sword);
                        System.out.printf(" %s smacks you(%s) across the face with his paws dealing %d damage\n\n", bear.animal.toUpperCase(), yourAvatar.animal.toUpperCase(), damageDealt);
                        System.out.printf("Your health: %d\n", yourAvatar.health);
                        System.out.printf("Enemy health: %d\n\n", bear.health);
                    } else if (Attack < Defense) {
                        System.out.print(shield);
                        System.out.printf(" %s attack has been blocked!\n\n", bear.animal.toUpperCase());
                    } else {
                        System.out.println("⚔ You both block and 0 damage is dealt\n\n");
                    }
                    yourTurn = true;

                }
                fightDelay(System.currentTimeMillis());
            }


        }
        if (yourAvatar.health <= 0) {
            System.out.printf("\u2620 %s fucked you(%s) up\n", bear.animal.toUpperCase(), yourAvatar.animal);
            System.out.printf("The %s lives with %d health", bear.animal.toUpperCase(), bear.health);
            System.out.println("\n\n GAME OVER ");
            System.exit(1);
        } else {
            System.out.print(trophy);
            System.out.printf(" You(%s) were the victorious one\n", yourAvatar.animal);
            System.out.printf("You are left with %d health\n", yourAvatar.health);
            System.out.printf("You have received %d gold!\n\n", yourAvatar.level * 100);
            yourAvatar.levelUp();
            bear.levelUp();
            bear.health = 100;
            bear.animal = bear.changeName(bear.animal, bear.level);

        }
    }


    public static void fightWolf(Avatar yourAvatar, Avatar wolf) {
        beginningSequence(wolf.animal);
        boolean yourTurn = true;
        while (yourAvatar.health > 0 && wolf.health > 0) {
            int damageDealt;
            int Attack;
            int Defense;
            if (yourTurn) {
                Attack = (int) (Math.floor(Math.random() * 30)) + yourAvatar.agility;
                Defense = (int) (Math.floor(Math.random() * 30)) + wolf.defense;
                if (Attack > Defense) {
                    damageDealt = (int) (((1 / (1 + ((float) wolf.armor / 10)))) * (float) yourAvatar.damage);
                    wolf.health -= damageDealt;
                    System.out.print(sword);
                    System.out.printf(" You (%s) smack %s across the face dealing %d damage\n\n", yourAvatar.animal.toUpperCase(), wolf.animal.toUpperCase(), damageDealt);
                    System.out.printf("Your health: %d\n", yourAvatar.health);
                    System.out.printf("Enemy health: %d\n\n", wolf.health);
                } else if (Attack < Defense) {
                    System.out.print(shield);
                    System.out.printf(" %s attack has been blocked!\n\n", yourAvatar.animal.toUpperCase());
                } else {
                    System.out.println("⚔ You both block and 0 damage is dealt\n\n");
                }
                yourTurn = false;
            } else {
                Attack = (int) (Math.floor(Math.random() * 30)) + wolf.agility;
                Defense = (int) (Math.floor(Math.random() * 30)) + yourAvatar.defense;
                if (Attack > Defense) {
                    damageDealt = (int) (((1 / (1 + ((float) yourAvatar.armor / 10)))) * (float) wolf.damage);
                    yourAvatar.health -= damageDealt;
                    System.out.print(sword);
                    System.out.printf(" %s bites you(%s) in the face dealing %d damage\n\n", wolf.animal.toUpperCase(), yourAvatar.animal.toUpperCase(), damageDealt);
                    System.out.printf("Your health: %d\n", yourAvatar.health);
                    System.out.printf("Enemy health: %d\n\n", wolf.health);
                } else if (Attack < Defense) {
                    System.out.print(shield);
                    System.out.printf(" %s attack has been blocked!\n\n", wolf.animal.toUpperCase());
                } else {
                    System.out.println("⚔ You both block and 0 damage is dealt\n\n");
                }
                yourTurn = true;

            }

            fightDelay(System.currentTimeMillis());
        }
        if (yourAvatar.health <= 0) {

            System.out.printf("\u2620 The %s mauled you(%s) to death\n", wolf.animal, yourAvatar.animal);
            System.out.printf("The %s lives with %d health", wolf.animal, wolf.health);
            System.out.println("\n\n GAME OVER ");
            System.exit(1);
        } else {
            System.out.print(trophy);
            System.out.printf("You(%s) were the victorious one\n", yourAvatar.animal);
            System.out.printf("You are left with %d health\n", yourAvatar.health);
            System.out.printf("You have received %d gold!\n\n", yourAvatar.level * 100);
            yourAvatar.levelUp();
            wolf.levelUp();
            wolf.health = 100;
            wolf.animal= wolf.changeName(wolf.animal, wolf.level);
        }

    }

    public static void fightLizard(Avatar yourAvatar, Avatar lizard) {
        beginningSequence(lizard.animal);
        boolean yourTurn = true;
        while (yourAvatar.health > 0 && lizard.health > 0) {
            int damageDealt;
            int Attack;
            int Defense;
            if (yourTurn) {
                Attack = (int) (Math.floor(Math.random() * 30)) + yourAvatar.agility;
                Defense = (int) (Math.floor(Math.random() * 30)) + lizard.defense;
                if (Attack > Defense) {
                    damageDealt = (int) (((1 / (1 + ((float) lizard.armor / 10)))) * (float) yourAvatar.damage);
                    lizard.health -= damageDealt;
                    System.out.print(sword);
                    System.out.printf(" You (%s) smack %s across the face dealing %d damage\n\n", yourAvatar.animal.toUpperCase(), lizard.animal.toUpperCase(), damageDealt);
                    System.out.printf("Your health: %d\n", yourAvatar.health);
                    System.out.printf("Enemy health: %d\n\n", lizard.health);
                } else if (Attack < Defense) {
                    System.out.print(shield);
                    System.out.printf(" %s attack has been blocked!\n\n", yourAvatar.animal.toUpperCase());
                } else {
                    System.out.println("⚔ You both block and 0 damage is dealt\n\n");
                }
                yourTurn = false;
            } else {
                Attack = (int) (Math.floor(Math.random() * 30)) + lizard.agility;
                Defense = (int) (Math.floor(Math.random() * 30)) + yourAvatar.defense;
                if (Attack > Defense) {
                    damageDealt = (int) (((1 / (1 + ((float) yourAvatar.armor / 10)))) * (float) lizard.damage);
                    yourAvatar.health -= damageDealt;
                    System.out.print(sword);
                    System.out.printf(" %s tail-slaps you(%s) across the face dealing %d damage\n\n", lizard.animal.toUpperCase(), yourAvatar.animal.toUpperCase(), damageDealt);
                    System.out.printf("Your health: %d\n", yourAvatar.health);
                    System.out.printf("Enemy health: %d\n\n", lizard.health);
                } else if (Attack < Defense) {
                    System.out.print(shield);
                    System.out.printf(" %s attack has been blocked!\n\n", lizard.animal.toUpperCase());
                } else {
                    System.out.println("⚔ You both block and 0 damage is dealt\n\n");
                }
                yourTurn = true;

            }

            fightDelay(System.currentTimeMillis());
        }
        if (yourAvatar.health <= 0) {

            System.out.printf("\u2620 The %s mauled you(%s) to death\n", lizard.animal, yourAvatar.animal);
            System.out.printf("The %s lives with %d health", lizard.animal, lizard.health);
            System.out.println("\n\n GAME OVER ");
            System.exit(1);
        } else {
            System.out.print(trophy);
            System.out.printf("You(%s) were the victorious one\n", yourAvatar.animal);
            System.out.printf("You are left with %d health\n", yourAvatar.health);
            System.out.printf("You have received %d gold!\n\n", yourAvatar.level * 100);
            yourAvatar.levelUp();
            lizard.levelUp();
            lizard.health = 100;
            lizard.animal = lizard.changeName(lizard.animal, lizard.level);
        }
    }


    public static void fightRat(Avatar yourAvatar, Avatar rat) {
        beginningSequence(rat.animal);
        boolean yourTurn = true;
        while (yourAvatar.health > 0 && rat.health > 0) {
            int damageDealt;
            int Attack;
            int Defense;
            if (yourTurn) {
                Attack = (int) (Math.floor(Math.random() * 30)) + yourAvatar.agility;
                Defense = (int) (Math.floor(Math.random() * 30)) + rat.defense;
                if (Attack > Defense) {
                    damageDealt = (int) (((1 / (1 + ((float) rat.armor / 10)))) * (float) yourAvatar.damage);
                    rat.health -= damageDealt;
                    System.out.print(sword);
                    System.out.printf(" You (%s) smack %s across the face dealing %d damage\n\n", yourAvatar.animal.toUpperCase(), rat.animal.toUpperCase(), damageDealt);
                    System.out.printf("Your health: %d\n", yourAvatar.health);
                    System.out.printf("Enemy health: %d\n\n", rat.health);
                } else if (Attack < Defense) {
                    System.out.print(shield);
                    System.out.printf(" %s attack has been blocked!\n\n", yourAvatar.animal.toUpperCase());
                } else {
                    System.out.println("⚔ You both block and 0 damage is dealt\n\n");
                }
                yourTurn = false;
            } else {
                Attack = (int) (Math.floor(Math.random() * 30)) + rat.agility;
                Defense = (int) (Math.floor(Math.random() * 30)) + yourAvatar.defense;
                if (Attack > Defense) {
                    damageDealt = (int) (((1 / (1 + ((float) yourAvatar.armor / 10)))) * (float) rat.damage);
                    yourAvatar.health -= damageDealt;
                    System.out.print(sword);
                    System.out.printf(" %s bites you(%s) dealing %d damage\n\n", rat.animal.toUpperCase(), yourAvatar.animal.toUpperCase(), damageDealt);
                    System.out.printf("Your health: %d\n", yourAvatar.health);
                    System.out.printf("Enemy health: %d\n\n", rat.health);
                } else if (Attack < Defense) {
                    System.out.print(shield);
                    System.out.printf(" %s attack has been blocked!\n\n", rat.animal.toUpperCase());
                } else {
                    System.out.println("⚔ You both block and 0 damage is dealt\n\n");
                }
                yourTurn = true;

            }

            fightDelay(System.currentTimeMillis());
        }
        if (yourAvatar.health <= 0) {

            System.out.printf("\u2620 The %s bit you(%s) to death\n", rat.animal, yourAvatar.animal);
            System.out.printf("The %s lives with %d health", rat.animal, rat.health);
            System.out.println("\n\n GAME OVER ");
            System.exit(1);
        } else {
            System.out.print(trophy);
            System.out.printf("You(%s) were the victorious one\n", yourAvatar.animal);
            System.out.printf("You are left with %d health\n", yourAvatar.health);
            System.out.printf("You have received %d gold!\n\n", yourAvatar.level * 100);
            yourAvatar.levelUp();
            rat.levelUp();
            rat.health = 100;
            rat.animal = rat.changeName(rat.animal, rat.level);
        }

    }

}

