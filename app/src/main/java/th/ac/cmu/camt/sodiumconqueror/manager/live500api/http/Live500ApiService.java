package th.ac.cmu.camt.sodiumconqueror.manager.live500api.http;

import retrofit2.Call;
import retrofit2.http.POST;
import th.ac.cmu.camt.sodiumconqueror.manager.live500api.http.dao.PhotoDaoOutterCollection;

/**
 * Created by Chart on 22/7/2559.
 */
public interface Live500ApiService {
    @POST("courses/500px/list")
    Call<PhotoDaoOutterCollection>  loadphotolistfunction();
}
