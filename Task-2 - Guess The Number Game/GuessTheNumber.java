class GuessTheNumber {

    public static void main(String[] args) {

            
            System.out.println("***Welcome to the Game!***");
            System.out.println("System will select a random number between 1 and 100");
            System.out.println("You have to guess the number within 7 trials");
            int number = (int) (Math.random() * 100);
            int guess = 0;
            int trials = 0;
            while (guess != number) {
                trials++;
                if (trials > 7) {
                    System.out.println("You have exceeded the number of trials");
                    System.out.println("The number was " + number);
                    break;
                }
                System.out.print("Enter your guess :");
                guess = new java.util.Scanner(System.in).nextInt();
                if (guess > number) {
                    System.out.println("Your guess is greater than the number");
                } else if (guess < number) {
                    System.out.println("Your guess is lower than the number");
                } else {
                    System.out.println("You guessed the number in " + trials + " trials");
                }
            }

    }

}