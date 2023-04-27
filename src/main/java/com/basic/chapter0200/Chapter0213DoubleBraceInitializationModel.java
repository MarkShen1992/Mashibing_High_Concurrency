package com.basic.chapter0200;

import java.util.UUID;

public class Chapter0213DoubleBraceInitializationModel {
    public static void main(String[] args) {
        // double brace initialization
        // https://www.baeldung.com/java-double-brace-initialization
        // this way can be used in making List, Set, Map, etc.
        User u = new User() {
            {
                setUserId(UUID.randomUUID().toString());
                setUserName("shenjy");
                setRealName("沈军禹");
            }
        };
        System.out.println(u);
    }
}

/**
 * 用户Model
 */
class User {

    private String userId;

    private String userName;

    private String realName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User{" + "userId='" + userId + '\'' + ", userName='" + userName + '\'' + ", realName='" + realName
            + '\'' + '}';
    }
}
