package JavaBeanForest;

import java.util.Random;
public class Knight {

	private String knightName;
	private int health;
	private int weapon;
	private int armor;
	private String weaponStr;
	
	public Knight()
	{
		setKnight(0,"");
	}
	
	public Knight(String name)
	{
		setKnight(0,name);
	}
	
	public void setKnight(int w,String n)
	{
		setWeapon(w);
		setName(n);
	}
	
	public String toString()
	{
		switch (weapon)
		{
			case 1: 
				weaponStr = "Long Sword";
				break;
			case 2: weaponStr = "Battle Axe";
				break;
			case 3: weaponStr = "Spear";
				break;
			case 4: weaponStr = "Warhammer";
				break;
			default: weaponStr = "none!";
		}
		
		String armorStr;
		switch (armor)
		{
			case 1: 
				armorStr = "Leather";
				break;
			case 2: armorStr = "Metal";
				break;
			default: armorStr = "none!";
		}
		
		
		String stats = ( "Your Knight " + knightName + "\n is equipped with "
				+ armorStr + " armor, \n is weilding a " + weaponStr + " weapon, \n and has "
				+ health + " health!");
		return stats;
	}
	
	public void setName( String name )
	{
		knightName = name;
	}
	public String getName()
	{
		return knightName;
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
	public int getWeapon()
	{
		return weapon;
	}
	
	public void setArmor( int a )
	{
		armor= a;
	}
	public int getArmor()
	{
		return armor;
	}
	
	public int fight()
	{
		Random makeRando = new Random();
		int rando = makeRando.nextInt();
		if (weapon == 1)
		{
			rando = Math.abs(rando % 7) + 5;
		}
		if (weapon == 2)
		{
			rando = Math.abs(rando % 3) + 8;
		}
		if (weapon == 3)
		{
			rando = Math.abs(rando % 18) + 1;
		}
		if (weapon == 4)
		{
			rando = Math.abs(rando % 25) + 1;
		}
		return rando;
	}
	
	public void takeDamage(int d)
	{
		health = (health-d);
	}
	
	public String combatText()
	{
		String text = knightName + " weilding " + weaponStr +" delivers: ";
		return text;
	}
}
