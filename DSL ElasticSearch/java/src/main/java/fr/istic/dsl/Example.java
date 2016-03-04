package fr.istic.dsl;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

/**
 * @author Monica Fernandez Armenta
 */

public class Example {

    public static void main(String ... args){

        QueryBuilder query = QueryBuilders
                .boolQuery()
                .must(QueryBuilders.termQuery("title", "Example"))
                .must(QueryBuilders.termQuery("author", "fracma"));

        System.out.println(query);
    }

}
