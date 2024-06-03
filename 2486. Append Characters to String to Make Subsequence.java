class Solution {
    public int appendCharacters(String s, String t) {
        int pointerT = 0;
        int lengthS = s.length();
        int lengthT = t.length();
        
        for (int i = 0; i < lengthS; i++) {
            if (pointerT < lengthT && s.charAt(i) == t.charAt(pointerT)) {
                pointerT++;
            }
        }
        
        return lengthT - pointerT;
    }
}
