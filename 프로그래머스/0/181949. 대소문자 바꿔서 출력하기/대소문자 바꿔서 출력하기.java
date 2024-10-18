import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        
    for(int i = 0; i< a.length();i++){
        char cA = a.charAt(i);
        if(Character.isUpperCase(cA)){
            answer += Character.toLowerCase(cA);
        } else{
            answer += Character.toUpperCase(cA);
        }
    }
    System.out.println(answer);
    }
}