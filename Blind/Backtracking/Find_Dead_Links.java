import java.util.*;

class DeadLinks {
    private Map<Integer, Boolean> getLinkStatus(Map<Integer, Boolean> active, Map<Integer, List<Integer>> links) {
        int n = active.size();
        boolean[] visited = new boolean[n];
        Map<Integer, Boolean> status = new HashMap<Integer, Boolean>();
        
        for(int i=0; i<n; i++) {
            if(active.get(i))
                dfs(i, visited, active, links, status);
            else
                status.put(i, false);
        }
        
        return status;
    }
    
    private boolean dfs(int src, boolean[] visited, Map<Integer, Boolean> active, Map<Integer, List<Integer>> links, Map<Integer, Boolean> status) {

        if(visited[src]) {
            return status.get(src);
        }
        
        visited[src] = true;
        status.put(src, active.get(src));
        
        for(Integer neighbour : links.get(src)) {
                if(!dfs(neighbour, visited, active, links, status)) {
                    status.put(src, false);
                    return false;
                }
        }
        
        visited[src] = false;
        return active.get(src);
    }
    public static void main(String[] args) {
        DeadLinks w = new DeadLinks();
        Map<Integer, Boolean> active = new HashMap<Integer, Boolean>();
        Map<Integer, List<Integer>> links = new HashMap<Integer, List<Integer>>();
        
        active.put(0, true); active.put(1, true); active.put(2, true);
        active.put(3, true); active.put(4, false);
        
        links.put(0, Arrays.asList(new Integer[]{1,3,4}));
        links.put(1, Arrays.asList(new Integer[]{3}));
        links.put(2, Arrays.asList(new Integer[]{4}));
        links.put(3, Arrays.asList(new Integer[]{0}));
        links.put(4, Arrays.asList(new Integer[]{}));
        
        System.out.println(w.getLinkStatus(active, links));
    }
}