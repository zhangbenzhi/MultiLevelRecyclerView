package wellijohn.org.multilevelrecyclerview;

import java.io.Serializable;

/**
 * @author 张本志
 * @date 2019/1/25 上午11:03
 */
public class FirstDataBean implements Serializable {

    public FirstData leftData;
    public FirstData rightData;

    public FirstDataBean() {
    }

    public static class FirstData implements Serializable {
        public String id;
        public String text;
        public boolean isOpen;
    }
}
