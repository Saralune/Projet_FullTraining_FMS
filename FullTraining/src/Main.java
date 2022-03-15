import java.util.ArrayList;
import java.util.Collections;

/**
 * Application permettant d'acheter des formations en ligne
 * */
public class Main {
	/****************NVLLE BRANCHE POUR NOUVELLE FOCNTIONNALITé******************/
	//Menu : 
		//- liste des formations
		//- Afficher le contenu du panier
		//- Ajouter une formation à son panier (possible d'ajouter plusieurs fois la même)
		//- Supprimer une formation du panier
	
	//Passer commande --> "Autre écran"
		//- Récap avec le contenu du panier + montant total
		//- Quand valid� => message de confirmation + panier vidé + appli qui revient sur le menu principal
	
	//Ajouter des formations prochainement disponibles
	
	//Fonctionnalité de mon choix

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
	public static ArrayList<String[]> initAllTraining() {
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
	
	/**Function that print all training initialized
	 * 
	 * @author Stagiaires10P
	 * @return void
	 * 
	 * */
	public static void displayAllTraining(ArrayList<String[]> trainingList) {
		String format  = "%1$-8s | %2$-8s | %3$-40s | %4$-8s\n";
		
		System.out.println(String.join("", Collections.nCopies(73, "-")));
		System.out.format(format, "COURS", "NB/JOURS", "DESCRIPTION", "PRIX");
		System.out.format(format, "--------", "--------", String.join("", Collections.nCopies(40, "-")), "--------");
		
		for (int i = 0; i < trainingList.size(); i++) {
			System.out.format(format, 
					trainingList.get(i)[1], 
					trainingList.get(i)[2], 
					trainingList.get(i)[3], 
					trainingList.get(i)[4]);
		}
		
		System.out.println(String.join("", Collections.nCopies(73, "-")));
		}
	
	/** Add a course to my list of training
	 * 
	 * */
	public static void addTraining(String[] training) {
		
	}

}
