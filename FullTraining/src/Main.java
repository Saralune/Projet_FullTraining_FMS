import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Application permettant d'acheter des formations en ligne
 * */
public class Main {

	public static void main(String[] args) {
		/*INIT*/
		Scanner scanner = new Scanner(System.in);
		
		HashMap<Integer, ArrayList<String>> basket = new HashMap<Integer, ArrayList<String>>();
		/*END INIT*/
		
		System.out.println("Bonjour et bienvenue dans mon application FullTraining.");
		System.out.println("Nous allons vous proposer une liste de formation actuellemnt disponibles : ");
		initAllTrainings();
		printTrainings();
		
		printMenu();
		int answer = scanner.nextInt();
		
		//A VOIR SI AUTRE R2PONSE ????
		//while(scanner.hasNextInt()) {
			switch(answer) {
				case 1:
					printTrainings();
					break;
					
				case 2:
					printTrainingsToChoose();
					addTrainingToBasket(basket, answer);
					break;
					
				case 3:
					printBasket();
					break;
					
			}
		//}
		
		
		scanner.close();
		
	}
	
	/**Function that initializes all training available (name, duration, description, price)
	 * 
	 * @author Stagiaires10P
	 * @return void
	 * 
	 * */
	public static ArrayList<String[]> initAllTrainings() {
		ArrayList<String[]> trainingList = new ArrayList<>();
				
		String[] training1 = {"1", "Java", "10", "Les bases", "1000"};
		String[] training2 = {"2", "Java", "20", "Java avancé : POO", "3000"};
		String[] training3 = {"3", "Git", "2", "Les bases", "500"};
		String[] training4 = {"4", "Git", "20", "Les branches et autres concepts avancés", "2599"};
		String[] training5 = {"5", "Angular", "200", "Les bases & autres cadeaux", "10 000"};
		
		trainingList.add(training1);
		trainingList.add(training2);
		trainingList.add(training3);
		trainingList.add(training4);
		trainingList.add(training5);
		
		return trainingList;
	}
	
	/**Function that print all training available (name, duration, description, price)
	 * 
	 * @author Stagiaires10P
	 * @return void
	 * 
	 * */
	public static void printTrainings() {
		ArrayList<String[]> trainingList = initAllTrainings();
		
		String format  = "%1$-8s | %2$-8s | %3$-40s | %4$-6s |\n";
		
		System.out.println(String.join("", Collections.nCopies(73, "-")));
		System.out.format(format, "COURS", "NB/JOURS", "DESCRIPTION", "PRIX");
		System.out.format(format, "--------", "--------", String.join("", Collections.nCopies(40, "-")), "------");
		
		for (int i = 0; i < trainingList.size(); i++) {
			System.out.format(format, 
					trainingList.get(i)[1], 
					trainingList.get(i)[2], 
					trainingList.get(i)[3], 
					trainingList.get(i)[4]);
		}
		
		System.out.println(String.join("", Collections.nCopies(73, "-")));
		System.out.println();
		
	}
	
	/**Function that print all training when user want to add one to his basket.
	 * 
	 * @author Stagiaires10P
	 * @return void
	 * 
	 * */
	public static void printTrainingsToChoose() {
		ArrayList<String[]> trainingList = initAllTrainings();
		String format  = "%1$-6s | %2$-8s | %3$-8s | %4$-40s | %5$-6s |\n";
		
		System.out.println(String.join("", Collections.nCopies(82, "-")));
		System.out.format(format,"CHOIX", "COURS", "NB/JOURS", "DESCRIPTION", "PRIX");
		System.out.format(format, "------",  "--------", "--------", String.join("", Collections.nCopies(40, "-")), "------");
		
		for (int i = 0; i < trainingList.size(); i++) {
			System.out.format(format, 
					trainingList.get(i)[0],
					trainingList.get(i)[1], 
					trainingList.get(i)[2], 
					trainingList.get(i)[3], 
					trainingList.get(i)[4]);
		}
		
		System.out.println(String.join("", Collections.nCopies(82, "-")));
	}
	
	/** Print menu. It will display all choices for user.
	 * 
	 * */
	public static void printMenu() {
		System.out.println("Que souhaitez-vous faire ?");
		System.out.println("1. Afficher la liste des formations.");
		System.out.println("2. Ajouter une formation à mon panier.");
		System.out.println("3. Afficher le contenu de mon panier.");
		
		//System.out.println("2. ");
		//System.out.println("2. ");
		//System.out.println("2. ");
		
		System.out.println("X. Quitter l'application.");

	}
	
	public static void addTrainingToBasket(HashMap<Integer, ArrayList<String>> basket, int id) {
		//ajouter à la hashmap avec integer = id
		//pour savoir si plusieurs ajout : taille de la arraylist
		
		System.out.println("Vous avez ajouté la leçon : " + "truc");
	}
	
	public static void printBasket() {
		
		//sous forme de tableau
		//ligne : cours - durée [1] jours - qté - prix unitaire - prix total
	}
	
	/** Add a course to my list of training
	 * 
	 * */
	public static void addTraining(String[] training) {
		
	}

}
