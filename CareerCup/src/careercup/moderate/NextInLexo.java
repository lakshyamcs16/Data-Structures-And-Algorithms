package careercup.moderate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class NextInLexo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	InputStreamReader inr =new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(inr);
        
        int cases=Integer.parseInt(br.readLine());
        while(cases-->0)
        {
        	//Scanner sc1=new Scanner(System.in);
             String s=br.readLine();
             char [] a=s.toCharArray();
             int n=a.length;
             int i=n-2;
             for(;i>=0;i--)
             {
                 if(a[i]<a[i+1])
                     break;
             }
            //System.out.println(i);
            if(i<0)
            {
                System.out.println("no answer");
                continue;
            }
            
            int d=i;
            int smallest=i+1;
            for(int j=i+1;j<n;j++)
            {
                if(a[j]>a[i])
                {
                    if(a[j]<a[smallest])
                        smallest=j;
                }
            }
            char c=a[i];
            a[i]=a[smallest];
            a[smallest]=c;
            
            Arrays.sort(a,d+1,n);
            System.out.println(new String(a));
        }
	}
}
	
