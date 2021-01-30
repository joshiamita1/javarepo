package com.flipkart.validation;
import java.util.*;
import org.apache.log4j.ConsoleAppender;

public class ValidateDataType {

    public static void main(String[]args)
    {
        char ch = '\u0253';
        System.out.println(ch);
        Hashtable ht = new Hashtable<String,String>();
        ht.put("asdf","sadf");
        ht.put(100,"sadf");
        ht.put("as",1010);
        System.out.println(ht.get("asdf"));
        System.out.println(ht.get(100));
        System.out.println(ht.get("as"));
        
        Set vals = new TreeSet<String>();
        vals.add("one");
        vals.add(1);
        vals.add("two");
        System.out.println(vals);

    }
}
