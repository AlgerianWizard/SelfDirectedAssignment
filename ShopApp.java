/* Islam Bourzah 
 * Student Number: 2209133
 * Self Directed Assignment */


import java.util.Scanner;
public class ShopApp 
{
    public static void main(String[]args)
    {
        System.out.println("Student Number: 2209133");
        System.out.println("Welcome to the shop app!");

        //Array declared and initialized with 5 objects ranging from index 0-4         
        Product[] itemArray = new Product[5];
        itemArray[0] = new Product("Milk", 10, 1.10); 
        itemArray[1] = new Product("Water", 5, 1.20);
        itemArray[2] = new Product("Soda", 10, 1.05);
        itemArray[3] = new Product("Juice", 5, 1.20);
        itemArray[4] = new Product("Energy drink", 5, 1.50);
        UI(itemArray);
        
        String anotherTask = "Do you want to peform another task?(Y/N)";

        Scanner sc = new Scanner(System.in);
        System.out.println(anotherTask);
        char answer = sc.next().charAt(0);
        

        while (answer != 'Y' && answer != 'N')
        {
            System.out.println("Please enter a single character 'Y' or 'N'.");
            answer = sc.next().charAt(0);
        }
        
        while(answer == 'Y' || answer == 'y')
        {
            UI(itemArray);
            System.out.println(anotherTask);
            answer = sc.next().charAt(0);
        }
    }


    public static void UI(Product[] itemArray) //Returns selection from first menu 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu:\n1)Product List\n2)Buy Stock \n3)Sell Stock\n4)Set Prices\n5)Total Stock Value");
        int choice = sc.nextInt();
        
        int selection = 0;
        switch(choice)
        {
            case 1: selection = 1;  
            break;
            case 2: selection = 2;
            break;
            case 3: selection = 3;
            break;
            case 4: selection = 4;
            break;
            case 5: selection = 5;
            break;
            default: System.out.println("Invalid input, enter number in range 1 - 5"); choice = sc.nextInt(); //Switches have built in input validation 
        }

