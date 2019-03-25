package com.company;

import java.lang.reflect.Array;

public class PowerSet {
    int count;
    //HashTable ht;
    DynArray array;

    public PowerSet()
    {
        // ваша реализация хранилища
        count = 0;
        //ht = new HashTable(53, 3, 1);
        array = new DynArray();
    }

    public int size()
    {
        // количество элементов в множестве
        return count;
    }


    public void put(String value)
    {
        // всегда срабатывает
        /*if(!ht.isKey(value)){
            ht.put(value);
            count++;
            //System.out.println("added " + value);
        }*/
        if(array.isValue(value) == -1){
            array.append(value);
            count++;
        }else
        System.out.println("not added " + value);
    }

    public boolean get(String value)
    {
        // возвращает true если value имеется в множестве,
        // иначе false
        if(array.isValue(value) != -1){
            return true;
        }else
        return false;
    }

    public boolean remove(String value)
    {
        // возвращает true если value удалено
        // иначе false
        return array.remove(value);
        //return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        // пересечение текущего множества и set2
        PowerSet ps = new PowerSet();
        for (int i = 0; i < array.count; i++) {
            if(set2.get(array.getItem(i))){
                ps.put(array.getItem(i));
            }
        }
        return ps;
    }

    public PowerSet union(PowerSet set2)
    {
        // объединение текущего множества и set2
        PowerSet ps = new PowerSet();
        for (int i = 0; i < array.count; i++) {
            /*if(array.getItem(i) != null){
                ps.put(ht.slots[i]);
            }
            if(set2.ht.slots[i] != null){
                ps.put(set2.ht.slots[i]);
            }*/
            ps.put(array.getItem(i));
        }
        for (int i = 0; i <set2.array.count ; i++) {
            ps.put(set2.array.getItem(i));
        }
        return ps;
    }

    public PowerSet difference(PowerSet set2)
    {
        // разница текущего множества и set2
        PowerSet ps = new PowerSet();
        for(int i = 0; i <array.count ; i++) {
            if(!set2.get(array.getItem(i))){
                ps.put(array.getItem(i));
            }
        }
        return ps;
    }

    public boolean isSubset(PowerSet set2)
    {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        boolean flag = true;
        for (int i = 0; i < set2.count; i++) {
            if(!get(set2.array.getItem(i))){
                flag = false;
            }
        }
        return flag;
    }

    public void log(){
        array.log();
        System.out.print("count " + count);
        System.out.println();
    }
}

class DynArray<T>
{
    public String [] array;
    private String[] tmp;
    public int count;
    public int capacity;
    //public Class clazz;

    public DynArray()
    {
        //this.clazz = clazz;
        this.count = 0;
        this.capacity = 16;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        //array = (T[]) Array.newInstance(this.clazz, new_capacity);
        array = new String[new_capacity];
    }

    public String getItem(int index) {
        if (index >= count || index < 0){
            return null;
            //throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        else return array[index];
    }

    public int isValue(String element){
        int index = -1;
        for (int i = 0; i < count ; i++) {
            if(getItem(i).equals(element)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void append(String element){
        if(count+1>capacity){
            incSize();
        }
        array[count++] = element;
    }
    public void incSize(){
        int current = count;
        int newSize = current * 2;
        tmp = array;
        makeArray(newSize);
        for(int i =0; i<tmp.length; i++){
            array[i] = tmp[i];
        }
        capacity = newSize;
    }
    public void insert(String ins, int i ){
        if (i > count || i<0){
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + count);}
        else{
            if(count+1>capacity){
                incSize();
            }
            for(int q = count; q > i; q--){
                array[q] = array[q-1];
            }
            array[i] = ins;
            count++;
        }
    }

    public boolean remove(String value){
        int index = isValue(value);
        if(index != -1){
            remove(index);
            return true;
        }else return false;

    }
    public void remove(int index){
        if (index > count || index<0 || array[0] == null){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);}
        else{
            count--;
            for(int q = index; q < count; q++){
                array[q] = array[q+1];
            }
            if (count * 2 < capacity) {
                capacity /=1.5;
                if(capacity<16){
                    capacity = 16;
                }
                tmp = array;
                makeArray(capacity);
                for(int i = 0; i<capacity; i++){
                    array[i] = tmp[i];
                }
            }
            array[count] = null;
        }
    }
    public void log(){
        if(array[0] == null){
            System.out.println("empty array");
        }
        for(int i = 0; i<count; i++){
            System.out.print(getItem(i)+" ");
        }
        //System.out.println();
    }
    public void statLog(){
        log();
        System.out.println(capacity+" capacity");
        System.out.println(count+ " count");
        System.out.println();
    }
}


