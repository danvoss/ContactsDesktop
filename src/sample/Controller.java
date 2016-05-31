package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    public void onAdd() {
        Contact item = new Contact(textName.getText(), textPhone.getText(), textEmail.getText());
        if (!item.name.isEmpty() && !item.phone.isEmpty() && !item.email.isEmpty()) {
            contacts.add(item);
        }
            textName.clear();
            textPhone.clear();
            textEmail.clear();
    }

    public void onRemove() {
        Contact item = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(item);
    }

//    public void writeFile () throws IOException {
//        File f = new File("contact.json");
//        JsonSerializer serializer = new JsonSerializer();
//        String json = serializer.serialize(contacts);
//        FileWriter fwJson = new FileWriter(f);
//        fwJson.write(json);
//        fwJson.close();
//    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }
}
