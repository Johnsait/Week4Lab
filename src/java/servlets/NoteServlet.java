package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author JohnC. <john.crudo@edu.sait.ca>
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String contents = br.readLine();
        br.close();

        Note note = new Note(title, contents);
        request.setAttribute("note", note);

        //TODO 
        String editInput = request.getParameter("edit");

        if (editInput != null) {

            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);

        }
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        String title = request.getParameter("title");
        String contents = request.getParameter("contents");

        pw.println(title);
        pw.println(contents);
        pw.close();

        Note note = new Note(title, contents);
        request.setAttribute("note", note);

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }

}
