package HW3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PhoneBook {

    HashMap<String, ArrayList<Person>> people;

    public PhoneBook() {
        people = new HashMap<>();
    }

    public void add(String surname, String phone, String email) {
        people.computeIfAbsent(surname, k -> new ArrayList<>());
        people.get(surname).add(new Person(phone, email));
    }

    public ArrayList<String> getPhones(String surname) {
        ArrayList<String> phones = new ArrayList<>();
        if(people.get(surname) != null) {
            for (Person p : people.get(surname)){
                phones.add(p.getPhone());
            }
        }
        return phones;
    }

    public ArrayList<String> getEmails(String surname) {
        ArrayList<String> mails = new ArrayList<>();
        if(people.get(surname) != null) {
            for (Person p : people.get(surname)){
                mails.add(p.getEmail());
            }
        }
        return mails;
    }

    public String toString() {
        String output = "";
        Iterator iterator = people.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry record = (Map.Entry) iterator.next();
            output += record.toString() + "\n";
        }
        return output;
    }
}
