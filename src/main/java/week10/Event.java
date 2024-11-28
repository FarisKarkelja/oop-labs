package week10;

import java.util.*;
import java.io.*;

public class Event {
    public void generateEventsFile(String fileName, int numberOfRecords) throws IOException {
        String eventTypes[] = {"Login", "Logout", "Purchase", "ViewPage", "Error"};
        Random random = new Random();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < numberOfRecords; i++) {
            String timestamp = String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    random.nextInt(25) + 2000,
                    random.nextInt(12) + 1,
                    random.nextInt(28) + 1,
                    random.nextInt(24),
                    random.nextInt(60),
                    random.nextInt(60)
            );
            String eventType = eventTypes[random.nextInt(eventTypes.length)];
            int userId = random.nextInt(1000);
            writer.write(timestamp + " | Event Type: <" + eventType + "> | User ID: <" + userId + ">" + "\n");
        }
        writer.close();
    }

    public static void printEventsFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String temp;
        while ((temp = reader.readLine()) != null) {
            System.out.println(temp);
        }
        reader.close();
    }

    public static ArrayList<String> readEventsFromFile(String fileName) throws IOException {
        ArrayList<String> events = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String temp;
        while ((temp = reader.readLine()) != null) {
            events.add(temp);
        }
        reader.close();
        return events;
    }

    public static void main(String[] args) throws IOException {
        Event event = new Event();
        event.generateEventsFile("events.txt", 5);
        printEventsFromFile("events.txt");
        ArrayList<String> events = readEventsFromFile("events.txt");
        System.out.println();
        for(String e : events){
            System.out.println(e);
        }
    }
}
