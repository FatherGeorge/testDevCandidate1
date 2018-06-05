package org.parts.dao.executor;

import org.parts.service.Dto;

import java.sql.*;
import java.util.ArrayList;

public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public <T> T execQuery(Dto dto, ResultHandler<T> handler) throws SQLException {
        String sqlQuery = "select * from Parts WHERE 1=1 ";
        ArrayList queryParams = new ArrayList();
        if (dto.getPartNumber() != null && !dto.getPartNumber().isEmpty()) {
            sqlQuery += " AND partNumber LIKE ? ";
            queryParams.add(dto.getPartNumber());
        }
        if (dto.getPartName() != null && !dto.getPartName().isEmpty()) {
            sqlQuery += " AND partName LIKE ? ";
            queryParams.add(dto.getPartName());
        }
        if (dto.getVendor() != null && !dto.getVendor().isEmpty()) {
            sqlQuery += " AND vendor LIKE ? ";
            queryParams.add(dto.getVendor());
        }
        if (dto.getQty() != null) {
            sqlQuery += " AND quantity >= ? ";
            queryParams.add(dto.getQty());
        }
        if (dto.getShippedAfter() != null) {
            sqlQuery += " AND shipped >= ? ";
            queryParams.add(dto.getShippedAfter());
        }
        if (dto.getShippedBefore() != null) {
            sqlQuery += " AND shipped <= ? ";
            queryParams.add(dto.getShippedBefore());
        }
        if (dto.getReceivedAfter() != null) {
            sqlQuery += " AND received >= ? ";
            queryParams.add(dto.getReceivedAfter());
        }
        if (dto.getReceivedBefore() != null) {
            sqlQuery += " AND received <= ? ";
            queryParams.add(dto.getReceivedBefore());
        }

        PreparedStatement stmt = connection.prepareStatement(sqlQuery);
        int index = 1;
        for (Object param : queryParams) {
            stmt.setObject(index++, param);
        }

        ResultSet result = stmt.executeQuery();
        T value = handler.handle(result);
        result.close();
        stmt.close();

        return value;
    }
}
