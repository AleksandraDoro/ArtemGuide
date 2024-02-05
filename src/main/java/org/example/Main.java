package org.example;

import org.example.utils.CRUDUtils;
import org.example.utils.DBConnection;

public class Main {
    public static void main(String[] args) {
        CRUDUtils crudUtils = new CRUDUtils();
        System.out.println(crudUtils.deleteStudent( "DoroDoro"));
    }
}
