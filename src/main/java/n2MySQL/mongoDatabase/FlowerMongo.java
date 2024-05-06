package n2MySQL.mongoDatabase;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import n2MySQL.DAO.FlowerDAO;
import com.mongodb.client.model.Filters;
import n2MySQL.beans.Flower;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class FlowerMongo implements FlowerDAO {
    private MongoCollection<Document> productsCollection;

    @Override
    public void create(Flower object) {
        try{
            if(object instanceof Flower flower) {
                Document productDoc = new Document("name", flower.getName())
                        .append("sellPrice", flower.getSellPrice())
                        .append("costPrice", flower.getCostPrice())
                        .append("quantity", flower.getStock())
                        .append("type", "flower")
                        .append("color", flower.getColour());
                productsCollection.insertOne(productDoc);
            }
        }catch(MongoException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Flower object) {
        try{
            Bson filter = Filters.eq("_id", object.getProduct_id());
            Document updateDoc = new Document("$set", new Document()
                    .append("name", object.getName())
                    .append("sellPrice", object.getSellPrice())
                    .append("costPrice", object.getCostPrice())
                    .append("quantity", object.getStock())
                    .append("color", object.getColour()));
            productsCollection.updateOne(filter, updateDoc);
        }catch(MongoException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Flower object) {
        try{
            Bson filter = Filters.eq("_id", object.getProduct_id());
            productsCollection.deleteOne(filter);
        }catch(MongoException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Flower> readAll() { //Falta id?
        List<Flower> allFlowers = new ArrayList<>();
        try{
            FindIterable<Document> findIterable = productsCollection.find();
            for (Document document : findIterable) {
                if (document.getString("type").equals("flower")) {
                    Flower flower = new Flower(
                            document.getString("name"),
                            document.getDouble("sellPrice"),
                            document.getDouble("costPrice"),
                            document.getInteger("quantity"),
                            document.getString("material")
                    );
                    allFlowers.add(flower);
                }
            }
        }catch(MongoException e){
            e.printStackTrace();
        }
        return allFlowers;
    }

    @Override
    public Flower getOne(String id) {
        ObjectId objectId = new ObjectId(id);
        Document flower = null;
        try {
            Bson filter = Filters.eq("_id", objectId);
            flower = productsCollection.find(filter).first();
        } catch (MongoException e) {
            e.printStackTrace();
        }
        assert flower != null;
        return new Flower(
                flower.getString("name"),
                flower.getDouble("sellPrice"),
                flower.getDouble("costPrice"),
                flower.getInteger("quantity"),
                flower.getString("color"));
    }
}
