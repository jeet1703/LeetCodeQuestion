class TreeNode{
    int key;
    int val;
    TreeNode next;
    TreeNode prev;
    public TreeNode(int key,int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    
    Map<Integer,TreeNode> mp;
    TreeNode head;
    TreeNode tail;
    int cap;
    
    public LRUCache(int capacity) {
        head = new TreeNode(0,0);
        tail = new TreeNode(0,0);
        mp = new HashMap<>();
        head.next = tail;
        head.prev= null;
        tail.next = null;
        tail.prev = head;
        this.cap = capacity;

    }
    
    public int get(int key) {
       if(mp.get(key) != null){
        TreeNode temp = mp.get(key);
        deleteTheNode(temp);
        addAtHead(temp.key,temp.val);
        return mp.get(key).val;
       }
       return -1;

    }
    
    public void put(int key, int value) {
        if(mp.get(key) != null){
            TreeNode temp = mp.get(key);
            temp.val = value;
            deleteTheNode(temp);
            addAtHead(key,value);
            return;
        }
        if(mp.size() == cap){
            TreeNode temp = tail.prev;
            deleteTheNode(temp);
            mp.remove(temp.key);
        }
        addAtHead(key,value);
    }
    public void deleteTheNode(TreeNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
    public void addAtHead(int key ,int value){
        TreeNode n = new TreeNode(key,value);
        n.next = head.next;
        head.next.prev= n;
        n.prev = head;
        head.next = n;
        mp.put(key,n);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */