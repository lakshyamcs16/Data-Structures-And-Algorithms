import java.util.*;

public class SingleThreadedCPU_1834 {
    // a node to hold the status of current task along with its original index
    class Node {
        int[] task;
        int index;

        Node(int[] t, int i) {
            task = t;
            index = i;
        }

        public String toString() {
            return Arrays.toString(task) + " : " + index;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];

        Node[] nodes = new Node[n];

        // store tasks with its original index
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(tasks[i], i);
        }

        // sort the array based on task's arrival time, if two or more tasks arrive at
        // the same time, use index to resolve conflicts
        // this can be easily avoided, but can't think of a solution better than
        // O(NlogN) so, this does not affect the overall TC.
        // but sorting makes it easier to understand the solution
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.task[0] == n2.task[0] ? n1.index - n2.index : n1.task[0] - n2.task[0];
            }
        });

        // Keep a min heap to get the task with shortest burst time, if two available
        // tasks have the same burst time,
        // resolve conflicts based on index
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.task[1] == n2.task[1] ? n1.index - n2.index : n1.task[1] - n2.task[1];
            }
        });

        // time variable to keep track of current cpu time
        int time = nodes[0].task[0];
        int i = 0, j = 0;

        // keep going until all the tasks are enqueued
        while (i < n) {

            // if at any time, there are no available tasks to schedule next within the
            // current time-frame
            // jump the timer to the next available task in the input and continue the
            // process
            if (pq.isEmpty() && time < nodes[i].task[0]) {
                pq.offer(nodes[i]);
                time = nodes[i].task[0];
                i++;
            }

            // keep add the tasks to the queue that are within the current time-frame
            while (i < n && nodes[i].task[0] <= time) {
                pq.offer(nodes[i]);
                i++;
            }

            // execute the task with shortest time from the enqueued tasks
            // and update the time to current time + process's burst time
            Node node = pq.poll();
            res[j++] = node.index;
            time += node.task[1];
        }

        // all the tasks have been enqueued, so just pick the tasks based on given
        // policy
        // as all the tasks are already in the queue, we don't care about the cpu time
        // anymore, just the burst time or index (to resolve conflicts)
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            res[j++] = node.index;
        }

        // return the resultant array
        return res;
    }
}
