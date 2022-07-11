package ru.ac.uniyar.mf.vl;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Node {

    String id;
    String Name;
    List<Node> numbers;

    public Node(String Name) {
        this.Name = Name;
        this.id = UUID.randomUUID().toString();
        this.numbers = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public void setName(String a) {
        Name = a;
    }

    public List<Node> getNumbers() {
        return numbers;
    }

    // Функция добавления элементов
    public void add(Node number) {
        this.numbers.add(number);
    }

    // Функция удаления
    public void delete(String Name) {
        for(int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).getName().equals(Name)) {
                numbers.remove(i);
            }
        }
    }

    // Функция поиска
    public boolean search(String name) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).getName().equals(name)) {
                return true;
            } else
                return false;
        }
        return false;
    }

    // Функция изменения названия
    public void rename(String name, String rename) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).getName().equals(name)) {
                numbers.get(i).setName(rename);
            }
        }
    }

    // Функция вывода строки
    public String print(){
        return print("",0);
    }
    private String print(String s,int t)
    {
        for(int i = 0; i < t; i++)
        {
            s += " ";
        }
        s += Name;
        s += "\n";
        if (numbers.size() == 0)
        {
            return s;
        }else {
            for (int i = 0; i < numbers.size(); i++)
            {
                s += numbers.get(i).print("",t+1);
            }
            return s;
        }
    }
}


