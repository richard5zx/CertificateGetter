Blog

09/03/24
    Achievements:
        - Wrote test for repeated users
        
    To do:
        - Something wrong with my getCert function
        - bug fixed
        
    Thoughts:


08/03/24
    Achievements:
        - More refactoring done

    To do:
        - User DAO test deleted repeated users
        - list certificate: return a dictionary or something instead of just printing
        - delete user should return name of user

    Thoughts:
        -   I want to make a function that can take screen shots of questions
        -   I want to read questions from screen shots
        -   I want to compare screen shots

05/03/24
    Achievements:
        - Rewriten the authentication system by adding system for registering users
        - Wrote test for the authentication
        - Finish implementation of authentication

    To do:
        - Refactor the Certificates
        - Start by:
            1) add the certificate dao functions to user
            2) User DAO test deleted repeated users
            3) list certificate: return a dictionary or something instead of just printing


    Thoughts:
        - I need to think about linking the tables that are created together

03/03/24
    Achievements:
        - Created PostgreSQL table that automatically adds date
            CREATE TABLE users (
                user_id SERIAL PRIMARY KEY,
                username text UNIQUE NOT NULL,
                password text NOT NULL,
                date_created date DEFAULT CURRENT_DATE
            ); 
        - sql for certificates
            CREATE TABLE users (
                user_id int NOT NULL,
                cert_id int UNIQUE NOT NULL,
                cert_name text UNIQUE NOT NULL
            ); 
        - 

    To do:
        - Refactor, add user that controls the certificates, and certificate should control the questions
        - I want to add a system to add different users too

    Thoughts:
        - Realized how important UML diagrams and designs are. I feel like my design is all over the place and I keep needing to refactor my whole thing
        - I have to think about how the tables reference each other. Need to learn about designing databases

02/03/24
    Achievements:
        - Started on working on the questions

    To do:
        - Complete each of the function

    Thoughts:
        - After these functions. Should think about the UI for displaying the graphics

29/02/24
    Achievements:
        - Created a new validation system, if a correct password is given a valid token is give
        - Finished implmenting the token system.
        - In listCertificates function, notify user with print statement to show there are no certificates

    To do:
        - Think about refactoring
        - If no certificates in when using list certificate function -> print no certificates available
        - Think about moving my methods in certificates to CertificateDAO.
        - Figure out what CertificateDAO actually does

    Thoughts:
        - Used this to help me refactor too: https://www.youtube.com/watch?v=wGzHrKI8pjM&list=LL&index=4
        - Still need to work on a better authentication system haha

28/02/24
    Achievements:
        - Fixed bug in
        - Delete functions fixed
        - More delete functions fixed

    To do:
        - Think about refactoring
        - If no certificates in when using list certificate function -> print no certificates available

    Thoughts:
        - Found bug in deleteAllCertificates. The tables are not deleted
        - Would like to reset the primary key number of certificate id back to 0
        - Another bug found in delete certificate function
        - The unit testing has been a great help. Defs need to use it more
        - Watched video about solid principles: https://www.youtube.com/watch?v=HoA6aZPR5K0. I could use first example in my project

