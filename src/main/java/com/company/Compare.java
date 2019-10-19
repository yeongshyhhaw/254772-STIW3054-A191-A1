package com.company;


import java.io.IOException;
import java.util.ArrayList;

public class Compare {
    private ArrayList<Data> unknown = new ArrayList<Data>();
    public void Compare(ArrayList<Data> result, ArrayList<Data> result2) throws IOException {

        for(int i=1;i<result.size();i++)
        {
            for (int x=0;x<result2.size();x++)
            {
                if(result.get(i).getMatric()!=(result2.get(x).getMatric()))
                {
                    unknown.add(new Data(result.get(i).getName(),result.get(i).getMatric(),result.get(i).getLink()));
                }
            }
        }





    }
}
