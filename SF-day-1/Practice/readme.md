## Day 1 : Spring first steps

### Practice

1. Non-Spring example;
2. Spring via XML based configuration

#### 1. Non-Spring Example : Create project

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

#### 1. Non-Spring Example : Code

1. Create the package 'ro.dbts.model';
2. Create Java class 'Task';
3. Add two private members: Name and Description and their getter/setter;
4. Create the package 'ro.dbts.repository';
5. Create Java class 'HibernateTaskRepository';
6. Create a (stub)method 'findAll' returning a list of Task;
7. Extract the interface out of this class (Refactor->Extract->Interface...);
8. Create the package 'ro.dbts.service';
9. Create a Java class 'SimpleTaskService';
10. Add a public method 'findAll' and use the repository to return the list of Task objects;
11. Create a Java class in 'ro.dbts' named 'Application';
12. Add a psvm method and inside and pout printing the name of the first task;

#### 1. Non-Spring Example : Pain points

1. The hard coded 'HibernateTaskRepository' in 'SimpleTaskService';
2. The hard coded 'SimpleTaskService' in the main method;

#### Maven is mandatory with Spring 4+ 

Main reasons: Transitive dependencies

#### 2. Spring XML Example : Create project

1. Method 1
Use steps 6-14 from step (1) 'Create project' and replace ArtefactId with 'spring-xml-example')
2. Method 2
In IntelliJ right click on project name 'non-spring-example' and copy it then paste it in the same section. Then close the current project and open the new one.

#### 2. Spring XML Example : Code

1. Go to File -> Settings -> ... -> Java Compiler : Target bytecode version and ensure is 8.
2. Go to File -> Project Settings -> Modules : Sources and ensure language level is 8
3. Go to File -> Project Settings -> Modules : Name and ensure is 'spring-xml-example'
4. Open 'pom.xml' and change 'artifactId' to 'spring-xml-example'

Changes (setter injection):

1. Open 'pom.xml' file and add after 'version tag the following: ```"<dependencies></dependencies>"```;
2. Go to https://mvnrepository.com/artifact/org.springframework/spring-context and copy the dependency for the most up-to-date release (when this was written is 5.1.8) then add it to your 'pom.xml' file inside the 'dependencies' tag; It should look like this:

    ```xml
        <dependencies>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-context</artifactId>
                <version>5.1.8.RELEASE</version>
            </dependency>
        </dependencies>
    ```

3. Check, in the left panel, the 'External libraries'. There should be, beside spring-context, a few more entries related to spring (6 entries in total for me), most notable spring-core;
4. Right click on the 'src/main/resources' and create a new file named 'applicationContext.xml' and add this snippet:

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN"
            "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>

        <!-- bean definitions here -->

    </beans>
    ```

5. Create a bean named 'taskRepository':

    ```xml
    <bean name="taskRepository" class="ro.dbts.repository.HibernateTaskRepository" />
    ```

6. Create a bean named 'taskService' with a property named 'taskRepository';

    ```xml
    <bean name="taskService" class="ro.dbts.service.SimpleTaskService">
        <property name="taskRepository" ref="taskRepository" />
    </bean>
    ```

7. Go to SimpleTaskService class and create a setter for 'taskRepository' variable;
8. Also in SimpleTaskService comment out the creation of 'taskRepository':

    ```java
        private TaskRepository taskRepository;
    ```

9. Go to 'Application' class and comment out the 'taskService' creation. We'll use the one the Spring creates for us.
10. Get the ApplicationContext from Spring.

    ```java
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    ```

11. Get the 'taskService' object from the application context:

    ```java
        TaskService taskService = applicationContext.getBean("taskService", TaskService.class);
    ```

12. Go to 'Application' class, right click on 'main' and select 'Run Application.main()'. Or click the green arrow in the left on the same line as main.

#### 3. Spring XML Example 2 : Create project

1. Method 1
Use steps 6-14 from step (1) 'Create project' and replace ArtefactId with 'spring-xml-example-2')
2. Method 2
In IntelliJ right click on project name 'spring-xml-example' and copy it then paste it in the same section then rename it to 'spring-xml-example-2'. Then close the current project and open the new one.

#### 3. Spring XML Example 2 : Code

1. Go to File -> Settings -> ... -> Java Compiler : Target bytecode version and ensure is 8.
2. Go to File -> Project Settings -> Modules : Sources and ensure language level is 8
3. Go to File -> Project Settings -> Modules : Name and ensure is 'spring-xml-example'
4. Open 'pom.xml' and change 'artifactId' to 'spring-xml-example-2'

Changes (constructor injection):

1. Open 'pom.xml' file and add after 'version tag the following: ```"<dependencies></dependencies>"```;
2. Go to https://mvnrepository.com/artifact/org.springframework/spring-context and copy the dependency for the most up-to-date release (when this was written is 5.1.8) then add it to your 'pom.xml' file inside the 'dependencies' tag; It should look like this:

    ```xml
        <dependencies>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-context</artifactId>
                <version>5.1.8.RELEASE</version>
            </dependency>
        </dependencies>
    ```

3. Check, in the left panel, the 'External libraries'. There should be, beside spring-context, a few more entries related to spring (6 entries in total for me), most notable spring-core;
4. Right click on the 'src/main/resources' and create a new file named 'applicationContext.xml' and add this snippet:

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN"
            "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>

        <!-- bean definitions here -->

    </beans>
    ```

