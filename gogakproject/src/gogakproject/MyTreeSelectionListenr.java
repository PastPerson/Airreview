package gogakproject;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;




class MyTreeSelectionListener implements TreeSelectionListener {




    MyDatabase md = new MyDatabase();


    String column_List[] ={"영문공항명", "한글공항명", "코드1", "코드2", "지역", "영문나라명", "한글나라명", "도시명"};


    DefaultTableModel model1 = new DefaultTableModel(column_List,0);

    JTable table = new JTable(model1);

    JScrollPane scrollPane = new JScrollPane(table);







    public void valueChanged (TreeSelectionEvent event) {
        TreePath path = event.getPath();
        System.out.println ("Selected: " +
                path.getLastPathComponent());
        Object elements[] = path.getPath();
        for (int i=0; i<elements.length; i++) {
            System.out.print ("->" + elements[i]);
        }

        String s[] = new String[md.getAirportData("한글나라명", elements[2].toString()).size()];



        Object rowData[][] = new Object[column_List.length][s.length];






        for( int i = 0; i < s.length /8 ; i++ ) {
            for(int j=0; j < column_List.length; j++){
                rowData[i][j] = md.getAirportData("한글나라명", elements[2].toString()).get((i*s.length/8) + j).toString();

            }

        }

        for( int i = 0; i < s.length /8 ; i++ ) {
            for(int j=0; j < column_List.length; j++) {
                System.out.println("i: "+ i +"j: " + j + " 번호 : " +((i*s.length/8) + j));
                System.out.println(rowData[i][j].toString());
            }
        }
        System.out.println(s.length);
        System.out.println(rowData.length);

       JTable table = new JTable(rowData, column_List);
        JScrollPane jscp1 = new JScrollPane(table);




        System.out.println ();
    }


}
