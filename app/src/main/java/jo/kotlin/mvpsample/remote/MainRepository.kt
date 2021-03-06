package jo.kotlin.mvpsample.remote

import jo.kotlin.mvpsample.util.Mockable
import jo.kotlin.mvpsample.view.data.PhotoResponse

/**
 * Created by Jo on 2018. 4. 2.
 */

@Mockable
class MainRepository : MainDataSource{

    private val remoteDataSource by lazy {
        RemoteDataSource()
    }

    override fun getSearchPhotos(format: String, nojsoncallback: String, method: String,
                                 searchKeyword: String, flickrKey: String, requestPage: Int,
                                 requestPerPage: Int, callback: MainDataSource.LoadFlickrCallback) {

        remoteDataSource.getSearchPhotos(format, nojsoncallback, method, searchKeyword, flickrKey, requestPage, requestPerPage,
                object : MainDataSource.LoadFlickrCallback {

                    override fun onSuccess(t: PhotoResponse) {
                        callback.onSuccess(t)
                    }

                    override fun onFailure(message: String) {
                        callback.onFailure(message)
                    }
                })
    }
}