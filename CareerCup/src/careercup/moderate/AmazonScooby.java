package careercup.moderate;



/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
* uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;

class AmazonScooby {
static long GCD(long B,long N)
{
if(N==0)return B;
return GCD(N,B%N);

}
static long LCM(long B,long N)
{
return B/GCD(B,N)*N;

}
@SuppressWarnings({ "resource", "unused" })
public static void main(String args[] ) throws Exception {


Scanner s = new Scanner(System.in);
int t=s.nextInt();
while(t-->0)
{
long A = s.nextLong();
long B=s.nextLong();
long N=s.nextLong();
long ans=LCM(B,N);
if(B!=0)
ans/=B;
else
ans=1;
System.out.println(ans);
}


}
}


