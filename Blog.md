Blog

20/02/24
    Achievements:
        - Refactored code seperate functions to different files using SRP (Single Responsibility Principle)
        - Get number of certificates from database function done
        - list the certificates from database function done

    To do:
        - Think about how to create a second layer of logic. Right now i have one for certificates and I want to have one more for questions for each certificate
        - I need to create a table for the question bank of that certificate if I add a certificate. Same for when I delete

    Thoughts:
        - I think I should start to create objects instead of just using static functions for example I should be creating certificate objects
        - I created an authentication file which could be used to write some authentication function later on
        - There is a lot of repitition in connecting to database maybe that can be cut down
        - There should be a way to move the switch statement in main to another file. The function shouldn't exist there. It can probably be moved to the Certificate class

19/02/24
    Achievements:
        - sucesfully deleted data from a table in database using java
        - figured out the pass scanner by value
        - refind the addCertificate function
            - Can now add name of certificate from user input

    To do:
        - refactor code
            -  seperate functions in to different classes
        - add date created to certificates table
        - create list certificates function
        - function to count number of certificates in table
        - create another table to add data(questions for certificates)
        - function to add and delete those questions to table

    Thoughts:
        - since I have to enter my password everytime, I wonder if i can implement something like SSO (Single Sign-on) to this project
        - would be nice to make my program look nicer for example creating an User Interface (UI) or something with frontend
        - i need to think about what the entry for questions look like:
            - String - text
            - List[String] - answer selections
            - int - number of mistakes
            - date added
18/02/24
    Achievements:
        - reading password for database is used in a lot of the functions so created a seperate function to read in password
            - this created a bug since i used scanner system.in in the function which i later found out would also close system.in in main method
            - Link: https://stackoverflow.com/questions/74445018/scanner-is-never-closed-in-method-but-i-think-it-does-actually-close-every-time
                BTW another reason we avoid creating Scanner which handles System.in inside our own methods is fact that closing such Scanner by that method would also close System.in. This means when you will try to call your method again it will create Scanner which will try to read from already close System.in. Again, preferred solution in such case is to pass Scanner handling System.in as method parameter.
            - Hence I would need to pass scanner object as a parameter to avoid this problem
    
        To do:
        - Need to refine addCertificate function
        - Need to learn and implement pass scanner object as a parameter
        - Implement funtion to add data to a table in the database
        - Implement function to create a database
        - Implment another table

17/02/24
    Achievements:
        - Sucessfully added data into database
    
    To do:
        - Need to refind the function
        - Implement funtion to add data to a table in the database
        - Implement function to create a database
        - Implment another table

16/02/24
    Achievements:
        - Sucessfully created a database and table in pgadmin 4 (postgreSQL)
        - Sucessfully connected with database server from java
    
    To do:
        - Implement funtion to add data to a table in the database
        - Implement function to create a database
        - Implment another table

    Resources used:
        - https://www.youtube.com/watch?v=OLmAZmBSwMo
            - Teaches you how to connect java to postgres database
            - Shows how to add data to databse using java via sql


15/02/24
    - Add some functions to be edited
    - Still need to figure out a database design and how to connect with it.
    - Decided to use PostgreSQL yesterday.

14/02/24
    - Figuring out a application to add questions from different certificates in a database using java
    - Just coding and typing things out to get some inspiration on what I need
    - So far I need to figure out the connection to a database and figure out the database design