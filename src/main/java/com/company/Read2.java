package com.company;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class Read2 {
    private final ArrayList<Data> result2 = new ArrayList<Data>();

    public  void ReadData2() {

        try {
            String URL = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
            Document doc = Jsoup.connect(URL).get();
            String tittle = doc.title();
            System.out.printf("%66s", tittle + "\n");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("| No. | Matric | Name                                  |");
            System.out.println("|-----|--------|---------------------------------------|");
            Elements trs = doc.getElementsByClass("markdown-body" );
            org.jsoup.select.Elements rows = trs.select("div");
            String name="";
            for (int i = 1; i <= 35; i++) {
                Elements Matric= doc.select(" tbody > tr:nth-child(" + i + ") > td:nth-child(2)");
                Elements Name= doc.select(" tbody > tr:nth-child(" + i + ") > td:nth-child(3)");
                System.out.printf("|%-5s|%-8s|%-39s|\n",i,Matric.text().trim(),Name.text().trim());
                result2.add(new Data(Name.text().trim(),Matric.text().trim()));
            }
            System.out.println("|-----|--------|---------------------------------------|");

        } catch (Exception e) {
            System.out.println("" + e);
        }

    }

    public ArrayList<Data> getResult2() {
        return result2;
    }
}
