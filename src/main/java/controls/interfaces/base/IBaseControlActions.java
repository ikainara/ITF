package controls.interfaces.base;

public interface IBaseControlActions {
    void click();
    void click(int timeoutSec);
    String getAttribute(String attributeName);
    String getAttribute(String attributeName, int timeout);
    String getText();
    String getText(int timeoutSec);
}
