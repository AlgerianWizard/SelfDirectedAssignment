public class Product 
{
    private String name;
    private int stockLevel;
    private double price;
    

    public Product(String namein, int stockLevelin, double pricein)
    {
        name = namein;
        stockLevel = stockLevelin;
        price = pricein;
    }

    public int buyStock(int stockLevelin)
    {
        return stockLevel = stockLevel + stockLevelin;
    }

    public boolean sell(int sellin)
    {
        //Minus the amount of stock sold, return boolean based on
        //the whether there is enough stock to sell

        if (stockLevel < sellin)
        {
            return false;
        }
        else
        {
            stockLevel = stockLevel - sellin;
            return true;
        }
    }

    public void setPrice(int setPricein)
    {
        price = setPricein;
    }

    //Return product's name
    public String getName()
    {
        return name; 
    }

    //Return amount of stock
    public int getStockLevel()
    {
        return stockLevel;
    }

    //Return product's price
    public double getPrice()
    {
        
        return price;
    }

}
