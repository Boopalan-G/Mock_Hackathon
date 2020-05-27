import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import org.json.JSONObject;
import java.math.RoundingMode;


public class Main {

	public static void main(String[] args) throws IOException 
	{
		double[] a = new double[10000];
		JSONObject jsn  = new JSONObject();
		JSONObject jsn1 = new JSONObject();
		File f = new File("C:\\Users\\Boopalan\\Documents\\Memory.txt");
		
		
		try (BufferedReader bf = new BufferedReader(new FileReader(f))) 
        {
			
            String readLine;
            double temp;
            int line = 0;
            int i=0;
            double sum=0.0;
            double max = 0.0;
            
            
            while ((readLine = bf.readLine()) != null) 
            {
                if (line % 2 != 0) {
                	String str=readLine;
                	str=str.replaceAll("[^0-9]","");
                    str=str.trim();
                    temp=Integer.parseInt(str);
              
                    a[i++]=temp/10000;
                }
                line++;
            }
			
			
            String str1;
			
			
            for(int j=0;j<938;j++)
            {
            	str1 = String.format("%d",j);
            	jsn1.put(str1 + "s", a[j]);
            	if(max<a[j])
            		max=a[j];
            	sum=sum+a[j];
            }
            
            double average=sum/938;
            
            DecimalFormat df = new DecimalFormat("#.###");
			
			
            df.setRoundingMode(RoundingMode.CEILING);
            jsn.put("AverageMemory(MB)", df.format(average));
            jsn.put("values: ", jsn1);
            jsn.put("MaximumMemory(MB)", df.format(max));
			
			
            System.out.println(jsn);
         }
 }
}
