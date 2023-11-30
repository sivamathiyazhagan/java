package j12;
import java.util.Scanner;
class InvalidUnitsException extends Exception {
 public InvalidUnitsException(String message) {
     super(message);
 }
}
public class ElectricityBoard {
 public static double calculateCharges(int units) throws InvalidUnitsException {
     if (units < 0) {
         throw new InvalidUnitsException("Invalid units. Units cannot be negative.");
     }
     double charges = 0;
     if (units <= 100) {
         charges = units * 0.40;
     }
     else if (units <= 300) {
         charges = 100 * 0.40 + (units - 100) * 0.50;
     }
     else {
         charges = 100 * 0.40 + 200 * 0.50 + (units - 300) * 0.60;
     }
     if (charges < 50) {
         charges = 50;
     }
     if (charges > 250) {
         charges += charges * 0.15;
     }
     return charges;
 }
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     try {
         System.out.print("Enter the number of units consumed: ");
         int units = scanner.nextInt();
         double totalCharges = calculateCharges(units);
         System.out.println("Total Charges: Rs. " + totalCharges);
     } catch (InvalidUnitsException e) {
         System.out.println("Error: " + e.getMessage());
     } catch (Exception e) {
         System.out.println("Error: Invalid input. Please enter a valid number of units.");
     } 
 }
}
