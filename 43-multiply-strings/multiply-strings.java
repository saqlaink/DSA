class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n1 = num1.length(), n2 = num2.length();
        int[] arr = new int[n1+n2];
        int idx = arr.length - 1, carry = 0, j = n2;
        for(int i=n2-1;i>=0;i--){
            int temp = idx;
            carry = 0;
            j = n1 - 1;
            while(j>=0){
                int prod = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                prod+=carry;
                carry = (prod + arr[idx])/10;
                arr[idx] = (arr[idx--] + prod) % 10;
                j--;
            }
            if(carry > 0) arr[idx--] = carry;
            idx = temp -1;
        }
        StringBuilder sb = new StringBuilder();
        boolean is = false;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > 0) is = true;
            if(is) sb.append(arr[i]);
        }
        return sb.toString();
    }
}