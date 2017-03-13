# Build
mvn clean package

# Database properties (default)
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=postgres

# Gtfs file path (default)
gtfs.import.file=budapest_gtfs.zip

# Run application with command line parameters
java -jar target/gtfstopostgres-0.0.1-SNAPSHOT.jar gtfs-import --spring.datasource.url=jdbc:postgresql://localhost:5432/database --spring.datasource.username=username --spring.datasource.password=password --gtfs.import.file=some-gtfs.zip

# Or create application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/database
spring.datasource.username=username
spring.datasource.password=password
gtfs.import.file=some-gtfs.zip