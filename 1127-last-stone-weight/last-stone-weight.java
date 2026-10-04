class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            pq.add(i);
        }
        while(pq.size()> 1){
            int a = pq.remove();
            int b = pq.remove();
            if(a!= b){
                pq.add(a-b);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();


    }
}