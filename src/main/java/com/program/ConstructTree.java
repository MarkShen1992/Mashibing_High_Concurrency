package com.program;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形结构遍历
 * @Date 2021-02-25
 * @author MarkShen
 */
public class ConstructTree {
    static class Menu {
        private int id;
        private String name;
        private int pId;
        private List<Menu> menu;

        public Menu(int id, String name, int pId) {
            this.id = id;
            this.name = name;
            this.pId = pId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getpId() {
            return pId;
        }

        public void setpId(int pId) {
            this.pId = pId;
        }

        public List<Menu> getMenu() {
            return menu;
        }

        public void setMenu(List<Menu> menu) {
            this.menu = menu;
        }

        @Override
        public String toString() {
            return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pId=" + pId +
                ", menu=" + menu +
                '}';
        }
    }

    public static void main(String[] args) {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu(1, "菜单管理", 0));
        menus.add(new Menu(2, "系统管理", 1));
        menus.add(new Menu(3, "用户管理", 2));
        menus.add(new Menu(4, "机构管理", 2));
        menus.add(new Menu(5, "权限管理", 2));
        menus.add(new Menu(6, "角色管理", 2));
        menus.add(new Menu(7, "货物管理", 1));
        menus.add(new Menu(8, "仓库管理", 1));


    }
}
