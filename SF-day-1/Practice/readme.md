## Day 1 : Spring first steps

### Practice

1. Non-Spring example;
2. Spring via XML based configuration
3. Spring via annotations configuration
4. Spring via Java configuration

#### Non-Spring Example : Create project

1. Create a work folder for the Spring sessions on your computer "mysf";
2. Open the Git Bash console;
3. Check your current folder with "pwd";
4. Change directory to the folder created in step (1);
5. Clone the project structure from Git;
    git clone https://github.com/gabigrigore/dbts_spring_2019.git 
6. In IntelliJ goto File -> New ->Project...;
7. Select "Maven" on the left side bar of the popup;
8. Ensure for the 'Project SDK' Java 1.8 is selected;
9. Click 'Next';
10. GroupId = 'ro.dbts';
11. ArtifactId = 'non-spring-example';
12. Click 'Next';
13. Project name, change it to 'non-spring-example';
14. Click 'Finish';

//Maven compile plugin in pom.xml

##### Non-Spring Example : Create Java code

1. Create the package 'ro.dbts.model';
2. Create Java class 'Task';
3. Add two private members: Name and Description and their getter/setter;
4. Create the package 'ro.dbts.repository';
5. Create Java class 'HibernetTaskRepository';
6. Create a (stub)method 'findAll' returning a list of Task;
7. Extract the interface out of this class;
8. Create the package 'ro.dbts.service';
9. Create a Java class 'SimpleTaskService';
10. Add a public method 'findAll' and use the repository to return the list of Task objects;
11. Create a Java class in 'ro.dbts' named 'Application';
12. Add a psvm method and inside and pout printing the name of the first task;

##### Non-Spring Example : Pain points

1. The hardcoded 'HibernateTaskRepository'in 'SimpleTaskService';
2. The hardcoded 'SimpleTaskService' in the main method;

##### Maven is mandatory with Spring 4+

Reasons: Transitive dependencies


#### Spring XML Example : Create project

1. Method 1
Use steps 6-14 from above 'Create project' and replace ArtefactId with 'spring-xml-example')
2. Method 2
In IntelliJ right click on project name 'non-spring-example' and copy it then paste it in the same section.

Checks:

1. Go to File -> Settings -> ... -> Java Compiler : Target bytecode version and ensure is 8.
2. Go to File -> Project Settings -> Modules : Sources and ensure language level is 8
3. Go to File -> Project Settings -> Modules : Name and ensure is 'spring-xml-example'
4. Open 'pom.xml' and change 'artifactId' to 'spring-xml-example'
