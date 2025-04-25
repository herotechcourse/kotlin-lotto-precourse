package src.main.java.com.MicroProject;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Lotto> lottos = new ArrayList<>();
    static long[] winners = new long[5];
    static int rate;
    static long totalEarn = 0;

    public static void main(String[] args) {
        System.out.println("Please enter the purchase amount.");
        long amountOfTickets = validateAmountOfTickets();
        System.out.println();
        System.out.println("You have purchased " + (amountOfTickets / 1000) + " tickets.");
        displayTickets((int)(amountOfTickets/1000));

        System.out.println("\nPlease enter last week's winning numbers.");
        ArrayList<Integer> winningNumberList = validateWinningNumber();

        System.out.println("\nPlease enter the bonus number.");
        int bonusNumber = validateNumber();


        for(int i = 0; i < lottos.size();i++){
            lottos.get(i).compareTicket(winningNumberList, bonusNumber);
        }
        displayWinners();
        displayRate(amountOfTickets);

    }
    public static void displayRate(long amountOfTickets){
        System.out.println("Total return rate is " + ((double)totalEarn / amountOfTickets) * 100 + "%.");
    }
    public static void displayWinners(){
        System.out.println("\nWinning Statistics\n---");

        System.out.println("3 Matches (5,000 KRW) - " + winners[0] + " tickets");
        System.out.println("4 Matches (50,000 KRW) - " + winners[1] + " tickets");
        System.out.println("5 Matches (1,500,000 KRW) - " + winners[2] + " tickets");
        System.out.println("5 Matches + Bonus Ball (30,000,000 KRW) - " + winners[3] + " tickets");
        System.out.println("6 Matches (2,000,000,000 KRW) - " + winners[4] + " tickets");
    }
    public static void displayTickets(int numberOfTickets){
        while (numberOfTickets-- > 0) {
            Lotto lotto = new Lotto(getNewTicket());
            lottos.add(lotto);
            System.out.println();
        }
    }
    public static int validateNumber() {
        while (true) {
            try {
                int n = sc.nextInt();
                return n;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static long validateAmountOfTickets() {
        while (true) {
            try {
                long amount = sc.nextLong();
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] Number of tickets must be divisible by 1000.\n");
                }
                return amount;
            }catch(InputMismatchException e2){
                System.out.println("[ERROR] Please Enter a valid number.");
                sc.nextLine();
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static ArrayList<Integer> validateWinningNumber() {
        while (true) {
            try {
                return validateWinningNumberHelper();
            } catch (InputMismatchException e2) {
                System.out.println("[ERROR] Invalid input. Please enter the numbers correctly.");
                sc.nextLine();  // Clear the scanner buffer
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static ArrayList<Integer> validateWinningNumberHelper() {
        ArrayList<Integer> resultList = new ArrayList<>();
        String[] list = sc.next().split(",");

        // Validate if exactly 6 numbers are entered
        if (list.length != 6) {
            throw new IllegalArgumentException("[ERROR] Please enter exactly 6 numbers, separated by commas.");
        }

        // Parse and validate each number
        for (int i = 0; i < 6; i++) {
            try {
                int number = Integer.parseInt(list[i]);

                // Check if the number is between 1 and 45
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("[ERROR] Each number must be between 1 and 45.");
                }
                if(resultList.contains(number))
                    throw new IllegalArgumentException("[ERROR] Please enter unique numbers.");

                resultList.add(number);  // Add valid number to result list
            } catch (NumberFormatException e) {
                // Handle case when input is not a valid integer
                throw new IllegalArgumentException("[ERROR] Invalid number input. Please enter valid numbers.");
            }
        }

        return resultList;
    }


    public static ArrayList<Integer> getNewTicket() {
        ArrayList<Integer> ticket = new ArrayList<>();
        System.out.print("[");
        while (ticket.size() < 6) {
            int randomInt = (int) ((Math.random() * 45) + 1);
            if (!ticket.contains(randomInt)) {
                ticket.add(randomInt);
                System.out.print(ticket.size() == 6 ? randomInt : randomInt + ", ");
            }
        }
        System.out.print("]");
        return ticket;
    }

    static class Lotto {
        private ArrayList<Integer> numbers;

        public Lotto(ArrayList<Integer> ticket){
            this.numbers = ticket;
        }

        public void compareTicket(ArrayList<Integer> ticket, int bonusNumber){
            int sum = 0;
            for(int number : ticket){
                if(this.numbers.contains(number))
                    sum++;
            }
            if(sum == 5 && this.numbers.contains(bonusNumber))
                sum = 7;
            switch (sum){
                case 6: winners[4]++; totalEarn += (long) 2e9; break;
                case 7: winners[3]++; totalEarn += (long) 3e7; break;
                case 5: winners[2]++; totalEarn += (long) 15e5; break;
                case 4: winners[1]++; totalEarn += (long) 5e4; break;
                case 3: winners[0]++; totalEarn += (long) 5e3; break;
            }
        }

    }
}