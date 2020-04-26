package sample;

import java.util.*;


public class subnetting {
	static String mask="";
	static String wild="";
	static String clas;
	static int CIDR;
	static String IP;
	static int host;
	static String network="";
	static String broadcast="";
	static String[] strs;
	static int set;
	static int temp;
	static String X;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter IP address \n(xxxx.xxxx.xxxx.xxxx/CIDR)");
		String input =sc.nextLine();//input Ip address
		int t=input.lastIndexOf("/");
		int length = input.length();
		CIDR = Integer.parseInt(input.substring(t+1,length));//get cidr from Inputed ip
		IP =input.substring(0,t);
		strs = IP.split("[,\\.]");//split inputed ip and store it in strs array
		
		findClass(Integer.parseInt(strs[0]));//find class
		getmask(CIDR);//get subnett mask
		findnetwork();//find network  id
		findbroadcast();//find broadcast id
		display();


	}

	private static void findnetwork() {//find network  id
		String ipbinary="";
		String networkoctal="";
		
		
		String s="";
		String p="0";
		switch(set) {
		  case 1:
			  ipbinary=binarydeal.getBinary(X);
			  networkoctal=binarydeal.findbinary(strs[0]);
			  temp=binarydeal.addBinary(ipbinary ,networkoctal); 
			  s=Integer.toString(temp);
				network=s+"."+p+"."+p+"."+p;
		    break;
		  case 2:
			  ipbinary=binarydeal.getBinary(X);
			  networkoctal=binarydeal.findbinary(strs[1]);
			  temp=binarydeal.addBinary(ipbinary ,networkoctal); 
			  s=Integer.toString(temp);
				network=strs[0]+"."+s+"."+p+"."+p;
		    break;
		  case 3:
			  ipbinary=binarydeal.getBinary(X);
			  networkoctal=binarydeal.findbinary(strs[2]);
			  temp=binarydeal.addBinary(ipbinary ,networkoctal); 
			  s=Integer.toString(temp);
				network=strs[0]+"."+strs[1]+"."+s+"."+p;
			break;
		  case 4:
			  ipbinary=binarydeal.getBinary(X);
			  networkoctal=binarydeal.findbinary(strs[3]);
			  temp=binarydeal.addBinary(ipbinary ,networkoctal); 
			  s=Integer.toString(temp);
              network=strs[0]+"."+strs[1]+"."+strs[2] + "." + s;
			break;    
		  default:
				System.out.println("Default case in find network");
		}
	}

	private static void findbroadcast() { //find broadcast id
		String s="";
		String ipbinary="";
		String p="255";
		switch(set) {
		  case 1:
			  ipbinary=binarydeal.getBinary(X);
			  s=Integer.toString(binarydeal.broadcast(ipbinary)+temp);
			  broadcast=s+"."+p+"."+p+"."+p;
			  break;
		  case 2:
			  ipbinary=binarydeal.getBinary(X);
			  s=Integer.toString(binarydeal.broadcast(ipbinary)+temp);
			  broadcast=strs[0]+"."+s+"."+p+"."+p;
			  break;
		  case 3:
			  ipbinary=binarydeal.getBinary(X);
			  s=Integer.toString(binarydeal.broadcast(ipbinary)+temp);
			  broadcast=strs[0]+"."+strs[1]+"."+s+"."+p;
			  break;
		  case 4:
			  ipbinary=binarydeal.getBinary(X);
			  s=Integer.toString(binarydeal.broadcast(ipbinary)+temp);
			  broadcast=strs[0]+"."+strs[1]+"."+strs[2]+"."+s;
			break;    
		  default:
				System.out.println("Default case in find network");
		}		
		
	}


	

	private static void findClass(int first_Octet) {  //find class
		if(first_Octet <= 127)
		{clas="A";}
		else if(128<=first_Octet &&first_Octet <= 191)
		{clas= "B";}
		else if(192<=first_Octet &&first_Octet <= 223)
		{clas="C";}
		}
	
	
	public static void getmask(int CIDR)//get subnett mask
	{	
		host=(int) (Math.pow(2, 32-CIDR)-2)	;
		int t;
		String i="255.";
		String ii="";
		String iii=".255";
		String f=".0";
		String ff="0.";
		if(CIDR<=8)
		{	set=1;
			t=CIDR+24;
			t=32-t;
			int tt=(int)Math.pow(2, t);
			int p=tt-1;
			ii=Integer.toString(tt-1);
			tt=255-tt +1;
			X=Integer.toString(tt);
			mask=X+f+f+f;	
			ii=Integer.toString(p);
			wild=ii+iii+iii+iii;
			}
		else if(CIDR<=16)
		{	set=2;
			
			t=CIDR+16;
			t=32-t;
			int tt=(int)Math.pow(2, t);
			int p=tt-1;
			tt=255-tt +1;	
			
			X=Integer.toString(tt);
			mask=i+X+f+f;	
			ii=Integer.toString(p);
			wild=ff+ii+f+f;			
			}
		else if(CIDR<=24)
		{	set=3;
			
			t=CIDR+8;
			t=32-t;
			int tt=(int)Math.pow(2, t);
			int p=tt-1;
			tt=255-tt +1;
			X=Integer.toString(tt);
			mask=i+i+X+f;	
			ii=Integer.toString(p);
			wild=ii+f+f+f;
			}
		else if (CIDR<=32)
		{	set=4;
			
			
			t=CIDR;
			t=32-t;
			int tt=(int)Math.pow(2, t);
			int p=tt-1;
			tt=255-tt +1;
			X=Integer.toString(tt);
			mask=i+i+i+X;	
			ii=Integer.toString(p);
			wild=ii+f+f+f;
			}
	
		
	}
	private static void display() {
		System.out.println("CLASS = " + clas);
		System.out.println("CIDR = " +CIDR);
		System.out.println("IP Address = " +IP);
		System.out.println("HOSTS = " +host);
		System.out.println("Mask = " +mask);
		System.out.println("Wildcard = " +wild);
		System.out.println("Network ID = " +network);
		System.out.println("Broadast ID = " +broadcast);
		}
}
