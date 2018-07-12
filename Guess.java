import java.util.Random;
import java.util.Scanner;

public class Guess {

    public static void main(String[] args) {

        boolean play = true;
        playGuessingGame();
        while (play == true) {
            if (playAgain() == true) {
                playGuessingGame();
            } else {
                break;
            }
        }
    }





    public static boolean playAgain() {

        while (true) {
            System.out
                    .println("Do you want to play again? Type y / n and hit enter");

            Scanner scan = new Scanner(System.in);
            String playAgain = scan.next();

            if (playAgain.charAt(0) == 'y') {
                return true;
            } else {
                System.out.println("Thanks for playing! Have a Nice Day");
                return false;
            }
        }
    }
    public static void playGuessingGame() {
        System.out.println("How many Players will be playing?");
        int playercount = numPlayers();
        int enteredNumber = 0;
        boolean[] won = new boolean[playercount];
        boolean done = false;
        int randomNumber[] = new int[playercount];
        int numbers[] = new int[(999)];
        Scanner myScanner = new Scanner(System.in);
        boolean numberError = false;
        int rank[] = new int[playercount];
        int rankplace[] = new int[playercount];
        String enteredString = "";
        int j = 0;
        int tries, temp;

        //Sets boolean array to false
        for (int place = 0; place < playercount; place++) {
            won[place] = false;
        }

        //Sets each player a random number
        for (int ran = 0; ran < playercount; ran++) {
            randomNumber[ran] = randNumb(1, 10);
            System.out.println("Target #" + (ran+1) + "= " + randomNumber[ran]);
        }

        for (int i = 0; i < playercount; i++) {
            boolean success = false;
            int player = i;
            int target = randomNumber[i];

            if (won[player] == true) {
                numbers[j] = 0;
                j++;

            } else {

                System.out.print("Player " + (i + 1) + " Please guess a Number between 1-10 ");


                while (numberError == true) ;

                while (success == false) {
                    try {
                        enteredString = myScanner.next();
                        enteredNumber = Integer.parseInt(enteredString.trim());
                        numberError = false;
                    } catch (Exception e) {
                        System.out.println("Your entry: \"" + enteredString + "\" is invalid...Please try again");
                        numberError = true;
                    }

                    if (enteredNumber == target) {
                        System.out.println("Player #" + (player + 1) + ": Correct!");
                        success = true;
                        won[player] = true;

                    } else if (enteredNumber < target) {
                        System.out.println("Player #" + (player + 1) + ": Too low!");
                        numbers[j] = enteredNumber;
                        success = true;

                    } else if (enteredNumber > target) {
                        System.out.println("Player #" + (player + 1) + ": Too high!");
                        numbers[j] = enteredNumber;
                        success = true;

                    }
                }
                //Checks to see if all players have won
                for (int c = 0; c < won.length; c++) {
                    if (won[c] != true) {
                        done = false;
                        break;
                    } else {
                        done = true;
                    }
                }
                if (done == true) {
                    break;
                }
            }

            if (playercount - 1 == i) {
                i = -1;
            }
                j++;

        }
        //Print number of tries/incorrect inputs
        for(int i = 0; i < playercount; i++) {
            tries = 0;
            if(numbers[i] != 0) {
                System.out.print("Player " + (i + 1) + " incorrect guesses: ");
                System.out.print(numbers[i] + " ");
                tries++;
            }else{
                tries--;
                System.out.print("Player " + (i + 1) + " incorrect guesses: NONE");
                tries++;
            }
            for (int k = (i+playercount); k < numbers.length; k += playercount) {
                if(numbers[k] != 0) {
                    System.out.print(numbers[k] + " ");
                    tries++;
                }
                else{
                    break;
                }
            }
            System.out.println();
            System.out.println("Number of tries = " + (tries+1));
            rank[i] = (tries+1);
            rankplace[i] = (tries+1);
        }

        //Sorts the rank array
        for(int smallest = 0; smallest < playercount; smallest++) {
            for (int secondSmallest = (smallest + 1); secondSmallest < playercount; secondSmallest++) {
                if (rank[smallest] > rank[secondSmallest]) {
                    temp = rank[smallest];
                    rank[smallest] = rank[secondSmallest];
                    rank[secondSmallest] = temp;
                }
            }
        }

            //Prints the rank
            for(int v = 0; v < rank.length; v++){
                for(int l = 0; l < rankplace.length; l++){
                    if(rank[v] == rankplace[l]){
                        System.out.println((v+1) + "# -> " + (l+1));
                    }
                    }
                }
            }
    private static int numPlayers() {
        Scanner myinput = new Scanner (System.in);
        return myinput.nextInt();

    }





    private static int randNumb(int min, int max) {
        Random randGen = new Random();
        int target = randGen.nextInt((max - min)+1)+min;
        return target;
    }
}