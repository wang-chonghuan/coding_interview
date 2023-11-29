package org.B_StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 346 moving average from data stream
 * given a stream of integers and a window size
 * calculate the moving average of all integers in the sliding window
 *
 * implement the movingAverage class:
 * MovingAverage(int size) initializes the object with the size of the window size.
 * double next(int val) returns the moving average of the last size values of the stream
 */
public class QueueE1N346 {
    private class MovingAverage {
        final private Deque<Integer> dq = new LinkedList<>();
        private int size;
        private double sum;

        MovingAverage(int size) {
            this.size = size;
            this.sum = 0;
        }

        public double next(int val) {
            dq.addLast(val);
            sum += val;
            while (dq.size() > size) {
                sum -= dq.removeFirst();
            }
            return sum / dq.size();
        }
    }
}
