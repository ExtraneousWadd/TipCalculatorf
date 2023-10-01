import java.util.Scanner;
import java.util.*;
import java.util.function.Supplier;
public class tipCalculator {
    public static void main(String []args){


        Scanner scan = new Scanner(System.in);
        List<String> list = new ArrayList<String>();


        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people do you have in your group?: ");
        int people = scan.nextInt();
        System.out.print("What is your tip percent? (0-100): ");
        int tipPercent = scan.nextInt();
        scan.nextLine();


        double total = 1;
        double foodPrice = 0;
        while (foodPrice != -1) {
            System.out.print("Enter a cost in dollars and cents, e.g, 12.50 (-1 to end): ");
            foodPrice = scan.nextDouble();
            scan.nextLine();
            total += foodPrice;
            if (foodPrice != -1) {
                System.out.print("Enter the item name: ");
                String foodName = scan.nextLine();
                list.add(foodName);
            }
        }


        double tipAmount = total * (tipPercent * 0.01) * 100;
        double tipAmountRound = Math.round(tipAmount);
        double tipAmountFinal = tipAmountRound / 100;
        double totalFinal = tipAmountFinal + total;
        double perCost = total * 100 / people;
        double perCostRound = Math.round(perCost);
        double perCostFinal = perCostRound / 100;
        double tipPer = (tipAmountFinal / people) * 100;
        double tipPerRound = Math.round(tipPer);
        double tipPerFinal = tipPerRound / 100;
        double totalPer = totalFinal * 100 / people;
        double totalPerRound = Math.round(totalPer);
        double totalPerFinal = totalPerRound / 100;


        System.out.println("-------------------------");
        System.out.println("Total bill before tip: $" + total);
        System.out.println("Tip percentage: " + tipPercent + "%");
        System.out.println("Total Tip: $" + tipAmountFinal);
        System.out.println("Total bill with tip: $" + totalFinal);
        System.out.println("Per person cost before tip: $" + perCostFinal);
        System.out.println("Tip per person: $" + tipPerFinal);
        System.out.println("Total cost per person: $" + totalPerFinal);
        System.out.println("-------------------------");
        System.out.println("Items Ordered:");
        System.out.println("Food list: " + list.toString());


        int tipPerFinalCharity = (int) (tipPerFinal + 1);
        System.out.println("Would you like to round each of your tips for charity? (yes/no)");
        String answer = scan.nextLine();
        if (answer.equals("yes")){
            System.out.println("Then, the tip per person is : $" + tipPerFinalCharity + " and you donated $" + tipPerFinalCharity * people);
        } else {
            System.out.println("Thanks for coming!");
        }
    }
}