class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String,List<String>> ans = new HashMap<>();
        for(String s: strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedList = new String(c);
            if(ans.get(sortedList) == null){
                List<String> temp = new ArrayList<>();
                temp.add(s);
                ans.put(sortedList,temp);
            }else{
                List<String> temp = ans.get(sortedList);
                temp.add(s);
                ans.put(sortedList,temp);
            }


        }
        List<List<String>> ansList = new ArrayList<>(ans.values());
        return ansList;
    }
}