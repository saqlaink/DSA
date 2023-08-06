class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0;i<sb.length;i++){
            sb[i] = new StringBuilder("");
        }
        int idx = 0;
        int step = -1;
        for(int i=0;i<s.length();i++){
            sb[idx].append(s.charAt(i));
            if(idx == 0) step=1;
            else if(idx == numRows-1) step=-1;
            idx+=step;
        }
        String res = "";
        for(int i=0;i<sb.length;i++) res+=sb[i];
        return res.toString();
    }
}


// int incre=1;
//     int index=0;
//     for(int i=0;i<s.length();i++){
//         sb[index].append(s.charAt(i));
//         if(index==0){incre=1;}
//         if(index==numRows-1){incre=-1;}
//         index+=incre;
//     }
//     String re="";
//         for(int i=0;i<sb.length;i++){
//             re+=sb[i];
//          }
//         return re.toString();