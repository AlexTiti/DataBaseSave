package com.example.administrator.databasesave.mvp;

/**
 * <pre>
 *
 *   author   :   Alex
 *   e_mail   :   18238818283@sina.cn
 *   time    :   2017/09/05
 *   desc     :
 *   version  :   V 1.0.5
 */
public class Userbean {
    private String name;
    private String age;

    public Userbean(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
