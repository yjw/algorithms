public class Solution {
    public boolean isAbbr(String s, String abbr){
        if(s == null) {
            return abbr == null;
        }
        
        if(s.length() == 0) {
            return abbr.length() == 0;
        }

        abbr += "A";
        int lastCharIdxInAbbr = -1;
        int lastCharIdxInS = -1;
        
        for(int i = 0; i<abbr.length(); i++) {
            if(Character.isLetter(abbr.charAt(i))) {
                String numStr = abbr.substring(lastCharIdxInAbbr + 1, i);
                lastCharIdxInAbbr = i;
                int num = 0;
                if(numStr != null && numStr.length() > 0) {
                    num += Integer.parseInt(numStr);
                }
                
                lastCharIdxInS += 1 + num;
                
                if(i == abbr.length() - 1) {
                    return lastCharIdxInS == s.length();
                }
                else {
                    if(lastCharIdxInS >= s.length()) {
                        return false;
                    }
                    if(s.charAt(lastCharIdxInS)!=abbr.charAt(lastCharIdxInAbbr)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
