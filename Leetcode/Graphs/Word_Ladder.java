import java.util.*;
public class Word_Ladder {

    // Idea : Create a Graph of Strings in O(n2 * len(str))
    //        Perform BFS and return distance
    public Map<String, Set<String>> edges = new HashMap<>();
    public Set<String> vis = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int wl = beginWord.length();
        HashMap<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 1);
        if (!wordList.contains(endWord))
            return 0;
        if (!wordList.contains(beginWord))
            wordList.add(beginWord);

        for (String s : wordList)
            addNode(s);

        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                int cnt = 0;
                String t = wordList.get(j);
                for (int p = 0; p < wl; p++) {
                    if (s.charAt(p) != t.charAt(p))
                        cnt++;
                    if (cnt == 2)
                        break;
                }
                if (cnt == 1)
                    addEdge(s, t);
            }
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        vis.add(beginWord);

        while (!q.isEmpty()) {
            String tmp = q.poll();
            if (tmp.equals(endWord))
                return dist.get(endWord);

            for (String to : edges.get(tmp)) {
                if (!vis.contains(to)) {
                    q.offer(to);
                    dist.put(to, dist.get(tmp) + 1);
                    vis.add(to);
                }
            }
        }

        return dist.getOrDefault(endWord, 0);
    }

    void addNode(String s) {
        if (!edges.containsKey(s))
            edges.put(s, new HashSet<>());
    }

    void addEdge(String s, String t) {
        edges.get(s).add(t);
        edges.get(t).add(s);
    }
}