import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AddressBook {
    //private static int i;
    public static ArrayList abList;
    public static ArrayList sorting;


    static class AddressBean {
        //  public static ArrayList abList ;
        public String first_name;
        public String last_name;
        public String phone_number;
        public String email_address;
        public String address;

        //AddressBean.abList.add(firstname);

    }

    static HashMap<String, AddressBean> lastnamesort = new HashMap<String, AddressBean>();
    static HashMap<String, AddressBean> firstnamesort = new HashMap<String, AddressBean>();
    static HashMap<String, AddressBean> emailsort = new HashMap<String, AddressBean>();
    static HashMap<String, AddressBean> phonesort = new HashMap<String, AddressBean>();
    static HashMap<String, AddressBean> addresssort = new HashMap<String, AddressBean>();

    //static ArrayList<String> entry = new ArrayList<String>();
    // static ArrayList<String> arrays = new ArrayList<String>();

    //static ArrayList entry = new ArrayList();

    public static void main(String[] args) {
        abList = new ArrayList();

        //sorting = new ArrayList();
        menu(0);

    }

    public static int menu(int p) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do? \n 1. Add an entry. \n 2. Load entries  \n 3. remove entries \n 4. sort entries");
        Integer input = scanner.nextInt();
        try {
            switch (input) {

                case 1:

                    if (abList.size() < 2) {
                        System.out.println("Add an entry");
                        System.out.println(p);
                        p++;
                        addanentry();

                    } else {
                        System.out.println("oops! thats a bit too many entries.. try removing some to make space! ");
                    }

                    menu(p);


                    break;
                case 2:
                    //   System.out.println(abList);
                    // System.out.println(abList.size());
                    for (int i = 0; i < abList.size(); i++) {
                        System.out.println("----------------------------------------------------");
                        System.out.println("Address Book Entry #" + i + "\nFirst name:  " + ((AddressBean) abList.get(i)).first_name + "\nLast name: " + ((AddressBean) abList.get(i)).last_name);
                        System.out.println("Address: " + ((AddressBean) abList.get(i)).address);
                        System.out.println("Email: " + ((AddressBean) abList.get(i)).email_address);
                        System.out.println("Phone Number: " + ((AddressBean) abList.get(i)).phone_number);
                        System.out.println("---------------------------------------------------");
                       // System.out.println(abList);

                    }
                    menu(p);
                    break;
                case 3:
                    System.out.println("Which user would you like to remove?");
                    for (int i = 0; i < abList.size(); i++) {
                        System.out.println();
                        System.out.println("Address Book Entry #" + i + " " + ((AddressBean) abList.get(i)).first_name + " " + ((AddressBean) abList.get(i)).last_name);
                       // p--;

                    }
                    System.out.println("Enter the user's number youd like to remove:");
                    int removedentry = scanner.nextInt();
                    abList.remove(removedentry);

                    for (int i = 0; i < abList.size(); i++) {
                        System.out.println();
                        System.out.println("Address Book Entry #" + i + " " + ((AddressBean) abList.get(i)).first_name + " " + ((AddressBean) abList.get(i)).last_name);
                    }
                    menu(p);

                    break;
                case 4:
                    System.out.println("Sorting the address book by last name");
                    sortentries();
                    menu(p);
                case 5:
                    for (int i = 0; i < abList.size(); i++) {
                        System.out.println();
                        System.out.println("Address Book Entry #" + i + " " + ((AddressBean) abList.get(i)).first_name + " " + ((AddressBean) abList.get(i)).last_name);
                        // p--;

                    }
                    System.out.println("Enter the user's number youd like to edit:");
                    int editentry = scanner.nextInt();
                    abList.remove(editentry);
                    System.out.println("Edit the entry:");
                    addanentry();
                    menu(p);


            }
        } catch (Exception e) {
            System.out.println("put a valid input buddy");
            menu(p);

        }
        return p;
    }


    public static void addanentry() {
        AddressBean ab = new AddressBean();

        Scanner scanner = new Scanner(System.in);

        System.out.println("First Name?");
        String firstname = scanner.nextLine();
        ab.first_name = firstname;

        //  entry.add(firstname);

        System.out.println("Last Name?");
        String lastname = scanner.nextLine();
        ab.last_name = lastname;



        // entry.add(lastname);

        System.out.println("Address?");
        String address = scanner.nextLine();
        ab.address = address;

        //  entry.add(address);

        System.out.println("Phone Number?");
        String phone = scanner.nextLine();
        ab.phone_number = phone;


        System.out.println("Email?");
        String email = scanner.nextLine();
        ab.email_address = email;
        //   entry.add(email);
        abList.add(ab);
        lastnamesort.put(lastname, ab);
        firstnamesort.put(firstname, ab);
        emailsort.put(email, ab);
        phonesort.put(phone, ab);
        addresssort.put(address, ab);
        addtotextfile(ab);


    }// end of add an entry function

    public static void addtotextfile(AddressBean ab) {
        try { // i ran out of time to finish this so it doesnt work but you can see my faithful attempt!
            FileWriter writer;
            writer = new FileWriter("Address Book");
            writer.write(ab.first_name + ",");
            writer.write(ab.last_name + ",");
            writer.write(ab.address + ",");
            writer.write(ab.phone_number + ",");
            writer.write(ab.email_address + ",");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }//end of add to text file function

    public static void sortentries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to  sort by? \n1: last name \n2: first name \n3: phone number \n4: address\n5: email ");
        Integer input = scanner.nextInt();
        switch (input) {
            case 1:

                TreeMap<String, AddressBean> sorted = new TreeMap<>(lastnamesort);
                Set<Map.Entry<String, AddressBean>> mappings = sorted.entrySet();
                System.out.println("Sorted AddressBook by last name");
                for (Map.Entry<String, AddressBean> mapping : mappings) {
                    System.out.println(mapping.getKey() + " ---> " + ((AddressBean) mapping.getValue()).first_name + " , " +
                            ((AddressBean) mapping.getValue()).address + " , " + ((AddressBean) mapping.getValue()).phone_number + " , " +
                            ((AddressBean) mapping.getValue()).email_address);


        }
                break;
            case 2:
                TreeMap<String, AddressBean> firstsorted = new TreeMap<>(firstnamesort);
                Set<Map.Entry<String, AddressBean>> mappings2 = firstsorted.entrySet();
                System.out.println("Sorted AddressBook by first name");
                for (Map.Entry<String, AddressBean> mapping : mappings2) {
                    System.out.println(mapping.getKey() + "--->" +  ((AddressBean) mapping.getValue()).first_name + " , " + ((AddressBean) mapping.getValue()).last_name + " , " +
                            ((AddressBean) mapping.getValue()).address + " , " + ((AddressBean) mapping.getValue()).phone_number + " , " +
                            ((AddressBean) mapping.getValue()).email_address);
                    }
                break;
            case 3:
                TreeMap<String, AddressBean> phonesorted = new TreeMap<>(phonesort);
                Set<Map.Entry<String, AddressBean>> mappings3 = phonesort.entrySet();
                System.out.println("Sorted AddressBook by phone");
                for (Map.Entry<String, AddressBean> mapping : mappings3) {
                    System.out.println(mapping.getKey() + "--->" + ((AddressBean) mapping.getValue()).first_name + " , " + ((AddressBean) mapping.getValue()).last_name + " , " +
                            ((AddressBean) mapping.getValue()).address + " , " + ((AddressBean) mapping.getValue()).phone_number + " , " +
                            ((AddressBean) mapping.getValue()).email_address);
                }
                break;
            case 4:
                TreeMap<String, AddressBean> addresssorted = new TreeMap<>(addresssort);
                Set<Map.Entry<String, AddressBean>> mappings4 = addresssort.entrySet();
                System.out.println("Sorted AddressBook by address ");
                for (Map.Entry<String, AddressBean> mapping : mappings4) {
                    System.out.println(mapping.getKey() + "--->" + ((AddressBean) mapping.getValue()).first_name + " , " + ((AddressBean) mapping.getValue()).last_name + ","+
                            ((AddressBean) mapping.getValue()).address + " , " + ((AddressBean) mapping.getValue()).phone_number + " , " +
                            ((AddressBean) mapping.getValue()).email_address);
                }
                break;
            case 5:
                TreeMap<String, AddressBean> emailsorted = new TreeMap<>(emailsort);
                Set<Map.Entry<String, AddressBean>> mappings5 = emailsort.entrySet();
                System.out.println("Sorted AddressBook by email");
                for (Map.Entry<String, AddressBean> mapping : mappings5) {
                    System.out.println(mapping.getKey() + "--->" + ((AddressBean) mapping.getValue()).first_name + " , " + ((AddressBean) mapping.getValue()).last_name + ","+
                            ((AddressBean) mapping.getValue()).address + " , " + ((AddressBean) mapping.getValue()).phone_number + " , " +
                            ((AddressBean) mapping.getValue()).email_address);
                }
                break;



        }//end of switch


    }// end of sort entries
}// end of class