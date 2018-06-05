package org.parts.dao;

import org.parts.model.Part;
import org.parts.service.Dto;

import java.sql.SQLException;
import java.util.List;

public interface PartsDAO {
    List<Part> getParts(Dto dto) throws SQLException;
}
