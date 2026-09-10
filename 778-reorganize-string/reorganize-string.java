class Solution {
    class Pair{
        char first;
        int count;
        public Pair(char first, int count){
            this.first=first;
            this.count = count;
        }
    }
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->Integer.compare(b.count,a.count));
        int n = s.length();
        Map<Character,Integer> mp = new HashMap<>();
        for(int i =0;i<n;i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        int index = 0;
        mp.forEach((key,value)->pq.add(new Pair(key,value)));
        Pair prev = null;
        String ans = "";
        while(!pq.isEmpty()|| prev != null){
            
            if(pq.isEmpty() && prev != null){
                return "";
            };
            Pair temp = pq.poll();
            ans+=temp.first;
            temp.count = temp.count-1;
            if(prev != null && prev.count >0){
                pq.add(prev);
            }
            if(temp.count != 0)prev = temp;
            else prev = null;
            
            
        }
        return ans;
    }
}