package EventObserverPa;

/**
 * Created by wucaiyan on 17-6-9.
 */
public interface EventObserverInterface {
    /**
     * 根据事件进行数据或者UI的更新
     * @param eventType
     */
    public void dispatchChange(String eventType);
}
