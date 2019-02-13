package wellijohn.org.multilevelrecyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import wellijohn.org.multilevelrecyclerview.R;


/**
 * @author: WelliJohn
 * @time: 2018/8/7-10:03
 * @email: wellijohn1991@gmail.com
 * @desc:
 */
public class DiscountFirstVH extends RecyclerView.ViewHolder {

    public TextView tv;
    public Button btn;

    public DiscountFirstVH(View itemView) {
        super(itemView);
        initView();
    }

    private void initView() {
        tv = itemView.findViewById(R.id.tv);
        btn = itemView.findViewById(R.id.btn);
    }
}
