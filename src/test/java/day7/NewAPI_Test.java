package day7;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.NewsApi_Articles;
import test_util.NewsApi_BaseTest;

import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.*;
public class NewAPI_Test extends NewsApi_BaseTest {
    // https://newsapi.org/v2/top-headlines?country=us&category=business
    @DisplayName("News API /Top Headlines printing author name")
    @Test
    public void newsApiTest() {
        String apiKey = "d7a6d82a9e284b619ea18b166c71c025";
        List<NewsApi_Articles> allArticles =
                given()
                        .log().uri()
                        .queryParam("apiKey", apiKey)
                        .queryParam("country", "us")
                        .queryParam("category", "business")
                        .when()
                        .get("/top-headlines")
                        .jsonPath()
                        .getList("articles", NewsApi_Articles.class);

     List<NewsApi_Articles> cleanList = new ArrayList<>();

        //System.out.println(allArticles.get(0).getSource().get("id"));
        for (NewsApi_Articles each: allArticles){
            if ( !(each.getSource().get("id")== null) ){
                cleanList.add(each);
            }
        }
        System.out.println(cleanList.size());
        System.out.println(allArticles.size());

        for (NewsApi_Articles each: cleanList){
            System.out.println("---------------------------------");
            System.out.println(each);
            System.out.println("--------------------------------");
        }

    }
}