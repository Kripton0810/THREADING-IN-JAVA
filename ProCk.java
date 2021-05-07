public class ProCk{
 
public static void main(String[] args)
{
int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
 
for (int i = 0; i < arr.length; i++) { 
    if (arr[i] >= 4)
{
System.out.println("Exit from the loop and exceting JVM");
System.exit(0); 
}
else
System.out.println("arr["+i+"] = " +arr[i]);
}
System.out.println("End of the Program");
}
}