class MyHashSet {
    private boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
        
    }
    
    public void add(int key) {
        if(key>=0 && key<set.length)
        {
            set[key] = true;
        }
        
    }
    
    public void remove(int key) {
        if(key>=0 && key<set.length)
        {
            set[key] = false;
        }
        
    }
    
    public boolean contains(int key) {
        return key>=0 && key<set.length && set[key];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */