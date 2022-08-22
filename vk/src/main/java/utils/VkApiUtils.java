package utils;

import aquality.selenium.browser.AqualityServices;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import responses.JsonResponse;

import java.io.File;

public class VkApiUtils {

    public static JsonResponse post(String requestPath) {
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.post(requestPath).asJson();
        } catch (UnirestException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        return new JsonResponse(response.getStatus(), response.getBody());
    }

    public static JsonResponse upload(String request, String filePath, String typeOfFile) {
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.post(request).field(typeOfFile, new File(filePath)).asJson();
        } catch (UnirestException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        return new JsonResponse(response.getStatus(), response.getBody());
    }
}
