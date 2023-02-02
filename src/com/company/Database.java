package com.company;

public class Database {

    private String filename;
    private int rowWidth;
    private int count;

    public Database(String filename, int rowWidth) {
        this.filename = filename;
        this.rowWidth = rowWidth;
        count = FileHandler.countLines(filename);
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

}
