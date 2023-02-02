package com.company;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersistentArrayList {
    String fileName;

    public static void New (String fileName, String text){
        try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, true))) {
            pr.println(text);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(int pos){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            ArrayList<String> array = new ArrayList<String>();
            while (line != null){
                array.add(line);
                line = br.readLine();
            }
            String text = array.get(pos);
            return text;
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public void add(String text){
        try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, true))) {
            pr.println(text);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clear(){
        try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, false))) {
            pr.println("");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int size(){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            int count = 0;
            while (line != null){
                count = count++;
            }
            return count;
        }
        catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }

    public boolean contains(String text){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            ArrayList<String> array = new ArrayList<String>();
            while (line != null){
                array.add(line);
                line = br.readLine();
            }
            int index = array.indexOf(text);
            if (index != -1){
                return true;
            } else {
                return false;
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public int indexOf(String text){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            ArrayList<String> array = new ArrayList<String>();
            while (line != null){
                array.add(line);
                line = br.readLine();
            }
            int index = array.indexOf(text);
            return index;
        }
        catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }
}