package ppp;

import java.math.BigDecimal;
import java.math.*; //need it because rounding numbers

public class Checkout {
	
	
	char[] name = {'A','B','C','D'}; // Items that can be bought
	int aopt = 4; // amout of product types // can by made with method, but not too meny types of products
	
	String[] cost1 = {"1.99", "3.23", "0.59", "2.30"}; // price for items. what can be bought
	BigDecimal[] price1 = new BigDecimal[4]; // price for items. what can be bought in BigDecimal

	BigDecimal[] basket = new BigDecimal[4]; // quantity of the items in the basket

    BigDecimal[] sum = new BigDecimal[4]; // sum of produckts price
    
    int[] offer = {0, 1, 0, 2}; // information about offer
    
	static BigDecimal count (char product, int len, char[] table) { // function counting same item,  selected from a table (basket)
		BigDecimal sum1 = new BigDecimal(0);
		BigDecimal add1 = new BigDecimal(1); 
        for (int p = 0; p <= len; p++) {

            if (product == table[p]) sum1 = sum1.add(add1);
        }

        return sum1;
    }
    
    static BigDecimal sumforname (BigDecimal productamout, BigDecimal price, int offer) { // function give a sum price for name of product
    	BigDecimal sum = new BigDecimal(0);
    	BigDecimal sum2 = new BigDecimal(0);
    	
    	switch(offer) {
    	case 1: //Promotion nr 1 ( buy TWO, get a THIRD one free )
    		sum = price.multiply(productamout);
    		sum2 = productamout.divide(new BigDecimal("3"), 0, RoundingMode.DOWN);
    		//System.out.println(sum2); test
    		sum2 = sum2.multiply(price);
    		sum = sum.subtract(sum2);
    		//System.out.println(sum); //test
    		break;
    	case 2: //Promotion nr 2 ( Two for 4.00 )
    		sum = price.multiply(productamout); //sum op price for product typ D
    		sum2 = productamout.divide(new BigDecimal("2"), 0, RoundingMode.DOWN); // divade amout of product by 2
    		sum2 = sum2.multiply(new BigDecimal("0.6")); 
    		sum = sum.subtract(sum2);
    		break;
    	default: sum = price.multiply(productamout); // counting price for product amout
    		break;
    	
    	}
    	return sum;
    }
    
    static BigDecimal costtoprice (BigDecimal[] bd, String[] st) { // method convert string in to BigDecimal
    	
    	for (int p = 0; p < 4; p++) {
    		bd[p] = new BigDecimal(st[p]);
    	}
    	
    	return null;
    }
    
    static BigDecimal price1(BigDecimal sop[], int aopt) { //method returns a price for all basket
    	BigDecimal price = new BigDecimal(0);
    	
    	for(int i = 0; i <=aopt-1; i++) {
    		price = price.add(sop[i]);
    	}
    	
    	return price;
    }
    
    public BigDecimal price(String goods){ // heart function
    	
    	costtoprice(price1, cost1); // method convert string in to BigDecimal
    	//System.out.println(price1[2]); //test
    	
    	char[] chartable = goods.toCharArray(); //convert shopping card to table (char shoping card)
        //System.out.println(chartable); //test

        int lenght = goods.length()-1; // counting lenght of shopping list
        //System.out.println(lenght); //testing
        
        for (int p = 0; p < (aopt); p++) { //filling a product name table with a number of product from bascet 

        	basket[p] = count(name[p], lenght, chartable); // function counting same item,  selected from a table (basket)
        	//System.out.println(name[p] + " = " + basket[p]); //test
        	
        	sum[p] = sumforname(basket[p], price1[p], offer[p]);  // function give a sum price for name of product
        	//System.out.println(name[p] + " = " + sum[p]); //test
        	
        }
        
        BigDecimal price1 = price1(sum, aopt); //function return price for all basket of produckts
    	//System.out.println(price1); //test
    	
        return price1;
    }
}


