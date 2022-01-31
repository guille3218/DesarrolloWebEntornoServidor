package org.iesalixar.servidor.hibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="posts")
public class Post implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false,length=500)
	private String content;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="post", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Comment> comments = new HashSet<>();
	
	@OneToMany(mappedBy="post", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Valuation> valuations = new HashSet<>();
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, date, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(content, other.content) && Objects.equals(date, other.date)
				&& Objects.equals(id, other.id) && Objects.equals(title, other.title);
	}
	
	
	//Métodos HELPERs post-comment	
		public void addComment(Comment comment)  {
			this.comments.add(comment);
			comment.setPost(this);
		}
		
		public void removeComment(Comment comment) {
			this.comments.remove(comment);
			comment.setPost(null);
		}
	
	//Métodos HELPERs many to many
		
		public void addValuation(User user, Double score) {
			Valuation valuation = new Valuation(user,this,score);
			this.valuations.add(valuation);
			user.getValuations().add(valuation);
		}
		
		public void removeValuation(User user) {
			Valuation valuation = new Valuation(user,this);
			user.getValuations().remove(valuation);
			this.valuations.remove(valuation);
		}
}
