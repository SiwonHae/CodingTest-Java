class MyCircularQueue {
    int[] queue;
    int front;
    int rear;
    int length;

    public MyCircularQueue(int k) {
        queue = new int[k];
        front = 0;
        rear = -1;
        length = 0;
    }
    
    public boolean enQueue(int value) {
        if (!isFull()) {
            rear = (rear + 1) % queue.length;
            queue[rear] = value;
            length++;
            return true;
        }

        return false;
    }
    
    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % queue.length;
            length--;
            return true;
        }

        return false;
    }
    
    public int Front() {
        if (!isEmpty()) {
            return queue[front];
        }

        return -1;
    }
    
    public int Rear() {
        if (!isEmpty()) {
            return queue[rear];
        }

        return -1;
    }
    
    public boolean isEmpty() {
        return length == 0;
    }
    
    public boolean isFull() {
        return length == queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */