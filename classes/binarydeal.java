package sample;

public class binarydeal {

	static int[] arr= {128,64,32,16,8,4,2,1}; 

	public static String findbinary(String a){	
		String ttt="";
		int binary=Integer.parseInt(a);
	
		for(int i =0; i<8; i++)
		{
		if(arr[i]<=binary)
		{
			binary=binary-arr[i];
			ttt=ttt+"1";
			
		}
		else
		{
			ttt=ttt+"0";
		}

		}
		
		return ttt;
		
	}
	public static String getBinary(String a){  
		int binary=Integer.parseInt(a);
		String decimal=Integer.toBinaryString(binary);
		int a1=0;
		while(a1==0)
		{
			if(decimal.length()<8)
		{
			decimal=decimal+"0";
		}
			else
				a1=2;
		
		}
	    return decimal;  
	}  
	
	public static int getDecimal(String binary){  
		int octale=0;
        for(int i=0;i<8;i++)
        {
        	if(binary.charAt(i)=='1')
        	{
        		octale=octale+arr[i];
        	}
        }
	    return octale;  
	}  
	

	public static int addBinary(String ipdecimal, String networkoctal) {
		String co="";
		for(int i=0;i<8;i++)
			{
				int a = (int)ipdecimal.charAt(i); 
	            int b = (int)networkoctal.charAt(i); 
	  
	            if (a == b && b == 49) { 
	                co=co+"1";
	             } 
	            else{
	            	co=co+"0";
	             }
			}
		return getDecimal(co);
		}
	
	
	public static int broadcast(String ipbinary) {
		int t=ipbinary.lastIndexOf("1");
		return arr[t]-1;
	}  
		
	
}
