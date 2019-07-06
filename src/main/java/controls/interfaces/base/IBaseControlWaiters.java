package controls.interfaces.base;

public interface IBaseControlWaiters {
    void waitIsPresent();
    void waitIsVisible();
    void waitIsClickable();

    void waitIsNotPresent() throws InterruptedException;
    void waitIsNotVisible();
    void waitIsNotClickable();
}
