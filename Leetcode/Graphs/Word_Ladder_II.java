package Leetcode.Graphs;
import java.util.*;
/*         Idea:
                In the problem Word Ladder, we had to find the shortest distance which was
                achieved using a BFS. In that problem, since only the shortest distance was
                asked we used to update our visited array as soon as we found an unvisited node.

                However, for this problem, since we need to find all shortest paths, it
                is better to update the visited array when that node is popped out of the
                queue to be explored. Moreover, if we do this, we might get some longer sequences
                that end with the endWord too, but to solve this issue, we will only append to
                final result if the seq length is == the seq length of the first found sequence.
*/

public class Word_Ladder_II {
    public Map<String, Set<String>> edges = new HashMap<>();
    public Set<String> vis = new HashSet<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> res = new ArrayList<>();
        int wl = beginWord.length();
        
        if(!wordList.contains(endWord))return res;
        if(!wordList.contains(beginWord))wordList.add(beginWord);
        
        for(String s: wordList) addNode(s);
        


        for(int i = 0; i<wordList.size(); i++)
        {
            String s = wordList.get(i);
            for(int j = i+1; j< wordList.size(); j++)
            {
                int cnt = 0;
                String t = wordList.get(j);
                for(int p = 0; p < wl; p++)
                {
                    if(s.charAt(p)!=t.charAt(p))cnt++;
                    if(cnt==2) break;
                }
                if(cnt==1)addEdge(s,t);
            }
        }
        
        Queue<String> q = new LinkedList<>();
        Queue<ArrayList<String>> seqs = new LinkedList<>();
        
        q.offer(beginWord);
        ArrayList<String> curr = new ArrayList<>();
        curr.add(beginWord);
        seqs.offer(curr);
        
        int mini = Integer.MAX_VALUE/2;
        while(!q.isEmpty())
        {
           
            String tmp = q.poll();
            vis.add(tmp);
            ArrayList<String> tmpseq = seqs.poll();
            
            if(tmp.equals(endWord) && tmpseq.size()<=mini)
            {
                mini = Math.min(mini, tmpseq.size());
                res.add(tmpseq);
                continue;
            }
            for(String to : edges.get(tmp))
            {
                if(!vis.contains(to))
                {
                    q.offer(to);
                    curr = new ArrayList<>(tmpseq);
                    curr.add(to);
                    seqs.offer(curr);   
                }
            }
        }
        
        return res;
    }
   
    void addNode(String s)
    {
        if(!edges.containsKey(s))
            edges.put(s, new HashSet<>()); 
    }
    void addEdge(String s, String t)
    {
        edges.get(s).add(t);
        edges.get(t).add(s);
    }
}
