package wellijohn.org.multilevelrecyclerview;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import wellijohn.org.treerecyclerview.vo.TreeItem;

/**
 * @author 张本志
 * @date 2019/1/22 下午1:29
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyLeftViewHolder> {

    private Activity activity;
    private ArrayList<TreeItem> items = new ArrayList<>();
    private OnLeftItemClickListener mOnLeftItemClickListener;

    public LeftAdapter(Activity activity, OnLeftItemClickListener onLeftItemClickListener) {
        this.activity = activity;
        items = TestData.getAllData();
        this.mOnLeftItemClickListener = onLeftItemClickListener;
    }

    @NonNull
    @Override
    public MyLeftViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyLeftViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_left, null));
    }

    @Override
    public void onBindViewHolder(@NonNull final LeftAdapter.MyLeftViewHolder myLeftViewHolder, final int pos) {
        final TreeItem treeItem = items.get(pos);
        myLeftViewHolder.tv.setText(treeItem.name);
        if (treeItem.isOpen) {
            myLeftViewHolder.rl.setBackgroundColor(ContextCompat.getColor(activity, R.color.white));
            myLeftViewHolder.tv.setTextColor(Color.parseColor("#555555"));
            myLeftViewHolder.view_left.setVisibility(View.VISIBLE);
        } else {
            myLeftViewHolder.rl.setBackgroundColor(ContextCompat.getColor(activity, R.color.left_rl_bg));
            myLeftViewHolder.tv.setTextColor(Color.parseColor("#999999"));
            myLeftViewHolder.view_left.setVisibility(View.GONE);
        }
        myLeftViewHolder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnLeftItemClickListener != null) {
                    mOnLeftItemClickListener.onClick(pos);
                }
                for (TreeItem treeItem1 : items) {
                    treeItem1.isOpen = false;
                }
                treeItem.isOpen = true;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyLeftViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;
        public View view_left;
        public View rl;

        public MyLeftViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            view_left = itemView.findViewById(R.id.view_left);
            rl = itemView.findViewById(R.id.rl);
        }
    }


    public interface OnLeftItemClickListener {
        void onClick(int position);
    }

}
