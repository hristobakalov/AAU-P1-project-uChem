package uchem;

import java.lang.reflect.Array;

public class QuestionsDataAccess {
	// TODO: maybe use an interface and inherit it
	// TODO: change hard coded questions with getting them from a database
	private Question[] cLevelQuestions = new Question[] {
			// 0,1,2 for the correct answer
			//used html, because this is the easiest way to show subscripted numbers
			//what the fuck? the subscripted numbers don't show if the font size is smaller than 22
			new Question("<html>Afstem følgende reaktionsskemaer: H₂ + O₂ → H₂O</html>", 
					"<html>H<sub>2</sub> + O<sub>2</sub> -> H<sub>2</sub>O</html>",
					"<html>H<sub>2</sub> + ½O<sub>2</sub> -> H<sub>2</sub>O</html>",
					"<html>H<sub>2</sub> + O<sub>2</sub> -> 2H<sub>2</sub>O</html>", 1),
			new Question("Hvad fortæller atomnummeret om det pågældende grundstof?",
					"Antal neutroner",
					"Antal protoner i atomet",
					"Antal kernepartikler", 1),
			new Question("Afstem reaktionsligningen N₂(g) + O₂ → NO?",
					"<html>N<sub>2</sub>(g) + O<sub>2</sub>(g) -> 2NO(g)</html>",
					"<html>2N<sub>2</sub>(g) + O<sub>2</sub>(g) -> 2NO(g)</html>",
					"<html>N<sub>2</sub>(g) + 2O<sub>2</sub>(g) -> 2NO(g)</html>", 0),
			new Question("Hvor meget vejer 2 mol Ag?",
					"107,87 g",
					"53,94 g",
					"215,74 g", 2),
			//problem with the two question below
			new Question("<html>Hvad er koncentrationen af ionerne i den følgende opløsning af letopløselige salte: Na<sup>+</sup> og Cl<sup>-</sup> i en 0,75 M NaCl opløsning</html>",
					"<html>[Na<sup>+</sup>]=0,375 M og [Cl<sup>-</sup>]=0,375 M</html>",
					"<html>[Na<sup>+</sup>]=0,75 M og [Cl<sup>-</sup>]=0,75 M</html>",
					"<html>[Na<sup>+</sup>]=1,0 M og [Cl<sup>-</sup>]=1,0 M</html>", 1),
			new Question("Fuldfør følgende reaktioner og angiv hvilke stoffer der er syrer og hvilke der er baser, ved at skrive henholdsvis \"s\" og \"b\" under formlerne. HCl(aq) + H₂O(l) ->",
					"<html>HCl(aq)\"b\" + H2O(l)\"s\" -><br> Cl<sup>-</sup>(aq)\"s\" + H3O<sup>+</sup>(aq)\"b\"</html>", 
					"<html>HCl(aq)\"s\" + H2O(l)\"b\" -><br> Cl<sup>-</sup>(aq)\"b\" + H3O<sup>+</sup>(aq)\"s\"</html>",
					"<html>HCl(aq)\"b\" + H2O(l)\"b\" -><br> Cl<sup>-</sup>(aq)\"s\" + H3O(aq)\"s\"</html>", 1),
			new Question("Find oxidationstallet for Kalium i følgende kemiske forbindelse: KOH",
					"+1", 
					"0",
					"-1", 0), 
			new Question("Navngiv denne forbindelse: CH₃CH₂CH₂CH₂CH₃",
					"Propan", 
					"Pentan",
					"Hexan", 1),
			new Question("Hvad er molmassen af AgNO₃?",
					"169,88 g/mol", 
					"169,88 M",
					"169,88 mol", 0),
			new Question("Hvad kaldes et stof som består af et metal og et ikke-metal?",
					"Forbindelse", 
					"Grundstof",
					"Salt", 2),
			//problem here
			new Question("Grupperne i det periodiske system er inddelt i hovedgrupper og undergrupper. Hvor mange hovedgrupper er der?",
					"7", 
					"8",
					"9", 1),
			new Question("Angiv hvordan stofmængdekoncentrationen (koncentrationen) er defineret.",
					"c=m/v", 
					"c=v/n",
					"c=n/v", 2),
			new Question("Hvad er det systematiske navn for vand?",
					"Dihydrogenoxid", 
					"Hydrogendioxid",
					"Hydrogenoxid", 0),
			new Question("Hvad er en ion?",
					"<html>Et atom som både har modtaget og afgivet en elektron</html>", 
					"<html>Et atom som enten har modtaget eller afgivet en elektron</html>",
					"<html>Et positiv ladet atom</html>", 1),
			};

	private Question[] bLevelQuestions = new Question[] {
			new Question("What is the molar mass of H2O BLEVEL?", "14", "16", "18", 1),
			new Question("Question 2 BLEVEL", "Answer 1", "Answer 2", "Answer 3", 0),
			new Question("Question 3 BLEVEL", "Answer 1", "Answer 2", "Answer 3", 0) };

	private Question[] aLevelQuestions = new Question[] {
			new Question("What is the molar mass of H2O ALEVEL?", "14", "16", "18", 1),
			new Question("Question 2 A LEVEL", "Answer 1", "Answer 2", "Answer 3", 2),
			new Question("Question 3 A LEVEL", "Answer 1", "Answer 2", "Answer 3", 0) };

	// maybe make this static
	public Question[] getCLevelQuestionsQuestions() {
		return cLevelQuestions;
	}

	public Question[] getBLevelQuestionsQuestions() {
		return bLevelQuestions;
	}

	public Question[] getALevelQuestionsQuestions() {
		return aLevelQuestions;
	}

	public Question[] getAllQuestions() {
		// problem with getting the a level questions
		int cLevelLength = cLevelQuestions.length;
		int bLevelLength = bLevelQuestions.length;
		int aLevelLength = aLevelQuestions.length;
		Question[] all = new Question[cLevelLength + bLevelLength + aLevelLength];
		System.out.println(all.length);
		System.out.println(all[0]);
		System.arraycopy(cLevelQuestions, 0, all, 0, cLevelLength);
		System.arraycopy(bLevelQuestions, 0, all, cLevelLength, bLevelLength);
		// System.arraycopy(aLevelQuestions, 0, all, bLevelLength,
		// aLevelLength);
		return all;
	}
}
