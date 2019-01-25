package wellijohn.org.multilevelrecyclerview;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import java.util.List;

import wellijohn.org.multilevelrecyclerview.viewholder.DiscountSecondVH;
import wellijohn.org.multilevelrecyclerview.viewholder.DiscountThirdVH;
import wellijohn.org.treerecyclerview.adapter.BaseTreeRVAdapter;
import wellijohn.org.treerecyclerview.vo.TreeItem;

/**
 * @author: WelliJohn
 * @time: 2018/8/17-16:42
 * @email: wellijohn1991@gmail.com
 * @desc:
 */
public class DemoRVAdapter extends BaseTreeRVAdapter<TreeItem> {

    private TestData.SecondData mySelectedSecondData;
    private TestData.ThirdData mSelectedThirdData;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder vh;
        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_discount_second, parent, false);
                vh = new DiscountSecondVH(view);
                break;
            case 2:
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_discount_third, parent, false);
                vh = new DiscountThirdVH(view);
                break;
        }
        return vh;
    }


    @Override
    public void onBindViewHolder(int type, final TreeItem itemCategoryListBean, RecyclerView.ViewHolder holder) {
        switch (type) {
            case 1:
                DiscountSecondVH SHolder = (DiscountSecondVH) holder;
                if (itemCategoryListBean instanceof TestData.SecondData) {
                    TestData.SecondData secondData = (TestData.SecondData) itemCategoryListBean;
                    SHolder.tv.setText(secondData.text);
                    if (itemCategoryListBean.isExpand()) {
                        mySelectedSecondData = secondData;
                        SHolder.tv.setTextColor(ContextCompat.getColor(SHolder.tv.getContext(), R.color.colorAccent));
                    } else {
                        SHolder.tv.setTextColor(ContextCompat.getColor(SHolder.tv.getContext(), R.color.text_333333));
                    }
                }
                SHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDatas != null) {
                            for (int i = 0; i < mDatas.size(); i++) {
                                TreeItem treeItem = mDatas.get(i);
                                if (itemCategoryListBean != treeItem) {
                                    treeItem.setOpen(false);
                                }
                            }
                        }
                        if (mSelectedThirdData != null) {
                            mSelectedThirdData.setOpen(false);
                        }
                        itemCategoryListBean.setOpen(!itemCategoryListBean.isExpand());
                        notifyDataSetChanged();
                    }
                });
                break;
            case 2:
                final DiscountThirdVH thirdVH = (DiscountThirdVH) holder;
                if (itemCategoryListBean instanceof TestData.ThirdData) {
                    TestData.ThirdData thirdData = (TestData.ThirdData) itemCategoryListBean;
                    thirdVH.tvName.setText(thirdData.text);
                    thirdVH.rb.setChecked(thirdData.isExpand());
                    if (thirdData.isExpand()) {
                        mSelectedThirdData = thirdData;
                    }
                }
                thirdVH.rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            if (mySelectedSecondData != null && mySelectedSecondData.list != null) {
                                List<TestData.ThirdData> list = mySelectedSecondData.list;
                                for (TestData.ThirdData thirdData : list) {
                                    thirdData.setOpen(false);
                                }
                            }
                            itemCategoryListBean.setOpen(isChecked);
                            notifyDataSetChanged();
                        }
                    }
                });
                break;
        }
    }

}
