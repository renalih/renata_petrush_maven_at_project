package tasks.classwork20day;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import gherkin.deps.com.google.gson.stream.JsonReader;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import tasks.classwork21day.Search;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class MyParser {

    private static final String JSON = "src/test/resources/testdata/recipe.json";
    private static final String XML = "src/test/resources/testdata/recipe.xml";

    public void parseGSON() throws FileNotFoundException {

        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);

        System.out.println(recipe.getRecipename());
        System.out.println(recipe.getIngredlist());
        System.out.println(recipe.getPreptime());
    }

    public void fromGSON() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Ingredient> ingridientList = new ArrayList<>();
        ingridientList.add(new Ingredient("tomato", 3));
        ingridientList.add(new Ingredient("carrot", 1));
        ingridientList.add(new Ingredient("oil", 2));
        Recipe recipe = new Recipe("salat", ingridientList, 15);
        System.out.println(gson.toJson(recipe));
    }

    public static String fromGSON2(Search search) {
        Gson gson = new Gson();
        return gson.toJson(search);
    }

    public void parseDOM() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File(XML);
        System.out.println(file.toString());
        Document doc = builder.parse(file);
        System.out.println(doc.getElementsByTagName("recipename").item(0).getTextContent());

    }
}
