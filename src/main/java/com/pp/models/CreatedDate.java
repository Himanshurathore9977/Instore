package com.pp.models;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pp.util.ConstantMessages;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class CreatedDate implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateCreated", nullable = false)
	@JsonFormat(pattern = ConstantMessages.DATE_TIME_FORMATE, timezone =  ConstantMessages.INDIAN_TIME_ZONE_CODE)
	//@CreationTimestamp
	private Date dateCreated;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateModified", nullable = false)
	@JsonFormat(pattern = ConstantMessages.DATE_TIME_FORMATE, timezone =  ConstantMessages.INDIAN_TIME_ZONE_CODE)
	//@UpdateTimestamp
	private Date dateModified;
	
	@PrePersist
    public void onCreate() {
        this.dateCreated = this.dateModified = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        this.dateModified = new Date();
    }
}