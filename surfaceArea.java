import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

 
    static int contribution_height(int current, int previous) 
    { 
        return Math.abs(current - previous); 
    } 
      
    






    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] A,int N,int M) {

        int ans = 0; 
      
        
        for (int i = 0; i < N; i++)  
        { 
            for (int j = 0; j < M; j++) { 
      
                
                int up = 0; 
      
                
                int left = 0; 
      
                
                if (i > 0) 
                    up = A[i - 1][j]; 
      
               
                if (j > 0) 
                    left = A[i][j - 1]; 
      
                
                ans += contribution_height(A[i][j], up)  
                       + contribution_height(A[i][j], left); 
      
                
                if (i == N - 1) 
                    ans += A[i][j]; 
      
                
                if (j == M - 1) 
                    ans += A[i][j]; 
            } 
        } 
      
        
        ans += N * M * 2; 
        return ans;
    
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A,H,W);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
