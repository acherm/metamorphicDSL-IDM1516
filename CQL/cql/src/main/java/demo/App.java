package demo;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.policies.TokenAwarePolicy;
import com.datastax.driver.core.policies.DCAwareRoundRobinPolicy;
import com.datastax.driver.core.policies.DefaultRetryPolicy;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import com.datastax.driver.core.exceptions.AlreadyExistsException;

/**
 * Hello world!
 *
 */
public class App {

  public static void main (String[] args) {

    // Connection
    Cluster cluster = Cluster
      .builder()
      .addContactPoint("localhost")
      .withRetryPolicy(DefaultRetryPolicy.INSTANCE)
      .withLoadBalancingPolicy(
	  new TokenAwarePolicy(new DCAwareRoundRobinPolicy()))
      .build();
    Session session = cluster.connect("MyKeySpace");

    // Table creation

    try {
      session.execute("create table MyColumns (id text, Last text, First text, primary key(id))");
    } catch (AlreadyExistsException e) {
      System.out.println("Table already exists");
    }

    // Table insertion
    session.execute("INSERT INTO MyColumns (id, Last, First) VALUES ('1', 'Doe', 'John')");

    // Table query
    ResultSet results = session.execute("SELECT * FROM MyColumns");
    for (Row row : results) {
      System.out.format("%s %s\n", row.getString("first"), row.getString("last"));
    }

    cluster.close();
  }
}
