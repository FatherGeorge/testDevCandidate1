package org.parts.service;

import org.parts.model.Part;

import java.util.List;

public interface PartsService {
    List<Part> getAllParts();
    List<Part> getArrangedParts(Dto dto);
}
