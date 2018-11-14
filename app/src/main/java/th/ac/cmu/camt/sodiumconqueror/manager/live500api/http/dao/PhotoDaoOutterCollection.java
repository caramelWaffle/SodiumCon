package th.ac.cmu.camt.sodiumconqueror.manager.live500api.http.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chart on 22/7/2559.
 */
public class PhotoDaoOutterCollection {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<PhotoItemDaoInner> data = new ArrayList<PhotoItemDaoInner>();

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<PhotoItemDaoInner> getData() {
        return data;
    }

    public void setData(List<PhotoItemDaoInner> data) {
        this.data = data;
    }
}
