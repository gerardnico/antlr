package com.gerardnico.antlr.hello;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Trees;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Hello {

    public static void main(String[] args) {
        String input = "hello nico";
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        HelloLexer lexer = new HelloLexer(inputStream);
        HelloParser parser = new HelloParser(new CommonTokenStream(lexer));

        // Create the tree from the r parser rule
        ParseTree tree = parser.r();
        printNode(tree, 0, Arrays.asList(parser.getRuleNames()));

    }

    /**
     * Recursive function to print a node
     * @param node
     * @param level
     * @param ruleNames
     */
    private static void printNode(ParseTree node, int level, List<String> ruleNames) {
        String nodeText = Trees.getNodeText(node, ruleNames);

        // Print
        StringBuilder line = new StringBuilder();
        IntStream.range(0, level).forEach(i -> line.append(" "));
        line
                .append("Level ")
                .append(level)
                .append(" - ")
                .append(nodeText);
        System.out.println(line.toString());


        // Chilrdnre
        if (node instanceof ParserRuleContext) {
            ParserRuleContext parserRuleContext = (ParserRuleContext) node;
            if (parserRuleContext.children != null) {
                for (ParseTree child : parserRuleContext.children) {
                    printNode(child, level + 1, ruleNames);
                }
            }
        }
    }
}
