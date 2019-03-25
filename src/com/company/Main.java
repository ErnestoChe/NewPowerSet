package com.company;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PowerSet p = new PowerSet();
        PowerSet s = new PowerSet();
        p.put("A");
        p.put("B");
        p.put("C");
        p.put("D");
        p.put("E");
        p.log();
        p.put("B");
        System.out.println("power P");
        p.log();

        s.put("a");
        s.put("B");
        s.put("c");
        s.put("D");
        s.put("E");
        System.out.println("power S");
        s.log();
        System.out.println(s.remove("z"));
        s.log();
        System.out.println(s.remove("c"));
        s.log();
        System.out.println(s.remove("a"));
        s.log();
        System.out.println(s.remove("c"));
        s.log();
        /*System.out.println("power T");
        PowerSet t = p.intersection(s);
        t.log();

        System.out.println("power R");
        PowerSet r = p.difference(s);
        r.log();

        System.out.println("power W");
        PowerSet w = p.union(s);
        w.log();
        System.out.println("removing B");
        System.out.println(w.remove("B"));
        w.log();

        PowerSet q = new PowerSet();
        PowerSet z = q.intersection(w);
        z.log();
        System.out.println("power Z");
        PowerSet x = z.union(w);
        System.out.println("logging x = z union w");
        x.log();

        PowerSet c = new PowerSet();
        PowerSet v = new PowerSet();
        System.out.println("power C");
        c.put("a");
        c.put("b");
        c.put("c");

        System.out.println("power V");
        v.put("a");
        v.put("b");
        v.put("c");

        PowerSet f = v.difference(c);
        System.out.println("logging f = v dif c   must be empty");
        f.log();

        PowerSet l = f.union(c);
        System.out.println("logging l");
        l.log();

        System.out.println(p.isSubset(r));
        System.out.println(w.isSubset(r));
        System.out.println(r.isSubset(w));
        System.out.println(f.isSubset(w));
        System.out.println(w.isSubset(f));*/
    }
}