5. Create a bean named 'taskRepository':

    ```xml
    <bean name="taskRepository" class="ro.dbts.repository.HibernateTaskRepository" />
    ```

6. Create a bean named 'taskService' with a property named 'taskRepository';

    ```xml
    <bean name="taskService" class="ro.dbts.service.SimpleTaskService">
        <constructor-arg index="0" ref="taskRepository" />
    </bean>
    ```

7. Go to SimpleTaskService class and remove the setter for 'taskRepository' variable if there;
8. Also in SimpleTaskService comment out the creation of 'taskRepository' and keep only the definition:

    ```java
        private TaskRepository taskRepository;
    ```

9. Create a SimpleTaskService public constructor that has one single parameter of type 'TaskRepository';

    ```java
    public SimpleTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    ```

10. Go to 'Application' class and comment out the 'taskService' creation. We'll use the one the Spring creates for us.
11. Get the ApplicationContext from Spring.

    ```java
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    ```

12. Get the 'taskService' object from the application context:

    ```java
        TaskService taskService = applicationContext.getBean("taskService", TaskService.class);
    ```

13. Go to 'Application' class, right click on 'main' and select 'Run Application.main()'. Or click the green arrow in the left on the same line as main.

#### 4. Spring Autowire Example : Create project

In IntelliJ right click on project name 'spring-xml-example-2' and copy it then paste it in the same section and name it 'spring-autowire-example'. Then close the current project and open the new one.

#### 4. Spring Autowire Example : Code

1. Go to File -> Settings -> ... -> Java Compiler : Target bytecode version and ensure is 8.
2. Go to File -> Project Settings -> Modules : Sources and ensure language level is 8
3. Go to File -> Project Settings -> Modules : Name and ensure is 'spring-xml-example'
4. Open 'pom.xml' and change 'artifactId' to 'spring-autowire-example'
5. No changes in 'pom.xml' file, 'spring-context' dependency should be there;
6. First will try constructor autowire so open 'applicationContext.xml';
7. Modify bean 'taskService' by removing the 'constructor-arg' entry.
8. Remove the closing tag for the same bean and add ```/>``` at the end;
9. For the 'taskService' bean add attribute 'autowire' with a value of 'constructor';
10. Make sure you have a constructor in 'SimpleTaskService' with the parameter of type 'TaskRepository';
11. Run the application. Check the output. Next autowire by type example...
12. In the 'applicationContext.xml' file change the value of 'autowire' to 'byType';
13. Make sure you have a setter in 'SimpleTaskService' with the parameter of type 'TaskRepository';
14. If you have an error above when run the app check if you have a default constructor for 'SimpleTaskService'.
15. Run the application. Check the output. Next autowire by name example.
16. In the 'applicationContext.xml' file change the value of 'autowire' to 'byName';
17. Make sure you have a setter in 'SimpleTaskService' with the name of 'setTaskRepository';
18. Run the application. Check the output.

#### END DAY 1 - to be continued
