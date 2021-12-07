package final_dz.readers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import final_dz.file_classes.Sale;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderSales extends MainReader {

    private List<Sale> sales;

    public List<Sale> getData(String path) throws IOException {

        sales = new ArrayList<Sale>();

        // create a reader
        java.io.Reader reader = Files.newBufferedReader(Paths.get(path));

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read customer.json file into tree model
        JsonNode parser = objectMapper.readTree(reader);

        // read all sales
        for (JsonNode x : parser.path("sales")) {
            int id_sale = x.path("id_sale").asInt();
            int id_seller = x.path("id_seller").asInt();
            int id_good = x.path("id_good").asInt();
            int amount = x.path("amount").asInt();
            String date = x.path("date").asText();
            sales.add(new Sale(id_sale, id_seller, id_good, amount, date));
        }

        //close reader
        reader.close();

        return sales;
    }

    public void Print(){
        for (Sale s: sales) {
            System.out.println(s.getId_good() + " sold on " + s.getDate());
        }
    }
}
