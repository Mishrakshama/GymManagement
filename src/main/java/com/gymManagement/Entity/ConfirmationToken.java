package com.gymManagement.Entity;

import java.util.Date;
import jakarta.persistence.*;
@Entity
public class ConfirmationToken {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="token_id")
	    private Long tokenId;

	    @Column(name="confirmation_token")
	    private String confirmationToken;

	    @Temporal(TemporalType.TIMESTAMP)
	    private Date createdDate;
		private User user;	    
		public ConfirmationToken(Long tokenId, String confirmationToken, Date createdDate) {
			super();
			this.tokenId = tokenId;
			this.confirmationToken = confirmationToken;
			this.createdDate = createdDate;
		}

		public ConfirmationToken(User user) {
			
			this.user = user;
		}
		 public User getUserEntity() {
		        return this.user;
		    }

		public Long getTokenId() {
			return tokenId;
		}

		public void setTokenId(Long tokenId) {
			this.tokenId = tokenId;
		}

		public String getConfirmationToken() {
			return confirmationToken;
		}

		public void setConfirmationToken(String confirmationToken) {
			this.confirmationToken = confirmationToken;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}
	    
}
