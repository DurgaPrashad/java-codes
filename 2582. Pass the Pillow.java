class Solution {
    public int passThePillow(int n, int time) {
        int position = 1;
        int direction = 1;
        
        for (int t = 0; t < time; t++) {
            position += direction;
            if (position == n || position == 1) {
                direction = -direction;
            }
        }
        
        return position;
    }
}
