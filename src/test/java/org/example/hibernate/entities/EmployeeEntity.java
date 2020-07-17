package org.example.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class EmployeeEntity implements Serializable {

    /* to create entity create
     * @Id if this is id column in the DB or primary
     * @Column the column name as it is in the DB
     * Long, Date, String is the type of the column in the DB
     * and variable @columnID or any name to deal with it in your code
     * it is prefer to use setter and getter
     */
    @Id
    @Column(name = "ColumnNameID")
    private Long columnID;

    @Column(name = "ColumnNameDate")
    private Date columnDate;

    @Column(name = "ColumnNameText")
    private String columnText;

    /*
     * Create setter and getter methods
     */

    public Long getColumnID() {
        return columnID;
    }

    public void setColumnID(Long couColumnID) {
        this.columnID = columnID;
    }

    public Date getColumnDate() {
        return columnDate;
    }

    public void setColumnDate(Date columnDate) {
        this.columnDate = columnDate;
    }

    public String getColumnText() {
        return columnText;
    }

    public void setColumnText(String columnText) {
        this.columnText = columnText;
    }
}
