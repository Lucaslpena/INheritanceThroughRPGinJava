package JavaBeanForest;

import java.util.Random;
public abstract class Enemy
{
	//the below protected only available to subclasses
	protected int health;
	protected int weapon;
	protected int armor;
	protected int armorType; //1 is hard armor, 0 is other armor
	protected String type;
	
	public Enemy()			//basic constructor 
	{
		health = 0;
	}
	
	public abstract int fight();
	public abstract String combatText();
	public abstract String toString();
	
	public void takeDamage(int x) //custom exception below
	{
		try
		{
			if (x < 0)
				throw new Exception();
		}
		catch ( Exception InvalidDamageException)
		{
			System.err.println("Exception Handled: setting 'damage taken' to zero");
			x = 0;
		}
		health = health - x;
	}
	
	public void setHealth( int num )
	{
		health = num;
	}
	public int getHealth()
	{
		return health;
	}
	public void setWeapon( int w )
	{
		weapon= w;
	}

	public void setArmor( int a )
	{
		armor= a;
	}
	public int getArmor()
	{
		return armor;
	}
	public int getArmorType()
	{
		return armorType;
	}

	public void setType( String t )
	{
		type = t;
	}
	public String getType()
	{
		return type;
	}
	
	public static Enemy getRandomEnemy()
	{
		Random generator = new Random();
		int totalEncounter = generator.nextInt();
		totalEncounter = Math.abs(totalEncounter % 3) + 1; //Genearate total numbers of enemy encountering 1 - 3
		Enemy myEnemy;
		switch (totalEncounter)
		{
			case 1: myEnemy = new Ogre();
				break;
			case 2: myEnemy =  new Sorcerer();
				break;
			default: myEnemy = new Troll();
		}
		return myEnemy;
	}
}
