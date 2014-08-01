package org.uma.dto;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * 
 * User model DTO.
 * 
 * @author piastrellatore
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -2905802084798623134L;

	private Long id;
	private String userName;
	private String password;
	private String email;
	private byte[] picture;
	private String company;
	private String division;
	private String area;
	private Boolean enable;
	private Boolean confirmed = false;
	private int loginCounter = 0;
	private Date lastLoginDate;
	private Date expirationDate;
	private Date creationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	public int getLoginCounter() {
		return loginCounter;
	}

	public void setLoginCounter(int loginCounter) {
		this.loginCounter = loginCounter;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", picture="
				+ Arrays.toString(picture) + ", company=" + company
				+ ", division=" + division + ", area=" + area + ", enable="
				+ enable + ", confirmed=" + confirmed + ", loginCounter="
				+ loginCounter + ", lastLoginDate=" + lastLoginDate != null ? sdf.format(lastLoginDate) : ""
				+ ", expirationDate=" + expirationDate != null ? sdf.format(expirationDate) : "" + ", creationDate="
				+ creationDate != null ? sdf.format(creationDate) : "" + "]";
	}
}
