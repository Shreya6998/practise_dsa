package Graph;

import java.util.*;

public class CourseScheduleII{

    public static void main(String[] args) {

        int numCourses1 = 2;
        int[][] pre1 = {{1,0}};
        System.out.println(Arrays.toString(findOrder(numCourses1, pre1)));
        // Expected: [0,1]

        int numCourses2 = 4;
        int[][] pre2 = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(findOrder(numCourses2, pre2)));
        // Expected: [0,1,2,3] or [0,2,1,3]

        int numCourses3 = 2;
        int[][] pre3 = {{1,0},{0,1}};
        System.out.println(Arrays.toString(findOrder(numCourses3, pre3)));
        // Expected: []
    }

    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        //Build Adjacency List
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adjList.add(new ArrayList<>());

        //Build indegree
        int[] indegree = new int[numCourses];

        //Fill indegree and adjList
        // p[1] --> p[0]
        for(int[] p: prerequisites) {
            indegree[p[0]]++;
            adjList.get(p[1]).add(p[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] output = new int[numCourses];
        int processed = 0;

        for(int i=0; i<numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                output[processed] = i;
                processed++;

            }
        }

        //BFS
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            for(int i:adjList.get(curr)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.add(i);
                    output[processed] = i;
                    processed++;
                }
            }
        }

        return processed == numCourses? output : new int[0];
    }
}

