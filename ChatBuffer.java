import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class ChatBuffer {
    static StringBuffer buffer = new StringBuffer();
}

class Analytics {
    static Map<String, Integer> mentionCount = new ConcurrentHashMap<>();
    static Map<String, Integer> hashtagCount = new ConcurrentHashMap<>();
    static int totalMessages = 0;
    static int totalLength = 0;
    static String longestMessage = "";
    static String shortestMessage = null;
    static long startTime = System.currentTimeMillis();
}

class UserThread extends Thread {
    String user;
    String[] messages;

    UserThread(String user, String[] messages) {
        this.user = user;
        this.messages = messages;
    }

    public void run() {
        for (String msg : messages) {
            processMessage(user, msg);
            try {
                ChatBuffer.buffer.append(user + " is typing...\n");
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }

    void processMessage(String user, String msg) {
        StringTokenizer st = new StringTokenizer(msg, " ");
        StringBuilder formatted = new StringBuilder();
        int wordCount = 0;

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            wordCount++;

            if (token.startsWith("@")) {
                formatted.append("**").append(token).append("** ");
                Analytics.mentionCount.put(token, Analytics.mentionCount.getOrDefault(token, 0) + 1);
            } else if (token.startsWith("#")) {
                formatted.append("*").append(token).append("* ");
                Analytics.hashtagCount.put(token, Analytics.hashtagCount.getOrDefault(token, 0) + 1);
            } else if (token.startsWith("/")) {
                formatted.append("[CMD: ").append(token.substring(1)).append("] ");
            } else {
                formatted.append(token).append(" ");
            }
        }

        String time = "[" + System.currentTimeMillis() + "]";
        String finalMsg = time + " " + user + ": " + formatted.toString().trim() +
                " (Chars:" + msg.length() + ", Words:" + wordCount + ")\n";

        synchronized (ChatBuffer.buffer) {
            ChatBuffer.buffer.append(finalMsg);
        }

        synchronized (Analytics.class) {
            Analytics.totalMessages++;
            Analytics.totalLength += msg.length();
            if (msg.length() > Analytics.longestMessage.length()) Analytics.longestMessage = msg;
            if (Analytics.shortestMessage == null || msg.length() < Analytics.shortestMessage.length())
                Analytics.shortestMessage = msg;
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        String[] m1 = {"Hello @Bob #Java", "/help me", "Working on #Project", "@Charlie check this", "Done!"};
        String[] m2 = {"Hey @Alice", "Using #SpringBoot", "Nice!", "#Java is cool", "See you"};
        String[] m3 = {"Hi all", "@Alice thanks", "/join #Java", "Learning #Programming", "Great!"};

        Thread t1 = new UserThread("Alice", m1);
        Thread t2 = new UserThread("Bob", m2);
        Thread t3 = new UserThread("Charlie", m3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(ChatBuffer.buffer.toString());

        String topMention = Collections.max(Analytics.mentionCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        String topHashtag = Collections.max(Analytics.hashtagCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        long duration = System.currentTimeMillis() - Analytics.startTime;

        System.out.println("Total Messages: " + Analytics.totalMessages);
        System.out.println("Most Mentioned User: " + topMention);
        System.out.println("Most Used Hashtag: " + topHashtag);
        System.out.println("Average Message Length: " + (Analytics.totalLength / (double) Analytics.totalMessages));
        System.out.println("Longest Message: " + Analytics.longestMessage);
        System.out.println("Shortest Message: " + Analytics.shortestMessage);
        System.out.println("Conversation Duration: " + duration);
    }
}
