import java.util.Scanner;

public class PalindromeCheck {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string to check: ");
        String str = input.nextLine();
        input.close();
        
        String cleaned = str.toLowerCase().replaceAll("[^a-z]", "");

        System.out.println("Is \"" + str + "\" a palindrome? " + isPalindrome(cleaned));
    }

    public static boolean isPalindrome(String str) {
        if(str.length() <= 1) return true;
        if(str.charAt(0) != str.charAt(str.length() - 1)) return false;
        return isPalindrome(str.substring(1, str.length() - 1));
    }
    
}
