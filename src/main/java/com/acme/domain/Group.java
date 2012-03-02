package com.acme.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The class group.
 * @author Ihar_Padaliakin
 */
@Entity
@Table(name = "groups")
public final class Group extends Domain {

    /** serialVersionUID.*/
    private static final long serialVersionUID = 1L;

    /**
     * Group roles.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "groups_roles", joinColumns = {@JoinColumn(name = "group_id")},
    inverseJoinColumns={@JoinColumn(name="role_id")})
    private List<Role> roles;

    @ManyToMany(mappedBy = "groups")
    private List<User> users;

    /**
     * Default constructor for group.
     */
    public Group() {
        super();
    }

    /**
     * Constructor for group.
     * @param name - name of the group.
     */
    public Group(final String name) {
        this.setName(name);
    }

    /**
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * @return the list group roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * Setter for group roles.
     * @param roles
     *            the roles to set
     */
    public void setRoles(final List<Role> roles) {
        this.roles = roles;
    }
}
