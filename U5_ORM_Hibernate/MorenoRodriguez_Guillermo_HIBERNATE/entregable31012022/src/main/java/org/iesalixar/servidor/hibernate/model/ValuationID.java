package org.iesalixar.servidor.hibernate.model;

import java.io.Serializable;
import java.util.Objects;

public class ValuationID implements Serializable{
	
	private Long user;
	private Long post;
	
	public ValuationID() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(post, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValuationID other = (ValuationID) obj;
		return Objects.equals(post, other.post) && Objects.equals(user, other.user);
	}

	public Long getUserId() {
		return user;
	}

	public void setUserId(Long userId) {
		this.user = userId;
	}

	public Long getPostId() {
		return post;
	}

	public void setPostId(Long postId) {
		this.post = postId;
	}
	
	

}
