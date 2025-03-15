package vn.iotstar.ltmob140325.Retrofit2;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.iotstar.ltmob140325.R;

public class MainActivity extends AppCompatActivity {
    RecyclerView reVw_categories;
    CategoryAdapter categoryAdapter;
    APIServices apiServices;
    List<CategoryModel> categoryModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        reVw_categories = findViewById(R.id.reVw_catgories);

        getCategories();
    }

    public void getCategories() {

        apiServices = RetrofitClient.getClient("http://app.iotstar.vn:8081/appfoods/").create(APIServices.class);
        apiServices.getAllCategories().enqueue(new Callback<List<CategoryModel>>() {
            @Override
            public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
                if (response.isSuccessful()) {
                    categoryModelList = response.body();

                    categoryAdapter = new CategoryAdapter(MainActivity.this, categoryModelList);

                    reVw_categories.setHasFixedSize(true);
                    reVw_categories.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    reVw_categories.setAdapter(categoryAdapter);

                    categoryAdapter.notifyDataSetChanged();
                } else {
                    int satusCode = response.code();
                    Log.e("LTMob140325", "Retrofit_Code: " + satusCode);
                }
            }

            @Override
            public void onFailure(Call<List<CategoryModel>> call, Throwable t) {
                Log.e("LTMob140325", "Retrofit_Error: " + t.getMessage());
            }
        });
    }
}