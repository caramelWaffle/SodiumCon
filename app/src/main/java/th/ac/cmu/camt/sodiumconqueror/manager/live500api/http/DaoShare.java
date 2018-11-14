package th.ac.cmu.camt.sodiumconqueror.manager.live500api.http;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import th.ac.cmu.camt.sodiumconqueror.manager.live500api.http.dao.PhotoDaoOutterCollection;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DaoShare {

    private static DaoShare instance;

    public static DaoShare getInstance() {
        if (instance == null)
            instance = new DaoShare();
        return instance;
    }

    private Context mContext;

    private DaoShare() {
        mContext = Contextor.getInstance().getContext();
    }
    private PhotoDaoOutterCollection dao;

    public PhotoDaoOutterCollection getDao() {
        return dao;
    }

    public void setDao(PhotoDaoOutterCollection dao) {
        this.dao = dao;
    }
}
