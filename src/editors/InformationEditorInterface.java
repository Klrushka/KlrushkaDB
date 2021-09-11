package editors;

import models.User;
import servises.DBHandler;

public interface InformationEditorInterface {
    void changeUsername(User user, DBHandler dbHandler);
    void changeFirstname(User user, DBHandler dbHandler);
    void changeSecondname(User user, DBHandler dbHandler);
    void changeGender(User user, DBHandler dbHandler);
    void changeBirthday(User user, DBHandler dbHandler);
    void changePassword(User user, DBHandler dbHandler);

}
