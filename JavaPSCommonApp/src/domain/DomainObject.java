/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author student2
 */
public abstract class DomainObject {

    public abstract String getTableName();

    public abstract String getColumnsForInsert();

    public abstract String getParamsForInsert();

    public abstract String getParamsForUpdate();

    public abstract void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException;

    public abstract void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) throws SQLException;

    public abstract void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) throws SQLException;

    public boolean containsAutoIncrementPK() {
        return true;
    }

    public abstract void setAutoIncrementPrimaryKey(int primaryKey);

;

}
