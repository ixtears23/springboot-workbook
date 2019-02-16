

spring-boot-journal   

window 환경  

spring boot cli로 생성    


> mkdir spring-boot-journal  
> cd spring-boot-journal  
> spring init -d=web, thymeleaf,data-jpa,data-rest -g=com.apress.spring -a=spring-boot-journal --package-name=com.apress.spring -name=spring-boot-journal -x  


 - spring-boot 2.1.2
 - mysql-connector-java 8.0.15  
 - hibernate 5
 - data.sql 
 

 
 1. http://localhost/journalEntry  
  - JournalEntry.java  
 2. http://localhost/journalEntry/search/findByTitleContaining?word=부트  
  - JournalRepository.java  
 3. http://localhost/api/journalEntry  
  - application.properties  
    - spring.data.rest.base-path = /api  
 4. http://localhost/api/journal/search/findByTitleContaining?word=부트  
  - JournalRepository.java  
    - @RepositoryRestResource(collectionResourceRel="entry", path="journal")  