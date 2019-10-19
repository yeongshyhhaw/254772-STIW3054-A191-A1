package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Data> result= new ArrayList<Data>();;
    private static ArrayList<Data> result2 = new ArrayList<Data>();
    public static void main(String[] args) throws IOException {
        Read2 read2 = new Read2();
        Read read = new Read();
        result2 = read2.ReadData2();
        result = read.ReadData();

        Compare compare = new Compare();
        compare.Compare(result,result2);

        Excel excel= new Excel();
        excel.WriteToExcel(result,result2);

    }
}
