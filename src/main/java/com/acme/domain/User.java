package com.acme.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The class User.
 *
 * @author Ihar_Padaliakin
 */
@Entity
@Table(name = "users", schema = "staff")
@NamedQuery(name = "user.paginator", query = "FROM User u WHERE u.name LIKE :name ORDER BY :order_by ASC ")
public class User extends Domain {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * User password.
     */
    private String password;

    /**
     * User roles.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")
            },
            uniqueConstraints =
            @UniqueConstraint(columnNames = {"user_id", "role_id"})
    )
    private Set<Role> roles;

    /**
     * User groups.
     */
    @ManyToMany
    @JoinTable(name = "users_groups",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "group_id", referencedColumnName = "id")
            }
    )
    private Set<Group> groups;

    /**
     * Persone.
     */
    private Long personeId;

    /**
     * User email.
     */
    private String email;

    /**
     * User email.
     */
    private Boolean deleted = Boolean.FALSE;

    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * Constructor.
     *
     * @param name - login of user
     */
    public User(final String name) {
        setName(name);
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for user password.
     *
     * @param password - set password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(final Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * @param personeId id of persone to set
     */
    public void setPersoneId(final Long personeId) {
        this.personeId = personeId;
    }

    /**
     * @return the persone
     */
    public Long getPersoneId() {
        return personeId;
    }

    /**
     * @return the groups
     */
    public Set<Group> getGroups() {
        return groups;
    }

    /**
     * @param groups the groups to set
     */
    public void setGroups(final Set<Group> groups) {
        this.groups = groups;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the deleted
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * @param deleted the deleted to set
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /* (non-Javadoc)
      * @see java.lang.Object#toString()
      */
    @Override
    public String toString() {
        return "User [password=" + password + ", roles=" + roles + ", groups="
                + groups + ", personeId=" + personeId + ", email=" + email
                + ", deleted=" + deleted + "]";
    }

}
