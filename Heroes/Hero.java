import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Hero {
	private String name;
	private String type;
	private int maxHealth;
	private int currentHealth;
	private int recoveryRate;
	private boolean hasPaperScissorsRockPowerUp = false;
	private boolean hasGuessNumberPowerUp = false;
	private boolean hasDiceGamePowerUp = false;
	private ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
	
	public Hero(String inputName, String inputType, int maxHealthInput, int recoveryRateInput) {
		name = inputName;
		type = inputType;
		maxHealth = maxHealthInput;
		currentHealth = maxHealth;
		recoveryRate = recoveryRateInput;
	}
	public void setCurrentHealth(int currentHealthInput) {
		currentHealth = currentHealthInput;
	}
	
	public int getRecoveryRate() {
		return recoveryRate;
	}
	public ArrayList<PowerUp> getPowerUps() {
		return powerUps;
	}
	public void increaseMaxHealth(int increaseBy) {
		maxHealth += increaseBy;
	}
	public void decreaseMaxHealth(int decreaseBy) {
		maxHealth -= decreaseBy;
	}
	public void addPaperScissorsRockPowerUp() {
		hasPaperScissorsRockPowerUp = true;
	}
	public void  addGuessNumberPowerUp() {
		hasGuessNumberPowerUp = true;
	}

	public void heal(double healingInput) {
		int toHeal = (int) (healingInput * maxHealth);
		currentHealth += toHeal;
		if (currentHealth > maxHealth) {
			currentHealth = maxHealth;
		}
	}
	public int getHealth() {
		return currentHealth;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public String toString() {
		String toReturn;
		toReturn = "Name: " + name + ". Herotype: " + type + ". Health: " + Integer.toString(currentHealth) + "/" + maxHealth +"\n";
		return toReturn;
	}
	
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public void doDamage(int damage, Team team, BattleWindowGUI battleWindowGui) {
		currentHealth -= damage;
		if (currentHealth <= 0) {
			if (battleWindowGui != null) {
				team.killHero(this);
				battleWindowGui.removeDeadHeroFromComboBox(this);
			}			
		}
	}
	public void addDiceGamePowerUp() {
		hasDiceGamePowerUp = true;
	}
	public boolean getHasPaperScissorsRockPowerUp() {
		return hasPaperScissorsRockPowerUp;
	}
	public void setHasPaperScissorsRockPowerUp(boolean hasPaperScissorsRockPowerUp) {
		this.hasPaperScissorsRockPowerUp = hasPaperScissorsRockPowerUp;
	}
	public boolean getHasGuessNumberPowerUp() {
		return hasGuessNumberPowerUp;
	}
	public void setHasGuessNumberPowerUp(boolean hasGuessNumberPowerUp) {
		this.hasGuessNumberPowerUp = hasGuessNumberPowerUp;
	}
	public boolean getHasDiceGamePowerUp() {
		return hasDiceGamePowerUp;
	}
	public void setHasDiceGamePowerUp(boolean hasDiceGamePowerUp) {
		this.hasDiceGamePowerUp = hasDiceGamePowerUp;
	}
	
}
	