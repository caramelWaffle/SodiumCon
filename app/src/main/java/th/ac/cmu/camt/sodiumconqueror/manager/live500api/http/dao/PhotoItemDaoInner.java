package th.ac.cmu.camt.sodiumconqueror.manager.live500api.http.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chart on 22/7/2559.
 */
public class PhotoItemDaoInner {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("profile_picture")
    @Expose
    private String profilePicture;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = new ArrayList<Object>();
    @SerializedName("created_time")
    @Expose
    private String createdTime;
    @SerializedName("camera")
    @Expose
    private String camera;
    @SerializedName("lens")
    @Expose
    private String lens;
    @SerializedName("focal_length")
    @Expose
    private String focalLength;
    @SerializedName("iso")
    @Expose
    private String iso;
    @SerializedName("shutter_speed")
    @Expose
    private String shutterSpeed;
    @SerializedName("aperture")
    @Expose
    private String aperture;


    public Integer getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public List<Object> getTags() {
        return tags;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getCamera() {
        return camera;
    }

    public String getLens() {
        return lens;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public String getIso() {
        return iso;
    }

    public String getShutterSpeed() {
        return shutterSpeed;
    }

    public String getAperture() {
        return aperture;
    }
}
