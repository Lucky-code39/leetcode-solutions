class LRUCache {

   class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
   }
   Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    HashMap<Integer, Node> map;
    
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
       
        head.next = tail;
    tail.prev = head;
    }

    private void addNode(Node node){
     node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev  = prev;
    }

    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }

    private Node removeLRU(){
     Node lru = tail.prev;
      removeNode(lru);
     return lru;
    }

    
    
    public int get(int key) {
         if(!map.containsKey(key)) return -1;


         else{
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
         }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        }
        else{
            Node node = new Node(key, value);
            map.put(key, node);
            addNode(node);

            if(map.size() > capacity){
               Node lru = removeLRU();
               map.remove(lru.key);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
