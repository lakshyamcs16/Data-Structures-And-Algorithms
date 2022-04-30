class UnionFind {
    Map<String, String> parents;
    Map<String, Integer> ranks;
    
    UnionFind(List<String> nodes) {
        parents = new HashMap<String, String>();
        ranks   = new HashMap<String, Integer>();

        for(String node : nodes) {
            parents.put(node, null);
            ranks.put(node, 0);
        }
    }
    
    public String find(String node) {
        if (parents.get(node) == null) {
            return node;
        }
        String parent = find(parents.get(node));
        parents.put(node, parent);
        return parent;
    }
    
    public void union(String n1, String n2) {
        String p1 = find(n1);
        String p2 = find(n2);
        
        if (ranks.get(p1) > ranks.get(p2)) {
            parents.put(p2, p1);
        } else if (ranks.get(p1) < ranks.get(p2)) {
            parents.put(p1, p2);
        } else {
            parents.put(p2, p1);
            ranks.put(p1, ranks.get(p2) + 1);
        }
        
    }
    
    public void printUF() {
        for(Map.Entry<String, String> entry : parents.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
