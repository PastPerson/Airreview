package gogakproject;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

class MyTreeSelectionListener
        implements TreeSelectionListener {

    private JTable table;
    private JScrollPane scrollPane;


    MyDatabase md = new MyDatabase();

    String [] column_List = {"영문공항명","한글공항명","코드1","코드2","지역","영문나라명","한글나라명","도시명"};

    private Object[][] data = {};

    public void valueChanged (TreeSelectionEvent event) {
        TreePath path = event.getPath();
        System.out.println ("Selected: " +
                path.getLastPathComponent());
        Object elements[] = path.getPath();
        for (int i=0; i<elements.length; i++) {
            System.out.print ("->" + elements[i]);
        }

        md.getAirportData("한글나라명", elements[2].toString());





        System.out.println ();
    }


}
