package enums;

public enum Methods {

    WALL_POST("method/wall.post"),
    WALL_EDIT("method/wall.edit"),
    METHODUPLOADPHOTO("method/photos.getWallUploadServer"),
    METHODSAVEWALLPHOTO("method/photos.saveWallPhoto"),
    METHODCREATECOMMENT("method/wall.createComment"),
    WALL_DELETE("method/wall.delete"),
    WALL_LIKE("method/wall.addLike");

    private String nameMethod;

    public String getNameMethod() {
        return nameMethod;
    }

    public void setNameMethod(String nameMethod) {
        this.nameMethod = nameMethod;
    }

    Methods(String nameMethod) {
        this.nameMethod = nameMethod;
    }
}
