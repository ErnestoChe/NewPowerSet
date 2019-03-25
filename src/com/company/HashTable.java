package com.company;

public class HashTable {
    public int size;
    public int step;
    public String [] slots;
    public int choose_fun;

    public HashTable(int sz, int stp, int ch_fun)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        choose_fun = ch_fun;
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value, int choose_fun)
    {
        // всегда возвращает корректный индекс слота
        char[] n = value.toCharArray();
        int v = 0;
        for(int i = 0; i<n.length;i++){
            v += (int)n[i];
        }
        int hash = 0;
        switch(choose_fun){
            case(1):
                hash = ((v * 9 + 16) % 29) % size;
            case(2):
                hash = ((v * 24 + 18) % 53) % size;
            case(3):
                hash = ((v * 58 + 74) % 97) % size;
            case(4):
                hash = h2(value);
        }
        return hash;
    }
    public int h2(String value){
        char[] n = value.toCharArray();
        int v = 0;
        for(int i = 0; i<n.length;i++){
            v += (int)n[i] % size;
        }
        return v % size;
    }

    public int seekSlot(String value)
    {
        // находит индекс пустого слота для значения, или -1
        int hash = hashFun(value, choose_fun);
        int h = hash;
        while(slots[hash] != null){
            hash += step;
            if(hash >= slots.length){
                int dif = hash - slots.length;
                hash = dif;
            }
            if(Math.abs(hash - h)<step){
                hash = -1;
                break;
            }
        }
        return hash;
    }

    public int put(String value)
    {
        int ind = seekSlot(value);
        if(ind != -1){
            slots[ind] = value;
        }
        // записываем значение по хэш-функции

        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
        return ind;
    }

    public int find(String value)
    {
        int ind = hashFun(value, choose_fun);
        int h = ind;
        while(slots[ind] != null){
            if(slots[ind].equals(value)){
                break;
            }else{
                ind+=step;
                if(ind >= slots.length){
                    int dif = ind - slots.length;
                    ind = dif;
                }
                if(Math.abs(h - ind) < step){
                    ind = -1;
                    return ind;
                }
            }
        }
        if(slots[ind] == null){
            ind = -1;
        }
        return ind;
        // находит индекс слота со значением, или -1
        //return -1;
    }


    //---------------NEW METHODS-----------------------

    public boolean isKey(String value){
        if(find(value) != -1){
            return true;
        }else return false;
    }

    public void log(){
        for (int i = 0; i < size; i++) {
            if(slots[i] != null){
                System.out.print(slots[i] + " ");
            }
        }
    }

    public boolean remove(String value){
        int index = find(value);
        if(index != -1){
            slots[index] = null;
            return true;
        }else return false;
    }
}

