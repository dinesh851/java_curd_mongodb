# spring-boot-mongodb-crud

<p>This project explains CRUD (<strong>Create</strong>, <strong>Read</strong>, <strong>Update</strong>, <strong>Delete</strong>) operations using MongoTemplate and MongoRepository using spring boot and mongo DB. In this app we are using Spring Data JPA for built-in methods to do CRUD operations and Mongo queries using MongoTemplate.</p>

<p><code>@EnableMongoRepositories</code> annotation is used on the main class to Enable Mongo related configuration, which will read properties from <code>application.properties</code> file.</p>

## Prerequisites 
- Java
- <a href="https://spring.io/projects/spring-boot">Spring Boot</a>
- <a href="https://maven.apache.org/guides/index.html">Maven</a>
- <a href="https://docs.mongodb.com/guides/">Mongo DB</a>
- <a href="https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok">Lombok</a>

## Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Gradle
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)

<br/>

### Build and Run application
_GOTO >_ **~/absolute-path-to-directory/spring-boot-mongodb**  
and try the below command in the terminal:
> <code>mvn spring-boot:run</code> - It will run the application as a Spring Boot application.

or

> <code>mvn clean install</code> - It will build the application and create a <strong>jar</strong> file under the target directory.

Run the jar file from the below path with the given command:

> <code>java -jar ~/path-to-spring-boot-mongodb/target/spring-boot-mongodb-0.0.1-SNAPSHOT.jar</code>

Or, run the main method from <code>SpringBootMongoDBApplication.java</code> as a Spring Boot application.

---

|||
|  :---------:  |
| **_Note_**: In the <code>SpringBootMongoDBApplication.java</code> class, we have autowired both SuperHero and Employee repositories. If there is no record present in the DB for any one of those module classes (Employee or SuperHero), static data is getting inserted in the DB from the <code>HelperUtil.java</code> class when we are starting the app for the first time. |

---

### Code Snippets
1. #### Maven Dependencies
    Need to add the following dependencies to enable Mongo related config in <strong>pom.xml</strong>. Lombok's dependency is to get rid of boiler-plate code.   
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
   
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    ```
   
2. #### Properties file
    Reading Mongo DB related properties from <strong>application.properties</strong> file and configuring the Mongo connection factory for MongoDB.  

    **src/main/resources/application.properties**
    ```properties
    spring.data.mongodb.host=localhost
    spring.data.mongodb.port=27017
    spring.data.mongodb.database=spring_boot_mongo_app
    spring.jackson.default-property-inclusion=NON_NULL
    #logging.level.ROOT=DEBUG  
    ```
   
3. #### Model class
    Below are the model classes which we will store in MongoDB and perform CRUD operations.  
    **com.spring.mongo.demo.model.SuperHero.java**
    ```java
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Document(collection = "super_hero")
    public class SuperHero implements Serializable {
    
        @Id
        private String id;
    
        private String name;
        private String superName;
        private String profession;
        private int age;
        private boolean canFly;
    
        // Constructor, Getter and Setter
    }
    ```
    **com.spring.mongo.demo.model.Employee.java**
    ```java
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class Employee implements Serializable {
   
        @Id
        private String id;
       
        private int empId;
        private String firstName;
        private String lastName;
        private float salary;
        
        // Constructor, Getter and Setter
    }
