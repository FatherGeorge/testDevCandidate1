package org.parts.service;

import org.parts.dao.PartsDAO;
import org.parts.dao.PartsDAOImpl;
import org.parts.model.Part;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fathergeorge on 29.04.18.
 */
public class PartsServiceImpl implements PartsService {

    private PartsDAO dao = new PartsDAOImpl();

    private ArrayList<Part> filteredParts;
    //private SortService sortService = new SortService();

    @Override
    public List<Part> getAllParts() {
        return dao.getAllParts();
    }

    @Override
    public List<Part> getArrangedParts(Dto dto) {

/*        if (dto.isFiltered()) {
            filteredParts = applyFilter((ArrayList<Part>) getAllParts(), dto);
            return filteredParts;
        } else if (dto.isSorted()) {
            return sortService.applySort(filteredParts, dto.getSortField());
        }*/

        filteredParts = (ArrayList<Part>) getAllParts();
        return filteredParts;
    }

/*    private ArrayList<Part> applyFilter(ArrayList<Part> allParts, final Dto dto) {

        if (!"".equals(dto.getPartNumber())) {
            filterColumn(allParts, new Filter<Part>() {
                @Override
                public boolean shouldRemove(Part part) {
                    return !part.getPartNumber().toLowerCase().contains(dto.getPartNumber().toLowerCase());
                }
            });
        }
        if (!"".equals(dto.getPartName())) {
            filterColumn(allParts, new Filter<Part>() {
                @Override
                public boolean shouldRemove(Part part) {
                    return !part.getPartName().toLowerCase().contains(dto.getPartName().toLowerCase());
                }
            });
        }
        if (!"".equals(dto.getVendor())) {
            filterColumn(allParts, new Filter<Part>() {
                @Override
                public boolean shouldRemove(Part part) {
                    return !part.getVendor().toLowerCase().contains(dto.getVendor().toLowerCase());
                }
            });
        }
        if (dto.getQty() != null) {
            filterColumn(allParts, new Filter<Part>() {
                @Override
                public boolean shouldRemove(Part part) {
                    return part.getQuantity() < dto.getQty();
                }
            });
        }
        if (dto.getShippedAfter() != null) {
            filterColumn(allParts, new Filter<Part>() {
                @Override
                public boolean shouldRemove(Part part) {
                    return part.getShipped().compareTo(dto.getShippedAfter()) < 0;
                }
            });
        }
        if (dto.getShippedBefore() != null) {
            filterColumn(allParts, new Filter<Part>() {
                @Override
                public boolean shouldRemove(Part part) {
                    return part.getShipped().compareTo(dto.getShippedBefore()) > 0;
                }
            });
        }
        if (dto.getReceivedAfter() != null) {
            filterColumn(allParts, new Filter<Part>() {
                @Override
                public boolean shouldRemove(Part part) {
                    return part.getReceived().compareTo(dto.getReceivedAfter()) < 0;
                }
            });
        }
        if (dto.getReceivedBefore() != null) {
            filterColumn(allParts, new Filter<Part>() {
                @Override
                public boolean shouldRemove(Part part) {
                    return part.getReceived().compareTo(dto.getReceivedBefore()) > 0;
                }
            });
        }
        return allParts;
    }

    private void filterColumn(List<Part> allParts, Filter<Part> filter) {
        Iterator<Part> partsIterator = allParts.iterator();
        while (partsIterator.hasNext()) {
            Part part = partsIterator.next();
            if (filter.shouldRemove(part)) {
                partsIterator.remove();
            }
        }
    }*/
}
