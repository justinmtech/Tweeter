# Twitter-Clone
A simple replication of Twitter built in Spring.

# Setup
1. Download the latest release JAR file
2. Place it into a folder of its own preferably
3. Create an application.properties file with the proper settings
4. Run the JAR file with a terminal using "java -jar <jarFileName>.jar"

# Configuration
- server.port = 8080
- spring.datasource.url = jdbc:mysql://localhost:3306/db
- spring.datasource.username = root
- spring.datasource.password = password
- spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
- spring.jpa.hibernate.ddl-auto = update
- spring.jpa.open-in-view = true
- spring.jpa.properties.hibernate.globally_quoted_identifiers = false
