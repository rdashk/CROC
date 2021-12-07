package final_dz.readers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import final_dz.file_classes.Goods;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderGoods extends MainReader {

    private List<Goods> goods;

    public List<Goods> getData(String path) throws IOException {

        goods = new ArrayList<Goods>();

        // create a reader
        Reader reader = Files.newBufferedReader(Paths.get(path));

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read customer.json file into tree model
        JsonNode parser = objectMapper.readTree(reader);

        // read all goods
        for (JsonNode x : parser.path("goods")) {
            int id = x.path("id").asInt();
            String name = x.path("name").asText();
            goods.add(new Goods(id, name));
        }

        //close reader
        reader.close();

        return goods;
    }

    public void Print(){
        for (Goods g: goods) {
            System.out.println(g.getName());
        }
    }
}
