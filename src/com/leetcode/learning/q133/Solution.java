package com.leetcode.learning.q133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private Map<Integer, Node> dict = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(null == node){
            return null;
        }

        if(!dict.containsKey(node.val)){
            dict.put(node.val, new Node(node.val, null));
        }

        Node cNode = dict.get(node.val);

        if(node.neighbors != null){
            List<Node> selfNeighbor = new ArrayList<>();
            for (Node ne: node.neighbors){
                if(!dict.containsKey(ne.val)){
                    dict.put(ne.val, cloneGraph(ne));
                }
                selfNeighbor.add(dict.get(ne.val));
            }
            cNode.neighbors = selfNeighbor;
        }

        return cNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.cloneGraph(null);
    }
}
