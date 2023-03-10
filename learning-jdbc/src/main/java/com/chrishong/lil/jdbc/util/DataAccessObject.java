package com.chrishong.lil.jdbc.util;

import java.sql.*;
import java.util.List;

public abstract class DataAccessObject <T extends DataTransferObject>  {

    protected final Connection connection;
    protected final static String LAST_VAL = "SELECT last_value FROM ";
    protected final static String USER_SEQUENCE = "user_sequence";

    public DataAccessObject(Connection connection){
        super();
        this.connection = connection;
    }

    public abstract T findById(long id);
}
