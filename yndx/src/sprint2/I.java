package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commandCount = Integer.parseInt(reader.readLine());
            int maxQueueSize = Integer.parseInt(reader.readLine());

            MyQueueSized myQueueSized = new MyQueueSized(maxQueueSize);

            for (int i = 0; i < commandCount; i++) {
                String currentCommand = reader.readLine();
                if (currentCommand.equals("peek")) {
                    myQueueSized.peek();
                } else if (currentCommand.equals("size")) {
                    myQueueSized.size();
                } else if (currentCommand.equals("pop")) {
                    myQueueSized.pop();
                } else  {
                    myQueueSized.push(Integer.parseInt(currentCommand.split(" ")[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class MyQueueSized {
    private int maxSize;
    private Integer [] myQueueSized;
    private int tail;
    private int head;
    private int currentSize;
    public MyQueueSized(int maxSize) {
        this.maxSize = maxSize;
        this.myQueueSized = new Integer [maxSize];
        this.tail = 0;
        this.head = 0;
        this.currentSize = 0;
    }

    public void push (int x){
        if (currentSize == maxSize){
            System.out.println("error");
        } else {
            myQueueSized[tail] = x;
            tail = (tail + 1) % maxSize;
            currentSize++;
        }
    }
    public void pop (){
        if (currentSize == 0){
            System.out.println("None");
        } else {
            System.out.println(myQueueSized[head]);
            myQueueSized[head] = null;
            head = (head + 1) % maxSize;
            currentSize--;
        }
    }
    public void size(){
        System.out.println(currentSize);
    }
    public void peek(){
        if (currentSize == 0){
            System.out.println("None");
        } else {
            System.out.println(myQueueSized[head]);
        }
    }
}
