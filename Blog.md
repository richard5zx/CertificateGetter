14/02/24
    Figuring out a application to add questions from different certificates in a database using java
    Just coding and typing things out to get some inspiration on what I need
    So far I need to figure out the connection to a database and figure out the database design

15/02/24
    Add some functions to be edited. Still need to figure out a database design and how to connect with it.
    Decided to use PostgreSQL yesterday.

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

17/02/24
    Achievement:
        - Sucessfully added data into database
    
    To do:
        - Need to refind the function
        - Implement funtion to add data to a table in the database
        - Implement function to create a database
        - Implment another table
    
18/02/24
    Achievement:
        - reading password for database is used in a lot of the functions so created a seperate function to read in password
            - this created a bug since i used scanner system.in in the function which i later found out would also close system.in in main method
            - Link: https://stackoverflow.com/questions/74445018/scanner-is-never-closed-in-method-but-i-think-it-does-actually-close-every-time
                BTW another reason we avoid creating Scanner which handles System.in inside our own methods is fact that closing such Scanner by that method would also close System.in. This means when you will try to call your method again it will create Scanner which will try to read from already close System.in. Again, preferred solution in such case is to pass Scanner handling System.in as method parameter.
            - Hence I would need to pass scanner object as a parameter to avoid this problem