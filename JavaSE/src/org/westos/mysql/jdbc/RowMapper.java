package org.westos.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {

    Object map(ResultSet rs) throws SQLException;
}
