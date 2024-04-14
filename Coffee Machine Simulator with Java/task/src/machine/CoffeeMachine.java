package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int disposableCups = 9;
    private static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWrite action (buy, fill, take):");
            String action = scanner.nextLine();

            switch (action) {
                case "buy":
                    buySomeCoffee(scanner);
                    break;
                case "fill":
                    fillSupplies(scanner);
                    break;
                case "take":
                    takeMoney(scanner);
                    break;
                case "remaining":
                    statusPrint();
                    break;
                case "exit":
                    return;
                case "back":
                    break;
                default:
                    System.out.println("Invalid action.");
                    break;
            }

        }

    }

    public static void statusPrint() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static void buySomeCoffee(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String coffeeChoice = scanner.nextLine();
        if (coffeeChoice.equals("back")) {
            return;
        }

        int choice;
        try {
            choice = Integer.parseInt(coffeeChoice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice.");
            return;
        }

        switch (choice) {
            case 1:
                toMakeCoffee(250, 0, 16, 1, 4);
                break;
            case 2:
                toMakeCoffee(350, 75, 20, 1, 7);
                break;
            case 3:
                toMakeCoffee(200, 100, 12, 1, 6);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static void toMakeCoffee(int needWater, int needMilk, int needBeans, int cups, int cost) {
        if (water >= needWater && milk >= needMilk && beans >= needBeans && cost >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= needWater;
            milk -= needMilk;
            beans -= needBeans;
            disposableCups -= cups;
            money += cost;
        }
        if (water < needWater) {
            System.out.println("Sorry, not enough water!");
        }
        if (milk < needMilk) {
            System.out.println("Sorry, not enough milk!");
        }
        if (beans < needBeans) {
            System.out.println("Sorry, not enough beans!");
        }
    }

    public static void fillSupplies(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add: ");
        water += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk you want to add: ");
        milk += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beans += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups you want to add:");
        disposableCups += Integer.parseInt(scanner.nextLine());
    }

    public static void takeMoney(Scanner scanner) {
        System.out.println("I gave you $" + money);
        money = 0;
    }
}

