package vn.iotstar.ltmob140325.Retrofit2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import vn.iotstar.ltmob140325.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    Context context;
    List<CategoryModel> categoryModelList;

    public CategoryAdapter(Context context, List<CategoryModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView img_category;
        TextView txt_cateName;

        public CategoryViewHolder(View itemView) {
            super(itemView);

            img_category = itemView.findViewById(R.id.img_category);
            img_category.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(context, "Ya clicked a category?", Toast.LENGTH_SHORT).show();
                    Snackbar snackbar = Snackbar.make(view, "Ya clicked a category?", Snackbar.LENGTH_INDEFINITE);
                    snackbar.setDuration(500);
                    snackbar.show();
                }
            });

            txt_cateName = itemView.findViewById(R.id.txt_cateName);
        }
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycleritem_category, null);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryModel category = categoryModelList.get(position);

        holder.txt_cateName.setText(category.getCateName());
        Glide.with(context).load(category.getCateImg()).into(holder.img_category);
    }

    @Override
    public int getItemCount() {
        return categoryModelList == null ? 0 : categoryModelList.size();
    }
}
