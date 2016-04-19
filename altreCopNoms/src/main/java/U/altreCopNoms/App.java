package U.altreCopNoms;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MongoClient mongo = new MongoClient();
        MongoDatabase database = mongo.getDatabase("classe");
        MongoCollection col = database.getCollection("classe"); 
    }
}
