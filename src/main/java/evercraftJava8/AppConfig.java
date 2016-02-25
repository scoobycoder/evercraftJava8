package evercraftJava8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public CraftCharacter craftCharacter() {
		return new CraftCharacter(plateArmor(), startingHealth(), modifier());
	}
	
	@Bean
	public Spock spock() {
		return new Spock(plateArmor(), startingHealth(), abilities(), alignment(), knittingFactory(), modifier());
	}

	@Bean
	public Spock evilSpock() {
		return new Spock(plateArmor(), startingHealth(), abilities(), alignment(), knittingFactory(), modifier());
	}
	
	@Bean
	public PlateArmor plateArmor() {
		return new PlateArmor();
	}
	
	@Bean
	public Health startingHealth() {
		return new Health();
	}
	
	@Bean
	public Modifier modifier() {
		return new Modifier();
	}
	
	@Bean
	public KnittingFactory knittingFactory() {
		return new KnittingFactory();
	}
	
	@Bean
	public Abilities abilities() {
		return new Abilities(intelligence(), charisma(), strength(), dexterity(), constitution());
	}
	
	@Bean
	public ActualAbility intelligence() {
		ActualAbility intelligence = new ActualAbility();
		intelligence.setAbilityName("intelligence");
		intelligence.setLevel(20);
		return intelligence;
	}
	
	@Bean
	public ActualAbility charisma() {
		ActualAbility charisma = new ActualAbility();
		charisma.setAbilityName("charisma");
		charisma.setLevel(5);
		return charisma;
	}
	
	@Bean
	public ActualAbility strength() {
		ActualAbility strength = new ActualAbility();
		strength.setAbilityName("strength");
		strength.setLevel(20);
		return strength;
	}
	
	@Bean
	public ActualAbility dexterity() {
		ActualAbility dexterity = new ActualAbility();
		dexterity.setAbilityName("dexterity");
		dexterity.setLevel(15);
		return dexterity;
	}
	
	@Bean
	public ActualAbility constitution() {
		ActualAbility constitution = new ActualAbility();
		constitution.setAbilityName("constitution");
		constitution.setLevel(18);
		return constitution;
	}
	
	@Bean
	public Alignment alignment() {
		return new Alignment(1000, 0, 1);
	}

	@Bean
	public RollingDice rollingDice() {
		return new RollingDice();
	}
	
	@Bean
	public Alignment evilAlignment() {
		return new Alignment(0,1000,1);
	}
	
}
