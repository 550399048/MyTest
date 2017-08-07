package EventObserverPa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wucaiyan on 17-6-9.
 */
public class EventSubject implements EventSubjectInterface {
    private Map<String,ArrayList<EventObserver>> mEventObservers=new HashMap<String,ArrayList<EventObserver>>();
    private static volatile EventSubject mEventSubject;
    private EventSubject(){

    }

    public synchronized static EventSubject getInstance(){
        if (mEventSubject == null){
            mEventSubject = new EventSubject();
        }
        return mEventSubject;
    }
    @Override
    public void registerObserver(String eventType, EventObserver observer) {
        synchronized (mEventObservers) {
            ArrayList<EventObserver> eventObservers = mEventObservers.get(eventType);
            if (eventObservers == null) {
                eventObservers = new ArrayList<EventObserver>();
                mEventObservers.put(eventType, eventObservers);
            }
            if(eventObservers.contains(observer)) {
                return;
            }
            eventObservers.add(observer);
        }
    }


    @Override
    public void removeObserver(String eventType, EventObserver observer) {
        int index = mEventObservers.get(eventType).indexOf(observer);
        if (index >0) {
            mEventObservers.remove(observer);
        }

    }

    @Override
    public void notifyObserver(String eventType) {

    }
}
