class Solution {
    public int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currChar){
                index++;
                count++;
            }
            chars[indexAns++] = currChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray()) 
                    chars[indexAns++] = c;
        }
        return indexAns;
    }
}