package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class FileHandler {

    public static void appendLine(String fileName, String data) {
        // write text to end of the file
        try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, true))) {
            pr.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readLineAt(String fileName, int start) {
        // grab the line from position "start" in the file
        try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
            rf.seek(start);
            return rf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeLineAt(String fileName, String data, int start) {
        // overwrite a line from position "start" in the file
        // doesn't check that the start position is actually
        // the beginning of the file. This will not behave well
        // unless every line is the same length
        try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
            rf.seek(start);
            PrintWriter pr = new PrintWriter(new FileWriter(fileName, false));
            pr.println(data);
            pr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countLines(String fileName) {
        // return the number of lines in the file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            int count = 0;
            String line = br.readLine();
            while (line != null){
                count = count++;
                line = br.readLine();
            }
            return count;

        } catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean inFile(String fileName, String data){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = br.readLine();
            while(line != null){
                if(line.equals(data)){
                    return true;
                }
                line = br.readLine();
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static char randomRead(String Filename, int startPos){
        try (RandomAccessFile rf = new RandomAccessFile(Filename,"rws")) {
            rf.seek(startPos);
            char letter = (char)rf.read();
            return letter;
        } catch(IOException e) {
            e.printStackTrace();
            return (char)-1;
        }
    }

    public static void oddCharacters(String Filename){
        try (RandomAccessFile rf = new RandomAccessFile(Filename,"rws")) {
            char letter = (char)rf.read();
            int i = 0;
            while(letter != (char)-1){
                System.out.print(letter);
                i = i+2;
                rf.seek(i);
                letter = (char)rf.read();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeSpace(String Filename){
        try (RandomAccessFile rf = new RandomAccessFile(Filename,"rws")){
            int i = 0;
            char letter = randomRead(Filename,i);
            while(letter != (char)-1){
                if (letter == ' '){
                    rf.seek(i);
                    rf.write('-');
                }
                i++;
                letter = randomRead(Filename,i);
            }
            System.out.print(Filename);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void reverseRead(String Filename){
        int i = -1;
        char letter = randomRead(Filename,i);
        while(letter != (char)-1){
            System.out.print(letter);
            i = i-1;
            letter = randomRead(Filename,i);
        }
    }

    public static String readFromFile(String fileName, int lineNumber) {
        // read and print out the contents of a text file
        // using all the exception handling best practices
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            int count = 0;
            while (count != lineNumber) {
                line = br.readLine();
                count++;
            }
            return line;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeToFile(String fileName, String text, boolean append) {
        // write text to fileName
        // either overwriting (append = false)
        // or appending (append = true)
        // using all the exception handling best practices
        try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, append))) {
            pr.println(text);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void compactFile(String fileName){
        // read the file
        // remove spaces " "
        // overwrite file
        try(PrintWriter pr = new PrintWriter(new FileWriter(fileName,false))){
            try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
                ArrayList<String> array = new ArrayList<String>();
                String line = br.readLine();
                while(line != null){
                    array.add(line);
                    line = br.readLine();
                }
                ArrayList<String> newArray = new ArrayList<String>();
                for(int i=0; i<array.size(); i++){
                    String newLine = array.get(i);
                    String replaceLine = newLine.replace(" ","");
                    newArray.add(replaceLine);
                }
                for(int i=0; i<newArray.size(); i++){
                    pr.println(newArray.get(i));
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
