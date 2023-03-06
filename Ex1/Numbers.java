import java.util.Scanner; // Import the Scanner class

public class Numbers {

  public static void main(String[] args) {
    int num;
    int armstrong_number;
    int firstD, secondD, thirdD, fourthD, fifthD;
    Scanner scan = new Scanner(System.in); // Create a Scanner object
    System.out.println("Please enter a number:");
    num = scan.nextInt();
    if (num >= 100 && num <= 999) {
      firstD = num / 100;
      secondD = (num / 10) % 10;
      thirdD = num % 10;
      armstrong_number = (firstD * firstD * firstD) + (secondD * secondD * secondD) + (thirdD * thirdD * thirdD);
      // checking if the number is an Armstrong 
      if (num == armstrong_number) {
        System.out.println("The number " + num + " is an Armstrong number.");
      } else {
        System.out.println("The number " + num + " is not an Armstrong number.");
      }
    }
    // checking if the number is a Palindrome 
    else if (num >= 1000 && num <= 99999) {
      //if 4 digit number 
      if (num <= 9999) {
        firstD = num / 1000;
        secondD = (num / 100) % 10;
        thirdD = (num / 10) % 10;
        fourthD = num % 10;
        if ((firstD == fourthD) && (secondD == thirdD)) {
          System.out.println("The number " + num + " is a Palindrome number.");
        } else {
          System.out.println("The number " + num + " is not a Palindrome.");
        }
      } else {
        // if 5 digit number
        firstD = num / 10000;
        secondD = (num / 1000) % 10;
        thirdD = (num / 100) % 10;
        fourthD = (num / 10) % 10;
        fifthD = (num % 10);
        if ((firstD == fifthD) && (secondD == fourthD)) {
          System.out.println("The number " + num + " is a Palindrome number.");
        } else {
          System.out.println("The number " + num + " is not a Palindrome.");
        }
      }
    } else {
      System.out.println("invalid input!");
    }
  }
}