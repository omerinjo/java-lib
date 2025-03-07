# Java Match Library 🏆

This library provides an interface and implementation for managing football matches.  
It allows you to **create, update, and retrieve matches**, while also keeping track of their results.

## 📦 Installation

1️⃣ To use this library in your Java project, **install the `.jar` file in your local Maven repository**:

mvn install:install-file \
   -Dfile=target/java-lib-1.0-SNAPSHOT.jar \
   -DgroupId=com.example \
   -DartifactId=java-lib \
   -Dversion=1.0-SNAPSHOT \
   -Dpackaging=jar
   
Then, add the following dependency to your pom.xml:

<dependency>
    <groupId>com.example</groupId>
    <artifactId>java-lib</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>

2️⃣ If you don't want to install the library in your global Maven repository, simply copy the .jar file into a folder inside your project (e.g., lib/), and manually reference it in pom.xml:

<dependency>
    <groupId>com.example</groupId>
    <artifactId>java-lib</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/src/main/resources/lib/java-lib-1.0-SNAPSHOT.jar</systemPath>
</dependency>


🚀 Usage
1️⃣ Obtain an instance of the service using the factory

    matchService.createMatch("Argentina", "Brazil", new Date());

2️⃣ Create a new match

    matchService.createMatch("Argentina", "Brazil", new Date());

4️⃣ Update a match result

    matchService.updateResult(2, 1, 0); // Set score 2-1 for match with index 0

5️⃣ End a match

   matchService.endMatch(0); // Removes match at index 0



📜 API Methods
🏗️ IMatchService Interface
The library provides the following methods for match management:

createMatch(String homeTeam, String awayTeam, Date date)	Creates a new match and adds it to the match list.
endMatch(int matchId)	Removes a match from the match list based on its index.
updateResult(int homeScore, int awayScore, int matchId)	Updates the score of an existing match.
getAllResults()	Returns all matches, sorted first by total score and then by date.


🏗 Internal Implementation
The library contains:

IMatchService → Interface defining the contract for match management.
BoardServiceImpl → The implementation of IMatchService (stores matches in a list).
MatchServiceFactory → Factory class to create instances of IMatchService.

import com.example.IMatchService;
import com.example.MatchServiceFactory;

IMatchService matchService = MatchServiceFactory.newInstance();


🔥 Error Handling
The library uses MatchValidation to ensure match IDs are valid before updating or deleting matches.
If an invalid match ID is provided, an error message will be printed instead of throwing an exception.

🛠 Development & Contribution
To build the project:
mvn clean package

To run unit tests:
mvn test
```
