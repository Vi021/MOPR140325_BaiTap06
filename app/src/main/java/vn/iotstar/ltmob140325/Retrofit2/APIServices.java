package vn.iotstar.ltmob140325.Retrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices {
    @GET("categories.php")
    Call<List<CategoryModel>> getAllCategories();
}