        switch(selection) //Menu with switch also passes arrays to all the functions
        {
            case 1: productList(itemArray); 
            break;  
            case 2: buyStock(itemArray);
            break;
            case 3: sellStock(itemArray);
            break;
            case 4: setPrice(itemArray);
            break;
            case 5: TotalValue(itemArray);
            break;
            default:System.out.println("null");
        }
    }

    public static void productList(Product[] itemArrayin)
    {
        System.out.println("Product List:");  
        int listindex = 1;        
        for (int i = 0; i < itemArrayin.length; i++)
        {
            System.out.println(listindex + "- " + itemArrayin[i].getName());
            listindex++;
        }

    }
    
    public static void buyStock(Product[] itemArrayin)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Which stock would you like to buy?\n1)" + itemArrayin[0].getName() + "\n2)" + itemArrayin[1].getName() + "\n3)" + itemArrayin[2].getName() + "\n4)" + itemArrayin[3].getName() + "\n5)" + itemArrayin[4].getName());
        int choice = sc.nextInt();
        
        while(choice < 1 || choice > 5)
        {
            System.out.println("Invalid input, please enter a number in range 1-5");
            choice = sc.nextInt();
        }
        
        System.out.println("How much stock would you like to buy?");
        int stockAmount = sc.nextInt();

        while(stockAmount < 0)
        {
            System.out.println("Invalid input, please enter positive amount");
            stockAmount = sc.nextInt();
        }
        
        System.out.println(itemArrayin[choice-1].getName());
        itemArrayin[choice-1].buyStock(stockAmount);
        System.out.println("Stock bought: " + stockAmount);
        System.out.println("Current stock level: " + itemArrayin[choice-1].getStockLevel());
    }
    
    public static void sellStock(Product[] itemArrayin)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Which stock would you like to sell\n1)" + itemArrayin[0].getName() + "\n2)" + itemArrayin[1].getName() + "\n3)" + itemArrayin[2].getName() + "\n4)" + itemArrayin[3].getName() + "\n5)" + itemArrayin[4].getName());
        int choice = sc.nextInt();
        
        while(choice < 1 || choice > 5)
        {
            System.out.println("Invalid input, please enter a number in range 1-5");
            choice = sc.nextInt();
        }

        System.out.println("How much stock would you like to sell?");
        int stockAmount = sc.nextInt();

        while(stockAmount < 0)
        {
            System.out.println("Invalid input, please enter positive amount");
            stockAmount = sc.nextInt();
        }
        
        switch(choice)
        {
            case 1: System.out.println(itemArrayin[0].getName()); itemArrayin[0].sell(stockAmount); System.out.println("Stock sold: " + stockAmount);  System.out.println("New Stock Level: " + itemArrayin[0].getStockLevel());
            break;
            case 2: System.out.println(itemArrayin[1].getName()); itemArrayin[1].sell(stockAmount); System.out.println("Stock sold: " + stockAmount);  System.out.println("New Stock Level: " + itemArrayin[1].getStockLevel());
            break;
            case 3: System.out.println(itemArrayin[2].getName()); itemArrayin[2].sell(stockAmount); System.out.println("Stock sold: " + stockAmount);  System.out.println("New Stock Level: " + itemArrayin[2].getStockLevel());
            break;
            case 4: System.out.println(itemArrayin[3].getName()); itemArrayin[3].sell(stockAmount); System.out.println("Stock sold: " + stockAmount);  System.out.println("New Stock Level: " + itemArrayin[3].getStockLevel());
            break;
            case 5: System.out.println(itemArrayin[4].getName()); itemArrayin[4].sell(stockAmount); System.out.println("Stock sold: " + stockAmount);  System.out.println("New Stock Level: " + itemArrayin[4].getStockLevel());
            break;
            default: System.out.println("Invalid input, please enter a number in range 1-5.");
        }

    }

    public static void setPrice(Product[] itemArrayin)
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("Which product's price would you like to change?\n1)" + itemArrayin[0].getName() + "\n2)" + itemArrayin[1].getName() + "\n3)" + itemArrayin[2].getName() + "\n4)" + itemArrayin[3].getName() + "\n5)" + itemArrayin[4].getName());
        int choice = sc.nextInt();

        System.out.println("Please enter a new price: ");
        double newPrice = sc.nextDouble();

        while(newPrice < 0.01) //Input validation while loop
        {
            System.out.println("Please enter a positive number for the new price!");
            newPrice = sc.nextDouble();
        }

        switch(choice)
        {
            case 1: System.out.println(itemArrayin[0].getName()); itemArrayin[0].setPrice(newPrice); System.out.println("New Price: " + itemArrayin[0].getPrice());
            break;
            case 2: System.out.println(itemArrayin[1].getName()); itemArrayin[1].setPrice(newPrice); System.out.println("New Price: " + itemArrayin[1].getPrice());
            break;
            case 3: System.out.println(itemArrayin[2].getName()); itemArrayin[2].setPrice(newPrice); System.out.println("New Price: " + itemArrayin[2].getPrice());
            break;
            case 4: System.out.println(itemArrayin[3].getName()); itemArrayin[3].setPrice(newPrice); System.out.println("New Price: " + itemArrayin[3].getPrice());
            break;
            case 5: System.out.println(itemArrayin[4].getName()); itemArrayin[4].setPrice(newPrice); System.out.println("New Price: " + itemArrayin[4].getPrice());
            break;
            default: System.out.println("Invalid input, please enter a number in range 1-5."); //Input validation built into the switch
        }

    }

    public static void TotalValue(Product[] itemArrayin)
    {
        double totalvalue = 0;

        for(int i = 0; i < itemArrayin.length; i++)
        {
             double currentvalue = itemArrayin[i].getPrice() * itemArrayin[i].getStockLevel();
             totalvalue = totalvalue + currentvalue;
        }
        
        System.out.println("The total value of stock is: " + totalvalue);

    }

    /*public static void backMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you wish to perform another task?(Y/N)");
        
        char selection = sc.next().charAt(0);

        if(selection == 'Y')
        {
            UI();
        }
        
        else
        ()
        /*switch(selection)
        {
            case 'Y': UI();
            break;
            case 'N': System.out.println("End of Program.");
            break;
            default: System.out.println("Please enter 'Y' or 'N'."); selection = sc.next().charAt(0);
        }
    }*/
}




