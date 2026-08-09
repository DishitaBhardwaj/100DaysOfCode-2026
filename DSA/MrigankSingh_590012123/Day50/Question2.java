import java.util.PriorityQueue;

public class Question2 {
	public int lastStoneWeight(int[] rocks) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

		for (int rock : rocks) {
			maxHeap.offer(rock);
		}

		while (maxHeap.size() > 1) {
			int heaviest = maxHeap.poll();
			int secondHeaviest = maxHeap.poll();

			if (heaviest != secondHeaviest) {
				maxHeap.offer(heaviest - secondHeaviest);
			}
		}

		return maxHeap.isEmpty() ? 0 : maxHeap.poll();
	}
}
