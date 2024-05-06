package n2MySQL.mongoDatabase;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import n2MySQL.DAO.TreeDAO;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import n2MySQL.beans.Tree;
import java.util.ArrayList;
import java.util.List;

public class TreeMongo implements TreeDAO {
    private MongoCollection<Document> productsCollection;

    @Override
    public void create(Tree object) {
        try{
            if(object instanceof Tree tree) {
                Document productDoc = new Document("name", tree.getName())
                        .append("sellPrice", tree.getSellPrice())
                        .append("costPrice", tree.getCostPrice())
                        .append("quantity", tree.getStock())
                        .append("type", "tree")
                        .append("height", tree.getHeight());
                productsCollection.insertOne(productDoc);
            }
        }catch(MongoException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Tree object) {
        try{
            Bson filter = Filters.eq("_id", object.productId());
            Document updateDoc = new Document("$set", new Document()
                    .append("name", object.getName())
                    .append("sellPrice", object.getSellPrice())
                    .append("costPrice", object.getCostPrice())
                    .append("quantity", object.getStock())
                    .append("height", object.getHeight()));
            productsCollection.updateOne(filter, updateDoc);
        }catch(MongoException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Tree object) {
        try{
            Bson filter = Filters.eq("_id", object.productId());
            productsCollection.deleteOne(filter);
        }catch(MongoException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Tree> readAll() { //Falta id?
        List<Tree> allTrees = new ArrayList<>();
        try{
            FindIterable<Document> findIterable = productsCollection.find();
            for (Document document : findIterable) {
                if (document.getString("type").equals("tree")) {
                    Tree tree = new Tree(
                            document.getString("name"),
                            document.getDouble("sellPrice"),
                            document.getDouble("costPrice"),
                            document.getInteger("quantity"),
                            document.getInteger("height")
                    );
                    allTrees.add(tree);
                }
            }
        }catch(MongoException e){
            e.printStackTrace();
        }
        return allTrees;
    }

    @Override
    public Tree getOne(String id) {
        ObjectId objectId = new ObjectId(id);
        Document tree = null;
        try {
            Bson filter = Filters.eq("_id", objectId);
            tree = productsCollection.find(filter).first();
        } catch (MongoException e) {
            e.printStackTrace();
        }
        assert tree != null;
        return new Tree(
                tree.getString("name"),
                tree.getDouble("sellPrice"),
                tree.getDouble("costPrice"),
                tree.getInteger("quantity"),
                tree.getInteger("height"));
    }
}