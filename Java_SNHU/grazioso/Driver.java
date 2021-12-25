import RescueAnimal.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    // Instance variables (if needed)

    public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      initializeDogList();
      initializeMonkeyList();
      String menuOptions = "Please select an option. \n"
                                + "[1] Intake a new dog\n"
                                + "[2] Intake a new monkey\n"
                                + "[3] Reserve an animal\n"
                                + "[4] Print a list of all dogs\n"
                                + "[5] Print a list of all monkeys\n"
                                + "[6] Print a list of all animals not reserved\n"
                                + "[q] Quit application\n";
      String userSelection;

//Print option menu for userSelection
      System.out.println("\t\t\t\tRescue Animal System Menu");
      System.out.println(menuOptions);
      userSelection = scnr.nextLine();

      do {
        displayMenu();
      }

//Print option menu for userSelection
      while(userSelection != 'q') {
        System.out.println(menuOptions);
        userSelection = scnr.nextLine();
      }
        if(userSelection == "1") {
          System.out.println("[1] Intake a new dog");
        }
        else if(userSelection == "2") {
          System.out.println("[2] Intake a new monkey");
        }
        else if(userSelection == "3") {
          System.out.println("[3] Reserve an animal");
        }
        else if(userSelection == "4") {
          System.out.println("[4] Print list of all dogs");
        }
        else if(userSelection == "5") {
          System.out.println("[5] Print list of all monkeys");
        }
        else if(userSelection == "6") {
          System.out.println("[6] Print list of all animals not reserved");
        }
        else if(userSelection == "q") {
          System.out.println("[q] Quit application");
        }
        else {
          System.out.println("Enter a menu selection");
        }
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
      Monkey monkey1 = new Monkey();
      Monkey monkey2 = new Monkey();
      Monkey monkey3 = new Monkey();

      monkeyList.add(monkey1);
      monkeyList.add(monkey2);
      monkeyList.add(monkey3);
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Add the code to instantiate a new dog and add it to the appropriate list
        Dog testDog = new Dog();
        System.out.println("Input the animal's name below");
    		String name = input.nextLine();
    		System.out.println("Input the animal's breed below");
    		String breed = input.nextLine();
        System.out.println("What is the animal's gender");
        String gender = input.nextLine();
        System.out.println("What is the animal's age");
        int age = input.nextLine();
        System.out.println("What is the animal's weight");
        double weight = input.nextLine();
        System.out.println("What is the acquisition date");
        String acquisitionDate = input.nextLine();
        System.out.println("What is the acquisition country");
        String acquisitionCountry = input.nextLine();
        System.out.println("What is the an animal's training status");
        String trainingStatus = input.nextLine();
        System.out.println("What is the animal's service country");
        String inServiceCountry = input.nextLine();
        testDog.setReserved(false);
        dogs.add(testDog);

    }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("What is the monkey's name?");
            String name = scanner.nextLine();
            for(Monkey monkey: monkeyList) {
              if(monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return;
              }
            }

            Monkey testMonkey = new Monkey();
            testMonkey.setSpecies("Capuchin");
            testMonkey.setTailLength(5.0);
            testMonkey.setBodyLength(4.0);
            testMonkey.setHeight(20.5);
            testMonkey.setTorso(4.2);
            testMonkey.setSkull(3.3);
            testMonkey.setNeck(3.2);
            testMonkey.setInserviceCountry("Argentina");
            testMonkey.setReserved(false);
            monkeuy.add(testMonkey);

        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("The method reserveAnimal needs to be implemented");

        }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved
	// Remember that you only have to fully implement ONE of these lists.
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals() {
            System.out.println("The method printAnimals needs to be implemented");

        }
}
