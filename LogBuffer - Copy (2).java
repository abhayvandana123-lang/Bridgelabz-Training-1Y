import java.util.HashMap;
import java.util.Map;

class LogBuffer {
    static StringBuffer buffer = new StringBuffer();
}

class ServiceThread extends Thread {
    String serviceName;
    int sleepTime;
    Map<String, Integer> stats;

    ServiceThread(String serviceName, int sleepTime, Map<String, Integer> stats) {
        this.serviceName = serviceName;
        this.sleepTime = sleepTime;
        this.stats = stats;
    }

    public void run() {
        String[] levels = {"INFO", "WARNING", "ERROR"};
        for (int i = 1; i <= 10; i++) {
            String level = levels[i % 3];
            String entry = "[" + System.currentTimeMillis() + "] [" + serviceName + "] [" + level + "] Message " + i + "\n";
            LogBuffer.buffer.append(entry);
            synchronized (stats) {
                stats.put(serviceName, stats.getOrDefault(serviceName, 0) + 1);
            }
            try {
                Thread.sleep(sleepTime);
            } catch (Exception e) {
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> stats = new HashMap<>();

        Thread web = new ServiceThread("Web Server", 100, stats);
        Thread db = new ServiceThread("Database Server", 150, stats);
        Thread cache = new ServiceThread("Cache Server", 80, stats);
        Thread api = new ServiceThread("API Gateway", 120, stats);

        web.start();
        db.start();
        cache.start();
        api.start();

        web.join();
        db.join();
        cache.join();
        api.join();

        System.out.println(LogBuffer.buffer.toString());

        int total = 0;
        for (String key : stats.keySet()) {
            int count = stats.get(key);
            total += count;
            System.out.println(key + " Entries: " + count);
        }

        System.out.println("Total Log Size: " + LogBuffer.buffer.length());
    }
}
