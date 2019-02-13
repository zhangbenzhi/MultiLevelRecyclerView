package wellijohn.org.multilevelrecyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import wellijohn.org.multilevelrecyclerview.R;


/**
 * @author: WelliJohn
 * @time: 2018/8/7-10:04
 * @email: wellijohn1991@gmail.com
 * @desc:
 */
public class DiscountSecondVH extends RecyclerView.ViewHolder {
    public TextView tv;
    public Button btn;
    public ImageView iv_arrow;

    public DiscountSecondVH(View view) {
        super(view);
        initView();
    }

    private void initView() {
        tv = itemView.findViewById(R.id.tv);
        btn = itemView.findViewById(R.id.btn);
        iv_arrow=itemView.findViewById(R.id.iv_arrow);
    }
}
