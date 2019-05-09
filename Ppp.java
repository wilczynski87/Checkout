package ppp;

import java.util.Scanner;

public class Ppp {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("You can buy A, B, C and D: ");
        String goods = scan.nextLine();

        Checkout Checkout = new Checkout();
        System.out.println(Checkout.price(goods));
        

	}

}


