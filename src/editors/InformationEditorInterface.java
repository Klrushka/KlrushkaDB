package editors;

import models.User;
import servises.DBHandler;

public interface InformationEditorInterface {
    void changeUsername();
    void changeFirstname();
    void changeSecondname();
    void changeGender();
    void changeBirthday();
    void changeMail();
    void changePassword();

}
