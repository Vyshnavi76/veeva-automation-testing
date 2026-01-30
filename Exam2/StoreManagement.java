import java.util.*;
public class StoreManagement {
static HashMap<String,HashMap<String,Integer>> stores=new HashMap<>();
public static void main(String[] args) 
{
Scanner sc=new Scanner(System.in);
int choice;
do 
{
System.out.println("Main menu");
System.out.println("1.Add Store");
System.out.println("2.Display All Store Details");
System.out.println("3.Queries");
System.out.println("4.Exit");
System.out.print("Enter your choice:");
choice=sc.nextInt();
sc.nextLine();
switch (choice)
{
case 1:addStore(sc);
       break;
case 2:displayAllStores();
       break;
case 3:queryMenu(sc);
       break;
case 4:
System.out.println("Exiting Program...");
       break;
default:
 System.out.println("Invalid choice!");
 }
 } while (choice != 4);
  sc.close();
    }
public static void addStore(Scanner sc)
{
System.out.print("Enter Store ID:");
String storeId = sc.nextLine();
HashMap<String,Integer> products=new HashMap<>();
System.out.print("Enter number of products:");
int n = sc.nextInt();
sc.nextLine();
for(int i=1;i<=n;i++)
 {
System.out.print("Enter product name: ");
String productName = sc.nextLine();
System.out.print("Enter price: ");
int price = sc.nextInt();
sc.nextLine();
products.put(productName, price);
}
stores.put(storeId, products);
System.out.println("Store added successfully!");
}
public static void displayAllStores() {
if(stores.isEmpty())
{
System.out.println("No store data available!");
 return;
 }
for(String storeId:stores.keySet())
{
System.out.println("Store ID:"+storeId);
 HashMap<String,Integer> products=stores.get(storeId);
 for(Map.Entry<String,Integer> entry:products.entrySet())
{
System.out.println("Product:"+entry.getKey()+"|Price:"+entry.getValue());
            }
        }
    }
public static void queryMenu(Scanner sc)
{
int subChoice;
do {
System.out.println("Sub Menu");
System.out.println("1.Display products of a Store");
System.out.println("2.Highest priced product in a Store");
System.out.println("3.Stores containing a Product");
System.out.println("4.Back to Main Menu");
System.out.print("Enter your choice: ");
subChoice = sc.nextInt();
sc.nextLine();
switch (subChoice)
 {
case 1:System.out.print("Enter Store ID: ");
String storeId1 = sc.nextLine();
displayStoreProducts(storeId1);
break;
case 2:System.out.print("Enter Store ID: ");
String storeId2 = sc.nextLine();
highestPricedProduct(storeId2);
break;
case 3:System.out.print("Enter Product Name: ");
String productName = sc.nextLine();
storesContainingProduct(productName);
break;
case 4:
break;
default:System.out.println("Invalid choice!");
}
} while (subChoice!=4);
}
public static void displayStoreProducts(String storeId) {
if (!stores.containsKey(storeId)) {
System.out.println("Store not found!");
return;
}
HashMap<String,Integer> products=stores.get(storeId);
System.out.println("Products in Store "+storeId + ":");
 for(Map.Entry<String,Integer> entry:products.entrySet())
{
   System.out.println(entry.getKey()+":"+entry.getValue());
}
}
public static void highestPricedProduct(String storeId) {
if (!stores.containsKey(storeId)) {
System.out.println("Store not found!");
return;
}
HashMap<String,Integer> products=stores.get(storeId);
String maxProduct=null;
int maxPrice=Integer.MIN_VALUE;
for (Map.Entry<String,Integer> entry:products.entrySet()){
if (entry.getValue()>maxPrice) {
maxPrice = entry.getValue();
maxProduct = entry.getKey();
}
}
System.out.println("Highest Priced Product:"+maxProduct+":"+maxPrice);
}
public static void storesContainingProduct(String productName)
{
boolean found=false;
for(String storeId:stores.keySet())
{
HashMap<String,Integer> products=stores.get(storeId);
if (products.containsKey(productName))
{
System.out.println("Product found in Store: " + storeId);
found = true;
}
}
if (!found) {
System.out.println("Product not found in any store!");
}
}
}
