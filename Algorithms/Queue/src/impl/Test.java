package impl;

public class Test {

    public static void main(String[] args) throws Exception {
        System.out.println("\n******** QUEUE ********");
        QueueImpl<String> strQueue = new QueueImpl<>();
        strQueue.push("teststr1");
        strQueue.push("teststr2");
        strQueue.push("teststr3");
        System.out.println(strQueue.pop());
        System.out.println(strQueue.pop());
    }
}
