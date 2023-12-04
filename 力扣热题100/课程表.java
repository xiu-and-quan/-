package 力扣热题100;

import java.util.*;

/**
 * @Author shizq18
 * @Date 2023/9/18
 * @Description
 */
public class 课程表 {
    public static void main(String[] args) {
        isFinish(2,new int[][]{{0,1}});

    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int length = prerequisites.length;
        // 课程出现的次数，为0说明不需要前置就可以学习，也可以是前置都学完了
        int[] isVisited = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        // 前置课程对应的后续课程
        HashMap<Integer, List<Integer>> prepositionToNext = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            List<Integer> list = prepositionToNext.getOrDefault(start, new ArrayList<>());
            isVisited[end]++;
            list.add(end);
            prepositionToNext.put(start,list);
        }
        // 找到不需要前置学习的课程 加入队列
        for (int i = 0; i < numCourses; i++) {
            if (isVisited[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int startNum = queue.poll();
            count++;
            List<Integer> nextList = prepositionToNext.get(startNum);
            if (nextList != null && !nextList.isEmpty()) {
                for (int e:
                     nextList) {
                    isVisited[e]--;
                    if (isVisited[e] == 0) {
                        queue.add(e);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static boolean isFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> startToEndList = new HashMap<>();
        int[] isPresentCount = new int[numCourses];
        int length = prerequisites.length;
        for (int i = 0; i < length; i++) {
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
            List<Integer> list= startToEndList.getOrDefault(start,new ArrayList<>());
            list.add(end);
            startToEndList.put(start, list);
            isPresentCount[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (isPresentCount[i] == 0) {
                queue.add(i);
            }
        }
        int count = numCourses;
        while (!queue.isEmpty()) {
            int currentElement = queue.poll();
            count--;
            List<Integer> endList = startToEndList.get(currentElement);
            if (endList != null && !endList.isEmpty()) {
                for (int e :
                        endList) {
                    isPresentCount[e]--;
                    if (isPresentCount[e] == 0) {
                        queue.add(e);
                    }
                }
            }
        }
        return count == 0;
    }
}
