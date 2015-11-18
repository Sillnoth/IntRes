package Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    volatile private List<String> nameList = new ArrayList<>();
    volatile private List<String> surnameList = new ArrayList<>();
    volatile private Map<String,List<String>> surnameLink = new HashMap<>();

    public void removeSurname(String surname) {
        surnameList.remove(surname);
        for(String name : nameList)
            if(surnameLink.get(name).contains(surname))
                surnameLink.get(name).remove(surname);
    }
    public void removeName(String name) {
        nameList.remove(name);
        for(String surname : surnameLink.get(name))
            surnameList.remove(surname);
        surnameLink.remove(name);
    }

    public void editSurname(String oldSurname, String newSurname){
        surnameList.remove(oldSurname);
        surnameList.add(newSurname);
        for(String name : nameList) {
            if (surnameLink.get(name).contains(oldSurname)) {
                surnameLink.get(name).remove(oldSurname);
                surnameLink.get(name).add(newSurname);

            }
        }
    }
    public void editName(String oldName, String newName){
        nameList.remove(oldName);
        nameList.add(newName);
        List<String> list = surnameLink.get(oldName);
        surnameLink.remove(oldName);
        surnameLink.put(newName, list);
    }
    public void addName(String name) {
        nameList.add(name);
        surnameLink.put(name,new ArrayList<String>());
    }

    public void addSurname(String name, String surname) {
        surnameList.add(surname);
        surnameLink.get(name).add(surname);
    }

    public boolean existSurname(String surname) {
        return surnameList.contains(surname);
    }

    public boolean existName(String name) {
        return nameList.contains(name);
    }

    public String getName(String surname) {
        String returnName="";
        for(String name : nameList) {
            if (surnameLink.get(name).contains(surname)) {
                returnName = name;
                break;
            }
        }
        return returnName;
    }

    public List<String> getSurname(String name) {
        return surnameLink.get(name);
    }
}
