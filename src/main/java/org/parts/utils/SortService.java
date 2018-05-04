package org.parts.utils;

import org.parts.model.Part;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortService {
    private Boolean lastSortAscending = true;
    private String lastSortField = "";

    public List<Part> applySort(List<Part> filteredParts, String sortField) {
        PartsComparator comparator;
        if (lastSortField.equals(sortField)) {
            if (lastSortAscending) {
                lastSortAscending = false;
                comparator = new PartsComparator(sortField, false);
            } else {
                lastSortAscending = true;
                comparator = new PartsComparator(sortField, true);
            }
        } else {
            lastSortAscending = true;
            comparator = new PartsComparator(sortField, true);
        }
        Collections.sort(filteredParts, comparator);
        
        lastSortField = sortField;

        return filteredParts;
    }

    private class PartsComparator implements Comparator<Part> {
        private String sortedField;
        private Boolean ascending;

        public PartsComparator(String sortedField, Boolean ascending) {
            this.sortedField = sortedField;
            this.ascending = ascending;
        }

        @Override
        public int compare(Part o1, Part o2) {
            try {
                Field field1 = o1.getClass().getDeclaredField(sortedField);
                field1.setAccessible(true);
                Object value1 = field1.get(o1);
                Comparable c1 = (Comparable) value1;

                Field field2 = o2.getClass().getDeclaredField(sortedField);
                field2.setAccessible(true);
                Object value2 = field2.get(o2);
                Comparable c2 = (Comparable) value2;

                if (ascending) {
                    return c1.compareTo(c2);
                } else {
                    return c2.compareTo(c1);
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }
}
