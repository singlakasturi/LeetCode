class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1 || numRows > s.length())
            return s;

        int i = 0;
        int d = 1;
        List<Character>[] rows = new ArrayList[numRows];

        for(int j=0; j < numRows; j++) {
            rows[j] = new ArrayList<>();
        }

        for(char c : s.toCharArray()) {
            rows[i].add(c);
            if(i == 0)
                d = 1;
            if(i == numRows - 1)
                d = -1;

            i += d;
        }

        StringBuilder res = new StringBuilder();
        for(List<Character> l : rows)
            for(char c : l)
                res.append(c);

        return res.toString();

    }
}