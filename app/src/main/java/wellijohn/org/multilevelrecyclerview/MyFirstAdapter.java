package wellijohn.org.multilevelrecyclerview;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author 张本志
 * @date 2019/1/22 下午1:29
 */
public class MyFirstAdapter extends RecyclerView.Adapter<MyFirstAdapter.MyFirstViewHolder> {


    private Activity activity;
    private ArrayList<FirstDataBean> items = new ArrayList<>();

    public MyFirstAdapter(Activity activity) {
        this.activity = activity;
        items = TestData.getFirstData();
    }

    @NonNull
    @Override
    public MyFirstViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyFirstViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_sign, null));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyFirstAdapter.MyFirstViewHolder mySignViewHolder, final int pos) {
        final FirstDataBean firstData = items.get(pos);
        final FirstDataBean.FirstData leftData = firstData.leftData;
        final FirstDataBean.FirstData rightData = firstData.rightData;
        mySignViewHolder.leftTextView.setText(leftData.text);
        mySignViewHolder.rightTextView.setText(rightData.text);
        if (leftData.isOpen || rightData.isOpen) {
            //TODO 根据左右打开状况来设置数据
            mySignViewHolder.recyclerView.setVisibility(View.VISIBLE);
            mySignViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            DemoRVAdapter demoRVAdapter = new DemoRVAdapter();
            demoRVAdapter.setDatas(TestData.getTestData());
            mySignViewHolder.recyclerView.setAdapter(demoRVAdapter);
        } else {
            mySignViewHolder.recyclerView.setVisibility(View.GONE);
        }
        mySignViewHolder.leftTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将全部非该position的关闭
                for (int i = 0; i < items.size(); i++) {
                    FirstDataBean.FirstData leftData1 = items.get(i).leftData;
                    if (leftData1 != leftData) {
                        leftData1.isOpen = false;
                    }
                    FirstDataBean.FirstData rightData2 = items.get(i).rightData;
                    if (rightData2 != rightData) {
                        rightData2.isOpen = false;
                    }
                }
                if (!leftData.isOpen) {
                    rightData.isOpen = false;
                    leftData.isOpen = true;
                } else {
                    leftData.isOpen = false;
                    rightData.isOpen = false;
                }
                notifyDataSetChanged();
            }
        });
        mySignViewHolder.rightTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将全部非该position的关闭
                for (int i = 0; i < items.size(); i++) {
                    FirstDataBean.FirstData leftData1 = items.get(i).leftData;
                    if (leftData1 != leftData) {
                        leftData1.isOpen = false;
                    }
                    FirstDataBean.FirstData rightData2 = items.get(i).rightData;
                    if (rightData2 != rightData) {
                        rightData2.isOpen = false;
                    }
                }
                if (!rightData.isOpen) {
                    leftData.isOpen = false;
                    rightData.isOpen = true;
                } else {
                    leftData.isOpen = false;
                    rightData.isOpen = false;
                }
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyFirstViewHolder extends RecyclerView.ViewHolder {

        public TextView leftTextView;
        public TextView rightTextView;
        public RecyclerView recyclerView;

        public MyFirstViewHolder(@NonNull View itemView) {
            super(itemView);
            leftTextView = itemView.findViewById(R.id.left_tv);
            rightTextView = itemView.findViewById(R.id.right_tv);
            recyclerView = itemView.findViewById(R.id.rv);
        }
    }

}
