package com.baosight;

import java.util.Map;
import java.util.UUID;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*for(int i=1;i<10;i++)
		{
			System.out.println(UUID.randomUUID().toString().replaceAll("-", "")); 
		}*/
/*        File[]   roots=File.listRoots();   
        
        for(int   i=0;i<roots.length;i++)   
  
        {   
  
            System.out.println(roots[i].getPath());   
        }
        System.out.println("-------- System Properties ---------"); 

        Properties pp = System.getProperties(); 

        Enumeration ee = pp.propertyNames(); 

        while (ee.hasMoreElements()) { 

            String name = (String) ee.nextElement(); 

            System.out.println(name + "\n\t\t\t" + pp.getProperty(name)); 

        } */
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        System.out.println("-------- System Environment ---------"); 

        for (Map.Entry entry : System.getenv().entrySet()) { 

            System.out.println(entry.getKey() + "\t\t\t" + entry.getValue()); 

        } 
        
	}

}
