package final_dz.readers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import final_dz.file_classes.GoodsAndSellers;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderGoodsFromSellers extends MainReader {

    private List<GoodsAndSellers> is_has;

    public List<GoodsAndSellers> getData(String path) throws IOException {

        is_has = new ArrayList<GoodsAndSellers>();

        // create a reader
        Reader reader = Files.newBufferedReader(Paths.get(path));

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read json file into tree model
        JsonNode parser = objectMapper.readTree(reader);

        // read all
        for (JsonNode x : parser.path("is_has")) {
            int id_seller = x.path("id_seller").asInt();
            int id_good = x.path("id_good").asInt();
            int price = x.path("price").asInt();
            int amount = x.path("amount").asInt();
            is_has.add(new GoodsAndSellers(id_seller, id_good, price, amount));
        }

        //close reader
        reader.close();

        return is_has;
    }

}
