package final_dz.readers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import final_dz.file_classes.Seller;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderSellers extends MainReader {

    private List<Seller> sellers;

    public List<Seller> getData(String path) throws IOException {

        sellers = new ArrayList<Seller>();

        // create a reader
        Reader reader = Files.newBufferedReader(Paths.get(path));

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read json file into tree model
        JsonNode parser = objectMapper.readTree(reader);

        // read all sellers
        for (JsonNode x : parser.path("sellers")) {
            int id = x.path("id").asInt();
            String surname = x.path("surname").asText();
            String name = x.path("name").asText();
            sellers.add(new Seller(id, surname, name));
        }

        //close reader
        reader.close();

        return sellers;
    }

    public void Print(){
        for (Seller g: sellers) {
            System.out.println(g.getSurname() + " " + g.getName());
        }
    }
}
