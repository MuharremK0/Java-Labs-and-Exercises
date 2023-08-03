package LabAssignments;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class lab_10 {

	public static void main(String[] args) {
		/* 
		 It's the user-social network program and allows contact each other.
		*/

	}

}
//1.
class User {
	private int id;
	private String username;
	private String email;
	private Set<User> followers;
	private Set<User> following;
	private Set<Post> likedPosts;
	private HashMap<User, Queue<Message>> messages;

	User(String username, String email) {
		this.id = hashCode();
		this.username = username;
		this.email = email;
		this.followers = new HashSet<>();
		this.following = new HashSet<>();
		this.likedPosts = new HashSet<>();
		this.messages = new HashMap<>();
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<User> getFollowers() {
		return followers;
	}

	public Set<User> getFollowing() {
		return following;
	}

	public Set<Post> getLikedPosts() {
		return likedPosts;
	}

	public void message(User recipient, String content) {
		if (!messages.containsKey(recipient)) {
			messages.put(recipient,new LinkedList<>());
		}
		if(!recipient.messages.containsKey(this)) {
			recipient.messages.put(this, new LinkedList<>());
		}
		Message m1=new Message(this,content);
		recipient.messages.put(this, (Queue<Message>) m1);
		messages.put(recipient, (Queue<Message>) m1);
		read(recipient);
	}
	public void read(User user) {
		if(messages.containsKey(user)) {
			Queue<Message> q1=messages.get(user);
			while(!q1.isEmpty()) {
				Message m1=q1.poll();
				System.out.println(m1);
			}
		}
	}
	public void follow(User user) {
		if(following.contains(user)) {
			following.remove(user);
			user.followers.remove(this);
		}else {
			following.add(user);
			user.followers.add(this);
		}
	}
	public void like(Post post) {
		if(likedPosts.contains(post)) 
			likedPosts.remove(post);
		else 
			likedPosts.add(post);
		post.likedBy(this);
	}
	public Post post(String content) {
		SocialNetwork.post(this, content);
		return new Post(content);
	}
	public Comment comment(Post post,String content) {
		Comment c1=new Comment(content);
		post.commentBy(this, c1);
		return c1;
	}
	public boolean equals(Object o) {
		User other=(User) o;
		return id==other.id;
	}
	public int hashCode() {
		return Objects.hash(email);
	}
}

//2.
class Message {
	private boolean seen;
	private java.util.Date dateSent;
	private String content;
	private User sender;
	
	Message(User sender,String content){
		dateSent=new Date();
		seen=false;
		this.sender=sender;
		this.content=content;
	}
	public String read(User reader) {
		if(!sender.equals(reader))
			seen=true;
		System.out.println("Sent at: "+dateSent);
		return content;
	}
	public boolean hasRead() {
		return seen;
	}
	
}

//3.
class Post {
	private java.util.Date datePosted;
	private String content;
	private Set<User> likes;
	private Map<User,List<Comment>> comments;
	
	Post(String content){
		datePosted=new Date();
		this.content=content;
		likes=new HashSet<>();
		comments=new HashMap<>();
	}
	public boolean likedBy(User user) {
		if(likes.contains(user)) {
			likes.remove(user);
			return false;
		}
		likes.add(user);
		return true;
	}
	public boolean commentBy(User user,Comment comment) {
		if(!comments.containsKey(user)) {
			comments.put(user,new LinkedList<>());
		}
		comments.get(user).add(comment);
		return true;
	}
	public String getContent() {
		System.out.println("Posted at: "+datePosted);
		return content;
	}
	public Comment getComment(User user,int index) {
		if(comments.containsKey(user) && index>=0 && index<comments.get(user).size()) {
			return comments.get(user).get(index);
		}
		return null;
	}
	public int getCommentCount() {
		int count=0;
		for(List<Comment> list:comments.values()) {
			count+=list.size();
		}
		return count;
	}
	public int getCommentCountByUser(User user) {
		return comments.getOrDefault(user, Collections.emptyList()).size();
	}
}

//4.
class Comment extends Post {

	Comment(String content) {
		super(content);
	}

}

//5.
class SocialNetwork {
	private static Map<User,List<Post>> postsByUsers=new HashMap<>();
	
	public static User register(String username,String email) {
		User s1=new User(username,email);
		if(!postsByUsers.containsKey(s1)) {
			postsByUsers.put(s1, new LinkedList<>());
			return s1;
		}
		return null;
	}
	public static Post post(User user,String content) {
		if(postsByUsers.containsKey(user)) {
			Post p1=new Post(content);
			List<Post> l1=postsByUsers.get(user);
			l1.add(p1);
			postsByUsers.put(user, l1);
			return p1;
		}
		return null;
	}
	public static User getUser(String email) {
		int hashed=Objects.hash(email);
		for(User user : postsByUsers.keySet()) {
			if(user.hashCode()==hashed)
				return user;
		}
		return null;
	}
	public static Set<Post> getFeed(User user){
		Set<Post> feed=new HashSet<>();
		for(User u:user.getFollowing()) {
			List<Post> listOfOthersPosts=postsByUsers.getOrDefault(u, Collections.emptyList());
			feed.addAll(listOfOthersPosts);
		}
		return feed;
	}
	public static Map<User,String> search(String keyword){
		Map<User,String> m1=new HashMap<>();
		for(User user:postsByUsers.keySet()) {
			if(user.getUsername().contains(keyword))
				m1.put(user, user.getUsername());
		}
		return m1;
	}
	public static <K,V>Map<V,Set<K>> reverseMap(Map<K,V> map){
		Map<V,Set<K>> reversed=new HashMap<>();
		for(Map.Entry<K, V> m:map.entrySet()) {
			if(!reversed.containsKey(m.getValue())) {
				reversed.put(m.getValue(), new HashSet<>());
			}
			reversed.get(m.getValue()).add(m.getKey());
		}
		return reversed;
	}
}