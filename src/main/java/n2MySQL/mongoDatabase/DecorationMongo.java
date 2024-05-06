package n2MySQL.mongoDatabase;
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
    public void create(Decoration object) { //falta ver se tem que botar try catch
        if(object instanceof Decoration decoration) {
            Document productDoc = new Document("name", decoration.getName())
                    .append("sellPrice", decoration.getSellPrice())
                    .append("costPrice", decoration.getCostPrice())
                    .append("quantity", decoration.getStock())
                    .append("type", "decoration")
                    .append("material", decoration.getMaterial());
            productsCollection.insertOne(productDoc);
        }
    }

    @Override
    public void update(Decoration object) {
        Bson filter = Filters.eq("_id", object.getProductId());
        Document updateDoc = new Document("$set", new Document()
                .append("name", object.getName())
                .append("sellPrice", object.getSellPrice())
                .append("costPrice", object.getCostPrice())
                .append("quantity", object.getStock())
                .append("material", object.getMaterial()));
        productsCollection.updateOne(filter, updateDoc);
    }

    @Override
    public void delete(Decoration object) {
        Bson filter = Filters.eq("_id", object.getProductId());
        productsCollection.deleteOne(filter);
    }

    @Override
    public List<Decoration> readAll() {
        List<Decoration> decorations = new ArrayList<>();
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
                decorations.add(decoration);
            }
        }
        return decorations;
    }

    @Override
    public Decoration getOne(String id) {
        ObjectId objectId = new ObjectId(id);
        Bson filter = Filters.eq("_id", objectId);
        Document decoration = productsCollection.find(filter).first();
        assert decoration != null;
        return new Decoration(
                decoration.getString("name"),
                decoration.getDouble("sellPrice"),
                decoration.getDouble("costPrice"),
                decoration.getInteger("quantity"),
                decoration.getString("material"));
    }
}
