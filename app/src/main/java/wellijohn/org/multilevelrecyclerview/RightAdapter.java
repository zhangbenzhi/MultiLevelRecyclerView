package wellijohn.org.multilevelrecyclerview;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import wellijohn.org.multilevelrecyclerview.viewholder.DiscountFirstVH;
import wellijohn.org.multilevelrecyclerview.viewholder.DiscountFourthVH;
import wellijohn.org.multilevelrecyclerview.viewholder.DiscountSecondVH;
import wellijohn.org.multilevelrecyclerview.viewholder.DiscountThirdVH;
import wellijohn.org.treerecyclerview.adapter.BaseTreeRVAdapter;
import wellijohn.org.treerecyclerview.vo.TreeItem;

public class RightAdapter extends BaseTreeRVAdapter<TreeItem> implements View.OnClickListener {

    private TreeItem mySelectedFirstData;
    private TreeItem mySelectedSecondData;
    private TreeItem mySelectedThirdData;
    private TreeItem mySelectedFourthData;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder vh;
        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_discount_first, parent, false);
                vh = new DiscountFirstVH(view);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_discount_second, parent, false);
                vh = new DiscountSecondVH(view);
                break;
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_discount_third, parent, false);
                vh = new DiscountThirdVH(view);
                break;
            case 4:
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_discount_fourth, parent, false);
                vh = new DiscountFourthVH(view);
                break;
        }
        return vh;
    }


    @Override
    public void onBindViewHolder(int type, final TreeItem vhTreeItem, RecyclerView.ViewHolder holder) {
        switch (type) {
            case 1:
                DiscountFirstVH firstHolder = (DiscountFirstVH) holder;
                firstHolder.tv.setText(vhTreeItem.name);
                if (vhTreeItem.isExpand()) {
                    mySelectedFirstData = vhTreeItem;
                    firstHolder.tv.setActivated(true);
                    firstHolder.tv.setTextColor(ContextCompat.getColor(firstHolder.tv.getContext(), R.color.colorAccent));
                    if (vhTreeItem.data == null || vhTreeItem.data.size() == 0) {
                        firstHolder.btn.setVisibility(View.VISIBLE);
                    } else {
                        firstHolder.btn.setVisibility(View.GONE);
                    }
                } else {
                    firstHolder.tv.setActivated(false);
                    firstHolder.tv.setTextColor(ContextCompat.getColor(firstHolder.tv.getContext(), R.color.text_999999));
                    firstHolder.btn.setVisibility(View.GONE);
                }
                firstHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDatas != null) {
                            for (int i = 0; i < mDatas.size(); i++) {
                                TreeItem treeItem = mDatas.get(i);
                                if (vhTreeItem != treeItem) {
                                    treeItem.isOpen = false;
                                }
                            }
                        }
                        //关闭刚才打开的二级
                        if (mySelectedSecondData != null) {
                            mySelectedSecondData.isOpen = false;
                            mySelectedSecondData = null;
                            mySelectedThirdData = null;
                            mySelectedFourthData = null;
                        }
                        vhTreeItem.isOpen = !vhTreeItem.isExpand();
                        notifyDataSetChanged();
                    }
                });
                firstHolder.btn.setOnClickListener(this);
                break;
            case 2:
                DiscountSecondVH secondHolder = (DiscountSecondVH) holder;
                secondHolder.tv.setText(vhTreeItem.name);
                if (vhTreeItem.isExpand()) {
                    mySelectedSecondData = vhTreeItem;
                    secondHolder.tv.setTextColor(ContextCompat.getColor(secondHolder.tv.getContext(), R.color.colorAccent));
                    if (vhTreeItem.data == null || vhTreeItem.data.size() == 0) {
                        secondHolder.btn.setVisibility(View.VISIBLE);
                    } else {
                        secondHolder.btn.setVisibility(View.GONE);
                    }
                    secondHolder.iv_arrow.setImageResource(R.drawable.down_arrow);
                } else {
                    secondHolder.tv.setTextColor(ContextCompat.getColor(secondHolder.tv.getContext(), R.color.text_666666));
                    secondHolder.btn.setVisibility(View.GONE);
                    secondHolder.iv_arrow.setImageResource(R.drawable.ic_arrow_right);
                }
                secondHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mySelectedFirstData != null && mySelectedFirstData.data != null) {
                            for (int i = 0; i < mySelectedFirstData.data.size(); i++) {
                                TreeItem treeItem = mySelectedFirstData.data.get(i);
                                if (vhTreeItem != treeItem) {
                                    treeItem.isOpen = false;
                                }
                            }
                        }
                        //关闭打开的第三级：
                        if (mySelectedThirdData != null) {
                            mySelectedThirdData.isOpen = false;
                            mySelectedThirdData = null;
                            mySelectedFourthData = null;
                        }
                        vhTreeItem.isOpen = !vhTreeItem.isExpand();
                        notifyDataSetChanged();
                    }
                });
                secondHolder.btn.setOnClickListener(this);
                break;
            case 3:
                DiscountThirdVH thirdHolder = (DiscountThirdVH) holder;
                thirdHolder.tv.setText(vhTreeItem.name);
                if (vhTreeItem.isExpand()) {
                    mySelectedThirdData = vhTreeItem;
                    thirdHolder.tv.setTextColor(ContextCompat.getColor(thirdHolder.tv.getContext(), R.color.colorAccent));
                    if (vhTreeItem.data == null || vhTreeItem.data.size() == 0) {
                        thirdHolder.btn.setVisibility(View.VISIBLE);
                    } else {
                        thirdHolder.btn.setVisibility(View.GONE);
                    }
                } else {
                    thirdHolder.tv.setTextColor(ContextCompat.getColor(thirdHolder.tv.getContext(), R.color.text_999999));
                    thirdHolder.btn.setVisibility(View.GONE);
                }
                thirdHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mySelectedSecondData != null && mySelectedSecondData.data != null) {
                            for (int i = 0; i < mySelectedSecondData.data.size(); i++) {
                                TreeItem treeItem = mySelectedSecondData.data.get(i);
                                if (vhTreeItem != treeItem) {
                                    treeItem.isOpen = false;
                                }
                            }
                        }
                        if (mySelectedFourthData != null) {
                            mySelectedFourthData.isOpen = false;
                            mySelectedFourthData = null;
                        }
                        vhTreeItem.isOpen = !vhTreeItem.isExpand();
                        notifyDataSetChanged();
                    }
                });
                thirdHolder.btn.setOnClickListener(this);
                break;
            case 4:
                final DiscountFourthVH fourthVH = (DiscountFourthVH) holder;
                fourthVH.tv.setText(vhTreeItem.name);
                fourthVH.iv.setActivated(vhTreeItem.isExpand());
                if (vhTreeItem.isExpand()) {
                    fourthVH.tv.setTextColor(ContextCompat.getColor(fourthVH.tv.getContext(), R.color.colorAccent));
                    mySelectedFourthData = vhTreeItem;
                } else {
                    fourthVH.tv.setTextColor(ContextCompat.getColor(fourthVH.tv.getContext(), R.color.text_999999));
                }
                fourthVH.btn.setVisibility(View.GONE);
                if (mySelectedThirdData != null && mySelectedThirdData.data != null) {
                    TreeItem treeItem = mySelectedThirdData.data.get(mySelectedThirdData.data.size() - 1);
                    if (vhTreeItem == treeItem) {
                        //最后一个显示出来
                        fourthVH.btn.setVisibility(View.VISIBLE);
                    }
                }
                fourthVH.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mySelectedThirdData != null && mySelectedThirdData.data != null) {
                            List<TreeItem> list = mySelectedThirdData.data;
                            for (TreeItem thirdData : list) {
                                thirdData.isOpen = false;
                            }
                        }
                        vhTreeItem.isOpen = true;
                        notifyDataSetChanged();
                    }
                });
                fourthVH.btn.setOnClickListener(this);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        StringBuffer sb = new StringBuffer();
        if (mySelectedFirstData != null) {
            sb.append("第一级：" + mySelectedFirstData.id);
        }
        if (mySelectedSecondData != null) {
            sb.append("第二级：" + mySelectedSecondData.id);
        }
        if (mySelectedThirdData != null) {
            sb.append("第三级：" + mySelectedThirdData.id);
        }
        if (mySelectedFourthData != null) {
            sb.append("第四级：" + mySelectedFourthData.id);
        }
        //这种情况为有第四级但是第四级没有选中的情况则提醒用户选择第四级内容：
        if (mySelectedThirdData != null && mySelectedThirdData.data != null && mySelectedThirdData.data.size() > 0) {
            if (mySelectedFourthData == null) {
                Toast.makeText(v.getContext(), "请选择第四级反馈内容", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Toast.makeText(v.getContext(), sb.toString(), Toast.LENGTH_SHORT).show();
    }
}
