package responses;

import enums.Methods;
import utils.*;

public class Wall {

    private static int postId;
    private static String textPost;
    private static String textPostAfterEdit;

    public static int getPostId() {
        return postId;
    }

    public static void setPostId(int postId) {
        Wall.postId = postId;
    }


    public static String getTextPost() {
        return textPost;
    }

    public static void setTextPost(String textPost) {
        Wall.textPost = textPost;
    }

    public static String getTextPostAfterEdit() {
        return textPostAfterEdit;
    }

    public static void setTextPostAfterEdit(String textPostAfterEdit) {
        Wall.textPostAfterEdit = textPostAfterEdit;
    }

    public static JsonResponse postTextMessageToTheWall(String text) {
        String request = String.format("'%s''%s'?user_ids='%s'&message='%s'&access_token='%s'&v='%s'",
                Config.URL_API, Methods.WALL_POST.getNameMethod(),
                Config.OWNER_ID, text, Config.ACCESS_TOKEN, Config.API_VERSION);
        JsonResponse jsonResponse = VkApiUtils.post(request);
        String postId = jsonResponse.getBody().getObject().getJSONObject("response").optString("post_id");
        setPostId(Integer.parseInt(postId));
        setTextPost(text);
        return jsonResponse;
    }

    public static JsonResponse editPostOnTheWall(int postId, String text) {
        String request = String.format("'%s''%s'?user_ids='%s'&post-id='%d'&attachment='%d'&message='%s'&access_token='%s'&v='%s'",
                Config.URL_API, Methods.WALL_EDIT.getNameMethod(),
                Config.OWNER_ID, postId, UploadPhotoUtils.photoId(), text, Config.ACCESS_TOKEN, Config.API_VERSION);
        JsonResponse jsonResponse = VkApiUtils.post(request);
        setTextPostAfterEdit(text);
        return jsonResponse;
    }

    public static JsonResponse commitPostWall(int postId, String text) {
        String request = String.format("'%s''%s'?user_ids='%s'&post_id='%d'&message='%s'&access_token='%s'&v='%s'",
                Config.URL_API, Methods.METHODCREATECOMMENT.getNameMethod(),
                Config.OWNER_ID, postId, text, Config.ACCESS_TOKEN, Config.API_VERSION);
        JsonResponse jsonResponse = VkApiUtils.post(request);
        return jsonResponse;
    }

    public static JsonResponse deletePostOnTheWall(int postId) {
        String request = String.format("'%s''%s'?user_ids='%s'&post_id='%d'&access_token='%s'&v='%s'",
                Config.URL_API, Methods.WALL_DELETE.getNameMethod(),
                Config.OWNER_ID, postId, Config.ACCESS_TOKEN, Config.API_VERSION);
        JsonResponse jsonResponse = VkApiUtils.post(request);
        return jsonResponse;
    }
}
