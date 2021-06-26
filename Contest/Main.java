import java.util.Scanner;

interface Dealer{
	 String dealer_Name;
	 String address;
	public int getConcession();
	
}

class TwoWheeler implements Dealer{
	public String model_Name;
	public String model_No;
	 int price;
	 int add_Ons;
	public TwoWheeler(String mod, String modnum, int p, int add)
    {
        model_Name = mod;
        model_No = modnum;
        price = p;
        add_Ons = add;
    }
	public int getConcession() {
		 
		//5% (5/100) of basic showroom price
		 int concession= price/20;
		 return concession;
	 }
	
	public void Printestimate() {
		int total_Price=price+add_Ons;
		System.out.println(total_Price);
		
	}
	
	
}

class FourWheeler implements Dealer{
	public String model_Name;
	public String model_No;
	 int price;
	 int add_Ons;
	public String Fuel_Type; 
	public FourWheeler(String mod, String modnum, int p, int add, String fuel)
    {
        model_Name = mod;
        model_No = modnum;
        price = p;
        add_Ons = add;
        Fuel_Type = fuel;
    }
	
	public int getConcession() {
		 
		//10% (10/100) of basic showroom price
		 int concession= price/10;
		 return concession;
	 }
	
	public void Printestimate() {
		int total_Price=price+add_Ons;
		System.out.println(total_Price);
		
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String modname = sc.nextLine();
        String model_No = sc.nextLine();
        int price = sc.nextInt();
        int addon = sc.nextInt();
        String f = sc.nextLine();

        FourWheeler car4 = new FourWheeler(modname, model_No, price, addon, f);
        TwoWheeler car2 = new TwoWheeler(modname, model_No, price, addon);
    }
	
}