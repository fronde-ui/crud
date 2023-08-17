package com.example.cruddemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sup {
    public Sup(){
        System.out.println("这是有参构造");
    }
    public   void Test1(){
        List tab_name=new ArrayList();
        tab_name.add("sup");
        tab_name.add("pro");
        List data=new ArrayList();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "cjj");
        map.put("say", "走在路上的码农");
        data.add(map);
        map.put("name", "c12");
        map.put("say", "走在路上的码农");
        data.add(map);
        for(int i=0;i<tab_name.size(); i++){
            System.out.print("tabname:"+tab_name.get(i));
            System.out.print("-------------");
            System.out.print("data:"+data.get(i));
        }
    }
}
class Te {
    public static <Student> void main(String[] args) {
        //这就是实例化过程
        Sup st = new Sup();
        st.Test1();
    }
}
