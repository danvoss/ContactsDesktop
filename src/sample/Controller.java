package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {
    @FXML
    TextField textName;

    @FXML
    TextField textPhone;

    @FXML
    TextField textEmail;

    @FXML
    ListView list;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void onAdd() throws IOException {
        Contact item = new Contact(textName.getText(), textPhone.getText(), textEmail.getText());
        if (!item.name.isEmpty() && !item.phone.isEmpty() && !item.email.isEmpty()) {
            contacts.add(item);
            writeFile(contacts);
        }
            textName.clear();
            textPhone.clear();
            textEmail.clear();
    }

    public void onRemove() {
        Contact item = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(item);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }

//    public ObservableList<Contact> readFile() {
//         create an ArrayLIst of HashMaps from parse method; loop over it to create Contact objects by pulling out each
    //     of the 3 fields
//    }

//    public ObservableList<Contact> readfile() {
//        File f = new File("contact.json");
//            Scanner scanner = null;
//            try {
//                scanner = new Scanner(f);
//                scanner.useDelimiter("\\Z");
//                String contents = scanner.next();
//                JsonParser parser = new JsonParser();
//
//                ArrayList<HashMap<String, String>> list = parser.parse(contents);
//                for (HashMap<String, String> h: list) {
//                    contacts.add(new Contact(h.get("name"), h.get("phone"), h.get("email")));
//                }
//                return contacts;
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                return contacts;
//            }
//    }


    public void writeFile(ObservableList<Contact> contacts) throws IOException {
        File f = new File("contact.json");
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(contacts);
        FileWriter fwJson = new FileWriter(f);
        fwJson.write(json);
        fwJson.close();
    }
}
