class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int n = pattern.length();
        if(words.length != pattern.length())
            return false;

        HashMap<Character, String> mappy = new HashMap<>();

        for(int i=0;i<n;i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if(mappy.containsKey(c)) {
                if(!mappy.get(c).equals(word))
                    return false;
            }
            else {
                if(mappy.containsValue(word))
                    return false;

                mappy.put(c, word);
            }
        }

        return true;
    }
}