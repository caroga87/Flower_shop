package n2MySQL.mongoDatabase;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import n2MySQL.DAO.DecorationDAO;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import n2MySQL.beans.Decoration;
import java.util.ArrayList;
import java.util.List;

public class DecorationMongo implements DecorationDAO {
    private MongoCollection<Document> productsCollection;

    @Override
    public void create(Decoration object) {
        try{
            if(object instanceof Decoration decoration) {
                Document productDoc = new Document("name", decoration.getName())
                        .append("sellPrice", decoration.getSellPrice())
                        .append("costPrice", decoration.getCostPrice())
                        .append("quantity", decoration.getStock())
                        .append("type", "decoration")
                        .append("material", decoration.getMaterial());
                productsCollection.insertOne(productDoc);
            }
        }catch(MongoException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Decoration object) {
        try{
            Bson filter = Filters.eq("_id", object.getProduct_id());
            Document updateDoc = new Document("$set", new Document()
                    .append("name", object.getName())
                    .append("sellPrice", object.getSellPrice())
                    .append("costPrice", object.getCostPrice())
                    .append("quantity", object.getStock())
                    .append("material", object.getMaterial()));
            productsCollection.updateOne(filter, updateDoc);
        }catch(MongoException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Decoration object) {
        try{
            Bson filter = Filters.eq("_id", object.getProduct_id());
            productsCollection.deleteOne(filter);
        }catch(MongoException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Decoration> readAll() { //Falta id?
        List<Decoration> allDecorations = new ArrayList<>();
        try{
            FindIterable<Document> findIterable = productsCollection.find();
            for (Document document : findIterable) {
                if (document.getString("type").equals("decoration")) {
                    Decoration decoration = new Decoration(
                            document.getString("name"),
                            document.getDouble("sellPrice"),
                            document.getDouble("costPrice"),
                            document.getInteger("quantity"),
                            document.getString("material")
                    );
                    allDecorations.add(decoration);
                }
            }
        }catch(MongoException e){
            e.printStackTrace();
        }
        return allDecorations;
    }

    @Override
    public Decoration getOne(String id) {
        ObjectId objectId = new ObjectId(id);
        Document decoration = null;
        try {
            Bson filter = Filters.eq("_id", objectId);
            decoration = productsCollection.find(filter).first();
        } catch (MongoException e) {
            e.printStackTrace();
        }
        assert decoration != null;
        return new Decoration(
                decoration.getString("name"),
                decoration.getDouble("sellPrice"),
                decoration.getDouble("costPrice"),
                decoration.getInteger("quantity"),
                decoration.getString("material"));
    }
}
