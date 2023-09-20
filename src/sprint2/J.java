package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class J {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commandCount = Integer.parseInt(reader.readLine());

            MyQueueLinked myQueueSized = new MyQueueLinked();

            for (int i = 0; i < commandCount; i++) {
                String currentCommand = reader.readLine();
                if (currentCommand.equals("get")) {
                    myQueueSized.get();
                } else if (currentCommand.equals("size")) {
                    myQueueSized.size();
                } else  {
                    myQueueSized.put(Integer.parseInt(currentCommand.split(" ")[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class MyQueueLinked {
    private List<Integer> queueLinked;
    private int currentSize;
    public MyQueueLinked() {
        this.queueLinked = new LinkedList<>();
        this.currentSize = 0;
    }
    public void get(){
        if (currentSize == 0) {
            System.out.println("error");
        } else {
            System.out.println(queueLinked.remove(0));
            currentSize--;
        }
    }
    public void put(int x){
        queueLinked.add(x);
        currentSize++;
    }

    public void size(){
        System.out.println(currentSize);
    }
}