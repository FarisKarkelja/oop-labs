package week10;

import java.util.*;
import java.io.*;
import java.lang.*;

class Event {
    public void generateEventsFile(String filename, int records) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String eventTypes[] = {"Login", "Logout", "Purchase", "ViewPage", "Error"};
            Random random = new Random();
            for (int i = 0; i < records; i++) {
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
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printEventsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<String> readEventsFromFile(String filename) {
        ArrayList<String> content = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return content;
    }
}

class MainCode {
    public static void main(String[] args) {
        Event event = new Event();
        event.generateEventsFile("events.txt", 2);
        Event.printEventsFromFile("events.txt");
        ArrayList<String> events = Event.readEventsFromFile("events.txt");
        System.out.println();
        for (String e : events) {
            System.out.println(e);
        }
    }
}

