class Smallest_Common_Region1 {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> map = new HashMap<>();
        for(List<String> list : regions) {
            String parent = list.get(0);
            for(String child : list)
                if(!child.equals(parent))
                    map.put(child, parent);
        }
        List<String> path1 = getPath(region1, map);
        List<String> path2 = getPath(region2, map);
        int i = path1.size() - 1, j = path2.size() - 1;
        String ans = "";
        while(i>=0 && j>=0 && path1.get(i).equals(path2.get(j))) {
            ans = path1.get(i);
            i--;j--;
        }
        return ans;
    }
    private List<String> getPath(String region, Map<String, String> map) {
        List<String> path = new ArrayList<>();
        while(map.containsKey(region)) {
            path.add(region);
            region = map.get(region);
        }
        path.add(region);
        return path;
    }
}