package Metier;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entities.Etudiant;


public class saveEtudiant extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public saveEtudiant() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        int age = Integer.parseInt(request.getParameter("age"));
        String ville = request.getParameter("ville");
        //String id = request.getParameter("id");
        ArrayList<Etudiant> listeEtudiants = new ArrayList<>();
       

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbetudiants", "root", "abc123abc");
            System.out.println("Connected successfully");

            String query1 = "insert into tetudiant values (?,?,?,?,?);";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query1)) {
                preparedStatement.setString(1, code);
                preparedStatement.setString(2, nom);
                preparedStatement.setString(3, prenom);
                preparedStatement.setInt(4, age);
                preparedStatement.setString(5, ville);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    
                    out.write("Registration successful");
                } else {
                    out.write("Registration failed");
                }
            }

            String query2 = "select * from tetudiant;";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query2); 
            		ResultSet res = preparedStatement.executeQuery()) {
                while (res.next()) {
                	Etudiant etu = new Etudiant();
                	etu.setNom(res.getString("nom"));
                    etu.setPrenom(res.getString("prenom"));
                    etu.setAge(res.getInt("age"));
                    etu.setVille(res.getString("ville"));
                    etu.setCode(res.getString("code"));
                    listeEtudiants.add(etu);
                   
                }
               
            }
          
            request.setAttribute("listeEtudiants", listeEtudiants);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            // Handle the error appropriately, log it, and provide a user-friendly response.
        }
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
