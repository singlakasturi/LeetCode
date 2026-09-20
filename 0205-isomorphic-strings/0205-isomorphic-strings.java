class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> StoT = new HashMap<>();
        HashMap<Character, Character> TtoS = new HashMap<>();
        int n = s.length();

        for(int i=0;i<n;i++) {
            if(StoT.containsKey(s.charAt(i))) {
                if(StoT.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            
            else if(TtoS.containsKey(t.charAt(i)))
                return false;
            else {
                StoT.put(s.charAt(i), t.charAt(i));
                TtoS.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }
}