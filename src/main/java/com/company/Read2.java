package com.company;


import org.apache.poi.ss.formula.functions.Na;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Read2 {
    private final ArrayList<Data> result2 = new ArrayList<Data>();
    public  ArrayList<Data>  ReadData2() throws IOException {
        try {
            String URL = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
            Document doc = Jsoup.connect(URL).get();
            String tittle = doc.title();
            System.out.printf("%66s", tittle + "\n");
            System.out.println("-----------------------------------------------------------------------------------------");
            Elements trs = doc.getElementsByClass("markdown-body" );
            org.jsoup.select.Elements rows = trs.select("div");
            String name="";
            for (int i = 1; i <= 35; i++) {
                Elements Matric= doc.select(" tbody > tr:nth-child(" + i + ") > td:nth-child(2)");
                Elements Name= doc.select(" tbody > tr:nth-child(" + i + ") > td:nth-child(3)");
                System.out.printf("%2d", i);
                System.out.print(" :");
                System.out.printf(""+Matric.text().trim());
                System.out.print("    ");
                System.out.printf(""+Name.text().trim() + "\n");

                result2.add(new Data(Name.text().trim(),Matric.text().trim()));
            }
            System.out.println("-----------------------------------------------------------------------------------------");


        } catch (Exception e) {
            System.out.println("" + e);
        }
        return result2;

    }
}
