package com.schedule.suggestion.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cluster")
public class Cluster implements Serializable {
    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    // ----------------------------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "cluster_alias")
    private String clusterAlias;

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    // ----------------------------------------------------------------------

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClusterAlias() {
        return clusterAlias;
    }

    public void setClusterAlias(String clusterAlias) {
        this.clusterAlias = clusterAlias;
    }
}