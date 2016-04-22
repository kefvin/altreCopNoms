package U.altreCopNoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App 
{
	Scanner lector = new Scanner(System.in);

    public static void main( String[] args ){
    	App app = new App();
        MongoClient mongo = new MongoClient();
        MongoDatabase database = mongo.getDatabase("classe");
        MongoCollection col = database.getCollection("classe");
        
        String idioma = app.menu();
        String nom = app.nom();        
        
        Document criteriRecerca = new Document(idioma,nom);
        List<Document> resultats = (List<Document>) col.find(criteriRecerca).into(new ArrayList<Document>());
        
        for(Document resultat: resultats) {
        	List<String> sants = (List<String>) resultat.get("sants");
        	
        	if (sants.size() == 1 && sants.get(0).equals("1 de gener")) {
        		// no té sant
        		String observacio = (String) resultat.get("observacions");
        		System.out.println("No té sant, "+observacio);        		
        	} else {        	     	        	
        		System.out.println(sants);
        	}
        }
        
        
        
    }
    
    
    public String menu(){
    	boolean semaforo = true;
        int tria;
        
        String idioma ="";
        
        while(semaforo){
        	System.out.println("Entra 1 per buscar en castellà o 2 en català"); 
        	tria = lector.nextInt();
        	lector.nextLine();
        	if(tria == 1){
        		idioma = "castella";
        		semaforo = false;
        	}else if(tria == 2){
        		idioma = "catala";
        		semaforo = false;
        	}
        }
    	
    	return idioma;
    }
    
    public String nom(){
    	String nom = "";
    	
    	System.out.println("Quin nom vols buscar?");
    	nom = lector.next();
    	lector.nextLine();
    	
    	return nom;
    }
    
}
