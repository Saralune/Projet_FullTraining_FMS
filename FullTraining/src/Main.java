import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		/*INIT*/
		int answer = 0;
		
		//List of trainings
		ArrayList<String[]> trainingsList = initAllTrainings();
		
		//Basket of user
		HashMap<Integer, Integer> basket = new HashMap<Integer, Integer>();
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
					
					while(answer != 0) {
						addTrainingToBasket(basket, answer, trainingsList);
						
						while(!scanner.hasNextInt()) scanner.next();
						answer = scanner.nextInt();
					}
					System.out.println(basket.entrySet());
					break;
					
				case 3:
					printBasket(basket, trainingsList);
					break;
					
				case 4:
					printBasket(basket, trainingsList);
					
					if(basket.size() > 0) {
						System.out.println("Que souhaitez-vous supprimer ? Saisir la référence.");
					
						while(!scanner.hasNextInt()) scanner.next();
						answer = scanner.nextInt();
						
						deleteTrainingFromBasket(basket, answer, trainingsList);
					}
					
					break;
					
				case 5:
					System.out.println("Merci d'avoir parcouru notre application. Bonne journée !");
					answer = -1;
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
		String[] training5 = {"5", "Angular", "200", "Les bases & autres cadeaux", "10000"};
		
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
		System.out.println("4. Supprimer une formation de mon panier.");
		System.out.println("5. Quitter l'application.");

	}
	
	public static void addTrainingToBasket(HashMap<Integer, Integer> basket, int answer, ArrayList<String[]> trainingList) {

		if(answer <= trainingList.size()) {
			if(basket.get(answer) == null) {
				Integer count = 0;
				basket.put(answer, ++count);
			} else {
				basket.put(answer, basket.get(answer) + 1);
			}
				
			System.out.println("Vous avez ajouté " + trainingList.get(answer - 1)[1] + " - " + trainingList.get(answer - 1)[3] + ".");	
			System.out.println(basket.entrySet());	
				
			System.out.println("Si vous souhaitez ajouter une autre formation, tapez le chiffre correspondant, sinon tapez 0 pour un retour au menu.");
		} else {
			System.out.println("Merci de saisir un nombre proposé.");
		}	
	}
	
	
	/**Print basket of user, with courses selected (duration, quantity, price and total price)
	 * 
	 * */
	public static void printBasket(HashMap<Integer, Integer> basket, ArrayList<String[]> trainingList) {
		if(basket.size() > 0) {
			System.out.println("Voici votre panier : ");
			
			String format  = "%1$-3s | %2$-45s | %3$-10s | %4$-8s | %5$-6s | %6$-12s |\n";
			
			System.out.println(String.join("", Collections.nCopies(101, "-")));
			System.out.format(format, "Ref", "Cours", "Durée", "Quantité", "Prix", "Prix total");
			System.out.format(format, "---", String.join("", Collections.nCopies(45, "-")),  "----------", "--------", "------", "------------");
			
			int totalTrainings = 0;
			
			for (Map.Entry<Integer, Integer> cartEntry : basket.entrySet()) {
				int total = Integer.parseInt(trainingList.get(cartEntry.getKey() - 1)[4]) * cartEntry.getValue(); //total price
						
				//key : cartEntry.getKey()
				//value : cartEntry.getValue());
		           if(cartEntry.getValue() > 0) {
		        	   	System.out.format(format,
		        		   trainingList.get(cartEntry.getKey() - 1)[0],
		        		   trainingList.get(cartEntry.getKey() - 1)[1] + " - " + trainingList.get(cartEntry.getKey() - 1)[3], //Name of course
		        		   trainingList.get(cartEntry.getKey() - 1)[2], //Duration
		        		   cartEntry.getValue(), //quantity
		        		   trainingList.get(cartEntry.getKey() - 1)[4], //Price U
		        		   total
		        		);
		           }

		           
		           totalTrainings += total;
		        }
			
			System.out.println(String.join("", Collections.nCopies(101, "-")));
			
			System.out.println("Total à régler : " + totalTrainings);
			
			System.out.println();
		} else {
			System.out.println("Votre panier est vide.\n");
		}

	}
	
	public static void deleteTrainingFromBasket(HashMap<Integer, Integer> basket, int answer, ArrayList<String[]> trainingList) {
	
		if(answer <= trainingList.size()) {
			if(basket.get(answer) != null && basket.get(answer) > 0) {
				basket.put(answer, basket.get(answer) - 1);
				System.out.println("Vous avez supprimé " + trainingList.get(answer - 1)[1] + " - " + trainingList.get(answer - 1)[3] + ".");	
			} else {
				System.out.println("Vous n'avez pas cette référence dans votre panier.");			}
		} else {
			System.out.println("Merci de saisir un nombre proposé.");
		}		
	}
	
	/** Add a course to my list of training
	 * 
	 * */
	public static void addTraining(String[] training) {
		
	}

}
