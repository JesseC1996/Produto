package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Prog {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter the number of products:");
		int n = sc.nextInt();
		for(int i =0;i<n;i++) {
			System.out.println("Product #"+(i+1)+" data:");
			System.out.print("Common,used or imported:(c/u/i):");
			char ch = Character.toLowerCase(sc.next().charAt(0));
			while(ch != 'u'&& ch !='c'&& ch != 'i') {
				System.out.println("Enter with a valid character: ");
				ch = Character.toLowerCase(sc.next().charAt(0));
			}
			
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.println("Price: ");
			double price = sc.nextDouble();
			
			if(ch == 'u') {
				System.out.print("Manufactured date: ");
				Date manufacturedDate = sdf.parse(sc.next()); 
				list.add( new UsedProduct(name,price,manufacturedDate));
				
			}else if(ch == 'c') {
				 list.add(new Product(name,price));
				 
			}else if(ch =='i') {
				System.out.print("Costums fee: ");
				Double costumsFee = sc.nextDouble();
				list.add( new ImportedProduct(name,price,costumsFee));
				
			}
						
		}
		
		System.out.println("PRICE TAGS:");
		for(Product prod :  list) {
		System.out.println(prod.priceTag());
		}
		
		sc.close();
	}
}
