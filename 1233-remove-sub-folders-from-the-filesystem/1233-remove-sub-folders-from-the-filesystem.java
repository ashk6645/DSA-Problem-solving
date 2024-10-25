class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        Arrays.sort(folder); // sort the folders
        
        for (String f : folder) {
            boolean isSubfolder = false;
            for (String existingFolder : set) {
                if (f.startsWith(existingFolder + "/")) {
                    isSubfolder = true;
                    break;
                }
            }
            if (!isSubfolder) {
                set.add(f);
                result.add(f);
            }
        }
        
        return result;
    }
}