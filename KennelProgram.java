import java.util.ArrayList;
import java.util.Scanner;

/* fixa så den ignorerar mellanslag i kommandon och namnen, etc.*/
public class KennelProgram {

    private Scanner input = new Scanner(System.in);
    private ArrayList<Dog> dogs = new ArrayList<>();

    private void initialize() {
        System.out.println("Welcome to our Kennel Program!");
        System.out.println("The available commands are:");
        System.out.println("Register New Dog");
        System.out.println("Increase Age");
        System.out.println("List Dogs");
        System.out.println("Remove Dog");
        System.out.println("Exit");

    }

    private String readCommand(){

        System.out.print("Command: ");
        String command = input.nextLine();
        return command;

    }

    private boolean handleCommand(String command){

        switch (command.toUpperCase()) {
            case "REGISTER NEW DOG":
                addDog();
                break;

            case "INCREASE AGE":
                increaseAge();
                break;

            case "LIST DOGS":
                listDogs();
                break;

            case "REMOVE DOG":
                removeDog();
                break;


            case "EXIT":
                return true;


            default:
                System.out.println("Error: Not a command");
        }
        return false;
    }

    private void runCommandLoop() {

        boolean exit;
        do {
            String command = readCommand();
            exit = handleCommand(command);
        } while (!exit);
    }

    private void addDog(){
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Breed: ");
        String breed = input.nextLine();
        System.out.print("Age: ");
        int age = input.nextInt();
        System.out.print("Weight: ");
        int weight = input.nextInt();
        input.nextLine();


        Dog d = new Dog(name, breed, age, weight);

        dogs.add(d);
        System.out.println(name + " added to the register.");
    }

    private void listDogs(){

        System.out.print("Smallest Tail Length to display: ");
        double tailLength = input.nextDouble();
        input.nextLine();
        boolean exists = false;

        for (int counter = 0; counter < dogs.size(); counter++) {
            if(dogs.get(counter).getTailLength()>=tailLength){
                System.out.println(dogs.get(counter));
                exists = true;
            }
        }

        if(!exists){
            System.out.println("Error: No such dog");
        }

    }

    private void removeDog(){

        System.out.print("Enter the name of the dog: ");
        String d = input.nextLine();
        boolean exists = false;

        for(int counter = 0; counter<dogs.size(); counter++){

            if(dogs.get(counter).getName().equalsIgnoreCase(d)){
                dogs.remove(counter);
                exists = true;
                System.out.println(d + " is removed from the register");
            }

        } if(!exists) {
            System.out.println("Error: No such dog");
        }

    }

    private void increaseAge(){

        System.out.print("Enter the name of the dog: ");
        String d = input.nextLine();
        boolean exists = false;

        for(int counter = 0; counter<dogs.size(); counter++){

            if(dogs.get(counter).getName().equalsIgnoreCase(d)){
                dogs.get(counter).increaseAge();
                exists = true;
                System.out.println(d + " is now one year older");
            }

        } if(!exists) {
            System.out.println("Error: No such dog");
        }
    }

    private void shutDown() {

        System.out.println("Goodbye!");
    }

    public static void main(String[] args) {
        KennelProgram program = new KennelProgram();
        program.initialize();
        program.runCommandLoop();
        program.shutDown();

    }

}
