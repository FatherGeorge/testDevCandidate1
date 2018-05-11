package org.parts.service;

import org.parts.dao.PartsDAO;
import org.parts.dao.PartsDAOImpl;
import org.parts.model.Part;
import org.parts.utils.FilterService;
import org.parts.utils.SortService;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by fathergeorge on 29.04.18.
 */
public class PartsServiceImpl implements PartsService {

    private PartsDAO dao = new PartsDAOImpl();
    private List<Part> filteredParts;
    private SortService sortService = new SortService();

    @Override
    public List<Part> getArrangedParts(Dto dto) {
        try {
            if (dto.isFiltered()) {
                filteredParts = FilterService.applyFilter(dao.getAllParts(), dto);
                return filteredParts;
            } else if (dto.isSorted()) {
                return sortService.applySort(filteredParts, dto.getSortField());
            }
            filteredParts = dao.getAllParts();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filteredParts;
    }
}
