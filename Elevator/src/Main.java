import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static ConcurrentHashMap<Integer, Integer> con = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Java is a powerful language");
        map.put(2, "Java is widely used for backend development");
        map.put(3, "Backend development with Java is popular");
        map.put(4, "Java developers use Spring Boot");
        map.put(5, "Spring Boot makes Java development easier");
        map.put(6, "Java is also used for microservices");
        map.put(7, "Microservices are popular in backend development");
        map.put(8, "Java and Spring Boot work well together");
        map.put(9, "Backend developers often choose Java");
        map.put(10, "Java is a popular backend language");
        countUnique(4, map);
        System.out.println(con.size());
        List<String> result = con.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> "Line "+entry.getKey()+" unique "+entry.getValue())
                .toList();

        result.forEach(System.out::println);

    }

    public static  void countUnique(int num, Map<Integer, String> map){
        ExecutorService executor = Executors.newFixedThreadPool(num);
        for(Map.Entry<Integer, String > entry : map.entrySet()){
            int key = entry.getKey();
            String value = entry.getValue();
            executor.submit(() -> count(key, value));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(20, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static  void count(int lineNumber, String text){

        HashSet<String> set = new HashSet<>();
        text.trim();
        String[] str = text.split("\\s+");
        for(String s : str){
            set.add(s.toLowerCase());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        con.put(lineNumber, set.size());

    }


}
