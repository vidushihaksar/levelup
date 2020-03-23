import java.io.*;
import java.util.*;

public class soln {
public static Scanner scn = new Scanner(System.in);
    // This is a functional problem. 
    // Input is managed for you.
    // Don't change main, write your code in the function below
    public static void main(String[] args) {
       int r = scn.nextInt();
		int c = scn.nextInt();
		int[][] arr = new int[r][c];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}

		}
        i=0;j=0;
		exitPoint(arr);
        System.out.print(i+", "+j);
    }
static boolean rowConst = true;
static boolean colInc= true;
static boolean rowInc = false;
    static int i;
    static int j;
    public static void exitPoint(int[][] arr) {
		// Write your code only here.
        while(j<(arr[0].length-1)  ){
          if(arr[i][j]==0){
                           }
          else{
          if(rowConst){
              if(colInc){
                rowConst=false;
                rowInc =true;
              }
              else{
                  rowConst=false;
                  rowInc=false;
              }
           }
         else{
             if(rowInc){
                 rowConst=true;
                 colInc=false;
             }
             else{
                 rowConst=true;
                 colInc=true;
             }
         }
          }
            
         if(rowConst  ){
             if(colInc){j++;}
             else{j--;}
         }
         else{
             if(rowInc){ i++; }
              else{i--;}
          }
             if (i > arr[0].length-1){
                    i--;
                    break;  
                }
                if (j >arr[0].length-1){ 
                    j--;
                    break;
                }

      }  
    
    }
}
     























#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int octalToDecimal(int n) 
{ 
    int num = n; 
    int dec_value = 0; 
      int base = 1; 
  
    int temp = num; 
    while (temp) { 
        int last_digit = temp % 10; 
        temp = temp / 10; 
        dec_value += last_digit * base; 
        base = base * 8; 
    } 
  
    return dec_value; 
} 
int DecimalToOctal(int decimalNum) {
   int octalNum = 0, placeValue = 1;
   int dNo = decimalNum;
   while (decimalNum != 0) {
      octalNum += (decimalNum % 8) * placeValue;
      decimalNum /= 8;
      placeValue *= 10;
   }
   return octalNum;
}
int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int first,sec;
    cin>>first;
    cin>>sec;
    int f = octalToDecimal(first);
    int s = octalToDecimal(sec);
    int diff = f-s;
    int octal = DecimalToOctal(diff);
    cout<<octal;
    
    return 0;
}




//lexio
import java.util.Scanner;

public class soln {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        lexcico(1, scn.nextInt());

    }

    public static void lexcico(int start, int end) {
        for(int i=1;i<=9;i++) {
            lexci(i, end);
        }
    }
    public static void lexci(int start, int end) {
        // Write your code here.
        if(start >= end) 
            return;
        
        System.out.println(start);
        for(int num = 0;num <= 9;num++) {
            lexci(start*10+num, end);
        }
    }
  }