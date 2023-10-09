package practice;


import java.util.*;
import java.io.*;

class MapPractice{
	public static void main(String []argh)
	{
      
		
		List<String> listo = new ArrayList<String>();
		
		listo.add("");listo.add("");listo.add("");
		
		System.out.print(listo.stream().allMatch(order -> order.isEmpty()));
		
		/*
      Map<String,Integer> nMap = new HashMap<String,Integer>();
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
            nMap.put(name, phone);
			in.nextLine();
		}
		
        Set<String> set = nMap.keySet();
        for (String key : set) {
            System.out.println(key + "=" + nMap.get(key));
        }
        */
	}
}