27/02/24
    Achievements:
        - Finished is Numeric function to tell if a string can be converted to integer or not (Got function from: https://www.baeldung.com/java-check-string-number)
        - Merged branch back to main for testing

    To do:
        - complete the new delete functions. They have bugs in them

    Thoughts:
        - This is more complicated then I thought

26/02/24
    Achievements:
        - change Authentication method
        - add database for users
        - find a method to encrypt data before adding it to database
        - Added a way to not alwways type the password
        - refactored quite a bit
        - added a single test

    To do:
        - Refactor
        - Need to complete tests and refactoring and merge branch
        - complete the delete all certificates test

    Thoughts:
        - Will learn and experiment using github branches to do refactoring
        - restart the primary key counter using this "TRUNCATE TABLE table_name RESTART IDENTITY" from: https://stackoverflow.com/questions/3819292/reset-postgresql-primary-key-to-1

25/02/24
    Achievements:
        - I finally crushed the bug in delete certificates! Basically, I wanted to query a data that I deleted already. So if I queried the data first than delete it, it would work. Thank god. I was stuck here for 2 days
        - added dependency because it kept saying "The compiler compliance specified is 1.7 but a JRE 11 is used". To fix this I used this link: https://stackoverflow.com/questions/56372006/the-compiler-compliance-specified-is-1-6-but-a-jre-1-8-is-used. The second comment worked for me where I added this:
            <properties>
                <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
                <maven.compiler.source>1.11</maven.compiler.source>
                <maven.compiler.target>1.11</maven.compiler.target>
                <java.version>1.11</java.version>
            </properties>
        
    To do:
        - Refactor my code so I can use them in junit test
        - Think about my design and parameters for functions and change them for junit testing
        - finish the last function (deleteall) after refactoring

    Thoughts:
        - I am starting the unit testing but the way I wrote my functions doesn't allow me to implement the test. I need to refactor my code to allow me to implement my functions at least for the certficate file

24/02/24
    Achievements:
        - Moved over to maven, in maven u need to add the jdbc driver by dependency.
            - Use this link to add driver (https://www.enterprisedb.com/postgres-tutorials/how-add-postgresql-driver-dependency-maven)

    To do:

    Thoughts:
        - Since I couldn't fix the bug I will use a junit testing to help me. But it comes with gradle or maven. Im not sure what it is but I will watch tutorials and see how it works. It helps with orgranizing my project and I will use gradle.

23/02/24
    Achievements:
        - Fixed the listCertificate() function bug. I changed column name in table of databse to having uppercase in it, postgres automatically changes to lower case unless you put it in double quotes. link: https://docs.aws.amazon.com/dms/latest/sql-server-to-aurora-postgresql-migration-playbook/chap-sql-server-aurora-pg.sql.casesensitivity.html
        - Fixed bug for addCertificates() function

    To do:
        - Need to implement something in deletecertificate to detect if the given ID number is actually in the table
        - quering certificate name from the id is proving to be annoying. I will come back to it after some food, il have to spit out everything and see if there is acutally anything
        - I want to add unit testing to help debugging easier

    Thoughts:
        - read this today: https://learn.microsoft.com/en-us/training/modules/describe-identity-principles-concepts/4-describe-role-identity-provider, thought I could implement a identity provider which reduces the need to enter a password
        - I really need to start unit testing, the way im testing for bugs isn't effecient. Im stuck on this query function, its not coming out like it should
        - fuk im stuck on this forever, im gonna take a break from this

22/02/24
    Achievements:
        - Did some refactoring to code moved the whole switch statement to a runner file which only runs programs
        - Finished initial draft of selctCertificate() function
        - Finished function that creates a new table in database
        - Changed database contraint of certName in certificates so it is now unique and cannot have duplicates

    To do:
        - I need a verify function to verify if inputed name is in the databse or verify certification ID
        - datatypes still need to be changed and their constraints as well. But need to design databse properly first
        - need to create a data for all the questions and need to think about the design of that database too.
        - finish deletequestiontable() function

    Thoughts:
        - start thinking of ways to authenticate once for all the applications, maybe like SSO or store a cache of the password for a set amount of time
        - can thinking about security of password like hashing or encryption 
        - above point brings me think about if i should add different users with authorization levels to different database
        - I wanted to have a list of strings in a column of one my tables but apparently that is not the point of RDB (Relational Database) from this link: https://stackoverflow.com/questions/3070384/how-to-store-a-list-in-a-column-of-a-database-table, this challenges me to think about the design of making a new table. I want to use one-to-many relations in the extra database.
        - need to think about unit testing too. I have been ignoring haha

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
            - You need to download and add jdbc driver under referenced libraries
            - Teaches you how to connect java to postgres database
            - Shows how to add data to database using java via sql


15/02/24
    - Add some functions to be edited
    - Still need to figure out a database design and how to connect with it.
    - Decided to use PostgreSQL yesterday.

14/02/24
    - Figuring out a application to add questions from different certificates in a database using java
    - Just coding and typing things out to get some inspiration on what I need
    - So far I need to figure out the connection to a database and figure out the database design