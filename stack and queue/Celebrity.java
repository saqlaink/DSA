// 16. The Celebrity Problem
    
// In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “. Find the stranger (celebrity) in the minimum number of questions.
// We can describe the problem input as an array of numbers/characters representing persons in the party. We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. How can we solve the problem. 
// ```
// Input:MATRIX = { {0, 0, 1, 0},
//                {0, 0, 1, 0},
//                {0, 0, 0, 0},
//                {0, 0, 1, 0} }
// Output:id = 2
// Explanation: The person with ID 2 does not 
// know anyone but everyone knows him
// Input:MATRIX = { {0, 0, 1, 0},
//                {0, 0, 1, 0},
//                {0, 1, 0, 0},
//                {0, 0, 1, 0} }
// Output: No celebrity
// Explanation: There is no celebrity.
// ```
// - [ ] 2 Pointer:
// - Time Complexity:O(n)
// - Space Complexity:O(1) No extra space is required.
// ```



public static int celebrity(int M[][], int n){
        // This function returns the celebrity
        // index 0-based (if any)
        int i = 0, j = n - 1;
        while (i < j) {
            if (M[j][i] == 1) // j knows i
                j--;
            else // j doesnt know i so i cant be celebrity
                i++;
        }
        // i points to our celebrity candidate
        int candidate = i;
        // Now, all that is left is to check that whether
        // the candidate is actually a celebrity i.e: he is
        // known by everyone but he knows no one
        for (i = 0; i < n; i++) {
            if (i != candidate) {
                if (M[i][candidate] == 0 || M[candidate][i] == 1)
                    return -1;
            }
        }
        // if we reach here this means that the candidate
        // is really a celebrity
        return candidate;
    }
```