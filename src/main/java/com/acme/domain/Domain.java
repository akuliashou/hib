package com.acme.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The class <code>Entity</code>.
 *
 * @author crash
 * @version 1.0
 */
@MappedSuperclass
public class Domain implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /** The entity id. */
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    /** The entity name. */
    private String name;

    /**
     * Getter for id.
     *
     * @return entity id.
     */
    public final Long getId() {
        return id;
    }

    /**
     * Setter for id.
     *
     * @param id entity id.
     */
    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * Getter for name.
     *
     * @return entity name.
     */
    public final String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name entity name.
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the <code>Entity</code> object.
     *
     * @return a string representation of the <code>Entity</code> object.
     */
    @Override
    public String toString() {
        return new StringBuilder()
            .append('{')
            .append(id)
            .append(',')
            .append(name)
            .append('}')
            .toString();
    }
} // class
