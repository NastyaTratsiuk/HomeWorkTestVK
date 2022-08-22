package responses;

import enums.Methods;
import utils.Config;
import utils.VkApiUtils;

public class Photo {

    public static JsonResponse getWallPhotoUploadServer() {
        String request = String.format("'%s''%s'?user_ids='%s'&access_token='%s'&v='%s'",
                Config.URL_API, Methods.METHODUPLOADPHOTO.getNameMethod(),
                Config.OWNER_ID, Config.ACCESS_TOKEN, Config.API_VERSION);
        JsonResponse jsonResponse = VkApiUtils.post(request);
        return jsonResponse;
    }

    public static JsonResponse saveUploadWallPhoto(String photo, String server, String hash) {
        String request = String.format("'%s''%s'?user_ids='%s'&photo='%s'&server='%s'&hash='%s'&access_token='%s'&v='%s'",
                Config.URL_API, Methods.METHODSAVEWALLPHOTO.getNameMethod(),
                Config.OWNER_ID, photo, server, hash, Config.ACCESS_TOKEN, Config.API_VERSION);
        JsonResponse jsonResponse = VkApiUtils.post(request);
        return jsonResponse;
    }
}
