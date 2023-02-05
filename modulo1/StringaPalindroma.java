package modulo1;

public class StringaPalindroma {
    public static void main(String[] args) {

        System.out.println(isPalindrome("c"));          //true
        System.out.println(isPalindrome("ciic"));       //true
        System.out.println(isPalindrome("aaaa"));       //true
        System.out.println(!isPalindrome("absca"));     //!false = true
        System.out.println(!isPalindrome("abbaa"));     //!false = true
        System.out.println(isPalindrome("zzzzz"));      //true
        System.out.println(isPalindrome("zzczz"));      //true
        System.out.println(isPalindrome("aabbaa"));     //true
    }

    private static boolean isPalindrome(String s) {

        if (s.length() == 1)    //Un solo carattere è palindromo
            return true;
        else {
            for (int i=0; i<(s.length())/2; i++)
                if (s.charAt(i) != s.charAt(s.length()-1-i))    //-1-i per evitare StringIndexOutOfBoundsException
                    return false;

            return true;
        }
    }
}