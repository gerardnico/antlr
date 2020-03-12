# Antlr Demo

## About

A demo project for `Antlr`

## Grammar

Every grammar is in [src/main/antlr](src/main/antlr)
  * The package of the generated parser and lexer is in the grammar file itself via `@header`
  * Generated source files are generated in `build/generated-src` via the Antlr plugin at compile time. Idea will then mark the generated directory as `source root`.
   
## Demo

  * Action (calculation) with a [Calculator](src/main/java/com/gerardnico/antlr/calculator/Calc.java)
  * Tree visitor with [SQLite](src/test/java/com/gerardnico/antlr/sqlite/SqliteTest.java)


  
      