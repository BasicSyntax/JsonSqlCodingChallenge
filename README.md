# JsonSqlCodingChallenge

Instructions: From the folder please use command :
"java -cp target/classes/com/basic/syntax/json/App.java"
This will begin the CLI interface, following such a prompt will show up for an input file, once inserted another prompt
will show up for an output file. For now .json is the only supported filetype. If no output file is specified then
output will be printed to the screen.

Coding challenge parsing JSON data into Java Objects. To then map the objects to a database using JPA, Using Unit
Testing through Test Driven Development (TDD). Using an in-memory H2 database with H2 dialect queries (to be switched to
MySQL dialect queries). Providing a CLI interface to specify an input file and output file.

1. Please use java to write the solution
2. Please do not use Spring
3. The CLI program should specify of the input file and output file
4. The format will always be the same for the input file supplied
5. Use an existing JSON library to parse the JSON do not reinvent the wheel
6. The insert and create statements should be based on MySQL and output to the filename supplied to the program. If file
   name is not supplied output statements to the screen
7. Please select the data types for the SQL create statement and identify the primary key for the data
8. Please list instructions to run the program you have written as well as supply the source code
9. Please show evidence of coding standards in your code
10. Please demonstrate use of unit testing against the code
11. This does not need to connect to an SQL database

      Chosen Libraries:
                   JSON Simple
                   Hibernate
                   H2 in-memory database

