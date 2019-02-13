package wellijohn.org.multilevelrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRvLeft;
    private RecyclerView mRvRight;
    private Button leftBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("我要反馈");
        initView();

        final RightAdapter demoRVAdapter = new RightAdapter();
        mRvLeft.setLayoutManager(new LinearLayoutManager(this));
        LeftAdapter myFirstAdapter = new LeftAdapter(this, new LeftAdapter.OnLeftItemClickListener() {
            @Override
            public void onClick(int position) {
                if (TestData.getRightList(position) != null && TestData.getRightList(position).size() > 0) {
                    demoRVAdapter.setDatas(TestData.getRightList(position));
                    mRvRight.setVisibility(View.VISIBLE);
                    leftBtn.setVisibility(View.GONE);
                } else {
                    mRvRight.setVisibility(View.GONE);
                    leftBtn.setVisibility(View.VISIBLE);
                }
            }
        });
        mRvLeft.setAdapter(myFirstAdapter);

        mRvRight.setLayoutManager(new LinearLayoutManager(this));
        mRvRight.setAdapter(demoRVAdapter);

        leftBtn.setOnClickListener(this);
    }

    private void initView() {
        mRvLeft = findViewById(R.id.rvLeft);
        mRvRight = findViewById(R.id.rvRight);
        leftBtn = findViewById(R.id.leftBtn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.leftBtn:
                Toast.makeText(this, "第一级后的下一步", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
