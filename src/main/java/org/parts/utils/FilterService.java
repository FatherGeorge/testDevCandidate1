package org.parts.utils;

import org.parts.model.Part;
import org.parts.service.Dto;

import java.util.Iterator;
import java.util.List;

public class FilterService {
    public static List<Part> applyFilter(List<Part> allParts, final Dto dto) {
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

    private static void filterColumn(List<Part> allParts, Filter<Part> filter) {
        Iterator<Part> partsIterator = allParts.iterator();
        while (partsIterator.hasNext()) {
            Part part = partsIterator.next();
            if (filter.shouldRemove(part)) {
                partsIterator.remove();
            }
        }
    }
}
