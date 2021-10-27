package com.extra.something.java.features;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.System.out;

public class Java11 {


    private static final String JSON = new StringBuilder().append("""
            {
              "name": "Extra Something",
              "Example": "Java11"
            }
            """).toString();

    public static void mainJava11(String[] args) throws IOException, InterruptedException {


        // 1. String has more functionality than before: isBlank, lines, strip, stripLeading, stripTrailing, and repeatExample.
        String stringWithJava11 = "With Java 11 \n String has more functionality \n than before ";
        List<String> lines = stringWithJava11.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());

        out.println(lines); //[With Java 11, String has more functionality, than before]

        String isBlankExample = "";
        out.println(isBlankExample.isBlank()); // true

        String repeatExample = "repeatExample ";
        out.println(repeatExample.repeat(5)); // repeatExample repeatExample repeatExample repeatExample repeatExample

        //2. File has more functionality than before: readString and writeString
        Path filePath = Files.writeString(Files.createTempFile(Path.of("/Users/walidelsayedaly/Desktop/JavaInnovations"), "demo", ".txt"), "File has more functionality than before: readString and writeString");
        String fileContent = Files.readString(filePath);
        out.println(fileContent); //File has more functionality than before: readString and writeString

        //3. Collection to Array: toArray
        List<String> sampleList = Arrays.asList("Java", "Go", "Kotlin");
        String[] sampleArray = sampleList.toArray(String[]::new);
        out.println(Arrays.toString(sampleArray)); //[Java, Go, Kotlin]

        //4. HTTP client becomes a standard feature in Java11

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        // GET Example
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:" + "8080"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        // POST Example
        httpRequest = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(JSON))
                .uri(URI.create("http://localhost:" + "8080"))
                .build();
        httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());


    }


}
