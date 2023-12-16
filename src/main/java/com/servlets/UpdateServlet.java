
package com.servlets;
import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.entities.Note;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.helper.FactoryProvider;

public class UpdateServlet extends HttpServlet {

    public UpdateServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Assuming you are trying to delete a note, so the method should be named appropriately
            // and should not update the note's title and content
        	String title=request.getParameter("title");
        	String content=request.getParameter("content");
            int noteId = Integer.parseInt(request.getParameter("noteId").trim());
            Session s = FactoryProvider.getFactory().openSession();
            Transaction tx = s.beginTransaction();

            // Fetch the note by ID
            Note note = s.get(Note.class, noteId);

           
           note.setTitle(title);
           note.setContent(content);
           note.setAddedDate(new Date());
           

            tx.commit();
            s.close();

            response.sendRedirect("all_notes.jsp");
        } catch (Exception e) {
            // Handle exceptions appropriately (logging, error pages, etc.)
            e.printStackTrace();
        }
    }
}
