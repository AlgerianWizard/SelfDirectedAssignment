import java.util.Scanner;
public class ShopApp 

{

    public static void main(String[]args)
    {
        //Array declared and initialized with 5 objects ranging from index 0-4         
        Product[] itemArray = new Product[5];
        itemArray[0] = new Product("Milk", 100, 1.10);
        itemArray[1] = new Product("Water", 50, 0.50);
        itemArray[2] = new Product("Soda", 20, 2.0);
        itemArray[3] = new Product("Juice", 40, 1.40);
        itemArray[4] = new Product("Energy drink", 45, 0.90);
        

        itemArray[0].getName();
        
        System.out.println("Welcome to the shop app!");
        

        int selection = UI(); //Calls UI method and assigns an integer to selection
        
        switch(selection)
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
            default:System.out.println("null");
        }
    }


    public static int UI()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu:\n1)Product List\n2)Buy Stock \n3)Sell Stock\n4)Set Prices\n5)Total Stock Value");
        int choice = sc.nextInt();
        while (choice < 1 || choice > 4)
        {
            System.out.println("Invalid input, enter number in range 1 - 4");
            choice = sc.nextInt(); 
        }
        
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
            default: System.out.println("null");
        }

        return selection;
    }

    public static void productList(Product[] itemArrayin)
    {
        System.out.println("Product List:");  
        
        for (int i = 0; i < itemArrayin.length; i++)
        {
            System.out.println(itemArrayin[i].getName());
        }
    }
    
    public static void buyStock(Product[] itemArrayin)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much stock would you like to buy?");
        int stockAmount = sc.nextInt();

        while(stockAmount < 0)
        {
            System.out.println("Invalid input, please enter positive amount");
            stockAmount = sc.nextInt();
        }
        
        System.out.println("Which stock would you like to buy?\n1)" + itemArrayin[0].getName() + "\n2)" + itemArrayin[1].getName() + "\n3)" + itemArrayin[2].getName() + "\n4)" + itemArrayin[3].getName() + "\n5)" + itemArrayin[4].getName());
        int choice = sc.nextInt();
        
        while(choice < 1 || choice > 5)
        {
            System.out.println("Invalid input, please enter a number in range 1-5");
            choice = sc.nextInt();
        }

        String sB = "Stock bought: ";
        String cSL = "Current stock level: ";
        
        switch(choice)
        {
            case 1: System.out.println(itemArrayin[0].getName()); itemArrayin[0].buyStock(stockAmount); System.out.println(sB  + stockAmount); System.out.println(cSL + itemArrayin[0].getStockLevel());
            break;
            case 2: System.out.println(itemArrayin[1].getName()); itemArrayin[0].buyStock(stockAmount); System.out.println(sB + stockAmount); System.out.println(cSL + itemArrayin[0].getStockLevel());
            break;
            case 3: System.out.println(itemArrayin[2].getName()); itemArrayin[0].buyStock(stockAmount); System.out.println(sB + stockAmount); System.out.println(cSL + itemArrayin[0].getStockLevel());
            break;
            case 4: System.out.println(itemArrayin[3].getName()); itemArrayin[0].buyStock(stockAmount); System.out.println(sB + stockAmount); System.out.println(cSL + itemArrayin[0].getStockLevel());
            break;
            case 5: System.out.println(itemArrayin[4].getName()); itemArrayin[0].buyStock(stockAmount); System.out.println(sB + stockAmount); System.out.println(cSL + itemArrayin[0].getStockLevel());
            break;
            default: System.out.println("This should never print!");

            // IDEA: MAYBE ADD BACK BUTTONS OR MAYBE LOOP CUZ THEY WANNA BUY MORE STOCK?
        }
    }
    
    public static void sellStock(Product[] itemArrayin)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much stock have you sold?");
        int stockAmount = sc.nextInt();

        while(stockAmount < 0)
        {
            System.out.println("Invalid input, please enter positive amount");
            stockAmount = sc.nextInt();
        }
        
        System.out.println("Which stock have you sold?\n1)" + itemArrayin[0].getName() + "\n2)" + item2.getName() + "\n3)" + item3.getName() + "\n4)" + item4.getName() + "\n5)" + item5.getName());
        int choice = sc.nextInt();
        
        while(choice < 1 || choice > 5)
        {
            System.out.println("Invalid input, please enter a number in range 1-5");
            choice = sc.nextInt();
        }

        switch(choice)
        {
            case 1: System.out.println(itemArrayin[0].getName()); itemArrayin[0].sell(stockAmount); System.out.println("Stock sold: " + stockAmount);  System.out.println("New Stock Level: " + itemArrayin[0].getStockLevel());
            break;
            case 2: System.out.println(itemArrayin[1].getName()); itemArrayin[1].sell(stockAmount); System.out.println("Stock sold: " + stockAmount);  System.out.println("New Stock Level: " + itemArrayin[1].getStockLevel());
            break;
            case 3: System.out.println(item3.getName()); item3.sell(stockAmount); System.out.println("Stock sold: " + stockAmount);  System.out.println("New Stock Level: " + item1.getStockLevel());
            break;
            case 4: System.out.println(item4.getName()); item4.sell(stockAmount); System.out.println("Stock sold: " + stockAmount);  System.out.println("New Stock Level: " + item1.getStockLevel());
            break;
            case 5: System.out.println(item5.getName()); item5.sell(stockAmount); System.out.println("Stock sold: " + stockAmount);  System.out.println("New Stock Level: " + item1.getStockLevel());
            break;
            default: System.out.println("This should never print!");
        }
    }

    public static void setPrice(Product[] itemArrayin)
    {
        //set PRICE METHOD
    }

    public static void TotalValue(Product[] itemArrayin)
    {
        
    }
}


