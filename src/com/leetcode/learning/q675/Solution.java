package com.leetcode.learning.q675;

import java.util.*;

public class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        //判断起点是否能够通行
        if (forest.size() == 0){
            return -1;
        }

        if(forest.get(0).get(0) == 0){
            return -1;
        }


        LinkedList<SNode> targetList = new LinkedList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j< forest.get(i).size(); j++){
                if(forest.get(i).get(j) > 1){
                    targetList.add(new SNode(i,j,forest.get(i).get(j)));
                }
            }
        }
        //先对整个target排序
        targetList.sort(new Comparator<SNode>() {
            @Override
            public int compare(SNode sNode1, SNode sNode2) {
                return sNode1.no - sNode2.no;
            }
        });

        int sum = 0;
        SNode start = new SNode(0, 0, forest.get(0).get(0));
        for(int i = 0;i< targetList.size();i++) {
            int step = gogogo(forest, start, targetList.get(i));
            if(step == -1){
                return -1;
            }else{
                sum += step;
                start = targetList.get(i);
            }
        }


        return sum;
    }

    /**
     * 使用A*算法
     * @param forest 整个地图
     * @param cur 当前位置
     * @param target 目标位置
     * @return  -1 表示无法到达，0表示cur和target是同一个点，>0表示最小步数
     */
    private int gogogo(List<List<Integer>> forest, SNode cur, SNode target) {

        List<CalNode> openCalNodeList = new ArrayList<>();

        Set<CalNode> closedCalNodeSet = new HashSet<>();

        //将起点放入open list中
        openCalNodeList.add(new CalNode(cur.x, cur.y, Math.abs(target.x-cur.x)+Math.abs(target.y - cur.y), 0, 0));

        int sum = -1;

        while (openCalNodeList.size()>0){
            CalNode closeCalNode = openCalNodeList.get(0);
            if (closeCalNode.x == target.x && closeCalNode.y == target.y){
                //找到终点，结束循环；
                CalNode tmp = closeCalNode;
                while (tmp != null){
                    sum ++;
                    System.out.println(tmp);
                    tmp = tmp.parent;
                }
                break;
            }else {
                closedCalNodeSet.add(closeCalNode);
                openCalNodeList.remove(0);

                //遍历closeCalNode的四个方向节点
                //up
                if (closeCalNode.x - 1 >= 0 && forest.get(closeCalNode.x-1).get(closeCalNode.y) > 0){
                    if(!closedCalNodeSet.contains(new CalNode(closeCalNode.x-1, closeCalNode.y, 0, 0))) {
                        CalNode upCalNode = new CalNode(closeCalNode.x - 1, closeCalNode.y, Math.abs(target.x - closeCalNode.x + 1) + Math.abs(target.y - closeCalNode.y), closeCalNode.gval + 1);
                        if(!openCalNodeList.contains(upCalNode)){
                            upCalNode.parent = closeCalNode;
                            openCalNodeList.add(upCalNode);
                        }else{
                            if(upCalNode.gval < openCalNodeList.get(openCalNodeList.indexOf(upCalNode)).gval){
                                openCalNodeList.get(openCalNodeList.indexOf(upCalNode)).gval = upCalNode.gval;
                                openCalNodeList.get(openCalNodeList.indexOf(upCalNode)).fval = openCalNodeList.get(openCalNodeList.indexOf(upCalNode)).gval + openCalNodeList.get(openCalNodeList.indexOf(upCalNode)).hval;
                                openCalNodeList.get(openCalNodeList.indexOf(upCalNode)).parent = closeCalNode;
                            }
                        }
                    }
                }
                //right
                if (closeCalNode.y + 1 < forest.get(closeCalNode.x).size() && forest.get(closeCalNode.x).get(closeCalNode.y + 1) > 0){
                    if(!closedCalNodeSet.contains(new CalNode(closeCalNode.x, closeCalNode.y+1, 0, 0))) {
                        CalNode rightCalNode = new CalNode(closeCalNode.x, closeCalNode.y + 1, Math.abs(target.x - closeCalNode.x) + Math.abs(target.y - closeCalNode.y - 1), closeCalNode.gval + 1);
                        if(!openCalNodeList.contains(rightCalNode)) {
                            rightCalNode.parent = closeCalNode;
                            openCalNodeList.add(rightCalNode);
                        }else{
                            if(rightCalNode.gval < openCalNodeList.get(openCalNodeList.indexOf(rightCalNode)).gval){
                                openCalNodeList.get(openCalNodeList.indexOf(rightCalNode)).gval = rightCalNode.gval;
                                openCalNodeList.get(openCalNodeList.indexOf(rightCalNode)).fval = openCalNodeList.get(openCalNodeList.indexOf(rightCalNode)).gval + openCalNodeList.get(openCalNodeList.indexOf(rightCalNode)).hval;
                                openCalNodeList.get(openCalNodeList.indexOf(rightCalNode)).parent = closeCalNode;
                            }
                        }
                    }
                }
                //down
                if (closeCalNode.x + 1 < forest.size() && forest.get(closeCalNode.x + 1).get(closeCalNode.y) > 0){
                    if(!closedCalNodeSet.contains(new CalNode(closeCalNode.x + 1, closeCalNode.y, 0, 0))) {
                        CalNode downCalNode = new CalNode(closeCalNode.x + 1, closeCalNode.y, Math.abs(target.x - closeCalNode.x - 1) + Math.abs(target.y - closeCalNode.y), closeCalNode.gval + 1);
                        if(!openCalNodeList.contains(downCalNode)) {
                            downCalNode.parent = closeCalNode;
                            openCalNodeList.add(downCalNode);
                        }else{
                            if(downCalNode.gval < openCalNodeList.get(openCalNodeList.indexOf(downCalNode)).gval){
                                openCalNodeList.get(openCalNodeList.indexOf(downCalNode)).gval = downCalNode.gval;
                                openCalNodeList.get(openCalNodeList.indexOf(downCalNode)).fval = openCalNodeList.get(openCalNodeList.indexOf(downCalNode)).gval + openCalNodeList.get(openCalNodeList.indexOf(downCalNode)).hval;
                                openCalNodeList.get(openCalNodeList.indexOf(downCalNode)).parent = closeCalNode;
                            }
                        }
                    }
                }
                //left
                if (closeCalNode.y -1 >= 0 && forest.get(closeCalNode.x).get(closeCalNode.y - 1) > 0){
                    if(!closedCalNodeSet.contains(new CalNode(closeCalNode.x, closeCalNode.y - 1, 0, 0))) {
                        CalNode leftCalNode = new CalNode(closeCalNode.x, closeCalNode.y - 1, Math.abs(target.x - closeCalNode.x) + Math.abs(target.y - closeCalNode.y + 1), closeCalNode.gval + 1);
                        if(!openCalNodeList.contains(leftCalNode)) {
                            leftCalNode.parent = closeCalNode;
                            openCalNodeList.add(leftCalNode);
                        }else{
                            if(leftCalNode.gval < openCalNodeList.get(openCalNodeList.indexOf(leftCalNode)).gval){
                                openCalNodeList.get(openCalNodeList.indexOf(leftCalNode)).gval = leftCalNode.gval;
                                openCalNodeList.get(openCalNodeList.indexOf(leftCalNode)).fval = openCalNodeList.get(openCalNodeList.indexOf(leftCalNode)).gval + openCalNodeList.get(openCalNodeList.indexOf(leftCalNode)).hval;
                                openCalNodeList.get(openCalNodeList.indexOf(leftCalNode)).parent = closeCalNode;
                            }
                        }
                    }
                }

                //从新进行一次排序
                openCalNodeList.sort(new Comparator<CalNode>() {
                    @Override
                    public int compare(CalNode calNode1, CalNode calNode2) {
                        return calNode1.fval - calNode2.fval;
                    }
                });
            }

        }

        return sum;
    }


    class SNode {
        int x;
        int y;
        int no;
        SNode(int x, int y, int no){
            this.x = x;
            this.y = y;
            this.no = no;
        }
    }

    static class CalNode {
        int hval;
        int gval;
        int fval;
        int x;
        int y;
        CalNode parent;

        CalNode(int x, int y, int hval, int gval){
            this.x = x;
            this.y = y;
            this.hval = hval;
            this.gval = gval;
            this.fval = hval + gval;
        }

        CalNode(int x, int y, int hval, int gval, int fval){
            this.x = x;
            this.y = y;
            this.hval = hval;
            this.gval = gval;
            this.fval = fval;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CalNode calNode = (CalNode) o;
            return x == calNode.x &&
                    y == calNode.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "CalNode{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
