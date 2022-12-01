package Game;

public class Avatar {                     // declaring constructor, constructor is used to initialize objects, i can access this objects variables, methods later,

    int damage;                     // 0 - 100       when i create an instance of this object. So i can make Shrek, superman, batman, joker as my avatar and they
    int defense;                    // 0 - 100        will all share common properties. Also changing those object properties doesnt affect other object properties
    int health;                    // 0 - 999          I can have million different Avatar objects and they can all have different values and its methods can be called
    int armor;                    //  0 - 100 ( % )      differently. Shrek, superman, batman all have walk() property, health property etc.

    int agility;               // 0 - 10

    int agilityCost = 1;
    int damageCost = 1;
    int armorCost = 1;
    int defenseCost = 1;

    int gold;

    short level = 1;

    String animal;

    public void levelUp() {

        gold += level * 100;
        level++;
        damage++;
        defense++;
        armor++;
        agility++;

    }
    public void changeName() {
        if (level > 3) {

            switch (animal) {
                case "bear":
                    animal = "Grizzly bear";
                case "wolf":
                    animal = "Indian Wolf";

                case "lizard":
                    animal = "Iguana";
                case "rat":
                    animal = "Hazardous rat";
            }


        }



    }


}

