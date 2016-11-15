package RetrofitService;

import model.Histories;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xw on 2016/11/15.
 */
public interface HistoriesService {
    @GET("japi/toh")
    Observable<Histories> getHistoriesDatas(
            @Query("v") String v,
            @Query("month")int month,
            @Query("day")int day,
            @Query("key")String key);

}
