import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r,int m,int n) {
       
   int[][] ar = new int[matrix.size()][];
       int row = 0, col = 0; 
        int prev, curr; 
   for (int i = 0; i < ar.length; i++) {
            ar[i] = new int[matrix.get(i).size()];
        }     
 int n1=m,n2=n;

  for (int i = 0; i < matrix.size(); i++) {
    
    for(int j=0;j<n;j++)
    {
             
        ar[i][j]=matrix.get(i).get(j);
          
    }
}



for(int k=0;k<r;k++)
{
      row=0;
      col=0;
      m=n1;
      n=n2;   
        while (row < m && col < n) 
        { 
      
            if (row + 1 == m || col + 1 == n) 
                break; 
      
            
            prev = ar[row+1][n-1]; 
      
            
            for (int i = n-1; i >=row; i--) 
            { 
                curr = ar[row][i]; 
                
                ar[row][i]=prev;
                prev = curr; 
            } 
            row++; 
      
             
              
            if (col < n) 
            {
                
                for (int i = row; i <=m-1; i++) 
                { 
                    curr = ar[i][col]; 
                    ar[i][col] = prev; 
                    prev = curr; 
                } 
            } 
            col++; 
              
            if (row < m) 
            { 
                for (int i = col; i <=n-1; i++) 
                { 
                    curr = ar[m-1][i]; 
                    ar[m-1][i] = prev; 
                    prev = curr; 
                } 
            } 
            m--;
            
             
            for (int i = m-1; i >=row; i--) 
            { 
                curr = ar[i][n-1]; 
                ar[i][n-1] = prev; 
                prev = curr; 
            } 
            n--;
      
            
        }

}



       for(int i=0;i<n1;i++)
       {
           for(int j=0;j<n2;j++)
           {
               System.out.print(ar[i][j]+" ");
           }
           System.out.println();
       }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        matrixRotation(matrix, r,m,n);

        bufferedReader.close();
    }
}
