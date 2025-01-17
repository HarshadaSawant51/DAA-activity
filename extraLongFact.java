import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

   
    static void extraLongFactorials(int n) {
   
   
       int res[] = new int[500]; 
  
        
        res[0] = 1; 
        int res_size = 1; 
  
       
        for (int x = 2; x <= n; x++) 
            res_size = multiply(x, res, res_size); 
  
        for (int i = res_size - 1; i >= 0; i--) 
            System.out.print(res[i]); 
    } 
      
     
    static int multiply(int x, int res[], int res_size) 
    { 
        int carry = 0; 
        for (int i = 0; i < res_size; i++) 
        { 
            int prod = res[i] * x + carry; 
            res[i] = prod % 10; 
            carry = prod/10; 
        } 
  
        
        while (carry!=0) 
        { 
            res[res_size] = carry % 10; 
            carry = carry / 10; 
            res_size++; 
        } 
        return res_size; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
