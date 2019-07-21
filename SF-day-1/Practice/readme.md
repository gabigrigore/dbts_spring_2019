## Day 1 : Spring first steps

### Practice

1. Non-Spring example;
2. Spring via XML based configuration
3. Spring via annotations configuration
4. Spring via Java configuration

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

#### 5. Spring Annotation Example : Create project

In IntelliJ close the current project and open 'non-spring-example'. Once open right click on it, copy it then paste it in the same section. In the new dialog window set the new project name as 'spring-annotation-example' and select bottom-right checkbox. Then, again, close the current project and open the new one. (same operations can be done via OS copy the open the new project in IntelliJ)

#### 5. Spring Annotation Example : Code

1. Create a new file 'applicationContext.xml' in the folder 'src/main/resources';
2. Add the new namespace for 'context'. After that the file should look like below:

    ```xml
        <?xml version="1.0" encoding="UTF-8"?>
        <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns:context="http://www.springframework.org/schema/context"
            xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans.xsd
                        http://www.springframework.org/schema/context
                        http://www.springframework.org/schema/context/spring-context.xsd">

        </beans>
    ```

3. Add these two lines inside 'applicationContext.xml' inside the ```<bean>``` tag:

    ```xml
        <context:annotation-config />

        <context:component-scan base-package="ro.dbts" />
    ```

    They help Spring to scan the defined package for annotated beans that will need to be managed.

4. Stereotype Annotations

   * @Component
   * @Repository
   * @Service
  
5. Open 'HibernateTaskRepository.java' file and add '@Repository("taskRepository") immediately above class definition.

    ```java
        @Repository("taskRepository")
        public class HibernateTaskRepository implements TaskRepository {
        ...
    ```

6. Open 'SimpleTaskService.java' file and add '@Service("taskRepository") immediately above class definition.

    ```java
        @Service("taskService")
        public class SimpleTaskService implements TaskService {
        ...
    ```

7. Remove the creation part of the 'TaskRepository' inside 'SimpleTaskService' and keep only the definition of it. Above definition add '@Autowired'.

    ```java
        @Autowired
        private TaskRepository taskRepository;
    ```

    This is call 'member autowire' or 'autowire member' or 'member injection'.

8. Run the application. Check the output.
9. There are two other different methods to autowire, beside member autowire:
   * Constructor injection;
   * Setter injection;

#### 6. Spring Java Configuration Example : Create project

In IntelliJ close the current project and open 'non-spring-example'. Once open right click on it, copy it then paste it in the same section. In the new dialog window set the new project name as 'spring-java-config-example' and select bottom-right checkbox. Then, again, close the current project and open the new one. (same operations can be done via OS copy the open the new project in IntelliJ)

#### 6. Spring Java Configuration Example : Code

1. Open 'pom.xml' file and add Spring dependencies:

    ```xml
        <dependencies>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-context</artifactId>
                <version>5.1.8.RELEASE</version>
            </dependency>
        </dependencies>
    ```

2. No 'applicationContext.xml' needed when using Java configuration with Spring.
3. But...there is an app config Java file!
4. At the root of 'ro.dbts' (where also Application.java is) create a Java class named 'AppConfig.java';
5. Right before the name of the class add '@Configuration' annotation.
6. Create the 'taskService' bean that uses setter injection to get the repository it needs:

    ```java
    @Bean(name = "taskService")
    public TaskService getTaskService() {
        SimpleTaskService taskService = new SimpleTaskService();
        taskService.setTaskRepository(getTaskRepository());

        return  taskService;
    }
    ```

7. Create the 'taskRepository' bean used by 'taskService':

    ```java
    @Bean(name = "taskRepository")
    public TaskRepository getTaskRepository() {
        return new HibernateTaskRepository();
    }
    ```

8. Make sure that 'SimpleTaskService' has the setter for 'taskRepository'.
9. Constructor injection for 'taskService' is as easy. Create in 'SimpleTaskService' a constructor with one argument, 'taskRepository'.
10. Modify the 'AppConfig.java' so it uses the constructor to build the 'taskService'.

    ```java
    @Bean(name = "taskService")
    public TaskService getTaskService() {
        SimpleTaskService taskService = new SimpleTaskService(getTaskRepository());

        return  taskService;
    }
    ```

11. Modify the 'Application.java' to get the 'taskService' bean using the 'AppConfig.java'.

    ```java
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        TaskService taskService = applicationContext.getBean("taskService", TaskService.class);
        ...
    ```

12. Run the application. Check the output.

#### 7. Spring Java Autowire Configuration Example : Create project

In IntelliJ right click on 'spring-java-config-example' project, copy it then paste it in the same section. In the new dialog window set the new project name as 'spring-java-autowire-example' and select bottom-right checkbox. Then, again, close the current project and open the new one. (same operations can be done via OS copy the open the new project in IntelliJ)

#### 7. Spring Java Autowire Configuration Example : Code

1. Go to 'AppConfig.java' file and add between '@configuration' and class definition '@ComponentScan({"ro.dbts"})'
2. Remove everything from this class, keep only the curly braces.
3. Go to 'HibernateTaskRepository' and add immediately above class definition '@Repository("taskRepository")'
4. Go to 'SimpleTaskService' and add immediately above class definition '@Service("taskService")'
5. In the same class add '@Autowired' to the 'taskRepository' member;
6. Run the application. Check the results.
