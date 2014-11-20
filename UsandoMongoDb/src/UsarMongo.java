import java.net.UnknownHostException;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;


public class UsarMongo {
	
	private static Mongo m;						//server e port: localhost e 27017
	private static DB db = null;				//test
	private static DBCollection colecaoPessoas; //pessoas
	private static boolean connected = false;
	
	public static void Conectar(){
		
		try {
			m = new Mongo( "localhost" , 27017 );
			db = m.getDB( "test" );
			System.out.println("Conexão com sucesso");
			colecaoPessoas = db.getCollection("pessoas");
			connected = true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro na conexão: " + e.getMessage());
			connected = false;
		}
	}
	
	public void Inserir1(){	
		
		if (connected) {
		
			BasicDBObject pessoa = new BasicDBObject();
			
			pessoa.put("nome", "Rodrigo");
			pessoa.put("sobrenome", "Aramburu");
			pessoa.put("telefone", "1234-5678");
			         
			BasicDBObject end = new BasicDBObject();
			end.put("rua", "Rua Fulano");
			end.put("numero","221B");
			end.put("bairro", "Centro");
			         
			pessoa.put("endereco", end);
			
			String[] tels = { "1234-5678","9898-9898" };
			pessoa.put("telefone", tels);
			
			pessoa.put("idade", 31);
						
			try {
				colecaoPessoas.insert(pessoa);
				System.out.println("Inserção com sucesso");
			} catch (Exception e) {
				e.getMessage();
				System.out.println("Erro na inserção");
			}	
		}
		else {
			System.out.println("Não há conexão");
		}
	}
	
	public void Inserir2(){	
		
		if (connected) {
		
			BasicDBObject pessoa = new BasicDBObject();
			
			pessoa.put("nome", "Leonardo");
			pessoa.put("sobrenome", "Lael");
			         
			BasicDBObject end = new BasicDBObject();
			end.put("rua", "Rua Furtado Menezes");
			end.put("numero","305 ap 301");
			end.put("bairro", "Jaragua");			         
			pessoa.put("endereco", end);
			
			String[] tels = { "31-97033231","31-91703056" };
			pessoa.put("telefone", tels);
						
			try {
				colecaoPessoas.insert(pessoa);
				System.out.println("Inserção com sucesso");
			} catch (Exception e) {
				e.getMessage();
				System.out.println("Erro na inserção");
			}	
		}
		else {
			System.out.println("Não há conexão");
		}
	}
	
	public void Listar(){
		
		try {
			BasicDBObject query = new BasicDBObject();
			query.put("nome","Leonardo");
//			DBCursor cursor = colecaoPessoas.find(query);
			DBCursor cursor = colecaoPessoas.find();
			while( cursor.hasNext() ){
			        BasicDBObject pessoa = (BasicDBObject) cursor.next();
			        System.out.println( "ID: "+pessoa.getString("_id") );
			        System.out.println( "Nome: "+pessoa.getString("nome") );
			        System.out.println("Sobrenome: "+pessoa.getString("sobrenome") );
			        System.out.println("Telefone: "+pessoa.getString("telefone") );
			        System.out.println("Idade: "+pessoa.getInt("idade"));
			             
			        BasicDBObject end = (BasicDBObject) pessoa.get("endereco");
			        System.out.println( "Rua: "+end.getString("rua") );
			        System.out.println( "Numero: "+end.getString("numero") );
			        System.out.println( "Bairro: "+end.getString("bairro") );
			        System.out.println( "======================================" );
			} 
		} catch (Exception e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		}				
	}
	
	public void Atualizar(){
		BasicDBObject ant = new BasicDBObject();
		ant.put("_id", new ObjectId( "54345faf85b910f3a0f2abb8" ));
		
		BasicDBObject novo =  new BasicDBObject();
		novo.put("$set", new BasicDBObject().append("sobrenome", "Lael").append("idade", 18));
		//novo.put("idade", "16");
		
		try {
			colecaoPessoas.update(ant, novo);
			System.out.println("Atualizou");
		} catch (Exception e) {
			 System.out.println("Erro ao atualizar:" + e.getMessage());
		}		
	}
	
	public void Deletar(){
		BasicDBObject obj = new BasicDBObject();
		obj.put("_id", new ObjectId( "5434652a85b9faaa2e97c537" )  );
		colecaoPessoas.remove(obj);
	}
	
}
