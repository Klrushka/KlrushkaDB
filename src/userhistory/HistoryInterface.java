package userhistory;

public interface HistoryInterface {

    /**
     * Create history txt file in src//userhistory//data
     */
    void createHistoryFile();

    /**
     * Add history to a history file of user
     * @param actions
     */
    void addHistory(UserActions actions);


    /**
     * Clear history file
     */
    void clearHistory();


    void displayHistory();
}
