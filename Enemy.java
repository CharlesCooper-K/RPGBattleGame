package rpg;

public class Enemy {
	private int health;
	private String name;
	private int attackPow;
	private int defense;
	
	public Enemy() {
		name = "";
		health = 100;
		attackPow = 0;
		defense = 0;
		}
	
	public Enemy(String name, int health, int attackPow, int defense) {		
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
	
	public boolean isDefeated() {
		return health <= 0;
	}
}