package com.gerardnico.antlr.sqlite;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility functions
 */
public class Sqlites {

    /**
     *
     * @param sql
     * @return the function name of sqlite sql
     *
     * Example code comes from https://github.com/bkiers/sqlite-parser#example
     */
    public static List<String> getFunctionNames(String sql) {

        // The list that will hold our function names.
        final List<String> functionNames = new ArrayList<String>();

        // Create a lexer and parser for the input.
        SQLiteLexer lexer = new SQLiteLexer(new ANTLRInputStream(sql));
        SQLiteParser parser = new SQLiteParser(new CommonTokenStream(lexer));

        // Invoke the `select_stmt` production.
        ParseTree tree = parser.select_stmt();

        // Walk the `select_stmt` production and listen when the parser
        // enters the `expr` production.
        ParseTreeWalker.DEFAULT.walk(new SQLiteBaseListener() {
            @Override
            public void enterExpr(@NotNull SQLiteParser.ExprContext ctx) {
                // Check if the expression is a function call.
                if (ctx.function_name() != null) {
                    // Yes, it was a function call: add the name of the function
                    // to out list.
                    functionNames.add(ctx.function_name().getText());
                }
            }
        }, tree);

        // return the parsed functions.
        return functionNames;
    }
}
