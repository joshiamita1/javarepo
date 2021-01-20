/**
 * 
 */
package com.flipkart.collection;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Customer;

/**
 * @author Joshi_Amita
 *
 */
public class ArrayListDemo {

	/**
	 * @param args
	 */
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			List<String> l1 = new ArrayList<String>();
		List<Customer> customers = new ArrayList<Customer>();
			
			System.out.println("Size of this Collection: "+l1.size());
			l1.add("Hello");
			l1.add("World");
			l1.add("Test");
			l1.add("Demo");
			l1.add("Demo");
//			l1.add(101);
			System.out.println("customers"+customers.size());
			System.out.println(l1.size());
			for(String value: l1) {
				System.out.println(value);
			}
			
			l1.remove(4);
			
			System.out.println(l1.size());
			for(String value: l1) {
				
				System.out.println(value);
			}
			
			
		}

	}


