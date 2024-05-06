package n2MySQL.mongoDatabase;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import n2MySQL.DAO.TicketDAO;
import n2MySQL.beans.Ticket;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketMongo implements TicketDAO {
    private MongoCollection<Document> salesCollection;

    @Override
    public void create (Ticket ticket){
        try{
            Document ticketDoc = new Document("datetime", ticket.getCreationDateTime())
                    .append("products", ticket.getProducts())
                    .append("totalPrice", ticket.getTotalAmount());
            salesCollection.insertOne(ticketDoc);
        }catch (MongoException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update (Ticket ticket){
        try{
            Bson filter = Filters.eq("_id", ticket.getTicketId());
            Document updateDoc = new Document("$set", new Document()
                    .append("detetime", ticket.getCreationDateTime())
                    .append("products", ticket.getProducts())
                    .append("totalprice", ticket.getTotalAmount()));
            salesCollection.updateOne(filter, updateDoc);
        }catch(MongoException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Ticket ticket){
        try{
            Bson filter = Filters.eq("_id", ticket.getTicketId());
            salesCollection.deleteOne(filter);
        }catch(MongoException e){
            e.printStackTrace();
        }
    }

    public List<Ticket> readAll(){ // necesita arreglar
        List<Ticket> allTickets = new ArrayList<>();
        try{
            FindIterable<Document> findIterable = salesCollection.find();
            for (Document document : findIterable) {
                Ticket ticket = new Ticket();
                allTickets.add(documen);
            }
        }catch(MongoException e){
            e.printStackTrace();
        }
        return allTickets;
    }

    public List<Document> getSalesWithProductInfo() {
        List<Document> pipeline = Arrays.asList(
                new Document("$lookup",
                        new Document("from", "products")
                                .append("localField", "products")
                                .append("foreignField", "_id")
                                .append("as", "productsInfo")
                ),
                new Document("$unwind", "$productsInfo"),
                new Document("$project",
                        new Document("_id", 1)
                                .append("datetime", 1)
                                .append("totalPrice", 1)
                                .append("product",
                                        new Document("name", "$productsInfo.name")
                                                .append("sellPrice", "$productsInfo.sellPrice")
                                                .append("costPrice", "$productsInfo.costPrice")
                                                .append("quantity", "$productsInfo.quantity")
                                                .append("type", "$productsInfo.type")
                                                .append("color", "$productsInfo.color")
                                                .append("height", "$productsInfo.height")
                                                .append("material", "$productsInfo.material")
                                )
                )
        );

        // Perform aggregation
        AggregateIterable<Document> result = salesCollection.aggregate(pipeline);
        return toList(result);
    }

    private List<Document> toList(AggregateIterable<Document> iterable) {
        List<Document> list = new ArrayList<>();
        for (Document document : iterable) {
            list.add(document);
        }
        return list;
    }

    public Ticket getOne(String id){
        ObjectId objectId = new ObjectId(id);
        Document ticket = null;
        try {
            Bson filter = Filters.eq("_id", objectId);
            ticket = salesCollection.find(filter).first();
        } catch (MongoException e) {
            e.printStackTrace();
        }
        assert ticket != null;
        return new Ticket(
                ticket.getObjectId("_id"),
                ticket.getDate("datetime"),
                ticket.getList("products"), // corregir esto
                ticket.getInteger("totalPrice"));
    }


}