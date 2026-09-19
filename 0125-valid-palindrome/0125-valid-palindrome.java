class Solution {

    public String convert(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString();
    }

    public boolean isPalindrome(String s) {
        s = convert(s);


        int i=0, j = s.length()-1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;


    }
}