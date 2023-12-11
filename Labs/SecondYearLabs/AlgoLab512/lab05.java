package DataLabs2;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class lab05 {

	public static void main(String[] args) {
		Solution ss=new Solution();
		char[] ch={'A','A','B','B','C','C','D'};
		System.out.println(ss.leastInterval(ch,2));
	}

}

class Solution {
	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : tasks) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		pq.addAll(map.values());

		Queue<AbstractMap.SimpleEntry<Integer, Integer>> q = new LinkedList<>();
		int time = 0;

		while (!pq.isEmpty() || !q.isEmpty()) {
			time++;

			if (!pq.isEmpty()) {
				int cnt = pq.poll() - 1;

				if (cnt != 0) {
					q.offer(new AbstractMap.SimpleEntry<>(cnt, time + n));
				}
			}

			if (!q.isEmpty() && q.peek().getValue() == time) {
				pq.offer(q.poll().getKey());
			}
		}

		return time;
	}

}
