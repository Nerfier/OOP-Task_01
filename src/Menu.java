import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        String choice;

        printMenu();
        do {
            choice = getChoice();
            switch (choice) {
                case "1":
                    Avatar.print();
                    break;
                case "2":
                    Today.print();
                    break;
                case "3A":
                    RockScissorPaper game = new RockScissorPaper();
                    game.play();
                    break;
                case "m":
                    printMenu();
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println("Not a valid choice.");
                    break;
            }
        } while(!(choice.equals("q") || choice.equals("Q")));
    }

    public String getChoice() {
        System.out.print(">>> ");
        return scanner.nextLine();
    }

    public void printMenu() {
        String menuText = """
             -----------------
            | 1) Print my avatar
            | 2) Print today date/time
            | 3A) Rock paper scissor
            | m) Print menu
            | qQ) Quit
             -----------------""";

        System.out.println(menuText);

    }
}
