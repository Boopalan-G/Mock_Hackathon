import java.util.*;
import java.io.*;

import org.json.JSONException;
import org.json.JSONObject;
import java.text.DecimalFormat;
import java.math.RoundingMode;


public class Main {

	public static void main(String[] args) throws IOException, JSONException 
	{
		double[] a = new double[10000];
		JSONObject jsn  = new JSONObject();
		JSONObject jsn1 = new JSONObject();
		
		
		File f = new File("C:\\Users\\G Boopalan\\Documents\\CPU.txt");
		
		
		try (BufferedReader bf = new BufferedReader(new FileReader(f))) 
        {
			
            String readLine;
            double temp;
            int line = 1,x=680;
            int i=0;
            double sum=0.0;
            double max = 0.0;
            while ((readLine = bf.readLine()) != null) 
            {
                if (line != 0) {
                	String str=readLine;
                	str=readLine.split(" ")[14];
                	temp=Double.parseDouble(str);
                  a[i++]=temp;
                }
                line++;
            }

            String str1;
      
            for(int j=0;j<x;j++)
            {
            	str1 = String.format("%d",j);
            	jsn1.put(str1 + "s", a[j]);
            	if(max<a[j])
            		max=a[j];
            	sum=sum+a[j];
            }
            
            double average=sum/x;
            
            DecimalFormat df = new DecimalFormat("#.##");
      
            df.setRoundingMode(RoundingMode.CEILING)
            
            jsn.put("values: ", jsn1);
            jsn.put("avgcpu", df.format(average));
            jsn.put("maxcpu", df.format(max));
			
			
            System.out.println(jsn);
         }
 }
}
