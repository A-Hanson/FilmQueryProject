# Film Query Application
## An Object-Relational Mapped Java application using a MySQL Database
<img src="http://clipart-library.com/data_images/206409.png" alt="film reel"/>

### Description
This application uses the JDBC (Java Data Base Connectivity) API to connect to a MySQL database. The user is presented a menu and is able to use the command-line prompts to search for movies by either ID or a keyword within the title or description. Using Object-Relational Mapping (ORM), java objects are made based on the information from the database. The application then calls the object's get____ methods to display information about the film based on the user stories given. After the initial information is displayed, the user is able to indicate if they would like to see the complete information or return to the main menu.

---

### Topics and Technologies Used
<u><strong>SQL</strong></u>
- MySQL - The Java project was configured with a Maven pom.xml file dependency to download the correct driver. 
- Queries - Joins, RegEx, and bind variables were used with PreparedStatement Objects to safely query the database.
- ORM - Class entities were created for each of the tables being interacted with. Each of those classes matched the database column name to the Java object field name. 


---

### How to Run

---

### Lessons Learned