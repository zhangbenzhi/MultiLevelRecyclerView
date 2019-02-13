package wellijohn.org.multilevelrecyclerview;

import java.util.ArrayList;

import wellijohn.org.treerecyclerview.vo.TreeItem;

/**
 * 模拟数据
 */
public class TestData {

    public static ArrayList<TreeItem> getAllData() {
        ArrayList<TreeItem> treeItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TreeItem left = new TreeItem();
            left.name = "左边数据投诉客服投诉保洁";
            left.id = String.valueOf(i);
            ArrayList<TreeItem> rightFirsts = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                TreeItem rightFirst = new TreeItem();
                rightFirst.name = "右边第一级服务态度等问题急需解决";
                rightFirst.level = 1;
                rightFirst.id = String.valueOf(i) + j;
                ArrayList<TreeItem> rightSeconds = new ArrayList<>();
                for (int k = 0; k < 3; k++) {
                    TreeItem rightSecond = new TreeItem();
                    rightSecond.name = "右边第二级业务能力差";
                    rightSecond.level = 2;
                    rightSecond.id = String.valueOf(i) + j + k;
                    ArrayList<TreeItem> rightThirds = new ArrayList<>();
                    for (int m = 0; m < 5; m++) {
                        TreeItem rightThird = new TreeItem();
                        rightThird.name = "右边第三级电话业务能力差";
                        rightThird.level = 3;
                        rightThird.id = String.valueOf(i) + j + k + m;
                        ArrayList<TreeItem> rightFourths = new ArrayList<>();
                        for (int n = 0; n < 4; n++) {
                            TreeItem rightFourth = new TreeItem();
                            rightFourth.name = "右边第四级客服业务能力差";
                            rightFourth.level = 4;
                            rightFourth.id = String.valueOf(i) + j + k + m + n;
                            rightFourths.add(rightFourth);
                        }
                        //造出第三级没有下一级的情况
                        if (m != 0) {
                            rightThird.data = rightFourths;
                        }
                        rightThirds.add(rightThird);
                    }
                    //造出第二级没有下一级的情况
                    if (k != 0) {
                        rightSecond.data = rightThirds;
                    }
                    rightSeconds.add(rightSecond);
                }
                //造出第一级没有下一级的情况
                if (j != 0) {
                    rightFirst.data = rightSeconds;
                }
                rightFirsts.add(rightFirst);
            }
            //造成左边没有右边第一级的情况
            if (i != 0) {
                left.data = rightFirsts;
            }
            treeItems.add(left);
        }
        return treeItems;
    }

    public static ArrayList<TreeItem> getRightList(int position) {
        return getAllData().get(position).data;
    }
}

