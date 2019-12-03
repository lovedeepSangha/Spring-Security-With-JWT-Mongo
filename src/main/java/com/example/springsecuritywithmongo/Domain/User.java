package com.example.springsecuritywithmongo.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Document(collection = "user")
@JsonIgnoreProperties({ "authorities" })
@Getter
@Setter
public class User  extends BaseEntity{



    private boolean active=true;
    private String roles;

    private static final long serialVersionUID = 1L;
    @Indexed(unique = true)
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    @Indexed(unique = true)
    private String email;
    private String gravatarHash;
    private String phoneNum;
    private String jobTitle;
    private String mobileNum;
    private String language;
    private String timeZone;
    private String userAppNo;
    private String defaultImage;
    private String imageURL;
    private String mediumImage;
    private String smallImage;
    private String standardImage;
    private String userType;
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String state;
    private String zip;
    private String fullName;
    private String timeZoneValue;
    private ObjectId country;
    private List<String> staffRoles;
    private List<String> freeLancersRole;
    private List<Map<String, Object>> secondaryEmail;
    private String additionalEmail;
    private ObjectId account;
    private List<ObjectId> contractFiles;
    private boolean isDeleted;
    private boolean isUser=true;
    private boolean isBillingContact;
    private boolean notification;
    private boolean invoice;
    private boolean isAccountLocked;
    private boolean inDayLightSaving = true;
    private boolean isTermsAccepted = false;
    private boolean isDefault;
    private boolean isGravatarSelected = true;
    private boolean isGestUser = false;
    private boolean suspendNotification = false;
    private boolean medialibraryNotification = false;
    private boolean isTimeClockEditingEnabled = false;
    private boolean isAllowOutsideClockIn = false;
    private String qbVendorID;
    private String qbEditSequence;
    private int defaultPageSize = 25;
    private boolean pto = false;
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }
        return id.toString().equals(((User) obj).id.toString());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
