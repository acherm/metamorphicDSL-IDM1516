Cassandra Query Language
==

Present basic database manipulation, all three approaches: create a table, insert a row then query the table and print the result.

External DSL
--

Plain CQL script

Lua Internal DSL
--

Using luarocks, `luarocks install cassandra`


Java Internal DSL
--

Using [Datastax Java Driver](http://docs.datastax.com/en/developer/java-driver/2.0/java-driver/whatsNew2.html)

Dependency management is handle with maven.

Just run `mvn package && java -jar target/cql-1.0-SNAPSHOT-jar-with-dependencies.jar`
