package userhistory;

public interface HistoryInterface {

    /**
     * Searching historyFile
     * @return -1 if not found, else id of user
     */
    long findHistoryFile();

    void createHistoryFile();
    void addHistory(UserActions actions);
    // TODO void clearHistory();
}
