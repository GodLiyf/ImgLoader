package com.example.imgloader.imgloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.imgloader.imgloader.image.NineImageViewEventAdapter;
import com.example.imgloader.imgloader.model.ImageEntity;
import com.example.imgloader.imgloader.model.ModelUtil;
import com.example.imgloader.imgloader.widget.NineImageView.ImageAttr;
import com.example.imgloader.imgloader.widget.NineImageView.NineImageView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(ModelUtil.getImages());
        recyclerView.setAdapter(adapter);
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private List<ImageEntity> list;

        RecyclerViewAdapter(List<ImageEntity> list) {
            this.list = list;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            ImageEntity entity = list.get(position);

            holder.tvTitle.setText(entity.getTitle());

            ArrayList<ImageAttr> imageAttrs = new ArrayList<>();
            for (String url : entity.getImages()) {
                ImageAttr attr = new ImageAttr();
                attr.url = url;
                imageAttrs.add(attr);
            }
            if (holder.nineImageView.getAdapter() != null) {
                holder.nineImageView.setAdapter(holder.nineImageView.getAdapter());
            } else {
                holder.nineImageView.setAdapter(new NineImageViewEventAdapter(holder.nineImageView.getContext(), imageAttrs));
            }
        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvTitle;
            NineImageView nineImageView;

            ViewHolder(View view) {
                super(view);
                tvTitle = (TextView) view.findViewById(R.id.tv_title);
                nineImageView = (NineImageView) view.findViewById(R.id.nineImageView);
            }
        }

    }
}
