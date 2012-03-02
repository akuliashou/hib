package com.acme.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The class Role.
 * @author Ihar_Padaliakin
 */
@Entity
@Table(name = "roles")
public class Role extends Domain {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
}
