package utils;

import aquality.selenium.browser.AqualityServices;
import responses.JsonResponse;
import responses.Photo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public class UploadPhotoUtils {

    public static List<String> uploadPhotoOnTheWall(String uploadUrl) {
        JsonResponse jsonResponse = VkApiUtils.upload(uploadUrl,
                JsonParseUtils.getElementParseFromJson("testing.json","/pathPhoto"), "photo");
        List<String> photoOdj = new LinkedList<String>();
        photoOdj.add(jsonResponse.getBody().getObject().optString("photo"));
        photoOdj.add(jsonResponse.getBody().getObject().optString("server"));
        photoOdj.add(jsonResponse.getBody().getObject().optString("hash"));
        return photoOdj;
    }

    public static Integer photoId() {
        String uploadUrl = Photo.getWallPhotoUploadServer().getBody().getObject().getJSONObject("response").optString("upload_url");
        List<String> photoObj = UploadPhotoUtils.uploadPhotoOnTheWall(uploadUrl);
        String photo = photoObj.get(0);
        String server = photoObj.get(1);
        String hash = photoObj.get(2);
        Integer photoId = null;
        try {
            photoId = Integer.valueOf(Photo.saveUploadWallPhoto(URLEncoder.encode(photo, "UTF-8"), server, hash)
                    .getBody().getObject().getJSONArray("response").getJSONObject(0).optString("id"));
        } catch (UnsupportedEncodingException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        return photoId;
    }

}
