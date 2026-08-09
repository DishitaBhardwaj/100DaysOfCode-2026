import java.util.PriorityQueue;

public class Question1_Leetcode {
	public int[] getFinalState(int[] nums, int k, int multiplier) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] != b[0]) {
				return Integer.compare(a[0], b[0]);
			}
			return Integer.compare(a[1], b[1]);
		});

		for (int i = 0; i < nums.length; i++) {
			pq.offer(new int[] {nums[i], i});
		}

		for (int i = 0; i < k; i++) {
			int[] current = pq.poll();
			current[0] *= multiplier;
			nums[current[1]] = current[0];
			pq.offer(current);
		}

		return nums;
	}
}
