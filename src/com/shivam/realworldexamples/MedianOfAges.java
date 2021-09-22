package com.shivam.realworldexamples;

import java.util.PriorityQueue;

public class MedianOfAges {
  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;

  public MedianOfAges(){
    minHeap = new PriorityQueue<>((a,b) -> a-b);
    maxHeap = new PriorityQueue<>((a,b) -> b-a);
  }

  public void insertNum(int num){
    if(maxHeap.isEmpty() || maxHeap.peek() >= num){
      maxHeap.add(num);
    } else {
      minHeap.add(num);
    }
    if(maxHeap.size() > minHeap.size() +1){
      minHeap.add(maxHeap.poll());
    } else if(maxHeap.size() < minHeap.size()){
      maxHeap.add(minHeap.poll());
    }
  }

  public double findMedian(){
    if(minHeap.size() == maxHeap.size()){
      return minHeap.peek()/2.0 + maxHeap.peek()/2.0;
    }
    return maxHeap.peek();
  }
  public static void main(String[] args) {
    // Driver code

    MedianOfAges MedianOfAges = new MedianOfAges();
    MedianOfAges.insertNum(22);
    MedianOfAges.insertNum(35);
    System.out.println("The recommended content will be for ages under: " + MedianOfAges.findMedian());
    MedianOfAges.insertNum(30);
    System.out.println("The recommended content will be for ages under: " + MedianOfAges.findMedian());
    MedianOfAges.insertNum(25);
    System.out.println("The recommended content will be for ages under: " + MedianOfAges.findMedian());
  }
}
