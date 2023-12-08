/**
 * Character class represents an in-game character with various attributes such as name, gender, job, level, health points (hp),
 * mana points (mana), strength (str), agility (agi), shield, run speed, damage, and equipped equipment.
 */
class Character {
    private String name;
    private String gender;
    private String job;
    private int level;
    private int hp;
    private int mana;
    private int str;
    private int agi;
    private int shield; 
    private int runSpeed = 34;
    private int damage ;
    private int totalWeight = 0; ;
    private Equipment[] weapon = new Equipment[2];
    private Equipment[] accessory = new Equipment[2];

    /**
     * Constructor to create a Character object with specified name, gender, and job.
     *
     * @param name   The name of the character.
     * @param gender The gender of the character.
     * @param job    The job of the character ("Novice," "Swordman," or "Mage").
     */
    
    public Character(String name, String gender , String job) {
        this.name = name;
        this.gender = gender;
        this.job = job;
        if ("Novice".equals(job)) {
            this.level = 1;
            this.hp = 40;
            this.mana = 20;
            this.str = 1;
            this.agi = 1;
            this.shield = 1;
        } else if ("Swordman".equals(job)) {
            this.level = 1;
            this.hp = 80;
            this.mana = 40;
            this.str = 5;
            this.agi = 2;
            this.shield = 1;
            
        } else if ("Mage".equals(job)) {
            this.level = 1;
            this.hp = 50;
            this.mana = 100;
            this.str = 0;
            this.agi = 0;
            this.shield = 1; 
        }

    }
    
    // max on lv.99
    String getName() {return name;}
    String getGender() {return gender;}
    String getJob() {return job;}
    int getLevel() {return level;}
    int getHp() {return hp;}
    int getMana() {return mana;}
    int getStr() {return str;}
    int getShield() {return shield;}
    int getDamage() {return damage+str;}
    double getAgi() {return agi;}
    Equipment[] getEquipments(Equipment[] equipment) {return equipment;}
    
    // Getter methods for various attributes

    /**
     * Increase the character's level and adjust attributes accordingly.
     *
     * Preconditions:
     * - The level is less than or equal to 99.
     *
     * Postconditions:
     * - The character's level is increased.
     * - Attributes such as hp, mana, str, and agi are adjusted based on the level.
     */

    public void levelUp() {
        if(level <= 99){
            level++;
            hp = 40 + 5*level;
            mana = 20 + 5*level;
            str = 1 + 5*level;
            agi = 34 + 2*level;
            if(agi >= 100){
                agi = 100;
            }
        }
    }

    /**
     * Set the character's damage based on equipped weapons.
     *
     * Preconditions:
     * - None
     *
     * Postconditions:
     * - The character's damage is updated based on equipped weapons.
     */

    public void setDamage(){
        if(weapon[0] != null){
            damage += weapon[0].getDamage();
        }
    }

    /**
     * Set the character's shield based on equipped shield.
     *
     * Preconditions:
     * - None
     *
     * Postconditions:
     * - The character's shield is updated based on equipped shield.
     */

    public void setShield(){
        if(weapon[1] != null){
            shield += weapon[1].getReduceDamage();
        }
    }

     /**
     * Set the character's shield to a specified value.
     *
     * Preconditions:
     * - None
     *
     * Postconditions:
     * - The character's shield is set to the specified value.
     */
    
    public void setShield(int newShield){
        shield = newShield;
    }
    
    /**
     * Set the character's health points to a specified value.
     *
     * Preconditions:
     * - None
     *
     * Postconditions:
     * - The character's health points are set to the specified value.
     */
   
     public void setHp(int newHp){
        hp = newHp;
    }
    
    /**
     * Set the character's run speed based on equipped weapons and total weight.
     *
     * Preconditions:
     * - None
     *
     * Postconditions:
     * - The character's run speed is updated based on equipped weapons and total weight.
     */
    
     public void setRunSpeed() {
        
        runSpeed = 34;
    
        if (weapon[0] != null) {
            totalWeight += weapon[0].getWeight();
        }
    
        if (weapon[1] != null) {
            totalWeight += weapon[1].getWeight();
        }
    
        if (totalWeight > 150 && totalWeight <= 200) {
            runSpeed *= 0.75; // วิ่งช้าลง 25%
        } else if (totalWeight > 200 && totalWeight <= 250) {
            runSpeed *= 0.7; // วิ่งช้าลง 30%
        } else if (totalWeight > 250) {
            runSpeed *= 0.5; // วิ่งช้าลง 50%
        }
    }

