package rpg;

public class Player {
	private int health;
	private String name;
	private int attackPow;
	private int defense;
	private int potions;
	
	public Player() {
		name = "";
		health = 100;
		attackPow = 0;
		defense = 0;
		}
	
	public Player(String name, int health, int attackPow, int defense) {		
		this.name = name;
		this.health = health;
		this.attackPow = attackPow;
		this.defense = defense;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getAttackPow() {
		return attackPow;
	}
	
	public void setAttackPow(int attackPow) {
		this.attackPow = attackPow;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public void takeDamage(int damage) {
		health -= damage;
	}
	
	public int getPotions() {
		return potions;
	}
	
	public void setPotions(int potions) {
		if (potions > 0) {
			this.potions = potions;
		} else {
			System.out.println("No more potions.");
		}
	}
	
	public int usePotion() {
		int potionValue = 15;
		health += potionValue;
		return health;
	}
}
