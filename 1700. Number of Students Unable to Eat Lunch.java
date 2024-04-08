class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] preferenceCount = new int[2]; 

        for (int student : students) {
            preferenceCount[student]++;
        }

        for (int sandwich : sandwiches) {
            if (preferenceCount[sandwich] == 0) {
                return preferenceCount[0] + preferenceCount[1];
            } else {
                preferenceCount[sandwich]--;
            }
        }

        return 0;
    }
}
