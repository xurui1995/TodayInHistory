package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xw.todayinhistory.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import model.Histories;
import model.News;

/**
 * Created by xw on 2016/11/15.
 */
public class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.ViewHolder>{
    private List<Histories.HistoryBean> datas;
    private Context context;
    public static final String TAG = "HisAdapter";

    public HistoryRecyclerAdapter(Context context, List<Histories.HistoryBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.history_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Histories.HistoryBean bean=datas.get(position);
        holder.title.setText(bean.getTitle());
        holder.content.setText(bean.getYear()+"-"+bean.getMonth()+"-"+bean.getDay());
        if (bean.getPic()!=null) {
            Glide.with(context).load(bean.getPic())
                    .error(R.drawable.nopic)
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {
        @BindView(R.id.his_item_image)
        ImageView imageView;
        @BindView(R.id.his_item_title)
        TextView title;
        @BindView(R.id.his_item_content)
        TextView content;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
