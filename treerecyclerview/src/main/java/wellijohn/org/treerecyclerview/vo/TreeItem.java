package wellijohn.org.treerecyclerview.vo;

import java.util.ArrayList;
import java.util.List;

public class TreeItem implements Tree {
    public boolean isOpen;
    public String name;
    public String id;
    public ArrayList<TreeItem> data;
    public int level;

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public List getChilds() {
        return data;
    }

    @Override
    public boolean isExpand() {
        return isOpen;
    }
}
