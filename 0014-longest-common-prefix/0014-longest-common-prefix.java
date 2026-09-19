class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int min = Integer.MAX_VALUE;
        for(String s : strs)
            min = Math.min(s.length(), min);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<min; i++) {
            char c = strs[0].charAt(i);

            for(String s : strs) {
                if(s.charAt(i) != c)
                    return sb.toString();
            }

            sb.append(c);
        }

        return sb.toString();
    }
}