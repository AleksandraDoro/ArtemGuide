package org.example.utils;

public enum QueryTypes {
    INSERT("INSERT INTO test_table VALUES(?,?)"),
    SELECT("SELECT * from test_table"),
    UPDATE("UPDATE test_table set name = ? where id = ?"),
    DELETE("DELETE From test_table WHERE name = ?"),
    ORDER("SELECT * FROM test_table ORDER BY id");


    private final String query;

    QueryTypes(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
