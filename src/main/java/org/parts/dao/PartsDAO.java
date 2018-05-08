package org.parts.dao;

import org.parts.model.Part;

import java.sql.SQLException;
import java.util.List;

public interface PartsDAO {
    List<Part> getAllParts()  throws SQLException;
}
