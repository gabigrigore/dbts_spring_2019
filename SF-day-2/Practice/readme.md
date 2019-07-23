## Day 2 : Spring first steps

### Practice

1. Spring via annotations configuration
2. Spring via Java configuration

#### DAY 1 continuation....

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

In IntelliJ right click on 'spring-java-config-example' project, copy it then paste it in the same section. In the new dialog window set the new project name as 'spring-java-annotation-example' and select bottom-right checkbox. Then, again, close the current project and open the new one. (same operations can be done via OS copy the open the new project in IntelliJ)

#### 7. Spring Java Autowire Configuration Example : Code

1. Go to 'AppConfig.java' file and add between '@configuration' and class definition '@ComponentScan({"ro.dbts"})'
2. Remove everything from this class, keep only the curly braces.
3. Go to 'HibernateTaskRepository' and add immediately above class definition '@Repository("taskRepository")'
4. Go to 'SimpleTaskService' and add immediately above class definition '@Service("taskService")'
5. In the same class add '@Autowired' to the 'taskRepository' member;
6. Run the application. Check the results.


#### 8. Spring XML Autowire and Properties Example : Create project

In IntelliJ copy 'spring-autowire-example' from Day 1. Set the new project name (& module) as 'spring-autowire-properties-example' and select bottom-right checkbox.

#### 8. Spring XML Autowire and Properties : Code

1. Create a file 'app.properties' in the 'resource' folder and add in it one single line with this content "databaseUser=myusername";
2. In 'applicationContext.xml' autowire via 'constructor' the 'taskService' bean. Make sure you have the right constructor in 'SimpleTaskService' class.
3. Also in 'applicationContext.xml' add for the 'taskRepository' bean a property injected via constructor

    ```xml
        <constructor-arg index="0" value="${databaseUser}" />
    ```

4. In the 'HibernateTaskRepository' declare a private property 'databaseUser' of type String and a constructor to initialize it.
5. Add a line in 'HibernateTaskRepository:findAll' to print the value of 'databaseUser' variable;

    ```java
        System.out.println("databaseUser : " + databaseUser);
        ...
    ```

6. ApplicationContext will be created in main with the use of 'applicationContext.xml';
7. Run the application. Check the results.

#### 9. Spring Java Annotation & Properties Example : Create project

In IntelliJ copy 'spring-java-annotation-example' from Day 2. Set the new project name (& module) as 'spring-java-annotations-properties-example'.


#### 9. Spring Java Annotation & Properties Example : Code

1. Create a file 'app.properties' in the 'resource' folder and add in it one single line with this content "databaseUser=myusername";
2. Go to 'AppConfig.java' file and add between '@configuration' and class definition '@PropertySource("app.properties")'
3. In the 'AppConfig.java' add the following bean definition:

    ```java
    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcePlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    ```

4. Remove everything from this class, keep only the curly braces.
5. Go to 'HibernateTaskRepository' and add immediately above class definition '@Repository("taskRepository")'
6. You should already have these annotations in place: @Repository(..), @Service(..), @Autowired;
7. In 'HibernateTaskRepository' add a declare a private String 'databaseUser' and annotate it with 

    ```java
    @Value("${databaseUser}")
    private String databaseUser;
    ```

8. ApplicationContext will be created in main with the use of 'AppConfig.class';
9. Run the application. Check the results.

#### END DAY 2 - to be continued