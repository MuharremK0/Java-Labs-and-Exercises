package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		MyTopic topic = new MyTopic();
		
		Observer obj1 = new MyTopicSubscriber("Obj1");
		Observer obj2 = new MyTopicSubscriber("Obj2");
		Observer obj3 = new MyTopicSubscriber("Obj3");
		
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		
		obj1.update();
		
		topic.postMessage("New Message");
		
		
	}

}

interface Subject {
	//methods to register and unregister observers
	public void register(Observer obj);
	public void unregister(Observer obj);
	public void notifyObservers();
	
	
	public Object getUpdate(Observer obs);
}

class MyTopic implements Subject {
	private List<Observer> observers;
	private String message;
	private boolean changed;
	
	public MyTopic() {
		this.observers = new ArrayList<>();
	}
	
	@Override
	public void register(Observer obj) {
		if(obj == null) throw new NullPointerException("Null Observer");
		if(!observers.contains(obj)) observers.add(obj);
	}
	
	@Override
	public void unregister(Observer obj) {
		observers.remove(obj);
	}
	
	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		
		if(!changed) return;
		
		observersLocal = new ArrayList<>(this.observers);
		this.changed = false;
		
		for(Observer objObserver : observersLocal) {
			objObserver.update();
		}
	}

	@Override
	public Object getUpdate(Observer obs) {
		return this.message;
	}
	
	// method to post message to the topic, change state (trigger notifications)
	public void postMessage(String msg) {
		System.out.println("Message Posted to Topic:" + msg);
		this.message = msg;
		this.changed = true;
		notifyObservers();
	}
	
	
}

interface Observer {
	// method to update the observer , used by subject
	public void update();
	public void setSubject(Subject sub);
}

class MyTopicSubscriber implements Observer {
	private String name;
	private Subject topic;
	
	public MyTopicSubscriber(String nm) {
		this.name = nm;
	}
	
	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if(msg == null) {
			System.out.println(name+":: No new message");
		}else {
			System.out.println(name+":: Consuming message::"+msg);
		}
		
	}
	
	@Override
	public void setSubject(Subject sub) {
		this.topic = sub;
	}
	
	
}
