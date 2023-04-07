import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class UnicodeWriter {
    public UnicodeWriter(){

    }

    public static void main(String[] args) {
        String filename_8 = "unicode_UTF-8.txt";
        String filename_16 = "unicode_UTF-16.txt";
        //System.out.println(filename.substring(1,3));
        List<String> words = Arrays.asList("line1", "line2", "隨時調整");
        writeUnicodeClassic("unicode_5_UTF-16.txt", words);
        writeUnicodeJava7("unicode_7_UTF-16.txt", words);
        writeUnicodeJava8("unicode_8_UTF-16.txt", words);
        writeUnicodeJava11("unicode_11_UTF-16.txt", words);
    }

    private static void writeUnicodeJava11(String filename_16, List<String> words) {
        try {
            FileWriter fileWriter = new FileWriter(new File(filename_16), StandardCharsets.UTF_8);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            words.stream().forEach(word -> {
                try {
                    writer.write(word);
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeUnicodeJava8(String filename_16, List<String> list) {
        Path path = Paths.get(filename_16);
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
            for(String word : list){
                bufferedWriter.append(word);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeUnicodeJava7(String filename, List<String> list){
        Path path = Paths.get(filename);
        try {
            Files.write(path, list, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void writeUnicodeClassic(String filename, List<String> list){
        File file = new File(filename);
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        ) {
            for(String word : list){
                bufferedWriter.append(word);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
        }

    }
}
