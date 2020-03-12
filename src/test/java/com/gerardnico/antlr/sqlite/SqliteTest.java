package com.gerardnico.antlr.sqlite;

import org.junit.Test;

import java.util.List;

public class SqliteTest {

    @Test
    public void baseSqliteTest() {
        String sql = "SELECT log AS x FROM t1 \n" +
                "GROUP BY x                   \n" +
                "HAVING count(*) >= 4         \n" +
                "ORDER BY max(n) + 0          \n";
        List<String> functionNames = Sqlites.getFunctionNames(sql);
        functionNames.stream().forEach(System.out::println);
    }
}
