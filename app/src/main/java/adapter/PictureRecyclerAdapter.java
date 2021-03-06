package adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xw.todayinhistory.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import model.Girls;

/**
 * Created by xw on 2016/11/14.
 */
public class PictureRecyclerAdapter extends RecyclerArrayAdapter<Girls.ResultsBean> {

    public PictureRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new PictureViewHolder(parent);
    }
    class PictureViewHolder extends BaseViewHolder<Girls.ResultsBean> {
        private ImageView pictureImage;
        private TextView pictureText;
        private CardView cardView;

        public PictureViewHolder(ViewGroup parent) {
            super(parent, R.layout.girls_item);
            pictureImage = $(R.id.adapter_picture_image);
            pictureText = $(R.id.adapter_picture_text);
            cardView = $(R.id.picture_item_cardview);
    /*      ViewGroup.LayoutParams imageViewParams = pictureImage.getLayoutParams();
           imageViewParams.height = (int) (200 + Math.random()*300);
          pictureImage.setLayoutParams(imageViewParams);*/
        }

        @Override
        public void setData(Girls.ResultsBean data) {
            super.setData(data);
            Glide.with(getContext())
                    .load(data.getUrl())
                    .error(R.mipmap.ic_launcher)
                    .into(pictureImage);
//            Picasso.with(getContext())
//                    .load(data.getUrl())
//                    .placeholder(R.mipmap.ic_launcher)
//                    .into(pictureImage);
            pictureText.setText(data.getDesc());

//            ViewGroup.LayoutParams imageViewParams = pictureImage.getLayoutParams();
//            ViewGroup.LayoutParams textViewParams = pictureText.getLayoutParams();
//            ViewGroup.LayoutParams cardViewParams = cardView.getLayoutParams();
//            cardViewParams.height = imageViewParams.height+textViewParams.height;
//            cardView.setLayoutParams(cardViewParams);

        }
    }
}
