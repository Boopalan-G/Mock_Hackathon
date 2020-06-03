import java.io.*;
import java.util.*;
 import org.json.*;
public class Sample {

    public static void main(String[] args) throws IOException {
    	JSONObject obj=new JSONObject();
    	double[] max=new double[10000];
    	
       FileInputStream f=new FileInputStream("C:\\Users\\windows\\Documents\\Memory.txt");
       InputStreamReader is=new InputStreamReader(f);
       BufferedReader b=new BufferedReader(is);
       String l="";
       double num=0;
       int i=0;
       ArrayList<String> a=new ArrayList<>();
       while((l=b.readLine())!=null)
       {
    	   StringTokenizer st=new StringTokenizer(l,"");
    	   while(st.hasMoreTokens());
    	   a.add(st.nextToken());
    	   
       }
       num=Double.parseDouble(a.get(8));
       max[i]=num;
       i++;
 
    }
  
    FileWriter fw=new FileWriter("Memory.jason");
    PrintWriter pw=new PrintWriter(fw);
    for(int k=0;k<=10;k++)
    {
    	try
    	{
    		obj.put(k+"s:",max[k]);
    	}
    	catch(JSONException e)
    	{
    		System.out.println(e);
    	}
    }
    pw.format("\n%s",obj);
    pw.close();
}
}
