class Solution
{
    public boolean wordPattern(String pattern, String s) 
    {
        
        String[] words = s.split(" ");

        if(pattern.length() != words.length){
            return false; 
        }

        HashMap<Character, String> map = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char key = pattern.charAt(i);
            String value = words[i];
            if(map.containsKey(key)){
                if(!map.get(key).equals(value)){
                    return false; 
                }
            }
            else{
                if(map.containsValue(value)){
                    return false;
                }
                else{
                    map.put(key, value);
                }
            }
        }

        return true; 
        
    }
}