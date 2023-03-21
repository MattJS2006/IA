package com.company;
import java.util.Random;

public class Database {

    private String filename;
    private int rowWidth;
    private int count;
    private int dataMaxLength;

    public Database(String filename, int rowWidth, int dataMaxLength) {
        this.filename = filename;
        this.rowWidth = rowWidth + (rowWidth/dataMaxLength);
        this.dataMaxLength = dataMaxLength;
        count = FileHandler.countLines(filename);
        correctLength();
    }

    public Database(int rowWidth){
        this.rowWidth = rowWidth;
        Random rand = new Random();
        int n = rand.nextInt(50);
        filename = "newFile" + n;
        count = 0;
    }

    // add a new record to the end of the database
    public void appendRecord(String data) {
        if(data.length() < rowWidth){
            while(data.length() < rowWidth){
                data = data + "#";
            }
            FileHandler.appendLine(filename, data);
            count = count+1;
        } else if(data.length() > rowWidth){
            System.out.println("The data is too long!");
        } else {
            FileHandler.appendLine(filename, data);
            count = count+1;
        }
    }

    // delete the record at the specified row
    public void deleteRecord(int rowNumber) {
        FileHandler.writeLineAt(filename, "", rowNumber);
        count = count-1;
    }

    // return the record at the specified row
    public String getRecord(int rowNumber) {
        int pos = rowNumber*(rowWidth+1);
        return FileHandler.readLineAt(filename,pos);
    }

    // return the number of records in the database
    public int getRecordCount() {
        return count;
    }

    // search for a record matching data
    // return true if found
    public boolean findRecord(String data) {
        if(FileHandler.inFile(filename, data)){
            return true;
        }
        return false;
    }

    public void correctLength(){
        String change;
        for(int i = 0;i < count; i++){
            String data = FileHandler.readLineAt(filename, i);
            if(data.length() < rowWidth){
                int j = 0;
                while(data.length() < rowWidth) {
                    if(dataLength(j,i) == -1){
                        change = "#";
                        String newData = data.substring(0,j) + change + data.substring(j+1);
                        data = newData;
                        j++;
                    } else if(FileHandler.randomRead(filename,((i*rowWidth)+j)) != ' ') {
                        j++;
                    } else if(dataLength(j,i) == 1){
                        change = ",";
                        String newData = data.substring(0,j) + change + data.substring(j+1);
                        data = newData;
                        j++;
                    } else {
                        change = "#";
                        String newData = data.substring(0,j) + change + data.substring(j+1);
                        data = newData;
                        j++;
                    }
                }
                FileHandler.appendLine(filename, data);
            } else if(data.length() > rowWidth){
                System.out.println("The data is too long!");
            } else {
                FileHandler.appendLine(filename, data);
            }
        }
    }

    public int dataLength(int pos, int line){
        if(pos > dataMaxLength){
            if(FileHandler.randomRead(filename,((line*rowWidth)+pos)) != ','){
                return 0;
            }
        }
    }
}
