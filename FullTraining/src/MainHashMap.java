import java.util.ArrayList;
import java.util.HashMap;

public class MainHashMap {
	public static void main(String[] args) {
		System.out.println("Bonjour et bienvenue dans mon application FullTraining.");
		System.out.println("Nous allons vous proposer une liste de formation actuellemnt disponibles : ");
		
		displayAllTraining(initAllTraining());
	}
	
	/**Function that initializes all training available (name, duration, description, price)
	 * 
	 * @author Stagiaires10P
	 * @return void
	 * 
	 * */
	public static HashMap<Integer, String[]> initAllTraining() {
		HashMap<Integer, String[]> trainingList = new HashMap<Integer, String[]>();
				
		String[] training1 = {"Java", "10", "Les bases", "1000"};
		String[] training2 = {"Java", "20", "Java avancé : POO", "3000"};
		String[] training3 = {"Git", "2", "Les bases", "500"};
		String[] training4 = {"Git", "20", "Les branches et autres concepts avancés", "2599"};
		String[] training5 = {"Angular", "200", "Les bases & autres cadeaux", "10 000"};
		
		trainingList.put(1, training1);
		trainingList.put(2, training2);
		trainingList.put(3, training3);
		trainingList.put(4, training4);
		trainingList.put(5, training5);
		
		return trainingList;
	}
	
	/**Function that print all training initialized
	 * 
	 * @author Stagiaires10P
	 * @return void
	 * 
	 * */
	public static void displayAllTraining(HashMap<Integer, String[]> trainingList) {
		String format  = "%8s | %8s | %40s | %8s";
		
		System.out.println("--------------------------------------------------------------");
		System.out.format(format, "COURS", "NB/JOURS", "DESCRIPTION", "PRIX\n");
		System.out.format(format, "--------", "--------", "----------", "--------\n");
		
		for (int i = 0; i < trainingList.size(); i++) {
			System.out.format(format, 
					trainingList.get(i)[0], 
					trainingList.get(i)[1], 
					trainingList.get(i)[2], 
					trainingList.get(i)[3] + "\n");
		}
		
		System.out.println("--------------------------------------------------------------");
	}
}
