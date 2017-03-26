package MavenGIT.MavenGITProj;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
 
import com.mongodb.*;
import com.mongodb.client.*;
 
 
public class connectMongo {
               
                static List<Integer> books = Arrays.asList(27464, 747854);
                static DBObject person = new BasicDBObject("_id", "jo")
                                            .append("name", "Jo Bloggs")
                                            .append("address", new BasicDBObject("street", "123 Fake St")
                                                                         .append("city", "Faketon")
                                                                         .append("state", "MA")
                                                                         .append("zip", 12345))
                                            .append("books", books);
               
                public static void main(String args[])
                {
 
                                try{
                                MongoClientURI uri = new MongoClientURI("mongodb://admin:admin@cluster0-shard-00-00-dvqwg.mongodb.net:27017,cluster0-shard-00-01-dvqwg.mongodb.net:27017,cluster0-shard-00-02-dvqwg.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");
                                MongoClient mongoClient = new MongoClient(uri);
                                //System.out.println(mongoClient.getAddress());
                                //MongoDatabase database = mongoClient.getDatabase("testDB");
                               
                                DB database = mongoClient.getDB("Examples");
                                String dbs  = database.getName();
                                System.out.println(dbs);
                               
                                //Create collection & Insert person
                                DBCollection collection = database.getCollection("people");
                                collection.insert(person);
                                System.out.println("Added person into table");
                               
                                //Query for the person
                                DBObject query = new BasicDBObject("_id", "jo");
                                DBCursor cursor = collection.find(query);
                                DBObject jo = cursor.one();
                               
                                System.out.println("Read from DB:"+jo.get("name"));                 
                               
                                /*MongoIterable<String> tables = database.listCollectionNames();
                                for(String coll : tables){
                                                System.out.println(coll);                              
                                }
                                */
                                mongoClient.close();
                                }
                                catch(Exception e)
                                {
                                                e.printStackTrace();
                                                e.getMessage();
                                }
 
                               
                }
               
}