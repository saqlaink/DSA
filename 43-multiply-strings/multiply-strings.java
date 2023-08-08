class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n1 = num1.length(), n2 = num2.length();
        int[] arr = new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                arr[i+j+1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                arr[i+j] += arr[i+j+1]/10;
                arr[i+j+1] = arr[i+j+1]%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(arr[i] == 0) i++;
        while(i<arr.length) sb.append(arr[i++]); 
        return sb.toString();
    }
}