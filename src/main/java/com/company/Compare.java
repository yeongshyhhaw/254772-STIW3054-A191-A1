package com.company;

import java.util.ArrayList;

public class Compare {
    ArrayList<Data> studentsub = new ArrayList<Data>();
    ArrayList<Data> studentunknown = new ArrayList<Data>();
    ArrayList<Data> studentnotsub = new ArrayList<Data>();
    public void check(ArrayList<Data> studentSubmittedList, ArrayList<Data> studentList) {

        for (int x = 1; x < studentSubmittedList.size(); x++) {
            for (int i = 0; i < studentList.size(); i++) {
                if (studentSubmittedList.get(x).getMatric().equals(studentList.get(i).getMatric())||studentSubmittedList.get(x).getName().equals(studentList.get(i).getName())) {
                    studentsub.add(new Data(studentSubmittedList.get(x).getName(), studentSubmittedList.get(x).getMatric(), studentSubmittedList.get(x).getLink()));
                }
            }
        }
        System.out.println("");
        System.out.println("|----------------------------------------Student Submitted List---------------------------------|");
        System.out.println("");
        System.out.println("|-----------------------------------------------------------------------------------------------|");
        System.out.println("| No. | Matric | Name                                  | GitHub Link                            |");
        System.out.println("|-----|--------|---------------------------------------|----------------------------------------|");
        for (int i = 0; i < studentsub.size(); i++) {
            System.out.printf("|%-5s|%-8s|%-39s|%-40s|\n",i+1,studentsub.get(i).getMatric(),studentsub.get(i).getName(),studentsub.get(i).getLink());
        }

        System.out.println("|-----|--------|---------------------------------------|----------------------------------------|");
    }

    public void studentnotsubmitted(ArrayList<Data> studentSubmittedList, ArrayList<Data> studentList) {
        int s = 0;
        studentnotsub = studentList;

        for (int x = 1; x < studentSubmittedList.size(); x++) {
            for (int i = 0; i < studentList.size(); i++) {
                if (studentSubmittedList.get(x).getMatric().equals(studentList.get(i).getMatric()) || studentSubmittedList.get(x).getName().equals(studentList.get(i).getName())) {
                    s=i;
                    studentnotsub.remove(s);
                }
            }
        }

            System.out.println("");
            System.out.println("|------------------------------------- Student That Not Submitted-------------------------------|");
            System.out.println("|------------------------------------------------------|");
            System.out.println("| No. | Matric | Name                                  | ");
            System.out.println("|-----|--------|---------------------------------------|");
            for (int i = 0; i < studentnotsub.size(); i++) {
                System.out.printf("|%-5s|%-8s|%-39s|\n", i + 1, studentnotsub.get(i).getMatric(), studentnotsub.get(i).getName());
            }

            System.out.println("|-----|--------|---------------------------------------|");
        }


    public ArrayList getstudentSub(){
        return studentsub;
    }
    public ArrayList getstudentNotSub(){
        return  studentnotsub;
    }

    }
