package com.company;

import org.apache.poi.ss.formula.functions.T;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Read2 read2 = new Read2();
        Read read = new Read();
        read.ReadData();
        read2.ReadData2();
        Compare compare = new Compare();
        compare.check(read.getResult(),read2.getResult2());
        compare.studentnotsubmitted(read.getResult(),read2.getResult2());
        Excel excel= new Excel();
        excel.WriteToExcel(compare.getstudentSub(),compare.getstudentNotSub());

    }
}
