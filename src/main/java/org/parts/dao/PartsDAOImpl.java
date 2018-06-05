package org.parts.dao;

import org.parts.dao.executor.Executor;
import org.parts.dao.executor.ResultHandler;
import org.parts.model.Part;
import org.parts.service.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartsDAOImpl implements PartsDAO {

    private Executor executor;

    public PartsDAOImpl () {
        executor = new Executor(ConnectionBuilder.getH2Connection("jdbc:h2:~/TestDB", "", ""));
    }

    @Override
    public List<Part> getParts(Dto dto) throws SQLException {
        return executor.execQuery(dto, new ResultHandler<List<Part>>() {
            @Override
            public List<Part> handle(ResultSet resultSet) throws SQLException {
                List<Part> parts = new ArrayList<>();
                while (resultSet.next()) {
                    parts.add(new Part(resultSet.getString(3),
                            resultSet.getString(2),
                            resultSet.getString(4),
                            resultSet.getInt(5),
                            resultSet.getDate(6),
                            resultSet.getDate(7)));
                }
                return parts;
            }
        });
    }
}
