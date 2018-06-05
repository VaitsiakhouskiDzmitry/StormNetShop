import org.codehaus.jackson.map.ObjectMapper;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.post;

public class Controller {
 //   public static void main(String[] args) {
//        Route getRoute = new Route(){
//            @Override
//            public Object handle(Request request, Response response)throws Exception{
//                return "this is GET request";
//            }
//        };
//        Route postRoute = new Route(){
//            @Override
//            public Object handle(Request request, Response response)throws Exception{
//                return "this is POST request";
//            }
//        };
//        get("/SimpleGet",getRoute);
//        post("/SimplePost",postRoute);
        private static final ObjectMapper mapper = new ObjectMapper();
        private static Route getAllGoodsRoute(){
            Route getRoute = new Route(){
                @Override
                public Object handle(Request request, Response response)throws Exception{
                    String allGoods =mapper.writeValueAsString(ShopDAO.FindAllGoods());
                    return allGoods;
                }
            };
            return getRoute;
        }

    public static void main(String[] args) {
        get("/getAllGoods",getAllGoodsRoute());
    }

    }

