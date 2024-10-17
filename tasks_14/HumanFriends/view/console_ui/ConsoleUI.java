package view.console_ui;

import presenter.Presenter;
import view.View;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private String path = "model/writer/animal_registry.ser";
    private List<String> animalTypes;
    private MenuHandler menuHandler;
    private Presenter presenter;
    private InputHandler inputHandler;
    private boolean work;

    public ConsoleUI() {
        inputHandler = new InputHandler(new Scanner(System.in));
        presenter = new Presenter(this);
        menuHandler = new MenuHandler(this);
        work = true;
        animalTypes = presenter.animalTypes();
        presenter.setPath(path);
    }

    @Override
    public void startWork() {
        greetings();
        presenter.readAnimalData();
        selectItemFromMenu();
    }

    private void greetings() {
        System.out.println("Начинаем работу с базой животных");
    }

    private void selectItemFromMenu() {
        while (work) {
            System.out.println(menuHandler.getMenu());
            String choiceStr = inputHandler.getInput();
            if (inputHandler.isValidMenuChoice(choiceStr, menuHandler.size())) {
                int choice = Integer.parseInt(choiceStr);
                menuHandler.execute(choice);
            } else {
                System.out.println("Invalid menu option entered.\nPlease enter a valid number from the menu: from 1 to " + menuHandler.size());
            }
        }
    }

    public void createAnimal() {
        System.out.println("Выберите пожалуйста вид животного для создания ");
        for (String animalType : animalTypes) {
            System.out.println("• " + animalType);
        }
        String animalType = inputHandler.getAnimalTypeInput(animalTypes);

        String name = getName(animalType);
        LocalDate birthDate = getBirthDate(name);

        switch (animalType.toLowerCase()) {
            case "dog":
                createDog(name, birthDate);
                break;
            case "cat":
                createCat(name, birthDate);
                break;
            case "hamster":
                createHamster(name, birthDate);
                break;
            case "camel":
                createCamel(name, birthDate);
                break;
            case "horse":
                createHorse(name, birthDate);
                break;
            case "donkey":
                createDonkey(name, birthDate);
                break;
            default:
                System.out.println("Неизвестный вид животного.");
        }
    }

    private String getName(String animalType) {
        System.out.println("Enter " + animalType.toLowerCase() + "'s name:");
        return inputHandler.getInput();
    }

    private LocalDate getBirthDate(String name) {
        System.out.println("Enter " + name + "'s birth date with spaces in the format DD MM YYYY:");
        return inputHandler.getBirthDateInput();
    }

    private void createDog(String name, LocalDate birthDate) {
        System.out.println("Enter the dog's breed:");
        String breed = inputHandler.getInput();
        presenter.createDog(name, birthDate, breed);
    }

    private void createCat(String name, LocalDate birthDate) {
        System.out.println("Enter the cat's color:");
        String color = inputHandler.getInput();
        presenter.createCat(name, birthDate, color);
    }

    private void createHamster(String name, LocalDate birthDate) {
        System.out.println("Enter the hamster's wheel size:");
        int wheelSize = inputHandler.getNumberInput("wheelSize");
        presenter.createHamster(name, birthDate, wheelSize);
    }

    private void createCamel(String name, LocalDate birthDate) {
        System.out.println("Enter the number of humps (1 or 2):");
        int numberOfHumps = inputHandler.getNumberInput("humps");
        presenter.createCamel(name, birthDate, numberOfHumps);
    }

    private void createHorse(String name, LocalDate birthDate) {
        System.out.println("Enter the horse's weight:");
        int weight = inputHandler.getNumberInput("weight");
        presenter.createHorse(name, birthDate, weight);
    }

    private void createDonkey(String name, LocalDate birthDate) {
        System.out.println("Enter the donkey's stamina:");
        int stamina = inputHandler.getNumberInput("stamina");
        presenter.createDonkey(name, birthDate, stamina);
    }

    public void trainAnimal() {
        while (true) {
            System.out.println("Please enter animal's name:");
            String name = inputHandler.getInput();
            if (presenter.isAnimalExist(name)) {
                System.out.println("Please enter command:");
                String command = inputHandler.getInput();
                presenter.trainAnimal(name, command);
                System.out.println("Animal with name " + name + " has learned command: " + command + ".\n");
                return;
            } else {
                System.out.println("Animal with name " + name + " not found.");
            }
        }
    }

    public void printAnimalCommands() {
        while (true) {
            System.out.println("Please enter animal's name:");
            String name = inputHandler.getInput();
            if (presenter.isAnimalExist(name)) {
                System.out.println("Commands for " + name + ": ");
                presenter.printAnimalCommands(name);
                return;
            } else {
                System.out.println("Animal with name " + name + " not found.");
            }
        }
    }

    public void getAnimalsSortedByBirthdate() {
        System.out.println("Animals sorted by birth date:");
        presenter.getAnimalsSortedByBirthdate();
    }

    public void getAnimalsSortedById() {
        System.out.println("Animals sorted by ID:");
        presenter.getAnimalsSortedById();
    }

    public void printAllAnimals() {
        presenter.printAllAnimals();
    }

    public void totalCountOfAnimals() {
        System.out.println("Total number of created animals: " + presenter.totalCountOfAnimals() + ".\n");
    }

    @Override
    public void finishWork() {
        work = false;
        System.out.println("Good bye!");
        presenter.saveAnimalData();
    }
}
