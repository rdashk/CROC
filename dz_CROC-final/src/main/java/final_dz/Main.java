package final_dz;

import final_dz.file_classes.Goods;
import final_dz.file_classes.GoodsAndSellers;
import final_dz.file_classes.Sale;
import final_dz.readers.ReaderGoods;
import final_dz.readers.ReaderGoodsFromSellers;
import final_dz.readers.ReaderSales;
import final_dz.writers.WriterXML;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {

            // get information from json-files
            ReaderGoods readerGoods = new ReaderGoods();
            List<Goods> goods = (List<Goods>) readerGoods.getData("goods.json");

            ReaderGoodsFromSellers readerIsHas = new ReaderGoodsFromSellers();
            List<GoodsAndSellers> goodsAndSellers = (List<GoodsAndSellers>) readerIsHas.getData("is_has.json");

            ReaderSales readerSales = new ReaderSales();
            List<Sale> sales = (List<Sale>) readerSales.getData("sales.json");

            // get files with answers
            task1(goods, goodsAndSellers);
            task2(sales);

        } catch (IOException e) {
            System.out.println("File is not exist");;
        }
    }

    /**
     * Getting middle value of sold goods in each date
     * @param sales list of sold goods
     */
    private static void task2(List<Sale> sales) {

        Map<String, Pair> map = new HashMap<String, Pair>();

        String date;

        for (Sale s: sales) {
            date = s.getDate();

            // if map contains discovered date
            if (map.containsKey(date)) {

                // add to set of id_goods new id_good
                map.get(date).getSet().add(s.getId_good());

                map.get(date).addToSecond(s.getAmount());
            } else {
                map.put(date, new Pair(s.getId_good(), s.getAmount()));
            }
        }

        // counting middle value (amount of all goods divide to amount of different goods)
        Map<String, Integer> answer = new HashMap<String, Integer>();
        for (Map.Entry<String, Pair> x : map.entrySet()) {
            String key = x.getKey();
            int mid = x.getValue().getSecond()/x.getValue().getSet().size();
            answer.put(key, mid);
        }

        // answer to xml-file
        WriterXML writerXML = new WriterXML();
        writerXML.writeToXML(answer, new String[]{"task2", "date", "middle"}, "answer_task2.xml");
        //System.out.println(answer);

    }

    /**
     * Getting good with his amount
     * @param goods list of goods
     * @param is_has list of seller's goods
     */
    private static void task1(List<Goods> goods, List<GoodsAndSellers> is_has) {

        Map<String, Integer> goodAmount = new HashMap<String, Integer>();

        for (Goods g: goods) {
            goodAmount.put(g.getName(), 0);
        }
        for (GoodsAndSellers x: is_has) {
            String goodName = getGoodsName(goods, x.getId_goods());

            // add discovered amount
            int amount = goodAmount.get(goodName);
            goodAmount.put(goodName, amount + x.getAmount());
        }

        // answer to xml-file
        WriterXML xml = new WriterXML();
        xml.writeToXML(goodAmount, new String[]{"task1", "name", "amount"}, "answer_task1.xml");
    }

    /**
     * Finding good's name from id
     * @param list good's list
     * @param id number need good
     * @return good's name from his id
     */
    public static String getGoodsName(final List<Goods> list, final int id){
        return list.stream().filter(o -> o.getId() == (id)).findFirst().get().getName();
    }

}
