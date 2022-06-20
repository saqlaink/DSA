// 4. Find Median from Data Stream
   
// The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.


class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    boolean even;
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        even = true;
    }
    public void addNum(int num) {
        if (even) {
        large.offer(num);
        small.offer(large.poll());
        } else {
        small.offer(num);
        large.offer(small.poll());
        }
        even = !even;
    }
    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }
}