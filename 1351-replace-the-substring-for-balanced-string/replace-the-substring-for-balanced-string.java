class Solution {
    public int balancedString(String s) {
        int length = s.length();
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0;
        int ans = length;
        int targetCount = length / 4;
        charCount.put('Q',0);
        charCount.put('W',0);
        charCount.put('E',0);
        charCount.put('R',0);
        // Count the occurrences of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (int right = 0; right < length; right++) {
            // Decrement the count of the character at the current index
            charCount.put(s.charAt(right), charCount.get(s.charAt(right)) - 1);

            // Shrink the window by moving the left pointer
            while (left < length && charCount.get('Q') <= targetCount && charCount.get('W') <= targetCount && charCount.get('E') <= targetCount && charCount.get('R') <= targetCount) {
                // Update the answer
                ans = Math.min(ans, right - left + 1);
                // Increment the count of the character at the left pointer
                charCount.put(s.charAt(left), charCount.get(s.charAt(left)) + 1);
                // Move the left pointer
                left++;
            }
        }
        return ans;
    }
}