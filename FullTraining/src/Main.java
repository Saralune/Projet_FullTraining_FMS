import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

//demander à mohamed :
/* problèmes avec le scanner
 * merge des branches quand on a fini une fonctionnalité ?
 * 
 * */

/**
 * Application permettant d'acheter des formations en ligne
 * */
public class Main {

	public static void main(String[] args) {
		/*INIT*/
		Scanner scanner = new Scanner(System.in);
		
		int answer = 0;
		
		//List of trainings
		ArrayList<String[]> trainingsList = initAllTrainings();
		
		//Basket of user
		HashMap<Integer, ArrayList<String[]>> basket = new HashMap<Integer, ArrayList<String[]>>();
		/*END INIT*/
		
		System.out.println("Bonjour et bienvenue dans mon application FullTraining.");
		System.out.println("Nous allons vous proposer une liste de formation actuellemnt disponibles : ");
		
		printTrainings();

		while(answer != -1) {
			printMenu();
			
			while(!scanner.hasNextInt()) scanner.next();
			answer = scanner.nextInt();
			
			switch(answer) {
				case 1:
					printTrainings();
					break;
					
				case 2:
					System.out.println("Quelle formation souhaitez-vous ajouter ? Saisir le chiffre correspondant.");
					printTrainingsToChoose();	
					
					while(!scanner.hasNextInt()) scanner.next();
					answer = scanner.nextInt();
					
					while(scanner.hasNextInt()) {

						if(answer == 0) {
							System.out.println("Retour au menu.");
							break;
						}
						
						addTrainingToBasket(basket, answer, trainingsList);
					
						answer = scanner.nextInt();
					}
					System.out.println(basket.entrySet());
					break;
					
				case 3:
					printBasket(basket);
					break;
					
				case 4:
					System.out.println("Merci d'avoir parcouru notre application. Bonne journée !");
					answer = -1;
					break;
					
			}
			
			if(answer != -1) {
				printMenu();
				while(!scanner.hasNextInt()) scanner.next();
				answer = scanner.nextInt();
			} else {
				break;
			}

		}
		
		
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
		System.out.println("4. Quitter l'application.");

	}
	
	public static void addTrainingToBasket(HashMap<Integer, ArrayList<String[]>> basket, int answer, ArrayList<String[]> trainingList) {
		
		if(answer <= trainingList.size()) {
			//If there are no values in basket with key "answer"
			if(basket.get(answer) == null) {
				//it creates an arraylist that i can fill
				basket.computeIfAbsent(answer, k -> new ArrayList<>()).add(trainingList.get(answer - 1));
				System.out.println("cébon");
				
			} else {
				System.out.println("déjà rempli");
				basket.get(answer).add(trainingList.get(answer - 1));
			}
			
			System.out.println("Vous avez ajouté " + trainingList.get(answer - 1)[1] + " - " + trainingList.get(answer - 1)[3] + ".");
			
			System.out.println(basket.entrySet());
			System.out.println(basket.get(answer).get(0)[1]);
			System.out.println();
			
			System.out.println("Si vous souhaitez ajouter une autre formation, tapez le chiffre correspondant, sinon tapez 0 pour un retour au menu.");
			System.out.println("answer : " + answer);
		} else {
			System.out.println("Merci de saisir un nombre proposé.");
		}
		
	}
	
	
	/**Print basket of user, with courses selected (duration, quantity, price and total price)
	 * 
	 * */
	public static void printBasket(HashMap<Integer, ArrayList<String[]>> basket) {
		if(basket.size() > 0) {
			System.out.println("Voici votre panier : ");
			
			String format  = "%1$-25s | %2$-10s | %3$-8s | %4$-6s | %5$-12s |\n";
			
			System.out.println(String.join("", Collections.nCopies(75, "-")));
			System.out.format(format,"Cours", "Durée", "Quantité", "Prix", "Prix total");
			System.out.format(format, "-------------------------",  "----------", "--------", "------", "------------");
			
			int totalTrainings = 0;
			
			for (int i = 0; i < basket.size() + 1; i++) {	
				if(basket.get(i) != null) {
					int total = (basket.get(i).size()) * Integer.parseInt((basket.get(i).get(0)[4])); // Total price
					
					System.out.format(format, 
						basket.get(i).get(0)[1] + " - " + basket.get(i).get(0)[3], //Name of course
						basket.get(i).get(0)[2] + " jours", //Duration
						basket.get(i).size(), //Quantity
						basket.get(i).get(0)[4], //Price U
						total
					);
					
					totalTrainings += total;
				}
				
			}
			
			System.out.println(String.join("", Collections.nCopies(75, "-")));
			
			System.out.println("Total à régler : " + totalTrainings);
			
			System.out.println();
		} else {
			System.out.println("Votre panier est vide.\n");
		}

	}
	
	
	/** Add a course to my list of training
	 * 
	 * */
	public static void addTraining(String[] training) {
		
	}

}
