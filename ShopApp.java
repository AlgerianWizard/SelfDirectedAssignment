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
        itemArray[0] = new Product("Milk", 10, 1.60); 
        itemArray[1] = new Product("Water", 10, 0.10);
        itemArray[2] = new Product("Soda", 10, 2.00);
        itemArray[3] = new Product("Juice", 10, 1.00);
        itemArray[4] = new Product("Energy drink", 10, 1.50);
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
        
        while(answer == 'Y')
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

        while(choice < 1 || choice > 5)
        {
            System.out.println("Invalid input, enter number in range 1 - 5"); 
            choice = sc.nextInt();
        }


        switch(choice) //Menu with switch also passes arrays to all the functions
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
        System.out.println("Product List + (Stock Level):");  
        int listindex = 1;
        for (int i = 0; i < itemArrayin.length; i++)
        {
            System.out.println(listindex + "- " + itemArrayin[i].getName() + " ; " + itemArrayin[i].getStockLevel());
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
        
        System.out.println(itemArrayin[choice-1].getName());
        if (itemArrayin[choice-1].sell(stockAmount) == true)
        {
            System.out.println("Stock sold: " + stockAmount);
            System.out.println("Current stock level: " + itemArrayin[choice-1].getStockLevel());
        }
        else
        {
            System.out.println("Sorry, the amount of stock you have entered is more than you have.\nCurrent stock level: " + itemArrayin[choice-1].getStockLevel());
        }
    }

    public static void setPrice(Product[] itemArrayin)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Which product's price would you like to change?\n1)" + itemArrayin[0].getName() + "\n2)" + itemArrayin[1].getName() + "\n3)" + itemArrayin[2].getName() + "\n4)" + itemArrayin[3].getName() + "\n5)" + itemArrayin[4].getName());
        int choice = sc.nextInt();

        while(choice < 1 || choice > 5)
        {
            System.out.println("Please enter number in range 1-5");
            choice = sc.nextInt();
        }

        System.out.println(choice + "- " + itemArrayin[choice-1].getName());
        System.out.println("Please enter a new price: ");
        
        double newPrice = sc.nextDouble();

        while(newPrice < 0.01) //Input validation while loop
        {
            System.out.println("Please enter a positive number for the new price!");
            newPrice = sc.nextDouble();
        }

        System.out.println(itemArrayin[choice-1].getName());
        System.out.println("Old price: " + itemArrayin[choice-1].getPrice());
        itemArrayin[choice-1].setPrice(newPrice);
        System.out.println("New price: " + itemArrayin[choice-1].getPrice());
    }

    public static void TotalValue(Product[] itemArrayin)
    {
        double totalvalue = 0;

        for(int i = 0; i < itemArrayin.length; i++)
        {
             double currentvalue = itemArrayin[i].getPrice() * itemArrayin[i].getStockLevel();
             totalvalue = totalvalue + currentvalue;
        }
        
        System.out.format("The total value of stock is: %.2f ", totalvalue); // Prints the double but in format of .00 - as normal currency would be.
    }

    public static void AddProduct(Product[] itemArrayin)
    {
        // Take in the Array
        // Ask the user to how many new products they would like to enter, this would set the loop counter to the number
        // of times they want to add products.
        // I need to check if its possible to add items to my array before I continue but its fine for now, this is hypothetical
        // So it seems that I declared the objects and initliazed them, I need to check if I can change the size.
        // So i can't resize an array that i've already declared and initliazed, I need to do that at

        //Maybe instead of adding we can make 99 products, however only define the number we need, and set the rest as
        //0? So when we find totalvalue we don't run into any issues.. That would be a nice idea.
    }
}




.