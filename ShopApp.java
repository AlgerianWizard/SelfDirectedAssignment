/* Islam Bourzah 
 * Student Number: 2209133
 * Self Directed Assignment */
import java.util.Scanner;
import java.util.ArrayList;

public class ShopApp 
{
    public static void main(String[]args) //
    {
        System.out.println("Student Number: 2209133");
        System.out.println("Welcome to the shop app!");

        //Array declared and initialized with 5 objects ranging from index 0-4
        /*
        Product[] itemArray = new Product[5];
        itemArray[0] = new Product("Milk", 10, 1.60); 
        itemArray[1] = new Product("Water", 10, 0.10);
        itemArray[2] = new Product("Soda", 10, 2.00);
        itemArray[3] = new Product("Juice", 10, 1.00);
        itemArray[4] = new Product("Energy drink", 10, 1.50);
         */

        //Default items that already come with the application - can be changed ofc.
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product("Milk", 10, 1.60));
        list.add(new Product("Water",10,0.10));
        list.add(new Product("Soda", 10, 2.00));
        list.add(new Product("Juice", 10, 1.00));
        list.add(new Product("Energy drink", 10, 1.50));
        UI(list);


        
        String anotherTask = "Do you want to perform another task?(Y/N)";

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
            UI(list);
            System.out.println(anotherTask);
            answer = sc.next().charAt(0);
        }
    }


    public static <Arraylist> void UI(ArrayList<Product> list) //Returns selection from first menu //
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu:\n1)Product List\n2)Buy Stock \n3)Sell Stock\n4)Set Prices\n5)Total Stock Value\n6)Add Product");
        int choice = sc.nextInt();

        while(choice < 1 || choice > 6)
        {
            System.out.println("Invalid input, enter number in range 1 - 5"); 
            choice = sc.nextInt();
        }


        switch(choice) //Menu with switch also passes arrays to all the functions
        {
            case 1: productList(list);
            break;  
            case 2: buyStock(list);
            break;
            case 3: sellStock(list);
            break;
            case 4: setPrice(list);
            break;
            case 5: TotalValue(list);
            break;
            case 6: AddProduct(list);
            break;
            default:System.out.println("null");
        }
    }

    public static void productList(ArrayList<Product> list)
    {
        System.out.println("Product List + (Stock Level):");

        int listindex = 1;
        for (int i = 0; i <list.size(); i++)
        {
            System.out.println(listindex + "- "+ list.get(i).getName() + " ; " + list.get(i).getStockLevel());
            listindex++;
        }
    }
    
    public static void buyStock(ArrayList<Product> list)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Which stock would you like to buy?\n1)" + list.get(0).getName() + "\n2)" + list.get(1).getName() + "\n3)" + list.get(2).getName() + "\n4)" + list.get(3).getName() + "\n5)" + list.get(4).getName());
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
        
        System.out.println(list.get(choice-1).getName());
        list.get(choice-1).buyStock(stockAmount);
        System.out.println("Stock bought: " + stockAmount);
        System.out.println("Current stock level: " + list.get(choice-1).getStockLevel());
    }
    
    public static void sellStock(ArrayList<Product> list)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Which stock would you like to sell\n1)" + list.get(0).getName() + "\n2)" + list.get(1).getName() + "\n3)" + list.get(2).getName() + "\n4)" + list.get(3).getName() + "\n5)" + list.get(4).getName());
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
        
        System.out.println(list.get(choice-1).getName());
        if (list.get(choice-1).sell(stockAmount)) //If statements without == always default to true so there's no point writing == true
        {
            System.out.println("Stock sold: " + stockAmount);
            System.out.println("Current stock level: " + list.get(choice-1).getStockLevel());
        }
        else
        {
            System.out.println("Sorry, the amount of stock you have entered is more than you have.\nCurrent stock level: " + list.get(choice-1).getStockLevel());
        }
    }

    public static void setPrice(ArrayList<Product> list)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Which product's price would you like to change?\n1)" + list.get(0).getName() + "\n2)" + list.get(1).getName() + "\n3)" + list.get(2).getName() + "\n4)" + list.get(3).getName() + "\n5)" + list.get(4).getName());
        int choice = sc.nextInt();

        while(choice < 1 || choice > 5)
        {
            System.out.println("Please enter number in range 1-5");
            choice = sc.nextInt();
        }

        System.out.println(choice + "- " + list.get(choice-1).getName());
        System.out.println("Please enter a new price: ");
        
        double newPrice = sc.nextDouble();

        while(newPrice < 0.01) //Input validation while loop
        {
            System.out.println("Please enter a positive number for the new price!");
            newPrice = sc.nextDouble();
        }

        System.out.println(list.get(choice-1).getName());
        System.out.println("Old price: " + list.get(choice-1).getPrice());
        list.get(choice-1).setPrice(newPrice);
        System.out.println("New price: " + list.get(choice-1).getPrice());
    }

    public static void TotalValue(ArrayList<Product> list)
    {
        double totalvalue = 0;

        for(int i = 0; i < list.size(); i++)
        {
             double currentvalue = list.get(i).getPrice() * list.get(i).getStockLevel();
             totalvalue = totalvalue + currentvalue;
        }
        
        System.out.format("The total value of stock is: %.2f ", totalvalue); // Prints the double but in format of .00 - as normal currency would be.
    }

    public static void AddProduct(ArrayList<Product> list)
    {
        System.out.println("What is the name of the product you would like to add?");
        Scanner sc = new Scanner(System.in);
        String inputName = sc.nextLine();
        System.out.println("Enter price for new product:");
        double inputPrice = sc.nextDouble();
        list.add(new Product(inputName,0, inputPrice));
    }
}