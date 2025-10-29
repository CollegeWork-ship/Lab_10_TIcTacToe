import java.util.Scanner;

public class SafeInput {

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int num = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                num = pipe.nextInt();
                if(num >= low && num <= high){
                    done = true;
                }
                else{
                    trash = pipe.nextLine();
                    System.out.println("You must enter a value between " + low + " and " + high + ".");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a integer betweeen " + low + " and " + high + ".");
            }
        }while(!done);
        return num;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("\n" + prompt + ": ");
            input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("y")) {
                return false;
            } else if (input.equals("n")) {
                return true;
            } else {
                System.out.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
            }
        }
    }


}
