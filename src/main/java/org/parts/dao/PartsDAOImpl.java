package org.parts.dao;

import org.parts.dao.executor.Executor;
import org.parts.model.Part;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class PartsDAOImpl implements PartsDAO {

    private List<Part> parts = new ArrayList<>();
    {
        parts.add(new Part("10", "Flame thrower" ,"factory", 10, new GregorianCalendar(2017, 4, 7).getTime(), new GregorianCalendar(2017, 5, 6).getTime()));
        parts.add(new Part("50", "Rocket launcher" ,"factory", 15, new GregorianCalendar(2016, 4, 7).getTime(), new GregorianCalendar(2012, 9, 7).getTime()));
        parts.add(new Part("60", "Gas splitter" ,"factory", 18, new GregorianCalendar(2017, 3, 8).getTime(), new GregorianCalendar(2018, 5, 7).getTime()));
    }

    private Executor executor;

    public PartsDAOImpl () {
        executor = new Executor(ConnectionBuilder.getH2Connection());
    }

    @Override
    public List<Part> getAllParts() {
        List<Part> clonedParts = new ArrayList<>();
        for(Part part : parts){
            Part clonedPart = new Part(part.getPartNumber(),
                                       part.getPartName(),
                                       part.getVendor(),
                                       part.getQuantity(),
                                       new Date(part.getShipped().getTime()),
                                       new Date(part.getReceived().getTime()));
            clonedParts.add(clonedPart);
        }
        return clonedParts;
    }
}
