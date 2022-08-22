package utils;

public class Config {

    public static final String URL = JsonParseUtils.getElementParseFromJson("config.json", "/url");
    public static final String URL_API = JsonParseUtils.getElementParseFromJson("config.json", "/urlApi");
    public static final Integer OWNER_ID = Integer.parseInt(JsonParseUtils.getElementParseFromJson("testing.json", "/idUser"));
    public static final String ACCESS_TOKEN = JsonParseUtils.getElementParseFromJson("testing.json", "/token");
    public static final String API_VERSION = JsonParseUtils.getElementParseFromJson("testing.json", "/apiVersion");
    public static final String LOGIN = JsonParseUtils.getElementParseFromJson("testing.json", "/login");
    public static final String PASSWORD = JsonParseUtils.getElementParseFromJson("testing.json", "/password");
    public static final Integer RANDOM_SIZE = Integer.parseInt(JsonParseUtils.getElementParseFromJson("testing.json", "/randomSize"));
}
