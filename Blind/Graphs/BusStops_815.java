class BusStops_815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        int n = routes.length;
        int totalStops = 0;
        
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        for(int i=0; i<routes.length; i++) {
            for(int stop : routes[i]) {
                List<Integer> stops = null;
                if(map.containsKey(stop)) {
                    stops = map.get(stop);
                }else{
                    stops = new ArrayList<Integer>();
                }
                
                stops.add(i);
                map.put(stop, stops);
            }
        }
        
        if(!map.containsKey(source)) return -1;
        
        List<Integer> sourceList = map.get(source);
        q.addAll(sourceList);
        map.put(source, null);
        
        while(!q.isEmpty()) {
            int size = q.size();
            totalStops++;
            
            for(int i=0; i<size; i++) {
                int routeNumber = q.poll();
                int[] route = routes[routeNumber];
                
                if(!visited[routeNumber]) {
                    for(int j=0; j<route.length; j++) {
                        int stopNumber = route[j];
                        if (stopNumber == target) {
                            return totalStops;
                        }

                        if (map.get(stopNumber) != null) {
                            List<Integer> stopList = map.get(stopNumber);
                            map.put(stopNumber, null);
	                        q.addAll(stopList);
                        }
                    }
                    
                    visited[routeNumber] = true;
                }
            }
        }
        
        return -1;
    }
}