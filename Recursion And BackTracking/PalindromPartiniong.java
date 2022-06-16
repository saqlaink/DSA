// Palindrome Partitioning
// Problem Statement: You are given a string s, partition it in such a way that every substring is a palindrome. Return all such palindromic partitions of s.

// Note: A palindrome string is a string that reads the same backward as forward.


public static List < List < String >> partition(String s) {
        List < List < String >> res = new ArrayList < > ();
        List < String > path = new ArrayList < > ();
        func(0, s, path, res);
        return res;
    }

    static void func(int index, String s, List < String > path, List < List < String >> res) {
        if (index == s.length()) {
            res.add(new ArrayList < > (path));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                func(i + 1, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }