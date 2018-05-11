package org.parts.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.parts.service.Dto;
import org.parts.service.PartsService;
import org.parts.service.PartsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*@WebServlet("/homeServlet")*/
public class HomeServlet extends HttpServlet {

    private PartsService service = new PartsServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        if (reader != null) {
            json = reader.readLine();
        }

        ObjectMapper mapper = new ObjectMapper();

        Dto dto = mapper.readValue(json, Dto.class);

        resp.setContentType("application/json");
        mapper.writeValue(resp.getOutputStream(), service.getArrangedParts(dto));
    }
}
