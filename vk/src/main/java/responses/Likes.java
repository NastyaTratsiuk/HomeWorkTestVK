package responses;

import enums.Methods;

import utils.Config;
import utils.JsonParseUtils;
import utils.VkApiUtils;

public class Likes {

    private static final int trueLike = Integer.parseInt(JsonParseUtils.getElementParseFromJson("testing.json", "/trueLike"));

    public static boolean isPostLiked(int postId) {
        String request = String.format("'%s''%s'?user_ids='%s'&post_id='%d'&access_token='%s'&v='%s'",
                Config.URL_API, Methods.WALL_LIKE.getNameMethod(),
                Config.OWNER_ID, postId, Config.ACCESS_TOKEN, Config.API_VERSION);
        JsonResponse jsonResponse = VkApiUtils.post(request);
        int result = Integer.parseInt(jsonResponse.getBody().getObject().getJSONObject("response").optString("likes"));
        return result == trueLike;
    }
}
