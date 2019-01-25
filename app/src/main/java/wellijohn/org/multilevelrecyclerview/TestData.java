package wellijohn.org.multilevelrecyclerview;

import java.util.ArrayList;
import java.util.List;

import wellijohn.org.treerecyclerview.vo.Tree;
import wellijohn.org.treerecyclerview.vo.TreeItem;

/**
 * @author: WelliJohn
 * @time: 2018/8/17-16:37
 * @email: wellijohn1991@gmail.com
 * @desc:
 */
public class TestData {

    public static ArrayList<FirstDataBean> getFirstData() {
        ArrayList<FirstDataBean> firstDataBeans = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            FirstDataBean firstDataBean = new FirstDataBean();
            FirstDataBean.FirstData leftData = new FirstDataBean.FirstData();
            leftData.id = i + "left";
            leftData.text = "业务/能力问题";
            leftData.isOpen = false;
            firstDataBean.leftData = leftData;

            FirstDataBean.FirstData rightData = new FirstDataBean.FirstData();
            rightData.id = i + "right";
            rightData.text = "服务/态度问题";
            rightData.isOpen = false;
            firstDataBean.rightData = rightData;

            firstDataBeans.add(firstDataBean);
        }
        return firstDataBeans;
    }

    public static List<SecondData> getTestData() {
        List<SecondData> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SecondData secondData = new SecondData();
            secondData.text = "客服提供错误解决方案" + i;
            secondData.id = "二级数据" + i;
            list.add(secondData);
        }
        return list;
    }

    /**
     * 第二级：
     */
    static class SecondData extends TreeItem {
        List<ThirdData> list = new ArrayList<>();
        public String id;
        public String text;

        public SecondData() {
            ThirdData thirdData1 = new ThirdData();
            thirdData1.text = "电话客服业务能力差1";
            thirdData1.id = "三级数据id";
            list.add(thirdData1);
            ThirdData thirdData2 = new ThirdData();
            thirdData2.text = "电话客服业务能力差2";
            thirdData2.id = "三级数据id";
            list.add(thirdData2);
        }

        public int getLevel() {
            return 1;
        }

        public List getChilds() {
            return list;
        }
    }

    /**
     * 第三级：
     */
    static class ThirdData extends TreeItem {
        public String id;
        public String text;

        public int getLevel() {
            return 2;
        }

        public List<Tree> getChilds() {
            return null;
        }

    }
}

