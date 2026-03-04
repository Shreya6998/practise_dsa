package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

public class CourseSchedule {

    public static void main(String[] args) {

        int numCourses1 = 2;
        int[][] pre1 = {{1,0}};
        System.out.println(canFinish(numCourses1, pre1)); // true

        int numCourses2 = 2;
        int[][] pre2 = {{1,0},{0,1}};
        System.out.println(canFinish(numCourses2, pre2)); // false

        int numCourses3 = 4;
        int[][] pre3 = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(canFinish(numCourses3, pre3)); // true
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new ArrayDeque<>();

        // Build adj list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i= 0;i< numCourses;i++)
            adjList.add(new ArrayList<>());

        // Build indegree
        int[] indegree = new int[numCourses];

        // Fill adj list & indegree
        // p[1] -> p[0]
        for(int[] p: prerequisites) {
            adjList.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        for(int i=0;i<numCourses;i++) {
            if(indegree[i]==0)
                queue.add(i);
        }

        // BFS
        int processed = 0;
        while(!queue.isEmpty()) {
            int index = queue.remove();
            processed++;
            for(int i:adjList.get(index)) {
                indegree[i]--;
                if(indegree[i]==0)
                    queue.add(i);
            }
        }
        return processed == numCourses;
    }
}

