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

        @Override
        public String toString() {
            return "" + name + ", " + "" + phone + ", " + "" + email + "";
        }
//            return "Contact{" +
//                    "name='" + name + '\'' +
//                    ", phone='" + phone + '\'' +
//                    ", email='" + email + '\'' +
//                    '}';
        }


