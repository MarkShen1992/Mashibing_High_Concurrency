package com.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

/**
 * 树形结构遍历
 *
 * @author MarkShen
 * @Date 2021-02-25
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
            return "Menu{" + "id=" + id + ", name='" + name + '\'' + ", pId=" + pId + ", menu=" + menu + '}';
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

        // 获取父节点
        List<Menu> collect = menus.stream().filter(m -> m.getpId() == 0).map((m) -> {
            m.setMenu(getChildrens(m, menus));
            return m;
        }).collect(Collectors.toList());
        System.out.println("-------转json输出结果-------");
        System.out.println(JSON.toJSON(collect));
    }

    /**
     * 递归查询子节点
     *
     * @param root
     *            根节点
     * @param all
     *            所有节点
     * @return 根节点信息
     */
    private static List<Menu> getChildrens(Menu root, List<Menu> all) {
        List<Menu> children = all.stream().filter(m -> Objects.equals(m.getpId(), root.getId())).map((m) -> {
            m.setMenu(getChildrens(m, all));
            return m;
        }).collect(Collectors.toList());
        return children;
    }
}
