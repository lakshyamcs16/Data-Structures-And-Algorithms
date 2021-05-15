/*

A valid number can be split up into these components (in order):
A decimal number can be split up into these components (in order):
An integer can be split up into these components (in order):
For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
Given a string s, return true if s is a valid number.
 
Example 1:
Example 2:
Example 3:
Example 4:
 
Constraints:


*/

/*

Input: s = "0"
Output: true

Input: s = "e"
Output: false

Input: s = "."
Output: false

Input: s = ".1"
Output: true



*/

class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        int i = 0;
        s = s.toLowerCase();
        
        //check sign
        boolean signPresent = false;
        if(s.charAt(i) == '+' || s.charAt(i) == '-') {
            signPresent = true;
            i++;
        }
        
        //check for decimal
        boolean decimalPresent = false;
        if(i < n && s.charAt(i) == '.') {
            decimalPresent = true;
            i++;
        }
        
        //check for digit
        if(i < n && !Character.isDigit(s.charAt(i))) {
            return false;
        }
        //3e+7
        boolean expo = false;
        boolean signPresentAfterE = false;
        boolean digitPresent = false;
        while(i < n) {
            char ch = s.charAt(i);
​
            //if it's the second sign, it must follow e
            if(signPresentAfterE && checkSign(ch) && i<1 && s.charAt(i - 1) != 'e') {
                return false;
            }
            
            if(decimalPresent && checkDecimal(ch)) {
                return false;
            }
            
            if(!signPresentAfterE && checkSign(ch) && i>0 && s.charAt(i - 1) == 'e') {
                signPresentAfterE = true;
                i++;
                continue;
            }
            
            if(signPresent && checkSign(ch)) {
                return false;
            }
            
            if(expo && checkDecimal(ch)) {
                return false;
            }
            
            if(!expo && ch == 'e') {
                expo = true;
                i++;
                continue;
            }
            
            if(expo && ch == 'e') {
                return false;
            }
            
            if(!decimalPresent && checkDecimal(ch)) {
                decimalPresent = true;
                i++;
                continue;
            }
            
            if(!Character.isDigit(ch)) {
                return false;
            }
            
            if(Character.isDigit(ch)) {
                digitPresent = true;    
            }
            
            i++;
        }
        
        if(expo && !Character.isDigit(s.charAt(n-1))) {
            return false;
        }
        
        if(n == 1 && decimalPresent && s.charAt(n-1) == '.') {
            return false;
        }
        
        if(n == 1 && !Character.isDigit(s.charAt(n-1))) {
            return false;
        }
        
        if(!digitPresent) return false;
        
        return true;
        
    }
    
    private boolean checkSign(char ch) {
        if(ch == '-' || ch == '+') {
            return true;
        }
        
        return false;
    }
    
    private boolean checkDecimal(char ch) {
        if(ch == '.') {
            return true;
        }
        
        return false;
    }
}
