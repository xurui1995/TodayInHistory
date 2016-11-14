package RetrofitService;

import model.Girls;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by xw on 2016/11/14.
 */
public interface GankService {
    @GET("data/福利/{num}/{page}")
    Observable<Girls> getPictures(
            @Path("num")int num,
            @Path("page")int page);
}
