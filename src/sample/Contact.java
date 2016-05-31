package sample;

/**
 * Created by Dan on 5/31/16.
 */
public class Contact {
        String name;
        String phone;
        String email;

        public Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
        public String toString() {
            return "" + name + ", " + "" + phone + ", " + "" + email + "";
        }
}


