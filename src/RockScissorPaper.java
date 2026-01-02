import java.util.Random;
import java.util.Scanner;

public class RockScissorPaper {
    private Scanner scanner;
    private int scoreP;
    private int scoreA;

    public RockScissorPaper() {
        scanner = new Scanner(System.in);
        scoreA = 0;
        scoreP = 0;
    }

    public void play() {
        String choice;
        System.out.println("Welcome to a game of rock ✊, scissor ✀, paper ✋!\nYou will play against Dude and we keep score.");
        printOptions();

        do {
            
            System.out.print("Your move: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "r":
                case "s":
                case "p":
                    handleOutcome(choice, getAvatarChoice());
                    break;
                case "q":
                    System.out.println("Thanks for playing! We will save your current score");
                    break;
                default:
                    System.out.println("Not an option. Try again");
                    break;
            }
        } while(!(choice.equals("q") || choice.equals("Q")));


    }

    private void printOptions() {
        printScore();
        System.out.println("Select rock ✊ [r], scissor ✀ [s], paper ✋ [p] or quit [q]:");
    }

    private void printScore() {
        System.out.println(String.format("Score: You %d - Dude %d", scoreP, scoreA));
    }

    private String getAvatarChoice() {
        String[] s = {"r", "s", "p"};
        Random rand = new Random();

        return s[rand.nextInt(3)];
    }

    private void handleOutcome(String choiceP, String choiceA) {
        System.out.println(constructString(choiceP, choiceA));
        printScore();
    }

    private String constructString(String choiceP, String choiceA) {
        String[] moves = {"did rock ✊", "selected paper ✋", "chose scissor ✀ "};
        String s = "You ";
        for(int i = 0 ; i < 2; i++) {
            String choice;
            if(i == 0) {
                choice = choiceP;
            } else {
                choice = choiceA;
                s += " and Dude ";
            }

            switch (choice) {
                case "r":
                    s += moves[0];
                    break;
                case "s":
                    s += moves[2];
                    break;
                case "p":
                    s += moves[1];
                    break;
            }
        }
        s += ". ";
        s += evaluateScore(choiceP, choiceA);
        return s;
    }

    private String evaluateScore(String choiceP, String choiceA) {
        String[] outcomes = {"Paper covers rock, ", "Scissor cut paper, ", "Rock smashes scissor, "};
        String s = "";
        if(choiceA.equals(choiceP)) {return "You are equal! No points!";}
        switch (choiceP) {
            case "r":
                if(choiceA.equals("s")) {
                    s += outcomes[2] + "You win";
                    scoreP ++;
                } else {
                    s += outcomes[0] + "Dude wins";
                    scoreA ++;
                }
                break;
            case "s":
                if(choiceA.equals("r")) {
                    s += outcomes[2] + "Dude wins";
                    scoreA ++;
                } else {
                    s += outcomes[1] + "You win";
                    scoreP ++;
                }
                break;
            case "p":
                if(choiceA.equals("s")) {
                    s += outcomes[1] + "Dude wins";
                    scoreA ++;
                } else {
                    s += outcomes[0] + "You win";
                    scoreP ++;
                }
        }
        s += " 1 point!";
        return s;
    }
}
