package practice.datadriventesting;

public class GenerateAlphanumericRandomData {
   public static void main(String[] args) {
	int n=20;
	//choose a character random from this string
	String AlphanumeriString ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
	
	//create stringbuffer size of AlphaNumericString
	StringBuilder sb=new StringBuilder(n);
	
	for(int i=0;i<n;i++)
	{
		//generate a random number between 0 to AlphanumericString variable length
		int index=(int)(AlphanumeriString.length()*Math.random());
		
		//add character one by one in end of sb
		sb.append(AlphanumeriString.charAt(index));
	}
	System.out.println(sb);
}
}