    // level up to job but not now 
    // public void setJob(String newJob) {
    //     if(level == 10){
    //         job = newJob;
    //     }
    // }
    
    /**
     * Equip one weapon to the character.
     *
     * @param weapon1 The weapon to be equipped.
     *
     * Preconditions:
     * - The weapon type is valid ("sword," "dagger," "wand," or "shield").
     *
     * Postconditions:
     * - The weapon is equipped, and character attributes are updated accordingly.
     */

    public void equipWeapon(Equipment weapon1) {
        if (weapon1.getType().equals("sword")||weapon1.getType().equals("dagger")||weapon1.getType().equals("wand")) { 
            weapon[0] = weapon1;
            setRunSpeed();
            setDamage();
        } else if (weapon1.getType().equals("shield")) {
            weapon[1] = weapon1;
            setRunSpeed();
            setShield();
        }
    }

    /**
     * Equip two weapons to the character.
     *
     * @param weapon1 The first weapon to be equipped.
     * @param weapon2 The second weapon to be equipped.
     *
     * Preconditions:
     * - The weapon types are valid ("sword," "dagger," or "wand").
     *
     * Postconditions:
     * - The weapons are equipped, and character attributes are updated accordingly.
     */

    public void equipWeapon(Equipment weapon1, Equipment weapon2) {
        weapon[0] = weapon1;
        weapon[1] = weapon2;
        setRunSpeed();
        setDamage();
        setShield();
    }

    /**
     * Equip two accessories to the character and apply their effects.
     *
     * @param accessory1 The first accessory to be equipped.
     * @param accessory2 The second accessory to be equipped.
     *
     * Preconditions:
     * - None
     *
     * Postconditions:
     * - The accessories are equipped, and character attributes are updated accordingly.
     */

    public void equipAccessory(Equipment accessory1, Equipment accessory2) {
        accessory[0] = accessory1;
        accessory[1] = accessory2;
        applyAccessoryEffects();
    }

    /**
     * Apply the effects of equipped accessories on the character.
     *
     * Preconditions:
     * - None
     *
     * Postconditions:
     * - The character's hp, agi, and mana are updated based on equipped accessories.
     */

    private void applyAccessoryEffects() {
        for (Equipment acc : accessory) {
            if (acc != null) {
                hp += acc.getBonusHp();
                agi += acc.getBonusSpeed();
                mana += acc.getBonusMana();
            }
        }
    }

    /**
     * Display information about equipped accessories.
     *
     * Preconditions:
     * - None
     *
     * Postconditions:
     * - Information about equipped accessories is displayed on the console.
     */

    public void displayEquipmentInfo() {
        Equipment[] acc = getEquipments(accessory);
        Equipment[] wpn = getEquipments(weapon);
    
        System.out.println("=== Accessory Info ===");
        if (accessory != null) {
            for (Equipment item : acc) {
                if (item != null) {
                    item.getWeaponInfo();
                } else {
                    System.out.println("No equipped.");
                }
            }
        }
        System.out.println("\n");
    
        if (weapon != null) {
            System.out.println("=== Weapon Info ===");
            for (Equipment item : wpn) {
                if (item != null) {
                    item.getWeaponInfo();
                } else {
                    System.out.println("No equipped.");
                }
            }
        }
        System.out.println("\n");
    }

     /**
     * Display information about the character including attributes and equipped accessories.
     *
     * Preconditions:
     * - None
     *
     * Postconditions:
     * - Information about the character is displayed on the console.
     */

    public void displayCharacterInfo() {
        System.out.println("=== Character Info ===");
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Job: " + job);
        System.out.println("Level: " + level);
        System.out.println("HP: " + hp);
        System.out.println("Mana: " + mana);
        System.out.println("ASPD: " + agi*2);
        System.out.println("Run Speed: " + runSpeed);
        System.out.println("Damage: " + (damage+str));
        System.out.println("Shield: " + shield);
        System.out.println("Weight: " + totalWeight);
        System.out.println("\n");
        }

    /**
     * Display character information and equipment details.
     *
     * Preconditions:
     * - None
     *
     * Postconditions:
     * - Information about the character and equipped accessories is displayed on the console.
     */

    void displayInfo() {
        if(hp <= 0){
            System.out.println(name + ": ARE DEAD!!\n");
        }else{
            displayCharacterInfo();
            displayEquipmentInfo();
        }

    }
}