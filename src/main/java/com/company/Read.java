package com.company;


import org.apache.poi.ss.formula.functions.MatrixFunction;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Read {
    private final ArrayList<Data> result = new ArrayList<Data>();
    public ArrayList<Data>  ReadData() throws IOException {
        try {

            System.out.println("");
            String URL = "https://github.com/STIW3054-A191/Main-Issues/issues/1";
            Document doc = Jsoup.connect(URL).get();
            String tittle = doc.title();
            System.out.printf("%66s", tittle + "\n");
            System.out.println("-----------------------------------------------------------------------------------------");
            Elements trs = doc.getElementsByClass("d-block comment-body markdown-body  js-comment-body" );
            org.jsoup.select.Elements rows = trs.select("ol");




            String url="";
            String name = "";
            String matric = "";

            for(Element tablenum:trs){
                /*find student's name*/
                Elements url1=tablenum.getElementsByTag("p");
                String transfer = url1.select("p").toString();
                Pattern pattern = Pattern.compile("Name: (.*?)<br>|Name :(.*?)<br>|:\\s(U.*)<br>|Name:(.*?)<br>|name :( .*?)<br> |Name (.*?)<br>"); // compile
                Matcher m = pattern.matcher(transfer);
                while(m.find()){
                    name = m.group(0).replace("<br>","").replace("name :","").replace("Name :","").replace("Name:","").replace(":","").replace("Name ","").trim();
                }


                /*find student's github link*/
                url=tablenum.getElementsByTag("a").attr("abs:href");


                /*find student's matric*/
                Pattern pattern1 = Pattern.compile("(\\b2.*?)<br>"); // compile
                Matcher n = pattern1.matcher(transfer);
                while(n.find()){
                    matric = n.group(1).trim();
                }


                /*add name,matric and githublink inside arraylist*/
                result.add(new Data(name,matric,url));
            }

            for(int i =1; i<result.size();i++){
                System.out.println(""+i+" "+result.get(i).getName()+" "+result.get(i).getMatric()+" "+result.get(i).getLink());

            }
            System.out.println("-----------------------------------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println(""+e);
        }
        return result;
    }
}