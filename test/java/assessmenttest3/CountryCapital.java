package assessmenttest3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountryCapital {
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, HashMap<String, String>> countryData = new HashMap<>();
	   public static void main(String[] args) {
	System.out.println("Enter number of countries:");
    int n = sc.nextInt();
 sc.nextLine(); 

    for (int i = 0; i < n; i++) {

        System.out.println("Enter country name:");
        String country = sc.nextLine();

        System.out.println("Enter number of capitals (1-3):");
        int capCount = sc.nextInt();
        sc.nextLine();

        HashMap<String, String> capitals = new HashMap<>();

        for (int j = 0; j < capCount; j++) {

            System.out.println("Enter season (Winter/Summer/Rainy):");
            String season = sc.nextLine();
            System.out.println("Enter capital:");
            String capital = sc.nextLine();

            capitals.put(season, capital);
        }

        countryData.put(country, capitals);
    }

    menu();
}

public static void menu() {
	 while (true) {
         System.out.println("\n----- MENU -----");
         System.out.println("1.Print all countries");
         System.out.println("2.Get capitals of a country");
         System.out.println("3.Countries with 2 capitals");
         System.out.println("4.Countries with 3 capitals");
         System.out.println("5.Countries without Summer capital");
         System.out.println("6.Capitals starting with vowel");
         System.out.println("7.Summer capitals starting with vowel ");
         System.out.println("8. Exit");
         int choice = sc.nextInt();
         sc.nextLine();
         switch (choice) {

             case 1:
                 printAll();
                 break;
             case 2:
                 System.out.println("Enter country name:");
                 String name = sc.nextLine();
                 printCountry(name);
                 break;
             case 3:
                 filterByCount(2);
                 break;
             case 4:
                 filterByCount(3);
                 break;
             case 5:
                 noSummerCapital();
                 break;
             case 6:
                 capitalsStartWithVowel();
                 break;
             case 7:
                 summerCapitalVowel();
                 break;
             case 8:
                 System.exit(0);

             default:
                 System.out.println("Invalid choice");
         }
     }
 }
 public static void printAll() {
    for (String country : countryData.keySet()) {
        HashMap<String, String> caps = countryData.get(country);
        System.out.println("Country: "+country);
        System.out.println("No of Capitals:"+caps.size());
        for (String season : caps.keySet()) {
            System.out.println(season +" ->"+ caps.get(season));
        }
    }
}
 public static void printCountry(String name) {
    if (countryData.containsKey(name)) {
        HashMap<String, String> caps = countryData.get(name);
        System.out.println("No of Capitals: "+ caps.size());
        for (String season : caps.keySet()) {
            System.out.println(season +" -> "+ caps.get(season));
        }
    } else {
        System.out.println("Country not found");
    }
}

public static void filterByCount(int count) {
    for (String country : countryData.keySet()) {
        if (countryData.get(country).size() == count) {
            System.out.println(country);
        }
    }
}

public static void noSummerCapital() {
    for (String country : countryData.keySet()) {
        if (!countryData.get(country).containsKey("Summer")) {
            System.out.println(country);
        }
    }
}
public static void capitalsStartWithVowel() {
    for (HashMap<String, String> caps : countryData.values()) {
        for (String capital : caps.values()) {
            if (isVowel(capital)) {
                System.out.println(capital);
            }
        }
    }
}

public static void summerCapitalVowel() {
    System.out.println("Enter country name:");
    String country = sc.nextLine();
    if (countryData.containsKey(country)) {
        Map<String, String> caps = countryData.get(country);
        if (caps.containsKey("Summer")) {
            String capital = caps.get("Summer");
            if (isVowel(capital)) {
                System.out.println("Summer Capital:"+capital);
            } else {
                System.out.println("Summer capital not vowel");
            }
        } else {
            System.out.println("No Capital");
        }
    } else {
        System.out.println("Country not found");
    }
}
public static boolean isVowel(String str) {
    char ch = Character.toLowerCase(str.charAt(0));
    return "aeiou".indexOf(ch) != -1;
}
}
