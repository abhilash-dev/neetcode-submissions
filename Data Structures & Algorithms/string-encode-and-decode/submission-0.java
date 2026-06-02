class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        String separator = "#";

        for(String s: strs){
            int length = s.length();
            sb.append(length);
            sb.append(separator);
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        char separator = '#';
        
        //empty list
        if(str.equals("")){
            return List.of();
        }

        int n = str.length();
        if(n == 2){
            return List.of("");
        }

        List<String> res = new ArrayList<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < n){
            int j = i;

            while(str.charAt(j) != separator){
                sb.append(str.charAt(j));
                j++;
            }

            int length = Integer.valueOf(sb.toString());
            i = j+1;

            // clear stringBuilder()
            sb.setLength(0);
            while(i < j+length+1){
                sb.append(str.charAt(i));
                i++;
            }
            res.add(sb.toString());
            sb.setLength(0);
        }

        return res;
    }
}
