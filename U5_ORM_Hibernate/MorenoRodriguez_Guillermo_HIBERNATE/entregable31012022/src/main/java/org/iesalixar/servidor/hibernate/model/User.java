package org.iesalixar.servidor.hibernate.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(nullable=false,unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String firstName;

	@Column(nullable=false)
	private String lastName;
	
	@Column(nullable=false)
	private String email;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Comment> comments = new HashSet<>();
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Post> posts = new HashSet<>();
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Valuation> valuations = new HashSet<>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	
	public Set<Comment> getComments() {
		return comments;
	}
	
	public Set<Post> getPosts() {
		return posts;
	}
	
	public Set<Valuation> getValuations() {
		return valuations;
	}

	//Métodos HELPERs user-comment	
	public void addComment(Comment comment)  {
		this.comments.add(comment);
		comment.setUser(this);
	}
	
	public void removeComment(Comment comment) {
		this.comments.remove(comment);
		comment.setUser(null);
	}
	
	//Métodos HELPERs user-post	
		public void addPost(Post post)  {
			this.posts.add(post);
			post.setUser(this);
		}
		
		public void removePost(Post post) {
			this.posts.remove(post);
			post.setUser(null);
		}
	
	
}
