class Action {
    private static boolean isDefend = false;
    static class Defend{
        Character defender;
        public Defend(Character defender){
            this.defender = defender;
        }

        public boolean defendAttack(){
            return isDefend = true;
        }
    }
    static class Attack {
        Character attacker;
        Character defender;
        int damage;
        int shield;
        int hp;
        
        public Attack(Character attacker, Character defender) {
            this.attacker = attacker;
            this.defender = defender;
            this.damage = attacker.getDamage();
            this.hp = defender.getHp();
            this.shield = defender.getShield();
        }
        
        public void takeDamage(int damage){
            hp = hp - damage;
            if(isDefend){
                if(shield - damage <= 0){
                    hp = hp + shield;
                    defender.setHp(hp);
                    defender.setShield(0);
                    if(hp <= 0){
                        defender.setHp(0);
                    }
                }else{
                    shield = shield - damage;
                    defender.setShield(shield);
                }
            }else{
                if(hp <= 0){
                    defender.setHp(0);
                }else{
                    defender.setHp(hp);
                }
            }
            
        }

        public void executeAttack() {
            takeDamage(damage);
        }
    }
}