package com.program;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信朋友圈点赞显示
 *
 * @author MarkShen
 * @since 20210506
 */
public class WechatCircleLikeDisplay {

    private static final String COMMA = ",";

    public static void main(String[] args) {
        // Bob, Mark, Mike
        List<String> names = new ArrayList<>();
        names.add("Bob");
        names.add("Mark");
        names.add("Mike");

        System.out.println(getWechatLikeStr(names));
    }

    private static String getWechatLikeStr(List<String> names) {
        if (names == null || names.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            if (i == 0) {
                sb.append(names.get(i));
            } else {
                sb.append(COMMA).append(names.get(i));
            }
        }
        return sb.toString();
    }
}
