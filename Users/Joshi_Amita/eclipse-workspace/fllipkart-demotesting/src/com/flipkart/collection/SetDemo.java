/**
 * 
 */
package com.flipkart.collection;

/**
 * @author Joshi_Amita
 *
 */
public class SetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// set  class

		package com.ericssion.dscollection;

		import java.util.HashSet;
		import java.util.Set;
		import java.util.TreeSet;

		public class DemoSet {

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				
				int count[] = {34,22,10,60,30,22};
			     
			     Set set = new HashSet();
			     
			     try{
			        for(int i = 0; i<=5; i++){
			           set.add(count[i]);
			        }
			        System.out.println(set);
			        
			        
			        
			        TreeSet<Integer> sortedSet = new TreeSet<Integer>(set);
			        System.out.println("The sorted list is:");
			        
			        System.out.println(sortedSet);

			        System.out.println("The First element of the set is: "+
			                          (Integer)sortedSet.first());
			       
			        System.out.println("The last element of the set is: "+
			                        (Integer)sortedSet.last());
			        
			        
			        
			        
			
			       }catch(Exception e){
			    	   
			    	   System.out.println(" in exception Class"+e.getMessage());
			       }
		}
		}


		// map Impl 


		/**
		 * 
		 */
		package com.ericssion.dscollection;

		import java.util.HashMap;
		import java.util.Map;
		import java.util.TreeMap;

		/**
		 * @author Amit
		 *
		 */
		public class MapDemo {

			/**
			 * @param args
			 */
			public static void main(String[] args) {
				// TODO Auto-generated method stub

				 HashMap<Integer,String> hm1=new HashMap<Integer,String>();	
					
				 TreeMap<Integer,String> hm=new TreeMap<Integer,String>();
				 
				hm1.put(101, "MALE");
				hm1.put(102, "DELHI");
				hm1.put(103, "New York");
				hm1.put(103, "Dubai");
				hm1.put(101, "LONDON");
				
				hm.put(102, "MALDIVES");
				hm.put(101, "MALDIVES");
				hm.put(106, "UK");
				hm.put(105, "US");
						
				for(Map.Entry m:hm1.entrySet()){  
					   System.out.println(m.getKey()+" "+m.getValue());  
					  }   
				
				for(Map.Entry m:hm.entrySet()){  
					   System.out.println(m.getKey()+" "+m.getValue());  
					  } 
				  
			}

				
		}	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				









	}

}
